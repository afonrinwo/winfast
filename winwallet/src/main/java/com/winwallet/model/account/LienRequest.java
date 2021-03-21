/**
 * 
 */
package com.winwallet.model.account;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public class LienRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "msisdn", nullable = false)
	private String msisdn;
	
	@Column(name = "msisdnNetwork", nullable = false)
	private String msisdnNetwork;
	
	@Column(name = "lienAmount", nullable = false)
	private double lienAmount;
	
	@Column(name = "lienReason", nullable = false)
	private String lienReason;
	
	@Column(name = "channel", nullable = false)
	private String channel;

	/**
	 * 
	 */
	public LienRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param msisdn
	 * @param msisdnNetwork
	 * @param lienAmount
	 * @param lienReason
	 * @param channel
	 */
	public LienRequest(String clientId, String msisdn, String msisdnNetwork, double lienAmount, String lienReason,
			String channel) {
		super();
		this.clientId = clientId;
		this.msisdn = msisdn;
		this.msisdnNetwork = msisdnNetwork;
		this.lienAmount = lienAmount;
		this.lienReason = lienReason;
		this.channel = channel;
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
	 * @return the lienReason
	 */
	public String getLienReason() {
		return lienReason;
	}

	/**
	 * @param lienReason the lienReason to set
	 */
	public void setLienReason(String lienReason) {
		this.lienReason = lienReason;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
