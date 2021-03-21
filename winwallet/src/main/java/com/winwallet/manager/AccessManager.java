/**
 * 
 */
package com.winwallet.manager;

import java.time.LocalDateTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.winwallet.model.AccessLogObject;
import com.winwallet.model.Response;
import com.winwallet.model.access.AccessCodesObject;
import com.winwallet.model.access.AgentAccessCodesObject;
import com.winwallet.model.access.AgentDataObject;
import com.winwallet.model.access.ChangeAgentPinRequest;
import com.winwallet.model.access.ChangePinRequest;
import com.winwallet.model.access.CreateAgentPinRequest;
import com.winwallet.model.access.CreateAgentWalletRequest;
import com.winwallet.model.access.CreatePinRequest;
import com.winwallet.model.access.CreateWalletRequest;
import com.winwallet.model.access.CustomerDataObject;
import com.winwallet.model.access.ResetAgentPinRequest;
import com.winwallet.model.access.ResetPinRequest;
import com.winwallet.model.account.AgentWalletObject;
import com.winwallet.model.account.CustomerWalletObject;
import com.winwallet.repository.AccessRepository;
import com.winwallet.repository.AgentRepository;
import com.winwallet.repository.AgentWalletRepository;
import com.winwallet.repository.CustomerDataRepository;
import com.winwallet.repository.CustomerWalletRepository;
import com.winwallet.utility.AuthUtility;
import com.winwallet.utility.ResponseUtility;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Service
public class AccessManager {

	private Logger logger = LogManager.getLogger();
	private AccessLogObject accessLogObject;
	private CustomerWalletObject customerWalletObject;
	private CustomerDataObject customerDataObject;
	private AccessCodesObject accessCodesObject;
	private CreateWalletRequest createWalletRequest;
	private AgentDataObject agentDataObject;
	private AgentWalletObject agentWalletObject;
	private AgentAccessCodesObject agentAccessCodesObject;

	@Autowired
	PlatformTransactionManager platformTransactionManager;

	@Autowired
	CustomerWalletRepository customerWalletRepository;

	@Autowired
	AgentWalletRepository agentWalletRepository;

	@Autowired
	PlatformTransactionManager transactionManager;

	@Autowired
	CustomerDataRepository customerDataRepository;

	@Autowired
	AccessRepository accessRepository;

	@Autowired
	AgentRepository agentRepository;

	@Autowired
	AuthUtility authUtility;

	@Autowired
	ResponseUtility responseUtility;

	public Response createWallet(CreateWalletRequest createWalletRequest, LocalDateTime requestIn) {

		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);

		try {

			accessLogObject = new AccessLogObject();
			accessLogObject.setChannel(createWalletRequest.getChannel());
			accessLogObject.setClientId(createWalletRequest.getClientId());
			accessLogObject.setMsisdn(createWalletRequest.getMsisdn());
			accessLogObject.setMsisdnNetwork(createWalletRequest.getMsisdnNetwork());
			accessLogObject.setRequestType("createWallet");
			accessLogObject.setRequestIn(requestIn);
			accessLogObject = accessRepository.save(accessLogObject);

			customerDataObject = new CustomerDataObject();
			customerDataObject.setDateCreated(LocalDateTime.now());
			customerDataObject.setMsisdn(accessLogObject.getMsisdn());
			customerDataObject.setMsisdnNetwork(accessLogObject.getMsisdnNetwork());
			customerDataObject = customerDataRepository.save(customerDataObject);

			customerWalletObject = new CustomerWalletObject();
			customerWalletObject.setAvailableBalance(0.00);
			customerWalletObject.setBookBalance(0.00);
			customerWalletObject.setDateCreated(LocalDateTime.now());
			customerWalletObject.setLastEditedDate(LocalDateTime.now());
			customerWalletObject.setLien(0.00);
			customerWalletObject.setMsisdn(customerDataObject.getMsisdn());
			customerWalletObject.setPnd(0);
			customerWalletObject.setUniqueId(customerDataObject.getUniqueId());
			customerWalletObject = customerWalletRepository.save(customerWalletObject);

			accessCodesObject = new AccessCodesObject();
			accessCodesObject.setDateCreated(customerDataObject.getDateCreated());
			accessCodesObject.setHashText(authUtility.encryptString(createWalletRequest.getPin()));
			accessCodesObject.setLastEditedDate(customerDataObject.getDateCreated());
			accessCodesObject.setMsisdn(customerDataObject.getMsisdn());
			accessCodesObject.setUniqueId(customerDataObject.getUniqueId());
			accessCodesObject = accessRepository.save(accessCodesObject);

			platformTransactionManager.commit(transactionStatus);

			return responseUtility.response(accessCodesObject.getUniqueId(), createWalletRequest.getClientId(), 0);

		} catch (Exception ex) {
			logger.error("AccessManager :: createWallet :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			platformTransactionManager.rollback(transactionStatus);
			if (ex instanceof DataIntegrityViolationException) {
				return responseUtility.response(0L, createWalletRequest.getClientId(), 7);
			} else {
				return responseUtility.response(0L, createWalletRequest.getClientId(), 99);
			}
		}
	}

