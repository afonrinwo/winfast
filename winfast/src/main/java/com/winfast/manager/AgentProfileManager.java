/**
 * 
 */
package com.winfast.manager;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.winfast.model.Response;
import com.winfast.model.profile.AgentProfileActivityLogObject;
import com.winfast.model.profile.agent.ActivateAgentProfileRequest;
import com.winfast.model.profile.agent.AgentPasswordProfileObject;
import com.winfast.model.profile.agent.AgentProfileObject;
import com.winfast.model.profile.agent.CreateAgentProfileRequest;
import com.winfast.model.profile.agent.ChangeAgentPasswordRequest;
import com.winfast.model.profile.agent.DisableAgentProfileRequest;
import com.winfast.model.profile.agent.ResetAgentPasswordRequest;
import com.winfast.model.terminal.ActivateTerminalRequest;
import com.winfast.model.terminal.DeactivateTerminalRequest;
import com.winfast.model.terminal.TerminalObject;
import com.winfast.model.terminal.MapTerminalRequest;
import com.winfast.model.terminal.MapTerminalResponse;
import com.winfast.repository.AgentPasswordProfileRepository;
import com.winfast.repository.AgentProfileActivityLogRepository;
import com.winfast.repository.AgentProfileRepository;
import com.winfast.repository.MapTerminalRepository;
import com.winfast.utility.AuthenticationUtility;
import com.winfast.utility.MessageUtility;
import com.winfast.utility.ResponseUtility;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Service
public class AgentProfileManager {

	private final Logger logger = LogManager.getLogger();
	private AgentProfileActivityLogObject agentProfileActivityLogObject;
	private Iterable<AgentProfileObject> iAgentProfileObject;
	private AgentProfileObject agentProfileObject;
	private AgentPasswordProfileObject agentPasswordProfileObject;
	private TerminalObject terminalObject;

	@Autowired
	PlatformTransactionManager platformTransactionManager;

	@Autowired
	AgentProfileActivityLogRepository agentProfileActivityLogRepository;

	@Autowired
	MapTerminalRepository mapTerminalRepository;

	@Autowired
	ResponseUtility responseUtility;

	@Autowired
	AgentProfileRepository agentProfileRepository;

	@Autowired
	AuthenticationUtility authenticationUtility;

	@Autowired
	AgentPasswordProfileRepository agentPasswordProfileRepository;

	@Autowired
	MessageUtility messageUtility;

