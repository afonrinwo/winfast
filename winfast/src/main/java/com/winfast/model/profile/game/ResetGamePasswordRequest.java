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
public class ResetGamePasswordRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5934658429525290411L;
	
	@Column(name="clientId", nullable = false)
	private String clientId;
	
	@Column(name="userId", nullable = false)
	private String userId;
	
	@Column(name="password", nullable = false)
	private String password;

	/**
	 * 
	 */
	public ResetGamePasswordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param userId
	 * @param password
	 */
	public ResetGamePasswordRequest(String clientId, String userId, String password) {
		super();
		this.clientId = clientId;
		this.userId = userId;
		this.password = password;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
