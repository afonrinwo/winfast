/**
 * 
 */
package com.winwallet.model.cashout;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Entity
@Table(name="CashOut_Log")
public class CashOutLogObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uniqueId", nullable = false)
	private long uniqueId;
	
	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "msisdn2Debit", nullable = false)
	private String msisdn2Debit;
	
	@Column(name = "msisdn2DebitNetwork", nullable = false)
	private String msisdn2DebitNetwork;
	
	@Column(name = "amount", nullable = false)
	private double amount;
	
	@Column(name = "channel", nullable = false)
	private String channel;
	
	@Column(name = "narration", nullable = false)
	private String narration;
	
	@Column(name = "requestType", nullable = false)
	private String requestType;
	
	@Column(name = "requestIn", nullable = false)
	private LocalDateTime requestIn;
	
	@Column(name = "bank2Credit")
	private String bank2Credit;
	
	@Column(name = "agentId2Credit")
	private String agentId2Credit;
	
	@Column(name = "agentId2CreditNetwork")
	private String agentId2CreditNetwork;
	
	@Column(name = "payToken")
	private String payToken;
	
	@Column(name = "payFlag")
	private String payFlag;
	
	@Column(name = "payDate")
	private LocalDateTime payDate;


	/**
	 * 
	 */
	public CashOutLogObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uniqueId
	 * @param clientId
	 * @param msisdn2Debit
	 * @param msisdn2DebitNetwork
	 * @param amount
	 * @param channel
	 * @param narration
	 * @param requestType
	 * @param requestIn
	 * @param bank2Credit
	 * @param agentId2Credit
	 * @param agentId2CreditNetwork
	 * @param payToken
	 * @param payFlag
	 * @param payDate
	 */
	public CashOutLogObject(long uniqueId, String clientId, String msisdn2Debit, String msisdn2DebitNetwork, double amount, 
			String channel, String narration, String requestType, LocalDateTime requestIn, String bank2Credit,
			String agentId2Credit, String agentId2CreditNetwork, String payToken, String payFlag,
			LocalDateTime payDate) {
		super();
		this.uniqueId = uniqueId;
		this.clientId = clientId;
		this.msisdn2Debit = msisdn2Debit;
		this.msisdn2DebitNetwork = msisdn2DebitNetwork;
		this.amount = amount;
		this.channel = channel;
		this.narration = narration;
		this.requestType = requestType;
		this.requestIn = requestIn;
		this.bank2Credit = bank2Credit;
		this.agentId2Credit = agentId2Credit;
		this.agentId2CreditNetwork = agentId2CreditNetwork;
		this.payToken = payToken;
		this.payFlag = payFlag;
		this.payDate = payDate;
	}

	/**
	 * @return the uniqueId
	 */
	public long getUniqueId() {
		return uniqueId;
	}

	/**
	 * @param uniqueId the uniqueId to set
	 */
	public void setUniqueId(long uniqueId) {
		this.uniqueId = uniqueId;
	}

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the msisdn2Debit
	 */
	public String getMsisdn2Debit() {
		return msisdn2Debit;
	}

	/**
	 * @param msisdn2Debit the msisdn2Debit to set
	 */
	public void setMsisdn2Debit(String msisdn2Debit) {
		this.msisdn2Debit = msisdn2Debit;
	}

	/**
	 * @return the msisdn2DebitNetwork
	 */
	public String getMsisdn2DebitNetwork() {
		return msisdn2DebitNetwork;
	}

	/**
	 * @param msisdn2DebitNetwork the msisdn2DebitNetwork to set
	 */
	public void setMsisdn2DebitNetwork(String msisdn2DebitNetwork) {
		this.msisdn2DebitNetwork = msisdn2DebitNetwork;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the channel
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * @param channel the channel to set
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}

	/**
	 * @return the narration
	 */
	public String getNarration() {
		return narration;
	}

	/**
	 * @param narration the narration to set
	 */
	public void setNarration(String narration) {
		this.narration = narration;
	}

	/**
	 * @return the requestType
	 */
	public String getRequestType() {
		return requestType;
	}

	/**
	 * @param requestType the requestType to set
	 */
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	/**
	 * @return the requestIn
	 */
	public LocalDateTime getRequestIn() {
		return requestIn;
	}

	/**
	 * @param requestIn the requestIn to set
	 */
	public void setRequestIn(LocalDateTime requestIn) {
		this.requestIn = requestIn;
	}

	/**
	 * @return the bank2Credit
	 */
	public String getBank2Credit() {
		return bank2Credit;
	}

	/**
	 * @param bank2Credit the bank2Credit to set
	 */
	public void setBank2Credit(String bank2Credit) {
		this.bank2Credit = bank2Credit;
	}

	/**
	 * @return the agentId2Credit
	 */
	public String getAgentId2Credit() {
		return agentId2Credit;
	}

	/**
	 * @param agentId2Credit the agentId2Credit to set
	 */
	public void setAgentId2Credit(String agentId2Credit) {
		this.agentId2Credit = agentId2Credit;
	}

	/**
	 * @return the agentId2CreditNetwork
	 */
	public String getAgentId2CreditNetwork() {
		return agentId2CreditNetwork;
	}

	/**
	 * @param agentId2CreditNetwork the agentId2CreditNetwork to set
	 */
	public void setAgentId2CreditNetwork(String agentId2CreditNetwork) {
		this.agentId2CreditNetwork = agentId2CreditNetwork;
	}

	/**
	 * @return the payToken
	 */
	public String getPayToken() {
		return payToken;
	}

	/**
	 * @param payToken the payToken to set
	 */
	public void setPayToken(String payToken) {
		this.payToken = payToken;
	}

	/**
	 * @return the payFlag
	 */
	public String getPayFlag() {
		return payFlag;
	}

	/**
	 * @param payFlag the payFlag to set
	 */
	public void setPayFlag(String payFlag) {
		this.payFlag = payFlag;
	}

	/**
	 * @return the payDate
	 */
	public LocalDateTime getPayDate() {
		return payDate;
	}

	/**
	 * @param payDate the payDate to set
	 */
	public void setPayDate(LocalDateTime payDate) {
		this.payDate = payDate;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

	