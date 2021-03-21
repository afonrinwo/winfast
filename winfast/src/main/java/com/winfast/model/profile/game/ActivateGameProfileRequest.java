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
public class ActivateGameProfileRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4963901362166185103L;
	@Column(name = "clientId", nullable = false)
	private String clientId;

	@Column(name = "userId", nullable = false)
	private String userId;

	/**
	 * 
	 */
	public ActivateGameProfileRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param userId
	 */
	public ActivateGameProfileRequest(String clientId, String userId) {
		super();
		this.clientId = clientId;
		this.userId = userId;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