	public Response createAgentProfile(CreateAgentProfileRequest createAgentProfileRequest, String appId,
			LocalDateTime requestIn) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
		try {

			agentProfileActivityLogObject = new AgentProfileActivityLogObject();
			agentProfileActivityLogObject.setAccountName(createAgentProfileRequest.getAccountName());
			agentProfileActivityLogObject.setAccountNumber(createAgentProfileRequest.getAccountNumber());
			agentProfileActivityLogObject
					.setAgentResidentialAddress(createAgentProfileRequest.getAgentResidentialAddress());
			agentProfileActivityLogObject.setAgentResidentialLGA(createAgentProfileRequest.getAgentResidentialLGA());
			agentProfileActivityLogObject
					.setAgentResidentialState(createAgentProfileRequest.getAgentResidentialState());
			agentProfileActivityLogObject.setAgentResidentialTown(createAgentProfileRequest.getAgentResidentialTown());
			agentProfileActivityLogObject.setAppId(appId);
			agentProfileActivityLogObject.setBankName(createAgentProfileRequest.getBankName());
			agentProfileActivityLogObject.setBusinessLocation(createAgentProfileRequest.getBusinessLocation());
			agentProfileActivityLogObject.setBusinessLocationLGA(createAgentProfileRequest.getBusinessLocationLGA());
			agentProfileActivityLogObject.setBusinessNature(createAgentProfileRequest.getBusinessNature());
			agentProfileActivityLogObject.setBvn(createAgentProfileRequest.getBvn());
			agentProfileActivityLogObject.setClientId(createAgentProfileRequest.getClientId());
			agentProfileActivityLogObject.setEmail(createAgentProfileRequest.getEmail());
			agentProfileActivityLogObject.setFirstName(createAgentProfileRequest.getFirstName());
			agentProfileActivityLogObject.setGuarantorAddress(createAgentProfileRequest.getGuarantorAddress());
			agentProfileActivityLogObject.setGuarantorEmail(createAgentProfileRequest.getGuarantorEmail());
			agentProfileActivityLogObject
					.setGuarantorMobileNumber(createAgentProfileRequest.getGuarantorMobileNumber());
			agentProfileActivityLogObject.setGuarantorName(createAgentProfileRequest.getGuarantorName());
			agentProfileActivityLogObject.setLastName(createAgentProfileRequest.getLastName());
			agentProfileActivityLogObject.setMeansOfId(createAgentProfileRequest.getMeansOfId());
			agentProfileActivityLogObject.setMsisdnNetwork(createAgentProfileRequest.getMsisdnNetwork());
			agentProfileActivityLogObject.setMsisdnNumber(createAgentProfileRequest.getMsisdnNumber());
			agentProfileActivityLogObject
					.setRelationshipWithGuarantor(createAgentProfileRequest.getRelationshipWithGuarantor());
			agentProfileActivityLogObject.setRequestIn(requestIn);
			agentProfileActivityLogObject.setRequestType("createAgentProfile");
			agentProfileActivityLogObject.setStatus(0);
			agentProfileActivityLogObject = agentProfileActivityLogRepository.save(agentProfileActivityLogObject);

			agentProfileObject = new AgentProfileObject();
			agentProfileObject.setAccountName(createAgentProfileRequest.getAccountName());
			agentProfileObject.setAccountNumber(createAgentProfileRequest.getAccountNumber());
			agentProfileObject.setAgentId(createAgentProfileRequest.getAgentId());
			agentProfileObject.setAgentResidentialAddress(createAgentProfileRequest.getAgentResidentialAddress());
			agentProfileObject.setAgentResidentialLGA(createAgentProfileRequest.getAgentResidentialLGA());
			agentProfileObject.setAgentResidentialState(createAgentProfileRequest.getAgentResidentialState());
			agentProfileObject.setAgentResidentialTown(createAgentProfileRequest.getAgentResidentialTown());
			agentProfileObject.setBankName(createAgentProfileRequest.getBankName());
			agentProfileObject.setBusinessLocation(createAgentProfileRequest.getBusinessLocation());
			agentProfileObject.setBusinessLocationLGA(createAgentProfileRequest.getBusinessLocationLGA());
			agentProfileObject.setBusinessNature(createAgentProfileRequest.getBusinessNature());
			agentProfileObject.setBvn(createAgentProfileRequest.getBvn());
			agentProfileObject.setClientId(createAgentProfileRequest.getClientId());
			agentProfileObject.setDateCreated(LocalDateTime.now());
			agentProfileObject.setEmail(createAgentProfileRequest.getEmail());
			agentProfileObject.setFirstName(createAgentProfileRequest.getFirstName());
			agentProfileObject.setGuarantorAddress(createAgentProfileRequest.getGuarantorAddress());
			agentProfileObject.setGuarantorEmail(createAgentProfileRequest.getEmail());
			agentProfileObject.setGuarantorMobileNumber(createAgentProfileRequest.getGuarantorMobileNumber());
			agentProfileObject.setGuarantorName(createAgentProfileRequest.getGuarantorName());
			agentProfileObject.setLastModified(LocalDateTime.now());
			agentProfileObject.setLastName(createAgentProfileRequest.getLastName());
			agentProfileObject.setMeansOfId(createAgentProfileRequest.getMeansOfId());
			agentProfileObject.setMsisdnNetwork(createAgentProfileRequest.getMsisdnNetwork());
			agentProfileObject.setMsisdnNumber(createAgentProfileRequest.getMsisdnNumber());
			agentProfileObject.setRelationshipWithGuarantor(createAgentProfileRequest.getRelationshipWithGuarantor());
			agentProfileObject.setStatus(0);
			agentProfileObject = agentProfileRepository.save(agentProfileObject);

			agentPasswordProfileObject = new AgentPasswordProfileObject();
			agentPasswordProfileObject.setChangeCount(0);
			String password = authenticationUtility.encryptString(String.valueOf(agentProfileObject.getAgentId()));
			agentPasswordProfileObject.setPassword(password);
			agentPasswordProfileObject.setDateCreated(LocalDateTime.now());
			agentPasswordProfileObject.setPassword(password);
			agentPasswordProfileObject.setLastUpdated(LocalDateTime.now());
			agentPasswordProfileObject.setAgentId(agentProfileObject.getAgentId());
			agentPasswordProfileObject = agentPasswordProfileRepository.save(agentPasswordProfileObject);

			platformTransactionManager.commit(transactionStatus);

			messageUtility.sendMail(createAgentProfileRequest.getClientId(), appId, "notification@winfast.ng",
					agentProfileObject.getEmail(), "Winfast Agent Game Account",
					"Agent Game Profile was created successfully, your default password is " + password
							+ " please login and change to a password of your choice before you start gaming.",
					requestIn);

			return responseUtility.responseBuilder(agentProfileObject.getAgentId(),
					createAgentProfileRequest.getClientId(), 0);

		} catch (Exception ex) {
			logger.error("createAgentProfile :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			platformTransactionManager.rollback(transactionStatus);
			return responseUtility.responseBuilder(0L, createAgentProfileRequest.getClientId(), 99);
		}
	}

