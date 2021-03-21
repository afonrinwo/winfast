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
import com.winwallet.model.account.CustomerWalletObject;
import com.winwallet.model.account.OfficeWalletObject;
import com.winwallet.model.cashout.ATMCashOutRequest;
import com.winwallet.model.cashout.AgentCashOutRequest;
import com.winwallet.model.cashout.BankCashOutRequest;
import com.winwallet.model.cashout.CashOutLogObject;
import com.winwallet.repository.CashOutLogRepository;
import com.winwallet.repository.CustomerWalletRepository;
import com.winwallet.repository.OfficeWalletRepository;
import com.winwallet.utility.MessageUtility;
import com.winwallet.utility.ResponseUtility;
import com.winwallet.utility.SMSUtility;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Service
public class CashOutManager {
	private Logger logger = LogManager.getFormatterLogger();
	private CashOutLogObject cashOutLogObject;
	private CustomerWalletObject customerWalletObject;
	private OfficeWalletObject officeWalletObject;

	@Autowired
	CashOutLogRepository cashOutLogRepository;

	@Autowired
	CustomerWalletRepository customerWalletRepository;

	@Autowired
	PlatformTransactionManager transactionManager;

	@Autowired
	ResponseUtility responseUtility;

	@Autowired
	OfficeWalletRepository officeWalletRepository;

	@Autowired
	SMSUtility smsUtility;

	@Autowired
	ConfigurationObject configurationObject;

	@Autowired
	UtilityManager utilityManager;
	
	@Autowired
	MessageUtility messageUtility;

