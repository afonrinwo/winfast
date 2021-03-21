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
public class ChangeGamePasswordRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2197535681742380469L;
	
	@Column(name="clientId", nullable = false)
	private String clientId;
	
	@Column(name="userId", nullable = false)
	private String userId;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name="newPassword", nullable = false)
	private String newPassword;

	/**
	 * 
	 */
	public ChangeGamePasswordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param userId
	 * @param password
	 * @param newPassword
	 */
	public ChangeGamePasswordRequest(String clientId, String userId, String password, String newPassword) {
		super();
		this.clientId = clientId;
		this.userId = userId;
		this.password = password;
		this.newPassword = newPassword;
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
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
