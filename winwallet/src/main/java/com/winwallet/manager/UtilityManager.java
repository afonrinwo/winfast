/**
 * 
 */
package com.winwallet.manager;

import java.time.LocalDateTime;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.winwallet.model.AccessLogObject;
import com.winwallet.model.Response;
import com.winwallet.model.access.AccessCodesObject;
import com.winwallet.model.access.CustomerDataObject;
import com.winwallet.model.account.CustomerWalletObject;
import com.winwallet.model.account.LienObject;
import com.winwallet.model.account.LienRequest;
import com.winwallet.model.account.PNDObject;
import com.winwallet.model.account.PNDRequest;
import com.winwallet.model.balance.WalletBalanceRequest;
import com.winwallet.model.balance.WalletBalanceResponse;
import com.winwallet.model.cashout.AgentCashOutRequest;
import com.winwallet.model.cashout.CashOutLogObject;
import com.winwallet.model.cashout.CashOutTokenObject;
import com.winwallet.model.cashout.GenerateCashOutTokenRequest;
import com.winwallet.model.cashout.RedeemCashOutTokenRequest;
import com.winwallet.model.enquiry.WalletEnquiryRequest;
import com.winwallet.model.enquiry.WalletEnquiryResponse;
import com.winwallet.model.payment.PaymentLogObject;
import com.winwallet.repository.AccessRepository;
import com.winwallet.repository.CashOutRepository;
import com.winwallet.repository.CustomerDataRepository;
import com.winwallet.repository.CustomerWalletRepository;
import com.winwallet.repository.LienRepository;
import com.winwallet.repository.PNDRepository;
import com.winwallet.repository.PaymentRepository;
import com.winwallet.utility.AuthUtility;
import com.winwallet.utility.MessageUtility;
import com.winwallet.utility.ResponseUtility;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Service
public class UtilityManager {

	private Logger logger = LogManager.getFormatterLogger();
	private AccessLogObject accessLogObject;
	private CustomerDataObject customerDataObject;
	private PaymentLogObject paymentLogObject;
	private AccessCodesObject accessCodesObject;
	private LienObject lienObject;
	private PNDObject pndObject;
	private CustomerWalletObject customerWalletObject;
	private CashOutLogObject cashOutLogObject;
	private CashOutTokenObject cashOutTokenObject;
	private AgentCashOutRequest agentCashOutRequest;

	@Autowired
	AuthUtility authUtility;

	@Autowired
	LienRepository lienRepository;

	@Autowired
	PNDRepository pndRepository;

	@Autowired
	PlatformTransactionManager transactionManager;

	@Autowired
	AccessRepository accessRepository;

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	CustomerWalletRepository customerWalletRepository;

	@Autowired
	ResponseUtility responseUtility;

	@Autowired
	UtilityManager utilityManager;

	@Autowired
	CustomerDataRepository customerDataRepository;

	@Autowired
	CashOutRepository cashOutRepository;

	@Autowired
	MessageUtility messageUtility;

	@Autowired
	CashOutManager cashOutManager;

