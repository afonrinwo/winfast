/**
 * 
 */
package com.winfast.model.games;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public class GameGeneratorRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "agentId", nullable = false)
	private String agentId;
	
	@Column(name = "mobileNumber", nullable = false)
	private String mobileNumber;
	
	@Column(name = "psp", nullable = false)
	private String psp;

	/**
	 * 
	 */
	public GameGeneratorRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param agentId
	 * @param mobileNumber
	 * @param psp
	 */
	public GameGeneratorRequest(String clientId, String agentId, String mobileNumber, String psp) {
		super();
		this.clientId = clientId;
		this.agentId = agentId;
		this.mobileNumber = mobileNumber;
		this.psp = psp;
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
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the psp
	 */
	public String getPsp() {
		return psp;
	}

	/**
	 * @param psp the psp to set
	 */
	public void setPsp(String psp) {
		this.psp = psp;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
