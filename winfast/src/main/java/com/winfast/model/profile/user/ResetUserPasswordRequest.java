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
public class ResetUserPasswordRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3796833642423590816L;
	
	@Column(name="clientId", nullable = false)
	private String clientId;
	
	@Column(name="userName", nullable = false)
	private String userName;
	
	@Column(name="password", nullable = false)
	private String password;

	/**
	 * 
	 */
	public ResetUserPasswordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param userName
	 * @param password
	 */
	public ResetUserPasswordRequest(String clientId, String userName, String password) {
		super();
		this.clientId = clientId;
		this.userName = userName;
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