	public MapTerminalResponse mapTerminal(String header, MapTerminalRequest mapTerminalRequest,
			LocalDateTime requestIn) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
		try {
			agentProfileActivityLogObject = new AgentProfileActivityLogObject();
			agentProfileActivityLogObject.setAgentId(mapTerminalRequest.getAgentId());
			agentProfileActivityLogObject.setAppId(mapTerminalRequest.getAppId());
			agentProfileActivityLogObject.setClientId(mapTerminalRequest.getClientId());
			agentProfileActivityLogObject.setTerminalLocation(mapTerminalRequest.getTerminalLocation());
			agentProfileActivityLogObject.setTerminalLocationLGA(mapTerminalRequest.getTerminalLocationLGA());
			agentProfileActivityLogObject.setTerminalLocationState(mapTerminalRequest.getTerminalLocationState());
			agentProfileActivityLogObject.setTerminalLocationTown(mapTerminalRequest.getTerminalLocationTown());
			agentProfileActivityLogObject = agentProfileActivityLogRepository.save(agentProfileActivityLogObject);

			agentProfileObject = new AgentProfileObject();
			agentProfileObject = agentProfileRepository.findByAgentId(mapTerminalRequest.getAgentId());

			if (agentProfileObject.getFirstName().equals(null)) {

				platformTransactionManager.commit(transactionStatus);
				logger.info("mapTerminal" + mapTerminalRequest.getTerminalId() + " Terminal Id does not exist");
				return responseUtility.terminalMappingResponseBuilder(terminalObject.getClientId(),
						terminalObject.getAgentId(), terminalObject.getTerminalId(), 35);

			} else {

				mapTerminalRepository.count();
				terminalObject = new TerminalObject();
				terminalObject.setAgentId(mapTerminalRequest.getAgentId());
				terminalObject.setAppId(mapTerminalRequest.getAppId());
				terminalObject.setClientId(mapTerminalRequest.getClientId());
				terminalObject.setDateCreated(LocalDateTime.now());
				terminalObject.setLastUpdated(LocalDateTime.now());
				terminalObject.setStatus(0);
				terminalObject.setTerminalLocation(mapTerminalRequest.getTerminalLocation());
				terminalObject.setTerminalLocationLGA(mapTerminalRequest.getTerminalLocationLGA());
				terminalObject.setTerminalLocationState(mapTerminalRequest.getTerminalLocationState());
				terminalObject.setTerminalLocationTown(mapTerminalRequest.getTerminalLocationTown());
				terminalObject = mapTerminalRepository.save(terminalObject);

				platformTransactionManager.commit(transactionStatus);

				return responseUtility.terminalMappingResponseBuilder(terminalObject.getClientId(),
						terminalObject.getAgentId(), terminalObject.getTerminalId(), 0);
			}

		} catch (Exception ex) {
			logger.error(
					"mapTerminal :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			platformTransactionManager.rollback(transactionStatus);
			return responseUtility.terminalMappingResponseBuilder(mapTerminalRequest.getClientId(),
					mapTerminalRequest.getAgentId(), "0", 99);
		}
	}