	public Response createPin(CreatePinRequest createPinRequest, LocalDateTime requestIn) {

		try {

			accessLogObject = new AccessLogObject();
			accessLogObject.setChannel(createPinRequest.getChannel());
			accessLogObject.setClientId(createPinRequest.getClientId());
			accessLogObject.setMsisdn(createPinRequest.getMsisdn());
			accessLogObject.setMsisdnNetwork(createPinRequest.getMsisdnNetwork());
			accessLogObject.setRequestType("createPin");
			accessLogObject.setRequestIn(requestIn);
			accessLogObject = accessRepository.save(accessLogObject);

			customerDataObject = new CustomerDataObject();
			customerDataObject = customerDataRepository.findByMsisdn(createPinRequest.getMsisdn());
			if (customerDataObject == null) {
				customerDataObject = new CustomerDataObject();
				customerDataObject.setMsisdn(createPinRequest.getMsisdn());
				customerDataObject.setMsisdnNetwork(createPinRequest.getMsisdnNetwork());
				customerDataObject.setDateCreated(LocalDateTime.now());
				customerDataObject = customerDataRepository.save(customerDataObject);
			}

			customerWalletObject = new CustomerWalletObject();
			customerWalletObject = customerWalletRepository.findByMsisdn(customerDataObject.getMsisdn());
			if (customerWalletObject == null) {
				customerWalletObject = new CustomerWalletObject();
				customerWalletObject.setAvailableBalance(0.00);
				customerWalletObject.setBookBalance(0.00);
				customerWalletObject.setDateCreated(LocalDateTime.now());
				customerWalletObject.setLastEditedDate(LocalDateTime.now());
				customerWalletObject.setLien(0.00);
				customerWalletObject.setMsisdn(customerDataObject.getMsisdn());
				customerWalletObject.setPnd(0);
				customerWalletObject.setUniqueId(customerDataObject.getUniqueId());
				customerWalletObject = customerWalletRepository.save(customerWalletObject);
			}

			accessCodesObject = new AccessCodesObject();
			accessCodesObject.setDateCreated(requestIn);
			accessCodesObject.setHashText(authUtility.encryptString(createPinRequest.getPin()));
			accessCodesObject.setLastEditedDate(LocalDateTime.now());
			accessCodesObject.setMsisdn(createPinRequest.getMsisdn());
			accessCodesObject.setUniqueId(customerDataObject.getUniqueId());
			accessCodesObject = accessRepository.save(accessCodesObject);

			return responseUtility.response(0L, createPinRequest.getClientId(), 0);

		} catch (Exception ex) {
			logger.error("AccessManager :: createPin :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			if (ex instanceof DataIntegrityViolationException) {
				return responseUtility.response(0L, createWalletRequest.getClientId(), 7);
			} else {
				return responseUtility.response(0L, createWalletRequest.getClientId(), 99);
			}
		}
	}

