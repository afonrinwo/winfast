/**
 * 
 */
package com.winfast.model.profile.system;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Entity
@Table(name = "System_Profile", uniqueConstraints = @UniqueConstraint(columnNames = {"appId", "appKey", "serverIp"}))
public class SystemProfileObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6992920709741010765L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uniqueId", nullable = false)
	private long uniqueId;
	
	@Column(name = "clientId", nullable = false)
	private String clientId;

	@Column(name = "appId", nullable = false)
	private String appId;

	@Column(name = "appKey", nullable = false)
	private String appKey;

	@Column(name = "serverIp", nullable = false)
	private String serverIp;
	
	@Column(name = "status", nullable = false)
	private int status;
	
	@Column(name = "dateCreated", nullable = false)
	private String dateCreated;
	
	@Column(name = "dateApproved")
	private String dateApproved;

	/**
	 * 
	 */
	public SystemProfileObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uniqueId
	 * @param clientId
	 * @param appId
	 * @param appKey
	 * @param serverIp
	 * @param status
	 * @param dateCreated
	 * @param dateApproved
	 */
	public SystemProfileObject(long uniqueId, String clientId, String appId, String appKey, String serverIp, int status,
			String dateCreated, String dateApproved) {
		super();
		this.uniqueId = uniqueId;
		this.clientId = clientId;
		this.appId = appId;
		this.appKey = appKey;
		this.serverIp = serverIp;
		this.status = status;
		this.dateCreated = dateCreated;
		this.dateApproved = dateApproved;
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
	 * @return the appId
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * @param appId the appId to set
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * @return the appKey
	 */
	public String getAppKey() {
		return appKey;
	}

	/**
	 * @param appKey the appKey to set
	 */
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	/**
	 * @return the serverIp
	 */
	public String getServerIp() {
		return serverIp;
	}

	/**
	 * @param serverIp the serverIp to set
	 */
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
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
	public String getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the dateApproved
	 */
	public String getDateApproved() {
		return dateApproved;
	}

	/**
	 * @param dateApproved the dateApproved to set
	 */
	public void setDateApproved(String dateApproved) {
		this.dateApproved = dateApproved;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