	public Response activateTerminal(String header, ActivateTerminalRequest activateTerminalRequest,
			LocalDateTime requestIn) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
		try {
			agentProfileActivityLogObject = new AgentProfileActivityLogObject();
			agentProfileActivityLogObject.setAgentId(activateTerminalRequest.getAgentId());
			agentProfileActivityLogObject.setAppId(activateTerminalRequest.getAppId());
			agentProfileActivityLogObject.setClientId(activateTerminalRequest.getClientId());
			agentProfileActivityLogObject.setTerminalId(activateTerminalRequest.getTerminalId());
			agentProfileActivityLogObject.setRequestIn(requestIn);
			agentProfileActivityLogObject = agentProfileActivityLogRepository.save(agentProfileActivityLogObject);

			terminalObject = new TerminalObject();
			terminalObject = mapTerminalRepository.findByTerminalId(activateTerminalRequest.getTerminalId());
			if (terminalObject.getAgentId() == null) {

				platformTransactionManager.commit(transactionStatus);
				logger.info("activateTerminal" + activateTerminalRequest.getTerminalId() + " Terminal does not exist");
				return responseUtility.responseBuilder(0L, terminalObject.getClientId(), 36);

			} else {
				terminalObject.setAgentId(terminalObject.getAgentId());
				terminalObject.setAppId(terminalObject.getAppId());
				terminalObject.setClientId(terminalObject.getClientId());
				terminalObject.setDateCreated(terminalObject.getDateCreated());
				terminalObject.setLastUpdated(LocalDateTime.now());
				terminalObject.setStatus(1);
				terminalObject.setTerminalId(terminalObject.getTerminalId());
				terminalObject.setTerminalLocation(terminalObject.getTerminalLocation());
				terminalObject.setTerminalLocationLGA(terminalObject.getTerminalLocationLGA());
				terminalObject.setTerminalLocationState(terminalObject.getTerminalLocationState());
				terminalObject.setTerminalLocationTown(terminalObject.getTerminalLocationTown());
				terminalObject = mapTerminalRepository.save(terminalObject);

				platformTransactionManager.commit(transactionStatus);
				return responseUtility.responseBuilder(agentProfileActivityLogObject.getUniqueId(), activateTerminalRequest.getClientId(), 0);
			}

		} catch (Exception ex) {
			logger.error("activateTerminal :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			platformTransactionManager.rollback(transactionStatus);
			return responseUtility.responseBuilder(0L, activateTerminalRequest.getClientId(), 99);
		}
	}

	public Response deactivateTerminal(String header, DeactivateTerminalRequest deactivateTerminalRequest,
			LocalDateTime requestIn) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
		try {
			agentProfileActivityLogObject = new AgentProfileActivityLogObject();
			agentProfileActivityLogObject.setAgentId(deactivateTerminalRequest.getAgentId());
			agentProfileActivityLogObject.setAppId(deactivateTerminalRequest.getAppId());
			agentProfileActivityLogObject.setClientId(deactivateTerminalRequest.getClientId());
			agentProfileActivityLogObject.setTerminalId(deactivateTerminalRequest.getTerminalId());
			agentProfileActivityLogObject.setReason(deactivateTerminalRequest.getReason());
			agentProfileActivityLogObject.setRequestIn(requestIn);
			agentProfileActivityLogObject = agentProfileActivityLogRepository.save(agentProfileActivityLogObject);

			terminalObject = new TerminalObject();
			terminalObject = mapTerminalRepository.findByTerminalId(deactivateTerminalRequest.getTerminalId());
			if (terminalObject.getAgentId() == null) {

				platformTransactionManager.commit(transactionStatus);
				logger.info("deactivateTerminal" + deactivateTerminalRequest.getTerminalId()
						+ " Terminal Id does not exist");
				return responseUtility.responseBuilder(0L, terminalObject.getClientId(), 36);

			} else {
				terminalObject.setAgentId(terminalObject.getAgentId());
				terminalObject.setAppId(terminalObject.getAppId());
				terminalObject.setClientId(terminalObject.getClientId());
				terminalObject.setDateCreated(terminalObject.getDateCreated());
				terminalObject.setLastUpdated(LocalDateTime.now());
				terminalObject.setReason(deactivateTerminalRequest.getReason());
				terminalObject.setStatus(2);
				terminalObject.setTerminalId(terminalObject.getTerminalId());
				terminalObject.setTerminalLocation(terminalObject.getTerminalLocation());
				terminalObject.setTerminalLocationLGA(terminalObject.getTerminalLocationLGA());
				terminalObject.setTerminalLocationState(terminalObject.getTerminalLocationState());
				terminalObject.setTerminalLocationTown(terminalObject.getTerminalLocationTown());
				terminalObject = mapTerminalRepository.save(terminalObject);

				platformTransactionManager.commit(transactionStatus);
				return responseUtility.responseBuilder(agentProfileActivityLogObject.getUniqueId(), deactivateTerminalRequest.getClientId(), 0);
			}

		} catch (Exception ex) {
			logger.error("deactivateTerminal :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			platformTransactionManager.rollback(transactionStatus);
			return responseUtility.responseBuilder(0L, deactivateTerminalRequest.getClientId(), 99);
		}
	}

