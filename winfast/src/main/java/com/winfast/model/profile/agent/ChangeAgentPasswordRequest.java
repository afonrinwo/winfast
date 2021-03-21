/**
 * 
 */
package com.winfast.model.profile.agent;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public class ChangeAgentPasswordRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3627716556098392617L;
	
	
	@Column(name="clientId", nullable = false)
	private String clientId;
	
	@Column(name="agentId", nullable = false)
	private String agentId;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name="newPassword", nullable = false)
	private String newPassword;
	
	@Column(name = "dateCreated", nullable = false)
	private LocalDateTime dateCreated;
	
	@Column(name = "lastUpdated", nullable = false)
	private LocalDateTime lastUpdated;
	
	@Column(name = "changeCount", nullable = false)
	private int changeCount;


	/**
	 * 
	 */
	public ChangeAgentPasswordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param clientId
	 * @param agentId
	 * @param password
	 * @param newPassword
	 * @param dateCreated
	 * @param lastUpdated
	 * @param changeCount
	 */
	public ChangeAgentPasswordRequest(String clientId, String agentId, String password, String newPassword,
			LocalDateTime dateCreated, LocalDateTime lastUpdated, int changeCount) {
		super();
		this.clientId = clientId;
		this.agentId = agentId;
		this.password = password;
		this.newPassword = newPassword;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.changeCount = changeCount;
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
	 * @return the agentId
	 */
	public String getAgentId() {
		return agentId;
	}


	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(String agentId) {
		this.agentId = agentId;
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
	 * @return the dateCreated
	 */
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}


	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}


	/**
	 * @return the lastUpdated
	 */
	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}


	/**
	 * @param lastUpdated the lastUpdated to set
	 */
	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}


	/**
	 * @return the changeCount
	 */
	public int getChangeCount() {
		return changeCount;
	}


	/**
	 * @param changeCount the changeCount to set
	 */
	public void setChangeCount(int changeCount) {
		this.changeCount = changeCount;
	}


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