	public Response changePin(ChangePinRequest changePinRequest, LocalDateTime requestIn) {
		try {

			accessLogObject = new AccessLogObject();
			accessLogObject.setChannel(changePinRequest.getChannel());
			accessLogObject.setClientId(changePinRequest.getClientId());
			accessLogObject.setMsisdn(changePinRequest.getMsisdn());
			accessLogObject.setMsisdnNetwork(changePinRequest.getMsisdnNetwork());
			accessLogObject.setRequestType("changePin");
			accessLogObject.setRequestIn(requestIn);
			accessLogObject = accessRepository.save(accessLogObject);

			accessCodesObject = new AccessCodesObject();
			accessCodesObject = accessRepository.findByMsisdn(changePinRequest.getMsisdn());
			if (accessCodesObject.getUniqueId() > 0) {
				if (authUtility.encryptString(changePinRequest.getOldPassword())
						.equals(accessCodesObject.getHashText())) {
					accessCodesObject.setDateCreated(LocalDateTime.now());
					accessCodesObject.setHashText(authUtility.encryptString(changePinRequest.getNewPassword()));
					accessCodesObject.setLastEditedDate(LocalDateTime.now());
					accessCodesObject.setUniqueId(customerDataObject.getUniqueId());
					accessCodesObject = accessRepository.save(accessCodesObject);

					return responseUtility.response(0L, changePinRequest.getClientId(), 0);
				} else {
					logger.error("AccessManager :: changePin :: Invalid Customer Id or Password.");
					return responseUtility.response(0L, createWalletRequest.getClientId(), 34);
				}

			} else {
				logger.error("AccessManager :: changePin :: Invalid Customer Id or Password.");
				return responseUtility.response(0L, changePinRequest.getClientId(), 34);
			}
		} catch (Exception ex) {
			logger.error("AccessManager :: changePin :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.response(0L, changePinRequest.getClientId(), 99);
		}
	}

	public Response resetPin(ResetPinRequest resetPinRequest, LocalDateTime localDateTime) {
		try {

			accessLogObject = new AccessLogObject();
			accessLogObject.setChannel(resetPinRequest.getChannel());
			accessLogObject.setClientId(resetPinRequest.getClientId());
			accessLogObject.setMsisdn(resetPinRequest.getMsisdn());
			accessLogObject.setMsisdnNetwork(resetPinRequest.getMsisdnNetwork());
			accessLogObject.setRequestType("resetPin");
			accessLogObject.setRequestIn(localDateTime);
			accessLogObject = accessRepository.save(accessLogObject);

			accessCodesObject = new AccessCodesObject();
			accessCodesObject = accessRepository.findByMsisdn(resetPinRequest.getMsisdn());
			if (accessCodesObject.getUniqueId() > 0) {
					accessCodesObject.setDateCreated(LocalDateTime.now());
					accessCodesObject.setHashText(authUtility.encryptString(resetPinRequest.getMsisdn() + "" + resetPinRequest.getMsisdnNetwork()));
					accessCodesObject.setLastEditedDate(LocalDateTime.now());
					accessCodesObject.setUniqueId(customerDataObject.getUniqueId());
					accessCodesObject = accessRepository.save(accessCodesObject);

					return responseUtility.response(0L, resetPinRequest.getClientId(), 0);

			} else {
				logger.error("AccessManager :: resetPin :: Invalid Customer Id or Password.");
				return responseUtility.response(0L, resetPinRequest.getClientId(), 34);
			}
		} catch (Exception ex) {
			logger.error("AccessManager :: resetPin :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.response(0L, resetPinRequest.getClientId(), 99);
		}
	}

	public Response createAgentWallet(CreateAgentWalletRequest createAgentWalletRequest, LocalDateTime requestIn) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);

		try {

			accessLogObject = new AccessLogObject();
			accessLogObject.setAccountName(createAgentWalletRequest.getAccountName());
			accessLogObject.setAccountNumber(createAgentWalletRequest.getAccountNumber());
			accessLogObject.setAgentId(createAgentWalletRequest.getAgentId());
			accessLogObject.setAgentLocationAddress(createAgentWalletRequest.getAgentLocationAddress());
			accessLogObject.setAgentLocationLGA(createAgentWalletRequest.getAgentLocationLGA());
			accessLogObject.setAgentLocationState(createAgentWalletRequest.getAgentLocationState());
			accessLogObject.setAgentLocationTown(createAgentWalletRequest.getAgentLocationTown());
			accessLogObject.setBankName(createAgentWalletRequest.getBankName());
			accessLogObject.setBvn(createAgentWalletRequest.getBvn());
			accessLogObject.setChannel(createAgentWalletRequest.getChannel());
			accessLogObject.setEmail(createAgentWalletRequest.getEmail());
			accessLogObject.setFirstName(createAgentWalletRequest.getFirstName());
			accessLogObject.setLastName(createAgentWalletRequest.getLastName());
			accessLogObject.setMsisdn(accessLogObject.getMsisdn());
			accessLogObject.setMsisdnNetwork(accessLogObject.getMsisdnNetwork());
			accessLogObject.setRequestType("createAgentWallet");
			accessLogObject.setRequestIn(LocalDateTime.now());
			accessLogObject = accessRepository.save(accessLogObject);

			agentDataObject = new AgentDataObject();
			agentDataObject.setAccountName(createAgentWalletRequest.getAccountName());
			agentDataObject.setAccountNumber(createAgentWalletRequest.getAccountNumber());
			agentDataObject.setAgentId(createAgentWalletRequest.getAgentId());
			agentDataObject.setAgentLocationAddress(createAgentWalletRequest.getAgentLocationAddress());
			agentDataObject.setAgentLocationLGA(createAgentWalletRequest.getAgentLocationLGA());
			agentDataObject.setAgentLocationState(createAgentWalletRequest.getAgentLocationState());
			agentDataObject.setAgentLocationTown(createAgentWalletRequest.getAgentLocationTown());
			agentDataObject.setBankName(createAgentWalletRequest.getBankName());
			agentDataObject.setBvn(createAgentWalletRequest.getBvn());
			agentDataObject.setDateCreated(accessLogObject.getRequestIn());
			agentDataObject.setEmail(createAgentWalletRequest.getEmail());
			agentDataObject.setFirstName(createAgentWalletRequest.getFirstName());
			agentDataObject.setLastName(createAgentWalletRequest.getLastName());
			agentDataObject.setMsisdn(accessLogObject.getMsisdn());
			agentDataObject.setMsisdnNetwork(accessLogObject.getMsisdnNetwork());
			agentDataObject = agentRepository.save(agentDataObject);

			agentWalletObject = new AgentWalletObject();
			agentWalletObject.setAvailableBalance(0.00);
			agentWalletObject.setBookBalance(0.00);
			agentWalletObject.setDateCreated(LocalDateTime.now());
			agentWalletObject.setLastEditedDate(LocalDateTime.now());
			agentWalletObject.setLien(0.00);
			agentWalletObject.setMsisdn(agentDataObject.getMsisdn());
			agentWalletObject.setPnd(0);
			agentWalletObject.setUniqueId(agentDataObject.getUniqueId());
			agentWalletObject = agentRepository.save(agentWalletObject);

			agentAccessCodesObject = new AgentAccessCodesObject();
			agentAccessCodesObject.setDateCreated(customerDataObject.getDateCreated());
			agentAccessCodesObject.setHashText(authUtility.encryptString(createWalletRequest.getPin()));
			agentAccessCodesObject.setLastEditedDate(customerDataObject.getDateCreated());
			agentAccessCodesObject.setMsisdn(customerDataObject.getMsisdn());
			agentAccessCodesObject.setUniqueId(customerDataObject.getUniqueId());
			agentAccessCodesObject = agentRepository.save(agentAccessCodesObject);

			platformTransactionManager.commit(transactionStatus);

			return responseUtility.response(agentAccessCodesObject.getUniqueId(),
					createAgentWalletRequest.getClientId(), 0);

		} catch (Exception ex) {
			logger.error("AccessManager :: createAgentWallet :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage()
					+ "\n" + ex.getStackTrace());
			platformTransactionManager.rollback(transactionStatus);
			if (ex instanceof DataIntegrityViolationException) {
				return responseUtility.response(0L, createAgentWalletRequest.getClientId(), 7);
			} else {
				return responseUtility.response(0L, createAgentWalletRequest.getClientId(), 99);
			}
		}
	}