	public WalletEnquiryResponse walletEnquiry(WalletEnquiryRequest walletEnquiryRequest, LocalDateTime requestIn) {

		try {
			accessLogObject = new AccessLogObject();
			accessLogObject.setChannel(walletEnquiryRequest.getChannel());
			accessLogObject.setClientId(walletEnquiryRequest.getClientId());
			accessLogObject.setMsisdn(walletEnquiryRequest.getMsisdn());
			accessLogObject.setMsisdnNetwork(walletEnquiryRequest.getMsisdnNetwork());
			accessLogObject.setRequestType("walletEnquiry");
			accessLogObject.setRequestIn(requestIn);
			accessLogObject = accessRepository.save(accessLogObject);

			customerDataObject = new CustomerDataObject();
			customerDataObject = customerDataRepository.findByMsisdn(accessLogObject.getMsisdn());
			if (customerDataObject.getMsisdn() != null) {
				return responseUtility.walletEnquiryResponse(0L, walletEnquiryRequest.getClientId(), customerDataObject,
						0);
			} else {
				return responseUtility.walletEnquiryResponse(0L, walletEnquiryRequest.getClientId(), 35);
			}
		} catch (Exception ex) {
			logger.error("AccessManager :: walletEnquiry :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.walletEnquiryResponse(0L, walletEnquiryRequest.getClientId(), 99);

		}
	}

	public WalletBalanceResponse walletBalance(WalletBalanceRequest walletBalanceRequest, LocalDateTime localDateTime) {
		try {
			customerWalletObject = new CustomerWalletObject();
			if (customerWalletRepository.existsByMsisdn(walletBalanceRequest.getMsisdn())) {
				customerWalletObject = customerWalletRepository.findByMsisdn(walletBalanceRequest.getMsisdn());
				return responseUtility.walletBalanceResponse(0l, customerWalletObject,
						walletBalanceRequest.getClientId(), 99);

			} else {
				return responseUtility.walletBalanceResponse(0l, walletBalanceRequest.getClientId(), 35);
			}

		} catch (Exception ex) {
			logger.error("walletBalance :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.walletBalanceResponse(0l, walletBalanceRequest.getClientId(), 99);

		}
	}

	public String walletRules(String msisdn, String pin, double amount) {
		try {
			if (pinVerication(msisdn, pin)) {
				customerWalletObject = new CustomerWalletObject();
				customerWalletObject = customerWalletRepository.findByMsisdn(msisdn);
				if (customerWalletObject.getPnd() == 0) {
					if (customerWalletObject.getAvailableBalance() > amount) {
						return "00";

					} else {
						return "14";
					}

				} else {
					return "37";
				}

			} else {
				return "36";
			}
		} catch (Exception ex) {
			logger.error(
					"walletRules :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return "99";
		}
	}

	public boolean pinVerication(String msisdn, String pin) {

		accessCodesObject = new AccessCodesObject();
		accessCodesObject = accessRepository.findByMsisdn(msisdn);
		if (accessCodesObject.getHashText().equals(authUtility.encryptString(pin))) {
			return true;
		} else {
			return false;
		}
	}

	public Response placeLien(LienRequest lienRequest, LocalDateTime requestIn) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);

		try {

			paymentLogObject = new PaymentLogObject();
			paymentLogObject.setAmount(lienRequest.getLienAmount());
			paymentLogObject.setChannel(lienRequest.getChannel());
			paymentLogObject.setClientId(lienRequest.getClientId());
			paymentLogObject.setMsisdn(lienRequest.getMsisdn());
			paymentLogObject.setMsisdnNetwork(lienRequest.getMsisdnNetwork());
			paymentLogObject.setRequestType("placeLien");
			paymentLogObject.setRequestIn(requestIn);
			paymentLogObject = paymentRepository.save(paymentLogObject);

			customerWalletObject = new CustomerWalletObject();
			customerWalletObject = customerWalletRepository.findByMsisdn(lienRequest.getMsisdn());
			customerWalletObject
					.setAvailableBalance(customerWalletObject.getAvailableBalance() - lienRequest.getLienAmount());
			customerWalletObject.setBookBalance(customerWalletObject.getBookBalance() + lienRequest.getLienAmount());
			customerWalletObject.setDateCreated(LocalDateTime.now());
			customerWalletObject.setLastEditedDate(LocalDateTime.now());
			customerWalletObject.setLien(lienRequest.getLienAmount());
			customerWalletObject.setMsisdn(customerWalletObject.getMsisdn());
			customerWalletObject.setMsisdnNetwork(customerWalletObject.getMsisdnNetwork());
			customerWalletObject.setPnd(customerWalletObject.getPnd());
			customerWalletRepository.save(customerWalletObject);

			lienObject = new LienObject();
			lienObject.setChannel(lienRequest.getChannel());
			lienObject.setClientId(lienRequest.getClientId());
			lienObject.setDatePlaced(LocalDateTime.now());
			lienObject.setLienAmount(lienRequest.getLienAmount());
			lienObject.setLienReason(lienRequest.getLienReason());
			lienObject.setMsisdn(lienRequest.getMsisdn());
			lienObject.setMsisdnNetwork(lienRequest.getMsisdnNetwork());
			lienObject = lienRepository.save(lienObject);

			transactionManager.commit(transactionStatus);

			return responseUtility.response(customerWalletObject.getUniqueId(), lienRequest.getClientId(), 0);

		} catch (Exception ex) {
			transactionManager.rollback(transactionStatus);
			logger.error(
					"placeLien :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return responseUtility.response(0L, lienRequest.getClientId(), 99);
		}

	}

	public Response removeLien(LienRequest lienRequest, LocalDateTime requestIn) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);

		try {

			paymentLogObject = new PaymentLogObject();
			paymentLogObject.setAmount(lienRequest.getLienAmount());
			paymentLogObject.setChannel(lienRequest.getChannel());
			paymentLogObject.setClientId(lienRequest.getClientId());
			paymentLogObject.setMsisdn(lienRequest.getMsisdn());
			paymentLogObject.setMsisdnNetwork(lienRequest.getMsisdnNetwork());
			paymentLogObject.setRequestType("removeLien");
			paymentLogObject.setRequestIn(requestIn);
			paymentLogObject = paymentRepository.save(paymentLogObject);

			customerWalletObject = new CustomerWalletObject();
			customerWalletObject = customerWalletRepository.findByMsisdn(lienRequest.getMsisdn());
			customerWalletObject
					.setAvailableBalance(customerWalletObject.getAvailableBalance() + lienRequest.getLienAmount());
			customerWalletObject.setBookBalance(customerWalletObject.getBookBalance() - lienRequest.getLienAmount());
			customerWalletObject.setDateCreated(customerWalletObject.getDateCreated());
			customerWalletObject.setLastEditedDate(LocalDateTime.now());
			customerWalletObject.setLien(lienRequest.getLienAmount());
			customerWalletObject.setMsisdn(customerWalletObject.getMsisdn());
			customerWalletObject.setMsisdnNetwork(customerWalletObject.getMsisdnNetwork());
			customerWalletObject.setPnd(customerWalletObject.getPnd());
			customerWalletRepository.save(customerWalletObject);

			lienObject = new LienObject();
			lienObject = lienRepository.findByMsisdn(lienRequest.getMsisdn());
			lienObject.setChannel(lienRequest.getChannel());
			lienObject.setClientId(lienRequest.getClientId());
			lienObject.setDatePlaced(lienObject.getDatePlaced());
			lienObject.setDateRemoved(LocalDateTime.now());
			lienObject.setLienAmount(lienRequest.getLienAmount());
			lienObject.setLienReason(lienRequest.getLienReason());
			lienObject.setMsisdn(lienRequest.getMsisdn());
			lienObject.setMsisdnNetwork(lienRequest.getMsisdnNetwork());
			lienObject = lienRepository.save(lienObject);

			transactionManager.commit(transactionStatus);

			return responseUtility.response(customerWalletObject.getUniqueId(), lienRequest.getClientId(), 0);

		} catch (Exception ex) {
			transactionManager.rollback(transactionStatus);
			logger.error(
					"removeLien :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return responseUtility.response(0L, lienRequest.getClientId(), 99);
		}

	}

	public Response placePnd(PNDRequest pndRequest, LocalDateTime requestIn) {

		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);

		try {
			paymentLogObject = new PaymentLogObject();
			paymentLogObject.setChannel(pndRequest.getChannel());
			paymentLogObject.setClientId(pndRequest.getClientId());
			paymentLogObject.setMsisdn(pndRequest.getMsisdn());
			paymentLogObject.setMsisdnNetwork(pndRequest.getMsisdnNetwork());
			paymentLogObject.setRequestType("placePnd");
			paymentLogObject.setPndFlag(pndRequest.getPndFlag());
			paymentLogObject.setRequestIn(requestIn);
			paymentLogObject = paymentRepository.save(paymentLogObject);

			customerWalletObject = new CustomerWalletObject();
			customerWalletObject = customerWalletRepository.findByMsisdn(pndRequest.getMsisdn());
			customerWalletObject.setAvailableBalance(customerWalletObject.getAvailableBalance());
			customerWalletObject.setBookBalance(customerWalletObject.getBookBalance());
			customerWalletObject.setDateCreated(LocalDateTime.now());
			customerWalletObject.setLastEditedDate(LocalDateTime.now());
			customerWalletObject.setLien(customerWalletObject.getLien());
			customerWalletObject.setMsisdn(customerWalletObject.getMsisdn());
			customerWalletObject.setMsisdnNetwork(customerWalletObject.getMsisdnNetwork());
			customerWalletObject.setPnd(pndRequest.getPndFlag());
			customerWalletRepository.save(customerWalletObject);

			pndObject = new PNDObject();
			pndObject.setChannel(pndRequest.getChannel());
			pndObject.setClientId(pndRequest.getClientId());
			pndObject.setDatePlaced(LocalDateTime.now().toString());
			pndObject.setMsisdn(pndRequest.getMsisdn());
			pndObject.setMsisdnNetwork(pndRequest.getMsisdnNetwork());
			pndObject.setPndFlag(pndRequest.getPndFlag());
			pndObject.setPndReason(pndRequest.getPndReason());
			pndObject = pndRepository.save(pndObject);

			transactionManager.commit(transactionStatus);

			return responseUtility.response(customerWalletObject.getUniqueId(), pndRequest.getClientId(), 0);

		} catch (Exception ex) {
			transactionManager.rollback(transactionStatus);
			logger.error(
					"placePnd :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return responseUtility.response(0L, pndRequest.getClientId(), 99);
		}

	}

	public Response removePND(PNDRequest pndRequest, LocalDateTime requestIn) {

		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);

		try {
			paymentLogObject = new PaymentLogObject();
			paymentLogObject.setChannel(pndRequest.getChannel());
			paymentLogObject.setClientId(pndRequest.getClientId());
			paymentLogObject.setMsisdn(pndRequest.getMsisdn());
			paymentLogObject.setMsisdnNetwork(pndRequest.getMsisdnNetwork());
			paymentLogObject.setRequestType("removePND");
			paymentLogObject.setPndFlag(pndRequest.getPndFlag());
			paymentLogObject.setRequestIn(requestIn);
			paymentLogObject = paymentRepository.save(paymentLogObject);

			customerWalletObject = new CustomerWalletObject();
			customerWalletObject = customerWalletRepository.findByMsisdn(pndRequest.getMsisdn());
			customerWalletObject.setAvailableBalance(customerWalletObject.getAvailableBalance());
			customerWalletObject.setBookBalance(customerWalletObject.getBookBalance());
			customerWalletObject.setDateCreated(LocalDateTime.now());
			customerWalletObject.setLastEditedDate(LocalDateTime.now());
			customerWalletObject.setLien(customerWalletObject.getLien());
			customerWalletObject.setMsisdn(customerWalletObject.getMsisdn());
			customerWalletObject.setMsisdnNetwork(customerWalletObject.getMsisdnNetwork());
			customerWalletObject.setPnd(pndRequest.getPndFlag());
			customerWalletRepository.save(customerWalletObject);

			pndObject = new PNDObject();
			pndObject = pndRepository.findByMsisdn(pndRequest.getMsisdn());
			pndObject.setChannel(pndRequest.getChannel());
			pndObject.setClientId(pndRequest.getClientId());
			pndObject.setDatePlaced(pndObject.getDatePlaced());
			pndObject.setMsisdn(pndRequest.getMsisdn());
			pndObject.setMsisdnNetwork(pndRequest.getMsisdnNetwork());
			pndObject.setPndFlag(pndRequest.getPndFlag());
			pndObject.setPndReason(pndRequest.getPndReason());
			pndObject = pndRepository.save(pndObject);

			transactionManager.commit(transactionStatus);

			return responseUtility.response(customerWalletObject.getUniqueId(), pndRequest.getClientId(), 0);

		} catch (Exception ex) {
			transactionManager.rollback(transactionStatus);
			logger.error(
					"removePND :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return responseUtility.response(0L, pndRequest.getClientId(), 99);
		}

	}

	public Response generateCashOutToken(String appId, GenerateCashOutTokenRequest generateCashOutTokenRequest,
			LocalDateTime requestIn) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);