	public Iterable<AgentProfileObject> listAgentProfile() {
		try {
			iAgentProfileObject = new ArrayList<>();
			iAgentProfileObject = agentProfileRepository.findAll();
		} catch (Exception ex) {
			iAgentProfileObject = new ArrayList<>();
			iAgentProfileObject.forEach(null);
		}
		return iAgentProfileObject;
	}

	public Iterable<AgentProfileObject> listAgentProfile(int status) {
		try {
			iAgentProfileObject = new ArrayList<>();
			iAgentProfileObject = agentProfileRepository.findByStatus(status);
		} catch (Exception ex) {
			iAgentProfileObject = new ArrayList<>();
			iAgentProfileObject.forEach(null);
		}
		return iAgentProfileObject;
	}

	public Response activateAgentProfle(String header, ActivateAgentProfileRequest activateAgentProfileRequest,
			LocalDateTime requestIn) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
		try {
			agentProfileActivityLogObject = new AgentProfileActivityLogObject();
			agentProfileActivityLogObject.setAppId(activateAgentProfileRequest.getAppId());
			agentProfileActivityLogObject.setClientId(activateAgentProfileRequest.getClientId());
			agentProfileActivityLogObject.setTerminalId(activateAgentProfileRequest.getTerminalId());
			agentProfileActivityLogObject.setRequestIn(requestIn);
			agentProfileActivityLogObject = agentProfileActivityLogRepository.save(agentProfileActivityLogObject);

			agentProfileObject = new AgentProfileObject();
			agentProfileObject = agentProfileRepository.findByAgentId(activateAgentProfileRequest.getAgentId());
			if (agentProfileObject.getAgentId() == Long.valueOf(activateAgentProfileRequest.getAgentId())) {
				agentProfileObject.setAccountName(agentProfileObject.getAccountName());
				agentProfileObject.setAccountNumber(agentProfileObject.getAccountNumber());
				agentProfileObject.setAgentId(agentProfileObject.getAgentId());
				agentProfileObject.setAgentResidentialAddress(agentProfileObject.getAgentResidentialAddress());
				agentProfileObject.setAgentResidentialLGA(agentProfileObject.getAgentResidentialLGA());
				agentProfileObject.setAgentResidentialState(agentProfileObject.getAgentResidentialState());
				agentProfileObject.setAgentResidentialTown(agentProfileObject.getAgentResidentialTown());
				agentProfileObject.setBankName(agentProfileObject.getBankName());
				agentProfileObject.setBusinessLocation(agentProfileObject.getBusinessLocation());
				agentProfileObject.setBusinessLocationLGA(agentProfileObject.getBusinessLocationLGA());
				agentProfileObject.setBusinessNature(agentProfileObject.getBusinessNature());
				agentProfileObject.setBvn(agentProfileObject.getBvn());
				agentProfileObject.setClientId(agentProfileObject.getClientId());
				agentProfileObject.setDateCreated(agentProfileObject.getDateCreated());
				agentProfileObject.setEmail(agentProfileObject.getEmail());
				agentProfileObject.setFirstName(agentProfileObject.getFirstName());
				agentProfileObject.setGuarantorAddress(agentProfileObject.getGuarantorAddress());
				agentProfileObject.setGuarantorEmail(agentProfileObject.getGuarantorEmail());
				agentProfileObject.setGuarantorMobileNumber(agentProfileObject.getGuarantorMobileNumber());
				agentProfileObject.setGuarantorName(agentProfileObject.getGuarantorName());
				agentProfileObject.setLastModified(LocalDateTime.now());
				agentProfileObject.setLastName(agentProfileObject.getLastName());
				agentProfileObject.setMeansOfId(agentProfileObject.getMeansOfId());
				agentProfileObject.setMsisdnNetwork(agentProfileObject.getMsisdnNetwork());
				agentProfileObject.setMsisdnNumber(agentProfileObject.getMsisdnNumber());
				agentProfileObject.setRelationshipWithGuarantor(agentProfileObject.getRelationshipWithGuarantor());
				agentProfileObject.setStatus(1);
				agentProfileObject = agentProfileRepository.save(agentProfileObject);

				platformTransactionManager.commit(transactionStatus);
				return responseUtility.responseBuilder(agentProfileActivityLogObject.getUniqueId(), activateAgentProfileRequest.getClientId(), 0);
				
			} else {
				platformTransactionManager.commit(transactionStatus);
				logger.info(
						"activateAgentProfle" + activateAgentProfileRequest.getAgentId() + " Agent Id does not exist");
				return responseUtility.responseBuilder(0L, terminalObject.getClientId(), 36);
			}

		} catch (Exception ex) {
			logger.error("activateAgentProfle :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.responseBuilder(0L, activateAgentProfileRequest.getClientId(), 99);
		}
	}

