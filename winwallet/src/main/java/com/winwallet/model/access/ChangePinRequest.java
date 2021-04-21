/**
 * 
 */
package com.winwallet.model.access;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public class ChangePinRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "channel", nullable = false)
	private String channel;
	
	@Column(name = "msisdn", nullable = false)
	private String msisdn;
	
	@Column(name = "msisdnNetwork", nullable = false)
	private String msisdnNetwork;
	
	@Column(name = "oldPin", nullable = false)
	private String oldPin;
	
	@Column(name = "newPin", nullable = false)
	private String newPin;

	/**
	 * 
	 */
	public ChangePinRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param channel
	 * @param msisdn
	 * @param msisdnNetwork
	 * @param oldPin
	 * @param newPin
	 */
	public ChangePinRequest(String clientId, String channel, String msisdn, String msisdnNetwork, String oldPin,
			String newPin) {
		super();
		this.clientId = clientId;
		this.channel = channel;
		this.msisdn = msisdn;
		this.msisdnNetwork = msisdnNetwork;
		this.oldPin = oldPin;
		this.newPin = newPin;
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
	 * @return the oldPin
	 */
	public String getOldPin() {
		return oldPin;
	}

	/**
	 * @param oldPin the oldPin to set
	 */
	public void setOldPin(String oldPin) {
		this.oldPin = oldPin;
	}

	/**
	 * @return the newPin
	 */
	public String getNewPin() {
		return newPin;
	}

	/**
	 * @param newPin the newPin to set
	 */
	public void setNewPin(String newPin) {
		this.newPin = newPin;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
