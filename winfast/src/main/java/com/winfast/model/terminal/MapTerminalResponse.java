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
public class MapTerminalResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7830972908399356564L;
	
	@Column(name = "clientId", nullable = false)
	private String clientId;

	@Column(name = "agentId", nullable = false)
	private String agentId;
	
	@Column(name = "terminalId", nullable = false)
	private String terminalId;
	
	@Column(name = "responseCode", nullable = false)
	private String responseCode;
	
	@Column(name = "responseMessage", nullable = false)
	private String responseMessage;

	/**
	 * 
	 */
	public MapTerminalResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param agentId
	 * @param terminalId
	 * @param responseCode
	 * @param responseMessage
	 */
	public MapTerminalResponse(String clientId, String agentId, String terminalId, String responseCode,
			String responseMessage) {
		super();
		this.clientId = clientId;
		this.agentId = agentId;
		this.terminalId = terminalId;
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
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
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the responseMessage
	 */
	public String getResponseMessage() {
		return responseMessage;
	}

	/**
	 * @param responseMessage the responseMessage to set
	 */
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