	public Response createAgentPin(CreateAgentPinRequest createAgentPinRequest, LocalDateTime requestIn) {

		try {

			accessLogObject = new AccessLogObject();
			accessLogObject.setChannel(createAgentPinRequest.getChannel());
			accessLogObject.setClientId(createAgentPinRequest.getClientId());
			accessLogObject.setMsisdn(createAgentPinRequest.getMsisdn());
			accessLogObject.setMsisdnNetwork(createAgentPinRequest.getMsisdnNetwork());
			accessLogObject.setRequestType("createPin");
			accessLogObject.setRequestIn(requestIn);
			accessLogObject = accessRepository.save(accessLogObject);

			agentDataObject = new AgentDataObject();
			agentDataObject = agentRepository.findByMsisdn(createAgentPinRequest.getMsisdn());
			if (agentDataObject == null) {
				agentDataObject = new AgentDataObject();
				agentDataObject.setMsisdn(createAgentPinRequest.getMsisdn());
				agentDataObject.setMsisdnNetwork(createAgentPinRequest.getMsisdnNetwork());
				agentDataObject.setDateCreated(LocalDateTime.now());
				agentDataObject = agentRepository.save(agentDataObject);
			}

			agentWalletObject = new AgentWalletObject();
			agentWalletObject = agentWalletRepository.findByMsisdn(agentDataObject.getMsisdn());
			if (agentWalletObject == null) {
				agentWalletObject = new AgentWalletObject();
				agentWalletObject.setAvailableBalance(0.00);
				agentWalletObject.setBookBalance(0.00);
				agentWalletObject.setDateCreated(LocalDateTime.now());
				agentWalletObject.setLastEditedDate(LocalDateTime.now());
				agentWalletObject.setLien(0.00);
				agentWalletObject.setMsisdn(agentDataObject.getMsisdn());
				agentWalletObject.setPnd(0);
				agentWalletObject.setUniqueId(agentDataObject.getUniqueId());
				agentWalletObject = agentWalletRepository.save(agentWalletObject);
			}

			agentAccessCodesObject = new AgentAccessCodesObject();
			agentAccessCodesObject.setDateCreated(requestIn);
			agentAccessCodesObject.setHashText(authUtility.encryptString(createAgentPinRequest.getPin()));
			agentAccessCodesObject.setLastEditedDate(LocalDateTime.now());
			agentAccessCodesObject.setMsisdn(createAgentPinRequest.getMsisdn());
			agentAccessCodesObject.setUniqueId(agentDataObject.getUniqueId());
			agentAccessCodesObject = agentRepository.save(agentAccessCodesObject);

			return responseUtility.response(0L, createAgentPinRequest.getClientId(), 0);

		} catch (Exception ex) {
			logger.error("AccessManager :: createAgentPin :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage()
					+ "\n" + ex.getStackTrace());
			if (ex instanceof DataIntegrityViolationException) {
				return responseUtility.response(0L, createAgentPinRequest.getClientId(), 7);
			} else {
				return responseUtility.response(0L, createAgentPinRequest.getClientId(), 99);
			}
		}
	}