	public Response bankCashOut(BankCashOutRequest bankCashOutRequest, String requestIn) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);

		try {

			cashOutLogObject = new CashOutLogObject();
			cashOutLogObject.setAmount(bankCashOutRequest.getAmount());
			cashOutLogObject.setChannel(bankCashOutRequest.getChannel());
			cashOutLogObject.setClientId(bankCashOutRequest.getClientId());
			cashOutLogObject.setMsisdn2Debit(bankCashOutRequest.getMsisdn2Debit());
			cashOutLogObject.setMsisdn2DebitNetwork(bankCashOutRequest.getGetMsisdn2DebitNetwork());
			cashOutLogObject.setBank2Credit(bankCashOutRequest.getBank2Credit() );
			cashOutLogObject.setRequestType("walletDebit");
			cashOutLogObject.setNarration(bankCashOutRequest.getNarration());
			cashOutLogObject.setRequestIn(requestIn);
			cashOutLogObject = cashOutLogRepository.save(cashOutLogObject);
			
			String code = utilityManager.walletRules(bankCashOutRequest.getMsisdn2Debit(), bankCashOutRequest.getPin(),
					bankCashOutRequest.getAmount());
			switch (code) {
			case "00":
				customerWalletObject = new CustomerWalletObject();
				customerWalletObject = customerWalletRepository.findByMsisdn(bankCashOutRequest.getMsisdn2Debit());
				customerWalletObject.setAvailableBalance(
						customerWalletObject.getAvailableBalance() - bankCashOutRequest.getAmount());
				customerWalletObject.setBookBalance(
						customerWalletObject.getBookBalance() - bankCashOutRequest.getAmount());
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
						.setAvailableBalance(officeWalletObject.getAvailableBalance() + bankCashOutRequest.getAmount());
				officeWalletObject.setBookBalance(officeWalletObject.getBookBalance() + bankCashOutRequest.getAmount());
				officeWalletObject.setDateCreated(officeWalletObject.getDateCreated());
				officeWalletObject.setLastEditedDate(LocalDateTime.now());
				officeWalletObject = officeWalletRepository.save(officeWalletObject);
				
				officeWalletObject = new OfficeWalletObject();
				officeWalletObject = officeWalletRepository.findByWalletNumber(configurationObject.getWalletPosition());
				officeWalletObject.setAvailableBalance(
						officeWalletObject.getAvailableBalance() - bankCashOutRequest.getAmount());
				officeWalletObject
						.setBookBalance(officeWalletObject.getBookBalance() - bankCashOutRequest.getAmount());
				officeWalletObject.setDateCreated(officeWalletObject.getDateCreated());
				officeWalletObject.setLastEditedDate(LocalDateTime.now());
				officeWalletObject = officeWalletRepository.save(officeWalletObject);
				
				
				messageUtility.sendMail(bankCashOutRequest.getClientId(), "Wallet", "notification@winfast.ng",
						"b.adewole@cloud-africa.com", "Winfast Game Account",
						"This is to notify you that the customer with mobile number " + bankCashOutRequest.getMsisdn2Debit() + " would like to Cashout " + bankCashOutRequest.getAmount() + "from his/her wallet.",
						LocalDateTime.now());

				return responseUtility.response(cashOutLogObject.getUniqueId(),
						bankCashOutRequest.getClientId(), 0);

			default:
				return responseUtility.response(cashOutLogObject.getUniqueId(), bankCashOutRequest.getClientId(),
						Integer.valueOf(code));
			}

		} catch (Exception ex) {
			transactionManager.rollback(transactionStatus);
			logger.error("wallet2Wallet :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.response(0l, cashOutLogObject.getClientId(), 99);
		}
	}

	public Response agentCashOut(AgentCashOutRequest agentCashOutRequest, String requestIn) {
		
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);

		try {

			cashOutLogObject = new CashOutLogObject();
			cashOutLogObject.setAmount(agentCashOutRequest.getAmount());
			cashOutLogObject.setChannel(agentCashOutRequest.getChannel());
			cashOutLogObject.setClientId(agentCashOutRequest.getClientId());
			cashOutLogObject.setMsisdn2Debit(agentCashOutRequest.getMsisdn2Debit());
			cashOutLogObject.setMsisdn2DebitNetwork(agentCashOutRequest.getMsisdn2DebitNetwork());
			cashOutLogObject.setAgentId2Credit(agentCashOutRequest.getAgentId2Credit());
			cashOutLogObject.setAgentId2CreditNetwork(agentCashOutRequest.getAgentId2CreditNetwork());
			cashOutLogObject.setRequestType("agentCashOut");
			cashOutLogObject.setNarration(agentCashOutRequest.getNarration());
			cashOutLogObject.setRequestIn(requestIn);
			cashOutLogObject = cashOutLogRepository.save(cashOutLogObject);
			
			String code = utilityManager.walletRules(agentCashOutRequest.getMsisdn2Debit(), agentCashOutRequest.getPin(),
					agentCashOutRequest.getAmount());
			switch (code) {
			case "00":
				customerWalletObject = new CustomerWalletObject();
				customerWalletObject = customerWalletRepository.findByMsisdn(agentCashOutRequest.getMsisdn2Debit());
				customerWalletObject.setAvailableBalance(
						customerWalletObject.getAvailableBalance() - agentCashOutRequest.getAmount());
				customerWalletObject.setBookBalance(
						customerWalletObject.getBookBalance() - agentCashOutRequest.getAmount());
				customerWalletObject.setDateCreated(customerWalletObject.getDateCreated());
				customerWalletObject.setLastEditedDate(LocalDateTime.now());
				customerWalletObject.setLien(customerWalletObject.getLien());
				customerWalletObject.setMsisdn(customerWalletObject.getMsisdn());
				customerWalletObject.setMsisdnNetwork(customerWalletObject.getMsisdnNetwork());
				customerWalletObject.setPnd(customerWalletObject.getPnd());
				customerWalletRepository.save(customerWalletObject);

				//Pending Agent Account set up 

				
				officeWalletObject = new OfficeWalletObject();
				officeWalletObject = officeWalletRepository.findByWalletNumber(configurationObject.getWalletPosition());
				officeWalletObject.setAvailableBalance(
						officeWalletObject.getAvailableBalance() - agentCashOutRequest.getAmount());
				officeWalletObject
						.setBookBalance(officeWalletObject.getBookBalance() - agentCashOutRequest.getAmount());
				officeWalletObject.setDateCreated(officeWalletObject.getDateCreated());
				officeWalletObject.setLastEditedDate(LocalDateTime.now());
				officeWalletObject = officeWalletRepository.save(officeWalletObject);
				
				
				messageUtility.sendMail(agentCashOutRequest.getClientId(), "Wallet", "notification@winfast.ng",
						"b.adewole@cloud-africa.com", "Winfast Game Account",
						"This is to notidy you that the customer with mobile number " + agentCashOutRequest.getMsisdn2Debit() + " would like to Cashout " + agentCashOutRequest.getAmount() + "from his/her wallet.",
						LocalDateTime.now());

				return responseUtility.response(cashOutLogObject.getUniqueId(),
						agentCashOutRequest.getClientId(), 0);

			default:
				return responseUtility.response(cashOutLogObject.getUniqueId(), agentCashOutRequest.getClientId(),
						Integer.valueOf(code));
			}

		} catch (Exception ex) {
			transactionManager.rollback(transactionStatus);
			logger.error("wallet2Wallet :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.response(0l, cashOutLogObject.getClientId(), 99);
		}
	}

	public Response atmCashOut(ATMCashOutRequest atmCashOutRequest, String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
