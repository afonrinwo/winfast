/**
 * 
 */
package com.winfast.model.profile.user;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public class ChangeUserPasswordRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 370396756450156916L;

	@Column(name="clientId", nullable = false)
	private String clientId;
	
	@Column(name="userName", nullable = false)
	private String userName;
	
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
	public ChangeUserPasswordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param userName
	 * @param password
	 * @param newPassword
	 * @param dateCreated
	 * @param lastUpdated
	 * @param changeCount
	 */
	public ChangeUserPasswordRequest(String clientId, String userName, String password, String newPassword,
			LocalDateTime dateCreated, LocalDateTime lastUpdated, int changeCount) {
		super();
		this.clientId = clientId;
		this.userName = userName;
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
