/**
 * 
 */
package com.winwallet.manager;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.winwallet.model.ConfigurationObject;
import com.winwallet.model.Response;
import com.winwallet.model.access.CustomerDataObject;
import com.winwallet.model.account.CustomerWalletObject;
import com.winwallet.model.account.OfficeWalletObject;
import com.winwallet.model.payment.PaymentLogObject;
import com.winwallet.model.payment.Wallet2WalletRequest;
import com.winwallet.model.payment.WalletCreditRequest;
import com.winwallet.model.payment.WalletDebitRequest;
import com.winwallet.model.payment.WalletDepositRequest;
import com.winwallet.repository.CustomerWalletRepository;
import com.winwallet.repository.OfficeWalletRepository;
import com.winwallet.repository.PaymentRepository;
import com.winwallet.utility.MessageUtility;
import com.winwallet.utility.ResponseUtility;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Service
public class PaymentManager {
	private Logger logger = LogManager.getFormatterLogger();
	private PaymentLogObject paymentLogObject;
	private CustomerWalletObject customerWalletObject;
	private CustomerDataObject customerDataObject;
	private OfficeWalletObject officeWalletObject;

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	CustomerWalletRepository customerWalletRepository;

	@Autowired
	PlatformTransactionManager transactionManager;

	@Autowired
	ResponseUtility responseUtility;

	@Autowired
	OfficeWalletRepository officeWalletRepository;

	@Autowired
	MessageUtility messageUtility;

	@Autowired
	ConfigurationObject configurationObject;

	@Autowired
	UtilityManager utilityManager;

	public Response walletDeposit(WalletDepositRequest walletDepositRequest, LocalDateTime requestIn) {

		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);