	public Response changeAgentPin(ChangeAgentPinRequest changeAgentPinRequest, LocalDateTime requestIn) {
		try {

			accessLogObject = new AccessLogObject();
			accessLogObject.setChannel(changeAgentPinRequest.getChannel());
			accessLogObject.setClientId(changeAgentPinRequest.getClientId());
			accessLogObject.setMsisdn(changeAgentPinRequest.getMsisdn());
			accessLogObject.setMsisdnNetwork(changeAgentPinRequest.getMsisdnNetwork());
			accessLogObject.setRequestType("changeAgentPin");
			accessLogObject.setRequestIn(requestIn);
			accessLogObject = accessRepository.save(accessLogObject);

			accessCodesObject = new AccessCodesObject();
			accessCodesObject = accessRepository.findByMsisdn(changeAgentPinRequest.getMsisdn());
			if (accessCodesObject.getUniqueId() > 0) {
				if (authUtility.encryptString(changeAgentPinRequest.getOldPassword())
						.equals(accessCodesObject.getHashText())) {
					accessCodesObject.setDateCreated(LocalDateTime.now());
					accessCodesObject.setHashText(authUtility.encryptString(changeAgentPinRequest.getNewPassword()));
					accessCodesObject.setLastEditedDate(LocalDateTime.now());
					accessCodesObject = accessRepository.save(accessCodesObject);
					return responseUtility.response(0L, changeAgentPinRequest.getClientId(), 0);
				} else {
					logger.error("AccessManager :: changeAgentPin :: Invalid Customer Id or Password.");
					return responseUtility.response(0L, createWalletRequest.getClientId(), 34);
				}

			} else {
				logger.error("AccessManager :: changeAgentPin :: Invalid Customer Id or Password.");
				return responseUtility.response(0L, createWalletRequest.getClientId(), 34);
			}
		} catch (Exception ex) {
			logger.error("AccessManager :: changeAgentPin :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.response(0L, createWalletRequest.getClientId(), 99);
		}
	}

	public Response resetAgentPin(ResetAgentPinRequest resetAgentPinRequest, String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
