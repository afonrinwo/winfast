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
@Table(name = "Game_Profile", uniqueConstraints = @UniqueConstraint(columnNames = {"msisdnNumber"}))
public class GameProfileObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8273756338042278711L;
	
	@Id
	@Column(name="uniqueId", nullable= false)
	private long uniqueId;

	@Column(name="clientId", nullable= false)
	private String clientId;
	
	@Column(name="userId", nullable= false)
	private String userId;
	
	@Column(name="msisdnNumber", nullable= false)
	private String msisdnNumber;
	
	@Column(name="msisdnNetwork", nullable= false)
	private String msisdnNetwork;
	
	@Column(name="email")
	private String email;
	
	@Column(name="status", nullable= false)
	private int status;
	
	@Column(name="dateCreated", nullable= false)
	private LocalDateTime dateCreated;
	
	@Column(name="lastModified", nullable= false)
	private LocalDateTime lastModified;

	/**
	 * 
	 */
	public GameProfileObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uniqueId
	 * @param clientId
	 * @param userId
	 * @param msisdnNumber
	 * @param msisdnNetwork
	 * @param email
	 * @param status
	 * @param dateCreated
	 * @param lastModified
	 */
	public GameProfileObject(long uniqueId, String clientId, String userId, String msisdnNumber, String msisdnNetwork,
			String email, int status, LocalDateTime dateCreated, LocalDateTime lastModified) {
		super();
		this.uniqueId = uniqueId;
		this.clientId = clientId;
		this.userId = userId;
		this.msisdnNumber = msisdnNumber;
		this.msisdnNetwork = msisdnNetwork;
		this.email = email;
		this.status = status;
		this.dateCreated = dateCreated;
		this.lastModified = lastModified;
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
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
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
	 * @return the lastModified
	 */
	public LocalDateTime getLastModified() {
		return lastModified;
	}

	/**
	 * @param lastModified the lastModified to set
	 */
	public void setLastModified(LocalDateTime lastModified) {
		this.lastModified = lastModified;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
}