/**
 * 
 */
package com.winfast.model.utility;

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
@Table(name="SMS_Logs")
public class SMSObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9209204712907453650L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uniqueId", nullable = false)
	private Long uniqueId;
	
	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "network", nullable = false)
	private String network; 
	
	@Column(name = "msisdn", nullable = false)
	private String msisdn; 
	
	@Column(name = "message", nullable = false)
	private String message;
	
	@Column(name = "requestIn", nullable = false)
	private LocalDateTime requestIn;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "responseOut", nullable = false)
	private LocalDateTime responseOut;

	/**
	 * 
	 */
	public SMSObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uniqueId
	 * @param clientId
	 * @param network
	 * @param msisdn
	 * @param message
	 * @param requestIn
	 * @param status
	 * @param responseOut
	 */
	public SMSObject(Long uniqueId, String clientId, String network, String msisdn, String message,
			LocalDateTime requestIn, String status, LocalDateTime responseOut) {
		super();
		this.uniqueId = uniqueId;
		this.clientId = clientId;
		this.network = network;
		this.msisdn = msisdn;
		this.message = message;
		this.requestIn = requestIn;
		this.status = status;
		this.responseOut = responseOut;
	}

	/**
	 * @return the uniqueId
	 */
	public Long getUniqueId() {
		return uniqueId;
	}

	/**
	 * @param uniqueId the uniqueId to set
	 */
	public void setUniqueId(Long uniqueId) {
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the responseOut
	 */
	public LocalDateTime getResponseOut() {
		return responseOut;
	}

	/**
	 * @param responseOut the responseOut to set
	 */
	public void setResponseOut(LocalDateTime responseOut) {
		this.responseOut = responseOut;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
