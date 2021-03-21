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
public class DailyHammerRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 917214305032540487L;

	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "channelId", nullable = false)
	private String channelId;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "mobileNumber", nullable = false)
	private String mobileNumber;
	
	@Column(name = "mobileNetwork", nullable = false)
	private String mobileNetwork;
	
	@Column(name = "multiplier", nullable = false)
	private String multiplier;
	
	@Column(name = "agentId", nullable = false)
	private String agentId;
	
	@Column(name = "amount", nullable = false)
	private String amount;
	
	@Column(name = "psp", nullable = false)
	private String psp;	
	
	@Column(name = "gameNumbers", nullable = false)
	private String gameNumbers;
	
	@Column(name = "bonus", nullable = false)
	private String bonus;
	
	@Column(name = "random", nullable = false)
	private Boolean random = false;
	

	/**
	 * 
	 */
	public DailyHammerRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param clientId
	 * @param channelId
	 * @param country
	 * @param mobileNumber
	 * @param mobileNetwork
	 * @param multiplier
	 * @param agentId
	 * @param amount
	 * @param psp
	 * @param gameNumbers
	 * @param bonus
	 * @param random
	 */
	public DailyHammerRequest(String clientId, String channelId, String country, String mobileNumber,
			String mobileNetwork, String multiplier, String agentId, String amount, String psp, String gameNumbers,
			String bonus, Boolean random) {
		super();
		this.clientId = clientId;
		this.channelId = channelId;
		this.country = country;
		this.mobileNumber = mobileNumber;
		this.mobileNetwork = mobileNetwork;
		this.multiplier = multiplier;
		this.agentId = agentId;
		this.amount = amount;
		this.psp = psp;
		this.gameNumbers = gameNumbers;
		this.bonus = bonus;
		this.random = random;
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
	 * @return the channelId
	 */
	public String getChannelId() {
		return channelId;
	}


	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}


	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}


	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
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
	 * @return the mobileNetwork
	 */
	public String getMobileNetwork() {
		return mobileNetwork;
	}


	/**
	 * @param mobileNetwork the mobileNetwork to set
	 */
	public void setMobileNetwork(String mobileNetwork) {
		this.mobileNetwork = mobileNetwork;
	}


	/**
	 * @return the multiplier
	 */
	public String getMultiplier() {
		return multiplier;
	}


	/**
	 * @param multiplier the multiplier to set
	 */
	public void setMultiplier(String multiplier) {
		this.multiplier = multiplier;
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
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}


	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
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
	public String getGameNumbers() {
		return gameNumbers;
	}


	/**
	 * @param gameNumbers the gameNumbers to set
	 */
	public void setGameNumbers(String gameNumbers) {
		this.gameNumbers = gameNumbers;
	}


	/**
	 * @return the bonus
	 */
	public String getBonus() {
		return bonus;
	}


	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(String bonus) {
		this.bonus = bonus;
	}


	/**
	 * @return the random
	 */
	public Boolean getRandom() {
		return random;
	}


	/**
	 * @param random the random to set
	 */
	public void setRandom(Boolean random) {
		this.random = random;
	}


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
