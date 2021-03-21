/**
 * 
 */
package com.winfast.model.games;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Entity
@Table(name = "Game_Activity_Log")
public class GameActivityLogObject implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3527740324240800659L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uniqueId", nullable = false)
	private long uniqueId;
	
	@Column(name = "appId", nullable = false)
	private String appId;
	
	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "channelId")
	private String channelId;
	
	@Column(name = "eventId")
	private String eventId;
	
	@Column(name = "multiplier")
	private String multiplier;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "mobileNumber")
	private String mobileNumber;
	
	@Column(name = "mobileNetwork")
	private String mobileNetwork;
	
	@Column(name = "agentId")
	private String agentId;
	
	@Column(name = "amount")
	private String amount;
	
	@Column(name = "psp")
	private String psp;	
	
	@Column(name = "gameNumbers")
	private String gameNumbers;
	
	@Column(name = "newGameNumbers")
	private String newGameNumbers;
	
	@Column(name = "bonus")
	private String bonus;
	
	@Column(name = "newBonus")
	private String newBonus;
	
	@Column(name = "random")
	private Boolean random;
	
	@Column(name = "requestType", nullable = false)
	private String requestType;
	
	@Column(name = "requestIn", nullable = false)
	private LocalDateTime requestIn;
	
	@Column(name = "sourceUid")
	private String sourceUid;
	
	@Column(name = "ticketId")
	private String ticketId;
	
	/**
	 * 
	 */
	public GameActivityLogObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uniqueId
	 * @param appId
	 * @param clientId
	 * @param channelId
	 * @param eventId
	 * @param multiplier
	 * @param country
	 * @param mobileNumber
	 * @param mobileNetwork
	 * @param agentId
	 * @param amount
	 * @param psp
	 * @param gameNumbers
	 * @param newGameNumbers
	 * @param bonus
	 * @param newBonus
	 * @param random
	 * @param requestType
	 * @param requestIn
	 * @param sourceUid
	 * @param ticketId
	 */
	public GameActivityLogObject(long uniqueId, String appId, String clientId, String channelId, String eventId,
			String multiplier, String country, String mobileNumber, String mobileNetwork, String agentId, String amount,
			String psp, String gameNumbers, String newGameNumbers, String bonus, String newBonus, Boolean random,
			String requestType, LocalDateTime requestIn, String sourceUid, String ticketId) {
		super();
		this.uniqueId = uniqueId;
		this.appId = appId;
		this.clientId = clientId;
		this.channelId = channelId;
		this.eventId = eventId;
		this.multiplier = multiplier;
		this.country = country;
		this.mobileNumber = mobileNumber;
		this.mobileNetwork = mobileNetwork;
		this.agentId = agentId;
		this.amount = amount;
		this.psp = psp;
		this.gameNumbers = gameNumbers;
		this.newGameNumbers = newGameNumbers;
		this.bonus = bonus;
		this.newBonus = newBonus;
		this.random = random;
		this.requestType = requestType;
		this.requestIn = requestIn;
		this.sourceUid = sourceUid;
		this.ticketId = ticketId;
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
	 * @return the eventId
	 */
	public String getEventId() {
		return eventId;
	}

	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(String eventId) {
		this.eventId = eventId;
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
	 * @return the newGameNumbers
	 */
	public String getNewGameNumbers() {
		return newGameNumbers;
	}

	/**
	 * @param newGameNumbers the newGameNumbers to set
	 */
	public void setNewGameNumbers(String newGameNumbers) {
		this.newGameNumbers = newGameNumbers;
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
	 * @return the newBonus
	 */
	public String getNewBonus() {
		return newBonus;
	}

	/**
	 * @param newBonus the newBonus to set
	 */
	public void setNewBonus(String newBonus) {
		this.newBonus = newBonus;
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
	 * @return the requestType
	 */
	public String getRequestType() {
		return requestType;
	}

	/**
	 * @param requestType the requestType to set
	 */
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	/**
	 * @return the requestIn
	 */
	public LocalDateTime getRequestIn() {
		return requestIn;
	}

	/**
	 * @param requestIn the requestIn to set
	 */
	public void setRequestIn(LocalDateTime requestIn) {
		this.requestIn = requestIn;
	}

	/**
	 * @return the sourceUid
	 */
	public String getSourceUid() {
		return sourceUid;
	}

	/**
	 * @param sourceUid the sourceUid to set
	 */
	public void setSourceUid(String sourceUid) {
		this.sourceUid = sourceUid;
	}

	/**
	 * @return the ticketId
	 */
	public String getTicketId() {
		return ticketId;
	}

	/**
	 * @param ticketId the ticketId to set
	 */
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
