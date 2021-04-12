/**
 * 
 */
package com.winwallet.model.payment;

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
@Table(name="Payment_Log")
public class PaymentLogObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4800658796503658135L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="uniqueId", nullable = false)
	private long uniqueId;
	
	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "msisdn")
	private String msisdn;
	
	@Column(name = "msisdnNetwork")
	private String msisdnNetwork;
	
	@Column(name = "msisdn2Credit")
	private String msisdn2Credit;
	
	@Column(name = "msisdn2CreditNetwork")
	private String msisdn2CreditNetwork;
	
	@Column(name = "msisdn2Debit")
	private String msisdn2Debit;
	
	@Column(name = "msisdn2DebitNetwork")
	private String msisdn2DebitNetwork;
	
	@Column(name = "channel", nullable = false)
	private String channel;
	
	@Column(name = "fundSource")
	private String fundSource;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "lienAmount")
	private double lienAmount;
	
	@Column(name = "pndFlag")
	private int pndFlag;
	
	@Column(name = "pndReason")
	private String pndReason;
	
	@Column(name = "narration")
	private String narration;
	
	@Column(name = "requestType", nullable = false)
	private String requestType;
	
	@Column(name = "requestIn", nullable = false)
	private LocalDateTime requestIn;

	/**
	 * 
	 */
	public PaymentLogObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uniqueId
	 * @param clientId
	 * @param msisdn
	 * @param msisdnNetwork
	 * @param msisdn2Credit
	 * @param msisdn2CreditNetwork
	 * @param msisdn2Debit
	 * @param msisdn2DebitNetwork
	 * @param channel
	 * @param fundSource
	 * @param amount
	 * @param lienAmount
	 * @param pndFlag
	 * @param pndReason
	 * @param narration
	 * @param requestType
	 * @param requestIn
	 */
	public PaymentLogObject(long uniqueId, String clientId, String msisdn, String msisdnNetwork, String msisdn2Credit,
			String msisdn2CreditNetwork, String msisdn2Debit, String msisdn2DebitNetwork, String channel,
			String fundSource, double amount, double lienAmount, int pndFlag, String pndReason, String narration,
			String requestType, LocalDateTime requestIn) {
		super();
		this.uniqueId = uniqueId;
		this.clientId = clientId;
		this.msisdn = msisdn;
		this.msisdnNetwork = msisdnNetwork;
		this.msisdn2Credit = msisdn2Credit;
		this.msisdn2CreditNetwork = msisdn2CreditNetwork;
		this.msisdn2Debit = msisdn2Debit;
		this.msisdn2DebitNetwork = msisdn2DebitNetwork;
		this.channel = channel;
		this.fundSource = fundSource;
		this.amount = amount;
		this.lienAmount = lienAmount;
		this.pndFlag = pndFlag;
		this.pndReason = pndReason;
		this.narration = narration;
		this.requestType = requestType;
		this.requestIn = requestIn;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	 * @return the msisdn
	 */
	public String getMsisdn() {
		return msisdn;
	}

	/**
	 * @param msisdn the msisdn to set
	 */
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	/**
	 * @return the msisdnNetwork
	 */
	public String getMsisdnNetwork() {
		return msisdnNetwork;
	}

	/**
	 * @param msisdnNetwork the msisdnNetwork to set
	 */
	public void setMsisdnNetwork(String msisdnNetwork) {
		this.msisdnNetwork = msisdnNetwork;
	}

	/**
	 * @return the msisdn2Credit
	 */
	public String getMsisdn2Credit() {
		return msisdn2Credit;
	}

	/**
	 * @param msisdn2Credit the msisdn2Credit to set
	 */
	public void setMsisdn2Credit(String msisdn2Credit) {
		this.msisdn2Credit = msisdn2Credit;
	}

	/**
	 * @return the msisdn2CreditNetwork
	 */
	public String getMsisdn2CreditNetwork() {
		return msisdn2CreditNetwork;
	}

	/**
	 * @param msisdn2CreditNetwork the msisdn2CreditNetwork to set
	 */
	public void setMsisdn2CreditNetwork(String msisdn2CreditNetwork) {
		this.msisdn2CreditNetwork = msisdn2CreditNetwork;
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
	 * @return the fundSource
	 */
	public String getFundSource() {
		return fundSource;
	}

	/**
	 * @param fundSource the fundSource to set
	 */
	public void setFundSource(String fundSource) {
		this.fundSource = fundSource;
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
	 * @return the lienAmount
	 */
	public double getLienAmount() {
		return lienAmount;
	}

	/**
	 * @param lienAmount the lienAmount to set
	 */
	public void setLienAmount(double lienAmount) {
		this.lienAmount = lienAmount;
	}

	/**
	 * @return the pndFlag
	 */
	public int getPndFlag() {
		return pndFlag;
	}

	/**
	 * @param pndFlag the pndFlag to set
	 */
	public void setPndFlag(int pndFlag) {
		this.pndFlag = pndFlag;
	}

	/**
	 * @return the pndReason
	 */
	public String getPndReason() {
		return pndReason;
	}

	/**
	 * @param pndReason the pndReason to set
	 */
	public void setPndReason(String pndReason) {
		this.pndReason = pndReason;
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

}
