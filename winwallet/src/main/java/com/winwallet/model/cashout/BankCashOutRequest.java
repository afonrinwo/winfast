/**
 * 
 */
package com.winwallet.model.cashout;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public class BankCashOutRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "msisdn2Debit", nullable = false)
	private String msisdn2Debit;
	
	@Column(name = "getMsisdn2DebitNetwork", nullable = false)
	private String getMsisdn2DebitNetwork;
	
	@Column(name = "bank2Credit", nullable = false)
	private String bank2Credit;
	
	@Column(name = "pin", nullable = false)
	private String pin;
	
	@Column(name = "amount", nullable = false)
	private double amount;
	
	@Column(name = "channel", nullable = false)
	private String channel;
	
	@Column(name = "narration", nullable = false)
	private String narration;

	/**
	 * 
	 */
	public BankCashOutRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param msisdn2Debit
	 * @param getMsisdn2DebitNetwork
	 * @param bank2Credit
	 * @param pin
	 * @param amount
	 * @param channel
	 * @param narration
	 */
	public BankCashOutRequest(String clientId, String msisdn2Debit, String getMsisdn2DebitNetwork, String bank2Credit,
			String pin, double amount, String channel, String narration) {
		super();
		this.clientId = clientId;
		this.msisdn2Debit = msisdn2Debit;
		this.getMsisdn2DebitNetwork = getMsisdn2DebitNetwork;
		this.bank2Credit = bank2Credit;
		this.pin = pin;
		this.amount = amount;
		this.channel = channel;
		this.narration = narration;
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
	 * @return the getMsisdn2DebitNetwork
	 */
	public String getGetMsisdn2DebitNetwork() {
		return getMsisdn2DebitNetwork;
	}

	/**
	 * @param getMsisdn2DebitNetwork the getMsisdn2DebitNetwork to set
	 */
	public void setGetMsisdn2DebitNetwork(String getMsisdn2DebitNetwork) {
		this.getMsisdn2DebitNetwork = getMsisdn2DebitNetwork;
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
	 * @return the pin
	 */
	public String getPin() {
		return pin;
	}

	/**
	 * @param pin the pin to set
	 */
	public void setPin(String pin) {
		this.pin = pin;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
