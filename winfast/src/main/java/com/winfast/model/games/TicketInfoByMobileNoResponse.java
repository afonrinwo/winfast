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
public class TicketInfoByMobileNoResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "gameString", nullable = false)
	private String gameString;
	
	@Column(name = "responsecode", nullable = false)
	private String responsecode;
	
	@Column(name = "responsemessage", nullable = false)
	private String responsemessage;

	/**
	 * 
	 */
	public TicketInfoByMobileNoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param gameString
	 * @param responsecode
	 * @param responsemessage
	 */
	public TicketInfoByMobileNoResponse(String clientId, String gameString, String responsecode,
			String responsemessage) {
		super();
		this.clientId = clientId;
		this.gameString = gameString;
		this.responsecode = responsecode;
		this.responsemessage = responsemessage;
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
	 * @return the gameString
	 */
	public String getGameString() {
		return gameString;
	}

	/**
	 * @param gameString the gameString to set
	 */
	public void setGameString(String gameString) {
		this.gameString = gameString;
	}

	/**
	 * @return the responsecode
	 */
	public String getResponsecode() {
		return responsecode;
	}

	/**
	 * @param responsecode the responsecode to set
	 */
	public void setResponsecode(String responsecode) {
		this.responsecode = responsecode;
	}

	/**
	 * @return the responsemessage
	 */
	public String getResponsemessage() {
		return responsemessage;
	}

	/**
	 * @param responsemessage the responsemessage to set
	 */
	public void setResponsemessage(String responsemessage) {
		this.responsemessage = responsemessage;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
