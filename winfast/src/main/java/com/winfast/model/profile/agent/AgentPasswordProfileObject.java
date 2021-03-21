/**
 * 
 */
package com.winfast.model.profile.agent;

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
@Table(name="Agent_Password", uniqueConstraints = @UniqueConstraint(columnNames = {"agentId"}))
public class AgentPasswordProfileObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 389128170934022856L;

	@Id
	@Column(name = "agentId", nullable = false)
	private long agentId;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "oldPassword", nullable = false)
	private String oldPassword;

	@Column(name = "dateCreated", nullable = false)
	private LocalDateTime dateCreated;

	@Column(name = "lastUpdated", nullable = false)
	private LocalDateTime lastUpdated;

	@Column(name = "changeCount", nullable = false)
	private int changeCount;

	/**
	 * 
	 */
	public AgentPasswordProfileObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param agentId
	 * @param password
	 * @param oldPassword
	 * @param dateCreated
	 * @param lastUpdated
	 * @param changeCount
	 */
	public AgentPasswordProfileObject(long agentId, String password, String oldPassword, LocalDateTime dateCreated,
			LocalDateTime lastUpdated, int changeCount) {
		super();
		this.agentId = agentId;
		this.password = password;
		this.oldPassword = oldPassword;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.changeCount = changeCount;
	}

	/**
	 * @return the agentId
	 */
	public long getAgentId() {
		return agentId;
	}

	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(long agentId) {
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
	 * @return the oldPassword
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * @param oldPassword the oldPassword to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
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
