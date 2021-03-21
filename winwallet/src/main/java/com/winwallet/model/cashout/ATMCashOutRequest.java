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
public class ATMCashOutRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "msisdn2Debit", nullable = false)
	private String msisdn2Debit;
	
	@Column(name = "msisdnNetwork", nullable = false)
	private String msisdnNetwork;
	
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
	public ATMCashOutRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param msisdn2Debit
	 * @param msisdnNetwork
	 * @param bank2Credit
	 * @param pin
	 * @param amount
	 * @param channel
	 * @param narration
	 */
	public ATMCashOutRequest(String clientId, String msisdn2Debit, String msisdnNetwork, String bank2Credit, String pin,
			double amount, String channel, String narration) {
		super();
		this.clientId = clientId;
		this.msisdn2Debit = msisdn2Debit;
		this.msisdnNetwork = msisdnNetwork;
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
