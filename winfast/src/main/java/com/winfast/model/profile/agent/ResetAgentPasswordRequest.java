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
public class ResetAgentPasswordRequest implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4366514373021181665L;
	
	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "agentId", nullable = false)
	private String agentId;
	

	/**
	 * 
	 */
	public ResetAgentPasswordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param clientId
	 * @param agentId
	 */
	public ResetAgentPasswordRequest(String clientId, String agentId) {
		super();
		this.clientId = clientId;
		this.agentId = agentId;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
