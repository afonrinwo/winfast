/**
 * 
 */
package com.winfast.model.profile.user;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public class DisableUserProfileRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 370396756450156916L;

	@Column(name="clientId", nullable = false)
	private String clientId;
	
	@Column(name="userName", nullable = false)
	private String userName;


	/**
	 * 
	 */
	public DisableUserProfileRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param userName
	 * @param password
	 */
	public DisableUserProfileRequest(String clientId, String userName) {
		super();
		this.clientId = clientId;
		this.userName = userName;
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
