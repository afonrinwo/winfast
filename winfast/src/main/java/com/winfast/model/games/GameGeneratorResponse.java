/**
 * 
 */
package com.winfast.model.games;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public class GameGeneratorResponse implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "agentId", nullable = false)
	private String agentId;
	
	@Column(name = "psp", nullable = false)
	private String psp;
	
	@Column(name = "gameNumbers", nullable = false)
	private List<Integer> gameNumbers;
	
	@Column(name = "mobileNumber", nullable = false)
	private String mobileNumber;
	
	@Column(name = "responsecode", nullable = false)
	private String responsecode;
	
	@Column(name = "responsemessage", nullable = false)
	private String responsemessage;

	/**
	 * 
	 */
	public GameGeneratorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param agentId
	 * @param psp
	 * @param gameNumbers
	 * @param mobileNumber
	 * @param responsecode
	 * @param responsemessage
	 */
	public GameGeneratorResponse(String clientId, String agentId, String psp, List<Integer> gameNumbers,
			String mobileNumber, String responsecode, String responsemessage) {
		super();
		this.clientId = clientId;
		this.agentId = agentId;
		this.psp = psp;
		this.gameNumbers = gameNumbers;
		this.mobileNumber = mobileNumber;
		this.responsecode = responsecode;
		this.responsemessage = responsemessage;
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
	 * @return the gameNumbers
	 */
	public List<Integer> getGameNumbers() {
		return gameNumbers;
	}

	/**
	 * @param gameNumbers the gameNumbers to set
	 */
	public void setGameNumbers(List<Integer> gameNumbers) {
		this.gameNumbers = gameNumbers;
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
	 * @return the responsecode
	 */
	public String getResponsecode() {
		return responsecode;
	}

	/**
	 * @param responsecode the responsecode to set
	 */
	public void setResponsecode(String responsecode) {
		this.responsecode = responsecode;
	}

	/**
	 * @return the responsemessage
	 */
	public String getResponsemessage() {
		return responsemessage;
	}

	/**
	 * @param responsemessage the responsemessage to set
	 */
	public void setResponsemessage(String responsemessage) {
		this.responsemessage = responsemessage;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
