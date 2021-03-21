package com.winfast.model.profile.system;

import java.io.Serializable;

import javax.persistence.Column;

public class SystemProfileRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6255483976713544748L;

	@Column(name = "clientId", nullable = false)
	private String clientId;

	@Column(name = "appId", nullable = false)
	private String appId;

	@Column(name = "appKey", nullable = false)
	private String appKey;

	@Column(name = "serverIp", nullable = false)
	private String serverIp;

	/**
	 * 
	 */
	public SystemProfileRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param appId
	 * @param appKey
	 * @param serverIp
	 */
	public SystemProfileRequest(String clientId, String appId, String appKey, String serverIp) {
		super();
		this.clientId = clientId;
		this.appId = appId;
		this.appKey = appKey;
		this.serverIp = serverIp;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