	public Response disableAgentProfile(String header, DisableAgentProfileRequest disableAgentProfileRequest,
			LocalDateTime requestIn) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
		try {
			agentProfileActivityLogObject = new AgentProfileActivityLogObject();
			agentProfileActivityLogObject.setAppId(disableAgentProfileRequest.getAppId());
			agentProfileActivityLogObject.setClientId(disableAgentProfileRequest.getClientId());
			agentProfileActivityLogObject.setTerminalId(disableAgentProfileRequest.getTerminalId());
			agentProfileActivityLogObject.setRequestIn(requestIn);
			agentProfileActivityLogObject = agentProfileActivityLogRepository.save(agentProfileActivityLogObject);

			agentProfileObject = new AgentProfileObject();
			agentProfileObject = agentProfileRepository.findByAgentId(disableAgentProfileRequest.getAgentId());
			if (agentProfileObject.getAgentId() == Long.valueOf(disableAgentProfileRequest.getAgentId())) {
				agentProfileObject.setAccountName(agentProfileObject.getAccountName());
				agentProfileObject.setAccountNumber(agentProfileObject.getAccountNumber());
				agentProfileObject.setAgentId(agentProfileObject.getAgentId());
				agentProfileObject.setAgentResidentialAddress(agentProfileObject.getAgentResidentialAddress());
				agentProfileObject.setAgentResidentialLGA(agentProfileObject.getAgentResidentialLGA());
				agentProfileObject.setAgentResidentialState(agentProfileObject.getAgentResidentialState());
				agentProfileObject.setAgentResidentialTown(agentProfileObject.getAgentResidentialTown());
				agentProfileObject.setBankName(agentProfileObject.getBankName());
				agentProfileObject.setBusinessLocation(agentProfileObject.getBusinessLocation());
				agentProfileObject.setBusinessLocationLGA(agentProfileObject.getBusinessLocationLGA());
				agentProfileObject.setBusinessNature(agentProfileObject.getBusinessNature());
				agentProfileObject.setBvn(agentProfileObject.getBvn());
				agentProfileObject.setClientId(agentProfileObject.getClientId());
				agentProfileObject.setDateCreated(agentProfileObject.getDateCreated());
				agentProfileObject.setEmail(agentProfileObject.getEmail());
				agentProfileObject.setFirstName(agentProfileObject.getFirstName());
				agentProfileObject.setGuarantorAddress(agentProfileObject.getGuarantorAddress());
				agentProfileObject.setGuarantorEmail(agentProfileObject.getGuarantorEmail());
				agentProfileObject.setGuarantorMobileNumber(agentProfileObject.getGuarantorMobileNumber());
				agentProfileObject.setGuarantorName(agentProfileObject.getGuarantorName());
				agentProfileObject.setLastModified(LocalDateTime.now());
				agentProfileObject.setLastName(agentProfileObject.getLastName());
				agentProfileObject.setMeansOfId(agentProfileObject.getMeansOfId());
				agentProfileObject.setMsisdnNetwork(agentProfileObject.getMsisdnNetwork());
				agentProfileObject.setMsisdnNumber(agentProfileObject.getMsisdnNumber());
				agentProfileObject.setRelationshipWithGuarantor(agentProfileObject.getRelationshipWithGuarantor());
				agentProfileObject.setStatus(1);
				agentProfileObject = agentProfileRepository.save(agentProfileObject);

				platformTransactionManager.commit(transactionStatus);
				return responseUtility.responseBuilder(agentProfileActivityLogObject.getUniqueId(), disableAgentProfileRequest.getClientId(), 0);
			} else {
				platformTransactionManager.commit(transactionStatus);
				logger.info(
						"disableAgentProfile" + disableAgentProfileRequest.getAgentId() + " Agent Id does not exist");
				return responseUtility.responseBuilder(0L, disableAgentProfileRequest.getClientId(), 36);
			}

		} catch (Exception ex) {
			logger.error("disableAgentProfile :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.responseBuilder(0L, disableAgentProfileRequest.getClientId(), 99);
		}
	}