		try {

			paymentLogObject = new PaymentLogObject();
			paymentLogObject.setAmount(walletDepositRequest.getAmount());
			paymentLogObject.setChannel(walletDepositRequest.getChannel());
			paymentLogObject.setClientId(walletDepositRequest.getClientId());
			paymentLogObject.setMsisdn(walletDepositRequest.getMsisdn());
			paymentLogObject.setMsisdn2CreditNetwork(walletDepositRequest.getMsisdnNetwork());
			paymentLogObject.setRequestType("WalletDeposit");
			paymentLogObject.setRequestIn(requestIn);
			paymentLogObject.setFundSource(walletDepositRequest.getFundSource());
			paymentLogObject = paymentRepository.save(paymentLogObject);

			if (customerWalletRepository.existsByMsisdn(walletDepositRequest.getMsisdn())) {

				try {

					officeWalletObject = new OfficeWalletObject();
					officeWalletObject = officeWalletRepository.findByWalletNumber(configurationObject.getGameWallet());
					officeWalletObject.setAvailableBalance(
							officeWalletObject.getAvailableBalance() - walletDepositRequest.getAmount());
					officeWalletObject
							.setBookBalance(officeWalletObject.getBookBalance() - walletDepositRequest.getAmount());
					officeWalletObject.setDateCreated(officeWalletObject.getDateCreated());
					officeWalletObject.setLastEditedDate(LocalDateTime.now());
					officeWalletObject = officeWalletRepository.save(officeWalletObject);

					customerWalletObject = new CustomerWalletObject();
					customerWalletObject = customerWalletRepository.findByMsisdn(walletDepositRequest.getMsisdn());
					customerWalletObject.setMsisdnNetwork(walletDepositRequest.getMsisdnNetwork());
					customerWalletObject.setAvailableBalance(customerWalletObject.getAvailableBalance()
							+ Double.valueOf(walletDepositRequest.getAmount()));
					customerWalletObject.setBookBalance(customerWalletObject.getBookBalance()
							+ customerWalletObject.getLien() + Double.valueOf(walletDepositRequest.getAmount()));
					customerWalletObject.setDateCreated(LocalDateTime.now());
					customerWalletObject.setLastEditedDate(LocalDateTime.now());
					customerWalletObject.setLien(customerWalletObject.getLien());
					customerWalletObject.setMsisdn(customerWalletObject.getMsisdn());
					customerWalletObject.setPnd(customerWalletObject.getPnd());
					customerWalletRepository.save(customerWalletObject);

					customerDataObject = new CustomerDataObject();
					customerDataObject.setDateCreated(LocalDateTime.now());
					customerDataObject.setMsisdn(customerWalletObject.getMsisdn());
					customerDataObject.setMsisdnNetwork(customerWalletObject.getMsisdnNetwork());

					officeWalletObject = new OfficeWalletObject();
					officeWalletObject = officeWalletRepository
							.findByWalletNumber(configurationObject.getWalletPosition());
					officeWalletObject.setAvailableBalance(
							officeWalletObject.getAvailableBalance() + walletDepositRequest.getAmount());
					officeWalletObject
							.setBookBalance(officeWalletObject.getBookBalance() + walletDepositRequest.getAmount());
					officeWalletObject.setDateCreated(officeWalletObject.getDateCreated());
					officeWalletObject.setLastEditedDate(LocalDateTime.now());
					officeWalletObject = officeWalletRepository.save(officeWalletObject);

					transactionManager.commit(transactionStatus);

					return responseUtility.response(paymentLogObject.getUniqueId(), paymentLogObject.getClientId(), 0);

				} catch (Exception ex) {
					logger.error("walletDeposit :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
							+ ex.getStackTrace());
					transactionManager.rollback(transactionStatus);
					return responseUtility.response(0L, paymentLogObject.getClientId(), 99);
				}

			} else {

				officeWalletObject = new OfficeWalletObject();
				officeWalletObject = officeWalletRepository.findByWalletNumber(configurationObject.getGameWallet());
				officeWalletObject.setAvailableBalance(
						officeWalletObject.getAvailableBalance() - walletDepositRequest.getAmount());
				officeWalletObject
						.setBookBalance(officeWalletObject.getBookBalance() - walletDepositRequest.getAmount());
				officeWalletObject.setDateCreated(officeWalletObject.getDateCreated());
				officeWalletObject.setLastEditedDate(LocalDateTime.now());
				officeWalletObject = officeWalletRepository.save(officeWalletObject);

				customerWalletObject = new CustomerWalletObject();
				customerWalletObject.setAvailableBalance(
						customerWalletObject.getAvailableBalance() + Double.valueOf(walletDepositRequest.getAmount()));
				customerWalletObject.setBookBalance(customerWalletObject.getBookBalance()
						+ customerWalletObject.getLien() + Double.valueOf(walletDepositRequest.getAmount()));
				customerWalletObject.setDateCreated(LocalDateTime.now());
				customerWalletObject.setLastEditedDate(LocalDateTime.now());
				customerWalletObject.setLien(0.00);
				customerWalletObject.setMsisdn(walletDepositRequest.getMsisdn());
				customerWalletObject.setMsisdnNetwork(walletDepositRequest.getMsisdnNetwork());
				customerWalletObject.setPnd(0);
				customerWalletRepository.save(customerWalletObject);

				officeWalletObject = new OfficeWalletObject();
				officeWalletObject = officeWalletRepository.findByWalletNumber(configurationObject.getWalletPosition());
				officeWalletObject.setAvailableBalance(
						officeWalletObject.getAvailableBalance() + walletDepositRequest.getAmount());
				officeWalletObject
						.setBookBalance(officeWalletObject.getBookBalance() + walletDepositRequest.getAmount());
				officeWalletObject.setDateCreated(officeWalletObject.getDateCreated());
				officeWalletObject.setLastEditedDate(LocalDateTime.now());
				officeWalletObject = officeWalletRepository.save(officeWalletObject);

				transactionManager.commit(transactionStatus);

				// SMS notification
				messageUtility.sendsms(paymentLogObject.getClientId(), walletDepositRequest.getMsisdnNetwork(),
						walletDepositRequest.getMsisdn(), "", requestIn);

				return responseUtility.response(paymentLogObject.getUniqueId(), paymentLogObject.getClientId(), 0);
			}

		} catch (Exception ex) {
			logger.error("walletDeposit :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			transactionManager.rollback(transactionStatus);
			return responseUtility.response(paymentLogObject.getUniqueId(), paymentLogObject.getClientId(), 99);
		}

	}

