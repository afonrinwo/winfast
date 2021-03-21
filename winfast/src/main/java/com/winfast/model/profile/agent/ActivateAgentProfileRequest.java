/**
 * 
 */
package com.winfast.model.profile.agent;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public class ActivateAgentProfileRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4103952807530932718L;
	
	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "agentId", nullable = false)
	private String agentId;
	
	@Column(name = "appId", nullable = false)
	private String appId;
	
	@Column(name = "terminalId", nullable = false)
	private String terminalId;

	/**
	 * 
	 */
	public ActivateAgentProfileRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param agentId
	 * @param appId
	 * @param terminalId
	 */
	public ActivateAgentProfileRequest(String clientId, String agentId, String appId, String terminalId) {
		super();
		this.clientId = clientId;
		this.agentId = agentId;
		this.appId = appId;
		this.terminalId = terminalId;
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
	 * @return the terminalId
	 */
	public String getTerminalId() {
		return terminalId;
	}

	/**
	 * @param terminalId the terminalId to set
	 */
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