		try {
			cashOutLogObject = new CashOutLogObject();
			cashOutLogObject.setAmount(generateCashOutTokenRequest.getAmount());
			cashOutLogObject.setChannel(generateCashOutTokenRequest.getChannel());
			cashOutLogObject.setClientId(generateCashOutTokenRequest.getClientId());
			cashOutLogObject.setMsisdn2Debit(generateCashOutTokenRequest.getMsisdn2Debit());
			cashOutLogObject.setMsisdn2DebitNetwork(generateCashOutTokenRequest.getMsisdn2DebitNetwork());
			cashOutLogObject.setRequestType("cashOutToken");
			cashOutLogObject.setNarration(generateCashOutTokenRequest.getNarration());
			cashOutLogObject.setRequestIn(requestIn);
			cashOutLogObject = cashOutRepository.save(cashOutLogObject);

			cashOutTokenObject = new CashOutTokenObject();
			cashOutTokenObject.setAmount(cashOutLogObject.getAmount());
			cashOutTokenObject.setChannel(cashOutLogObject.getChannel());
			cashOutTokenObject.setClientId(cashOutLogObject.getClientId());
			cashOutTokenObject.setMsisdn2Debit(cashOutLogObject.getMsisdn2Debit());
			cashOutTokenObject.setMsisdn2DebitNetwork(cashOutLogObject.getMsisdn2DebitNetwork());
			cashOutTokenObject.setNarration(cashOutLogObject.getNarration());
			cashOutTokenObject.setPayDate(null);
			cashOutTokenObject.setPayFlag(0);
			Random rnd = new Random();
			int number = rnd.nextInt(999999);
			String payToken = authUtility.base64Encode(String.format("%06d", number));
			cashOutTokenObject.setPayToken(payToken);
			cashOutTokenObject = cashOutRepository.save(cashOutTokenObject);

			transactionManager.commit(transactionStatus);

			messageUtility.sendMail(cashOutTokenObject.getClientId(), "Wallet", "notification@winfast.ng",
					"b.adewole@cloud-africa.com", "Winfast Game Account", "Your payment token is " + payToken
							+ " for the amount  " + cashOutTokenObject.getAmount() + "from his/her wallet.",
					LocalDateTime.now());

			return responseUtility.response(cashOutLogObject.getUniqueId(), generateCashOutTokenRequest.getClientId(),
					00);

		} catch (Exception ex) {
			transactionManager.rollback(transactionStatus);
			logger.error("generateCashOutToken :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.response(0L, generateCashOutTokenRequest.getClientId(), 99);
		}
	}