	public Response walletCredit(WalletCreditRequest walletCreditRequest, LocalDateTime requestIn) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);

		try {
			paymentLogObject = new PaymentLogObject();
			paymentLogObject.setAmount(walletCreditRequest.getAmount());
			paymentLogObject.setChannel(walletCreditRequest.getChannel());
			paymentLogObject.setClientId(walletCreditRequest.getClientId());
			paymentLogObject.setMsisdn2Credit(walletCreditRequest.getMsisdn());
			paymentLogObject.setMsisdn2CreditNetwork(walletCreditRequest.getMsisdnNetwork());
			paymentLogObject.setMsisdn2Debit(configurationObject.getGameWallet());
			paymentLogObject.setRequestType("walletCredit");
			paymentLogObject.setNarration(walletCreditRequest.getNarration());
			paymentLogObject.setRequestIn(requestIn);
			paymentLogObject = paymentRepository.save(paymentLogObject);

			customerWalletObject = new CustomerWalletObject();
			customerWalletObject = customerWalletRepository.findByMsisdn(walletCreditRequest.getMsisdn());
			customerWalletObject
					.setAvailableBalance(customerWalletObject.getAvailableBalance() + walletCreditRequest.getAmount());
			customerWalletObject
					.setBookBalance(customerWalletObject.getBookBalance() + walletCreditRequest.getAmount());
			customerWalletObject.setDateCreated(customerWalletObject.getDateCreated());
			customerWalletObject.setLastEditedDate(LocalDateTime.now());
			customerWalletObject.setLien(customerWalletObject.getLien());
			customerWalletObject.setMsisdn(customerWalletObject.getMsisdn());
			customerWalletObject.setMsisdnNetwork(customerWalletObject.getMsisdnNetwork());
			customerWalletObject.setPnd(customerWalletObject.getPnd());
			customerWalletRepository.save(customerWalletObject);

			officeWalletObject = new OfficeWalletObject();
			officeWalletObject = officeWalletRepository.findByWalletNumber(configurationObject.getGameWallet());
			officeWalletObject
					.setAvailableBalance(officeWalletObject.getAvailableBalance() - walletCreditRequest.getAmount());
			officeWalletObject.setBookBalance(officeWalletObject.getBookBalance() - walletCreditRequest.getAmount());
			officeWalletObject.setDateCreated(officeWalletObject.getDateCreated());
			officeWalletObject.setLastEditedDate(LocalDateTime.now());
			officeWalletObject = officeWalletRepository.save(officeWalletObject);

			officeWalletObject = new OfficeWalletObject();
			officeWalletObject = officeWalletRepository.findByWalletNumber(configurationObject.getWalletPosition());
			officeWalletObject
					.setAvailableBalance(officeWalletObject.getAvailableBalance() + walletCreditRequest.getAmount());
			officeWalletObject.setBookBalance(officeWalletObject.getBookBalance() + walletCreditRequest.getAmount());
			officeWalletObject.setDateCreated(officeWalletObject.getDateCreated());
			officeWalletObject.setLastEditedDate(LocalDateTime.now());
			officeWalletObject = officeWalletRepository.save(officeWalletObject);

			transactionManager.commit(transactionStatus);

			return responseUtility.response(customerWalletObject.getUniqueId(), walletCreditRequest.getClientId(), 0);

		} catch (Exception ex) {
			transactionManager.rollback(transactionStatus);
			logger.error(
					"walletCredit :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return responseUtility.response(0l, walletCreditRequest.getClientId(), 99);
		}
	}

	public Response walletDebit(WalletDebitRequest walletDebitRequest, LocalDateTime requestIn) {

		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);

		try {
			paymentLogObject = new PaymentLogObject();
			paymentLogObject.setAmount(walletDebitRequest.getAmount());
			paymentLogObject.setChannel(walletDebitRequest.getChannel());
			paymentLogObject.setClientId(walletDebitRequest.getClientId());
			paymentLogObject.setMsisdn2Debit(walletDebitRequest.getMsisdn());
			paymentLogObject.setMsisdn2DebitNetwork(walletDebitRequest.getMsisdnNetwork());
			paymentLogObject.setMsisdn2Credit(configurationObject.getGameWallet());
			paymentLogObject.setRequestType("walletDebit");
			paymentLogObject.setNarration(walletDebitRequest.getNarration());
			paymentLogObject.setRequestIn(requestIn);
			paymentLogObject = paymentRepository.save(paymentLogObject);

			String code = utilityManager.walletRules(walletDebitRequest.getMsisdn(), walletDebitRequest.getPin(),
					walletDebitRequest.getAmount());
			switch (code) {
			case "00":
				customerWalletObject = new CustomerWalletObject();
				customerWalletObject = customerWalletRepository.findByMsisdn(walletDebitRequest.getMsisdn());
				customerWalletObject.setAvailableBalance(
						customerWalletObject.getAvailableBalance() - walletDebitRequest.getAmount());
				customerWalletObject
						.setBookBalance(customerWalletObject.getBookBalance() - walletDebitRequest.getAmount());
				customerWalletObject.setDateCreated(customerWalletObject.getDateCreated());
				customerWalletObject.setLastEditedDate(LocalDateTime.now());
				customerWalletObject.setLien(customerWalletObject.getLien());
				customerWalletObject.setMsisdn(customerWalletObject.getMsisdn());
				customerWalletObject.setMsisdnNetwork(customerWalletObject.getMsisdnNetwork());
				customerWalletObject.setPnd(customerWalletObject.getPnd());
				customerWalletRepository.save(customerWalletObject);

				officeWalletObject = new OfficeWalletObject();
				officeWalletObject = officeWalletRepository.findByWalletNumber(configurationObject.getGameWallet());
				officeWalletObject
						.setAvailableBalance(officeWalletObject.getAvailableBalance() + walletDebitRequest.getAmount());
				officeWalletObject.setBookBalance(officeWalletObject.getBookBalance() + walletDebitRequest.getAmount());
				officeWalletObject.setDateCreated(officeWalletObject.getDateCreated());
				officeWalletObject.setLastEditedDate(LocalDateTime.now());
				officeWalletObject = officeWalletRepository.save(officeWalletObject);

				officeWalletObject = new OfficeWalletObject();
				officeWalletObject = officeWalletRepository.findByWalletNumber(configurationObject.getWalletPosition());
				officeWalletObject
						.setAvailableBalance(officeWalletObject.getAvailableBalance() - walletDebitRequest.getAmount());
				officeWalletObject.setBookBalance(officeWalletObject.getBookBalance() - walletDebitRequest.getAmount());
				officeWalletObject.setDateCreated(officeWalletObject.getDateCreated());
				officeWalletObject.setLastEditedDate(LocalDateTime.now());
				officeWalletObject = officeWalletRepository.save(officeWalletObject);

				transactionManager.commit(transactionStatus);

				return responseUtility.response(customerWalletObject.getUniqueId(), walletDebitRequest.getClientId(),
						0);

			default:
				return responseUtility.response(paymentLogObject.getUniqueId(), walletDebitRequest.getClientId(),
						Integer.valueOf(code));
			}

		} catch (Exception ex) {
			transactionManager.rollback(transactionStatus);
			logger.error(
					"walletDebit :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return responseUtility.response(0l, walletDebitRequest.getClientId(), 99);
		}
	}

	public Response wallet2Wallet(Wallet2WalletRequest wallet2WalletRequest, LocalDateTime requestIn) {

		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);

		try {

			paymentLogObject = new PaymentLogObject();
			paymentLogObject.setAmount(wallet2WalletRequest.getAmount());
			paymentLogObject.setChannel(wallet2WalletRequest.getChannel());
			paymentLogObject.setClientId(wallet2WalletRequest.getClientId());
			paymentLogObject.setMsisdn2Debit(wallet2WalletRequest.getMsisdn2Debit());
			paymentLogObject.setMsisdn2DebitNetwork(wallet2WalletRequest.getMsisdn2DebitNetwork());
			paymentLogObject.setMsisdn2Credit(wallet2WalletRequest.getMsisdnCredit());
			paymentLogObject.setMsisdn2CreditNetwork(wallet2WalletRequest.getMsisdnCreditNetwork());
			paymentLogObject.setMsisdn2Credit(configurationObject.getGameWallet());
			paymentLogObject.setRequestType("walletDebit");
			paymentLogObject.setNarration(wallet2WalletRequest.getNarration());
			paymentLogObject.setRequestIn(requestIn);
			paymentLogObject = paymentRepository.save(paymentLogObject);

			if (wallet2WalletRequest.getMsisdn2Debit().equals(wallet2WalletRequest.getMsisdnCredit())) {
				return responseUtility.response(paymentLogObject.getUniqueId(), wallet2WalletRequest.getClientId(), 39);
			} else {

				String code = utilityManager.walletRules(wallet2WalletRequest.getMsisdn2Debit(),
						wallet2WalletRequest.getPin(), wallet2WalletRequest.getAmount());
				switch (code) {
				case "00":
					customerWalletObject = new CustomerWalletObject();
					customerWalletObject = customerWalletRepository
							.findByMsisdn(wallet2WalletRequest.getMsisdn2Debit());
					customerWalletObject.setAvailableBalance(
							customerWalletObject.getAvailableBalance() - wallet2WalletRequest.getAmount());
					customerWalletObject
							.setBookBalance(customerWalletObject.getBookBalance() - wallet2WalletRequest.getAmount());
					customerWalletObject.setDateCreated(customerWalletObject.getDateCreated());
					customerWalletObject.setLastEditedDate(LocalDateTime.now());
					customerWalletObject.setLien(customerWalletObject.getLien());
					customerWalletObject.setMsisdn(customerWalletObject.getMsisdn());
					customerWalletObject.setMsisdnNetwork(customerWalletObject.getMsisdnNetwork());
					customerWalletObject.setPnd(customerWalletObject.getPnd());
					customerWalletRepository.save(customerWalletObject);

					customerWalletObject = new CustomerWalletObject();
					customerWalletObject = customerWalletRepository
							.findByMsisdn(wallet2WalletRequest.getMsisdnCredit());
					customerWalletObject.setAvailableBalance(
							customerWalletObject.getAvailableBalance() + wallet2WalletRequest.getAmount());
					customerWalletObject
							.setBookBalance(customerWalletObject.getBookBalance() + wallet2WalletRequest.getAmount());
					customerWalletObject.setDateCreated(customerWalletObject.getDateCreated());
					customerWalletObject.setLastEditedDate(LocalDateTime.now());
					customerWalletObject.setLien(customerWalletObject.getLien());
					customerWalletObject.setMsisdn(customerWalletObject.getMsisdn());
					customerWalletObject.setMsisdnNetwork(customerWalletObject.getMsisdnNetwork());
					customerWalletObject.setPnd(customerWalletObject.getPnd());
					customerWalletRepository.save(customerWalletObject);
					
					transactionManager.commit(transactionStatus);

 					return responseUtility.response(paymentLogObject.getUniqueId(), wallet2WalletRequest.getClientId(),
							0);

				default:
					return responseUtility.response(paymentLogObject.getUniqueId(), wallet2WalletRequest.getClientId(),
							Integer.valueOf(code));
				}
			}

		} catch (Exception ex) {
			transactionManager.rollback(transactionStatus);
			logger.error("wallet2Wallet :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.response(0l, wallet2WalletRequest.getClientId(), 99);
		}
	}

}
