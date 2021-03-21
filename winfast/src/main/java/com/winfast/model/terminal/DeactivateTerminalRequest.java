/**
 * 
 */
package com.winfast.model.terminal;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public class DeactivateTerminalRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9143472271143794376L;
	
	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "appId", nullable = false)
	private String appId;
	
	@Column(name = "agentId", nullable = false)
	private String agentId;
	
	@Column(name = "terminalId", nullable = false)
	private String terminalId;
	
	@Column(name = "reason", nullable = false)
	private String reason;

	/**
	 * 
	 */
	public DeactivateTerminalRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param appId
	 * @param agentId
	 * @param terminalId
	 * @param reason
	 */
	public DeactivateTerminalRequest(String clientId, String appId, String agentId, String terminalId, String reason) {
		super();
		this.clientId = clientId;
		this.appId = appId;
		this.agentId = agentId;
		this.terminalId = terminalId;
		this.reason = reason;
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
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