	public Response redeemCashOutToken(RedeemCashOutTokenRequest redeemCashOutTokenRequest, LocalDateTime requestIn) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
		try {
			cashOutLogObject = new CashOutLogObject();
			cashOutLogObject.setAmount(redeemCashOutTokenRequest.getAmount());
			cashOutLogObject.setChannel(redeemCashOutTokenRequest.getChannel());
			cashOutLogObject.setClientId(redeemCashOutTokenRequest.getClientId());
			cashOutLogObject.setMsisdn2Debit(redeemCashOutTokenRequest.getMsisdn2Debit());
			cashOutLogObject.setMsisdn2DebitNetwork(redeemCashOutTokenRequest.getMsisdn2DebitNetwork());
			cashOutLogObject.setRequestType("redeemCashOutToken");
			cashOutLogObject.setNarration(redeemCashOutTokenRequest.getNarration());
			cashOutLogObject.setRequestIn(requestIn);
			cashOutLogObject = cashOutRepository.save(cashOutLogObject);

			cashOutTokenObject = new CashOutTokenObject();
			cashOutTokenObject = cashOutRepository.findByMsisdn2DebitNetworkAndAmountAndPayToken(
					redeemCashOutTokenRequest.getMsisdn2Debit(), redeemCashOutTokenRequest.getAmount(),
					authUtility.base64Encode(redeemCashOutTokenRequest.getPayToken()));
			if (cashOutTokenObject.getPayToken()
					.equals(authUtility.base64Encode(redeemCashOutTokenRequest.getPayToken()))) {
				cashOutTokenObject.setAmount(cashOutTokenObject.getAmount());
				cashOutTokenObject.setChannel(cashOutTokenObject.getChannel());
				cashOutTokenObject.setClientId(cashOutTokenObject.getClientId());
				cashOutTokenObject.setMsisdn2Debit(cashOutTokenObject.getMsisdn2Debit());
				cashOutTokenObject.setMsisdn2DebitNetwork(cashOutTokenObject.getMsisdn2DebitNetwork());
				cashOutTokenObject.setNarration(cashOutTokenObject.getNarration());
				cashOutTokenObject.setPayDate(LocalDateTime.now());
				cashOutTokenObject.setPayFlag(1);
				cashOutTokenObject.setPayToken(cashOutTokenObject.getPayToken());
				cashOutTokenObject = cashOutRepository.save(cashOutTokenObject);

				transactionManager.commit(transactionStatus);

				agentCashOutRequest = new AgentCashOutRequest();
				agentCashOutRequest.setAgentId2Credit(redeemCashOutTokenRequest.getAgentId2Credit());
				agentCashOutRequest.setAgentId2CreditNetwork(redeemCashOutTokenRequest.getAgentId2CreditNetwork());
				agentCashOutRequest.setAmount(redeemCashOutTokenRequest.getAmount());
				agentCashOutRequest.setChannel(redeemCashOutTokenRequest.getChannel());
				agentCashOutRequest.setClientId(redeemCashOutTokenRequest.getClientId());
				agentCashOutRequest.setMsisdn2Debit(redeemCashOutTokenRequest.getMsisdn2Debit());
				agentCashOutRequest.setMsisdn2DebitNetwork(redeemCashOutTokenRequest.getMsisdn2DebitNetwork());
				agentCashOutRequest.setNarration(redeemCashOutTokenRequest.getNarration());
				agentCashOutRequest.setPin(redeemCashOutTokenRequest.getPin());
				Response rsp = cashOutManager.agentCashOut(agentCashOutRequest, requestIn);
				if (rsp.getResponseCode().equals("00")) {

					messageUtility
							.sendMail(cashOutTokenObject.getClientId(), "Wallet", "notification@winfast.ng",
									"b.adewole@cloud-africa.com", "Winfast Game Account",
									"Your payment token is " + cashOutTokenObject.getPayToken() + " for the amount  "
											+ cashOutTokenObject.getAmount() + "from his/her wallet.",
									LocalDateTime.now());

					return responseUtility.response(cashOutLogObject.getUniqueId(),
							redeemCashOutTokenRequest.getClientId(), 00);

				} else {
					return rsp;
				}

			} else {
				return responseUtility.response(0, redeemCashOutTokenRequest.getClientId(), 38);
			}

		} catch (Exception ex) {
			transactionManager.rollback(transactionStatus);
			logger.error("generateCashOutToken :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.response(0L, redeemCashOutTokenRequest.getClientId(), 99);
		}
	}
}