	public Response changeAgentPassword(String appId, ChangeAgentPasswordRequest changeAgentPasswordRequest,
			LocalDateTime requestIn) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
		try {
			agentProfileActivityLogObject = new AgentProfileActivityLogObject();
			agentProfileActivityLogObject.setAppId(appId);
			agentProfileActivityLogObject.setClientId(changeAgentPasswordRequest.getClientId());
			agentProfileActivityLogObject.setAgentId(changeAgentPasswordRequest.getAgentId());
			agentProfileActivityLogObject.setNewPassword(changeAgentPasswordRequest.getNewPassword());
			agentProfileActivityLogObject.setPassword(changeAgentPasswordRequest.getPassword());
			agentProfileActivityLogObject.setRequestIn(requestIn);
			agentProfileActivityLogObject = agentProfileActivityLogRepository.save(agentProfileActivityLogObject);
			
			agentPasswordProfileObject = new AgentPasswordProfileObject();  
			agentPasswordProfileObject = agentPasswordProfileRepository.findByAgentId(changeAgentPasswordRequest.getAgentId());
			if(agentProfileObject.getAgentId() == Long.valueOf(changeAgentPasswordRequest.getAgentId())) {
				agentPasswordProfileObject.setAgentId(agentPasswordProfileObject.getAgentId());
				agentPasswordProfileObject.setChangeCount(agentPasswordProfileObject.getChangeCount() + 1);
				agentPasswordProfileObject.setDateCreated(agentPasswordProfileObject.getDateCreated());
				agentPasswordProfileObject.setLastUpdated(LocalDateTime.now());
				agentPasswordProfileObject.setPassword(authenticationUtility.encryptString(String.valueOf(changeAgentPasswordRequest.getNewPassword())));
				agentPasswordProfileObject.setOldPassword(agentPasswordProfileObject.getPassword());
				agentPasswordProfileObject = agentPasswordProfileRepository.save(agentPasswordProfileObject);
				
				platformTransactionManager.commit(transactionStatus);
				return responseUtility.responseBuilder(agentProfileActivityLogObject.getUniqueId(), changeAgentPasswordRequest.getClientId(), 0);
				
			} else {
				platformTransactionManager.commit(transactionStatus);
				logger.info(
						"activateAgentProfle" + changeAgentPasswordRequest.getAgentId() + " Agent Id does not exist");
				return responseUtility.responseBuilder(0L, changeAgentPasswordRequest.getClientId(), 36);
				
			}
			
		} catch (Exception ex) {
			logger.error("activateAgentProfle :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.responseBuilder(0L, changeAgentPasswordRequest.getClientId(), 99);

		}
	}

