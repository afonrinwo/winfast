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
public class PNDRequest implements Serializable {


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
	
	@Column(name = "channel", nullable = false)
	private String channel;
	
	@Column(name = "pndFlag", nullable = false)
	private int pndFlag;
	
	@Column(name = "pndReason", nullable = false)
	private int pndReason;

	/**
	 * 
	 */
	public PNDRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * @param clientId
	 * @param msisdn
	 * @param msisdnNetwork
	 * @param channel
	 * @param pndFlag
	 * @param pndReason
	 */
	public PNDRequest(String clientId, String msisdn, String msisdnNetwork, String channel, int pndFlag,
			int pndReason) {
		super();
		this.clientId = clientId;
		this.msisdn = msisdn;
		this.msisdnNetwork = msisdnNetwork;
		this.channel = channel;
		this.pndFlag = pndFlag;
		this.pndReason = pndReason;
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
	public int getPndReason() {
		return pndReason;
	}


	/**
	 * @param pndReason the pndReason to set
	 */
	public void setPndReason(int pndReason) {
		this.pndReason = pndReason;
	}


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
