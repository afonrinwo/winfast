/**
 * 
 */
package com.winfast.model.games;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public class TicketInfoByTicketIdRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "mobileNumber", nullable = false)
	private String mobileNumber;
	
	@Column(name = "ticketId", nullable = false)
	private String ticketId;
	

	/**
	 * 
	 */
	public TicketInfoByTicketIdRequest() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param clientId
	 * @param mobileNumber
	 * @param ticketId
	 * @param gameType
	 */
	public TicketInfoByTicketIdRequest(String clientId, String mobileNumber, String ticketId) {
		super();
		this.clientId = clientId;
		this.mobileNumber = mobileNumber;
		this.ticketId = ticketId;
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
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}



	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	/**
	 * @return the ticketId
	 */
	public String getTicketId() {
		return ticketId;
	}



	/**
	 * @param ticketId the ticketId to set
	 */
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}



	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