	public Response resetAgentPassword(String appId, ResetAgentPasswordRequest resetAgentPasswordRequest,
			LocalDateTime requestIn) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
		try {
			agentProfileActivityLogObject = new AgentProfileActivityLogObject();
			agentProfileActivityLogObject.setAppId(appId);
			agentProfileActivityLogObject.setClientId(resetAgentPasswordRequest.getClientId());
			agentProfileActivityLogObject.setAgentId(resetAgentPasswordRequest.getAgentId());
			agentProfileActivityLogObject.setRequestIn(requestIn);
			agentProfileActivityLogObject = agentProfileActivityLogRepository.save(agentProfileActivityLogObject);
			
			agentPasswordProfileObject = new AgentPasswordProfileObject();  
			agentPasswordProfileObject = agentPasswordProfileRepository.findByAgentId(resetAgentPasswordRequest.getAgentId());
			if(agentProfileObject.getAgentId() == Long.valueOf(resetAgentPasswordRequest.getAgentId())) {
				agentPasswordProfileObject.setAgentId(agentPasswordProfileObject.getAgentId());
				agentPasswordProfileObject.setChangeCount(agentPasswordProfileObject.getChangeCount() + 1);
				agentPasswordProfileObject.setDateCreated(agentPasswordProfileObject.getDateCreated());
				agentPasswordProfileObject.setLastUpdated(LocalDateTime.now());
				String password = authenticationUtility.encryptString(String.valueOf(agentProfileObject.getAgentId() + agentPasswordProfileObject.getChangeCount()));
				agentPasswordProfileObject.setPassword(authenticationUtility.encryptString(String.valueOf(password)));
				agentPasswordProfileObject.setOldPassword(agentPasswordProfileObject.getPassword());
				agentPasswordProfileObject = agentPasswordProfileRepository.save(agentPasswordProfileObject);
				
				
				agentProfileObject = new AgentProfileObject();
				agentProfileObject.setAccountName(agentProfileObject.getAccountName());
				agentProfileObject.setAccountNumber(agentProfileObject.getAccountNumber());
				agentProfileObject.setAgentId(agentProfileObject.getAgentId());
				agentProfileObject.setAgentResidentialAddress(agentProfileObject.getAgentResidentialAddress());
				agentProfileObject.setAgentResidentialLGA(agentProfileObject.getAgentResidentialLGA());
				agentProfileObject.setAgentResidentialState(agentProfileObject.getAgentResidentialState());
				agentProfileObject.setAgentResidentialTown(agentProfileObject.getAgentResidentialTown());
				agentProfileObject.setBankName(agentProfileObject.getBankName());
				agentProfileObject.setBusinessLocation(agentProfileObject.getBusinessLocation());
				agentProfileObject.setBusinessLocationLGA(agentProfileObject.getBusinessLocationLGA());
				agentProfileObject.setBusinessNature(agentProfileObject.getBusinessNature());
				agentProfileObject.setBvn(agentProfileObject.getBvn());
				agentProfileObject.setClientId(agentProfileObject.getClientId());
				agentProfileObject.setDateCreated(agentProfileObject.getDateCreated());
				agentProfileObject.setEmail(agentProfileObject.getEmail());
				agentProfileObject.setFirstName(agentProfileObject.getFirstName());
				agentProfileObject.setGuarantorAddress(agentProfileObject.getGuarantorAddress());
				agentProfileObject.setGuarantorEmail(agentProfileObject.getEmail());
				agentProfileObject.setGuarantorMobileNumber(agentProfileObject.getGuarantorMobileNumber());
				agentProfileObject.setGuarantorName(agentProfileObject.getGuarantorName());
				agentProfileObject.setLastModified(LocalDateTime.now());
				agentProfileObject.setLastName(agentProfileObject.getLastName());
				agentProfileObject.setMeansOfId(agentProfileObject.getMeansOfId());
				agentProfileObject.setMsisdnNetwork(agentProfileObject.getMsisdnNetwork());
				agentProfileObject.setMsisdnNumber(agentProfileObject.getMsisdnNumber());
				agentProfileObject.setRelationshipWithGuarantor(agentProfileObject.getRelationshipWithGuarantor());
				agentProfileObject.setStatus(0);
				agentProfileObject = agentProfileRepository.save(agentProfileObject);
				
				platformTransactionManager.commit(transactionStatus);
				
				messageUtility.sendMail(resetAgentPasswordRequest.getClientId(), appId, "notification@winfast.ng",
						agentProfileObject.getEmail(), "Winfast Agent Password Reset",
						"Dear Agent, your password has been reset to " + password
								+ " please login and change to a password of your choice before you start gaming.",
						requestIn);
				
				return responseUtility.responseBuilder(agentProfileActivityLogObject.getUniqueId(), resetAgentPasswordRequest.getClientId(), 0);
				
			} else {
				platformTransactionManager.commit(transactionStatus);
				logger.info(
						"activateAgentProfle" + resetAgentPasswordRequest.getAgentId() + " Agent Id does not exist");
				return responseUtility.responseBuilder(0L, resetAgentPasswordRequest.getClientId(), 36);
				
			}
			
		} catch (Exception ex) {
			logger.error("activateAgentProfle :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.responseBuilder(0L, resetAgentPasswordRequest.getClientId(), 99);

		}
	}

}
