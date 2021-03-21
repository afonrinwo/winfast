/**
 * 
 */
package com.winfast.model.profile.game;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Entity
@Table(name="Game_Password_Profile", uniqueConstraints = @UniqueConstraint(columnNames = {"uniqueId", "userId"}))
public class GamePasswordProfileObject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "uniqueId", nullable = false)
	private long uniqueId;
	
	@Column(name="userId", nullable = false)
	private String userId;
	
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
	public GamePasswordProfileObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uniqueId
	 * @param userId
	 * @param password
	 * @param newPassword
	 * @param dateCreated
	 * @param lastUpdated
	 * @param changeCount
	 */
	public GamePasswordProfileObject(long uniqueId, String userId, String password, String newPassword,
			LocalDateTime dateCreated, LocalDateTime lastUpdated, int changeCount) {
		super();
		this.uniqueId = uniqueId;
		this.userId = userId;
		this.password = password;
		this.newPassword = newPassword;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.changeCount = changeCount;
	}

	/**
	 * @return the uniqueId
	 */
	public long getUniqueId() {
		return uniqueId;
	}

	/**
	 * @param uniqueId the uniqueId to set
	 */
	public void setUniqueId(long uniqueId) {
		this.uniqueId = uniqueId;
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
