/**
 * 
 */
package com.winwallet.model.utility;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public class SMSRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9209204712907453650L;
	
	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "network", nullable = false)
	private String network; 
	
	@Column(name = "msisdn", nullable = false)
	private String msisdn; 
	
	@Column(name = "message", nullable = false)
	private String message;

	/**
	 * 
	 */
	public SMSRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param network
	 * @param msisdn
	 * @param message
	 */
	public SMSRequest(String clientId, String network, String msisdn, String message) {
		super();
		this.clientId = clientId;
		this.network = network;
		this.msisdn = msisdn;
		this.message = message;
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
	 * @return the network
	 */
	public String getNetwork() {
		return network;
	}

	/**
	 * @param network the network to set
	 */
	public void setNetwork(String network) {
		this.network = network;
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
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
