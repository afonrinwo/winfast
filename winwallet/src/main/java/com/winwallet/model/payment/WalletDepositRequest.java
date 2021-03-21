/**
 * 
 */
package com.winwallet.model.payment;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public class WalletDepositRequest implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6632260475056826842L;

	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "msisdn", nullable = false)
	private String msisdn;
	
	@Column(name = "msisdn2Credit", nullable = false)
	private String msisdn2Credit;
	
	@Column(name = "msisdn2CreditNetwork", nullable = false)
	private String msisdn2CreditNetwork;
	
	@Column(name = "amount", nullable = false)
	private double amount;
	
	@Column(name = "channel", nullable = false)
	private String channel;
	
	@Column(name = "fundSource", nullable = false)
	private String fundSource;

	/**
	 * 
	 */
	public WalletDepositRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param msisdn
	 * @param msisdn2Credit
	 * @param msisdn2CreditNetwork
	 * @param amount
	 * @param channel
	 * @param fundSource
	 */
	public WalletDepositRequest(String clientId, String msisdn, String msisdn2Credit, String msisdn2CreditNetwork,
			double amount, String channel, String fundSource) {
		super();
		this.clientId = clientId;
		this.msisdn = msisdn;
		this.msisdn2Credit = msisdn2Credit;
		this.msisdn2CreditNetwork = msisdn2CreditNetwork;
		this.amount = amount;
		this.channel = channel;
		this.fundSource = fundSource;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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

}
