/**
 * 
 */
package com.winfast.model.profile.game;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public class GameProfileRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8273756338042278711L;

	@Column(name="clientId", nullable= false)
	private String clientId;
	
	@Column(name="userId", nullable= false)
	private String userId;
	
	@Column(name="msisdnNumber", nullable= false)
	private String msisdnNumber;
	
	@Column(name="msisdnNetwork", nullable= false)
	private String msisdnNetwork;
	
	@Column(name="email", nullable= false)
	private String email;

	/**
	 * 
	 */
	public GameProfileRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param userId
	 * @param msisdnNumber
	 * @param msisdnNetwork
	 * @param email
	 */
	public GameProfileRequest(String clientId, String userId, String msisdnNumber, String msisdnNetwork, String email) {
		super();
		this.clientId = clientId;
		this.userId = userId;
		this.msisdnNumber = msisdnNumber;
		this.msisdnNetwork = msisdnNetwork;
		this.email = email;
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
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the msisdnNumber
	 */
	public String getMsisdnNumber() {
		return msisdnNumber;
	}

	/**
	 * @param msisdnNumber the msisdnNumber to set
	 */
	public void setMsisdnNumber(String msisdnNumber) {
		this.msisdnNumber = msisdnNumber;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}