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
import javax.persistence.UniqueConstraint;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Entity
@Table(name = "Daily_Hammer", uniqueConstraints = @UniqueConstraint(columnNames = {"clientId", "agentId", "mobileNumber"}))
public class DailyHammerObject implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1135998724415006542L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uniqueId", nullable = false)
	private Long uniqueId;
	
	@Column(name = "channelId", nullable = false)
	private String channelId;
	
	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "random", nullable = false)
	private Boolean random;
	
	@Column(name = "mobileNumber", nullable = false)
	private String mobileNumber;
	
	@Column(name = "mobileNetwork", nullable = false)
	private String mobileNetwork;
	
	@Column(name = "multiplier", nullable = false)
	private String multiplier;
	
	@Column(name = "agentId", nullable = false)
	private String agentId;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "sourceUid", nullable = false)
	private String sourceUid;
	
	@Column(name = "amount", nullable = false)
	private String amount;
	
	@Column(name = "psp", nullable = false)
	private String psp;
	
	@Column(name = "gameNumbers", nullable = false)
	private String gameNumbers;
	
	@Column(name = "bonus", nullable = false)
	private String bonus;
	
	@Column(name = "newBonus")
	private String newBonus;
	
	@Column(name = "newBonusFlag")
	private String newBonusFlag;
	
	@Column(name = "user_id")
	private String user_id;
	
	@Column(name = "transaction_id")
	private String transaction_id;
	
	@Column(name = "ticket_id")
	private String ticket_id;
	
	@Column(name= "draw_date")
	private String draw_date;
	
	@Column(name= "costPerLine")
	private String costPerLine;
	
	@Column(name= "event_ids")
	private String event_ids;
	
	@Column(name = "error")
	private String error;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "newGameNumbersFlag")
	private String newGameNumbersFlag;

	@Column(name = "newGameNumbers")
	private String newGameNumbers;
	
	@Column(name = "requestIn")
	private LocalDateTime requestIn;
	
	@Column(name = "responseOut")
	private LocalDateTime responseOut;

	/**
	 * 
	 */
	public DailyHammerObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uniqueId
	 * @param channelId
	 * @param clientId
	 * @param random
	 * @param mobileNumber
	 * @param mobileNetwork
	 * @param multiplier
	 * @param agentId
	 * @param country
	 * @param sourceUid
	 * @param amount
	 * @param psp
	 * @param gameNumbers
	 * @param bonus
	 * @param newBonus
	 * @param newBonusFlag
	 * @param user_id
	 * @param transaction_id
	 * @param ticket_id
	 * @param draw_date
	 * @param costPerLine
	 * @param event_ids
	 * @param error
	 * @param message
	 * @param newGameNumbersFlag
	 * @param newGameNumbers
	 * @param requestIn
	 * @param responseOut
	 */
	public DailyHammerObject(Long uniqueId, String channelId, String clientId, Boolean random, String mobileNumber,
			String mobileNetwork, String multiplier, String agentId, String country, String sourceUid, String amount,
			String psp, String gameNumbers, String bonus, String newBonus, String newBonusFlag, String user_id,
			String transaction_id, String ticket_id, String draw_date, String costPerLine, String event_ids,
			String error, String message, String newGameNumbersFlag, String newGameNumbers, LocalDateTime requestIn,
			LocalDateTime responseOut) {
		super();
		this.uniqueId = uniqueId;
		this.channelId = channelId;
		this.clientId = clientId;
		this.random = random;
		this.mobileNumber = mobileNumber;
		this.mobileNetwork = mobileNetwork;
		this.multiplier = multiplier;
		this.agentId = agentId;
		this.country = country;
		this.sourceUid = sourceUid;
		this.amount = amount;
		this.psp = psp;
		this.gameNumbers = gameNumbers;
		this.bonus = bonus;
		this.newBonus = newBonus;
		this.newBonusFlag = newBonusFlag;
		this.user_id = user_id;
		this.transaction_id = transaction_id;
		this.ticket_id = ticket_id;
		this.draw_date = draw_date;
		this.costPerLine = costPerLine;
		this.event_ids = event_ids;
		this.error = error;
		this.message = message;
		this.newGameNumbersFlag = newGameNumbersFlag;
		this.newGameNumbers = newGameNumbers;
		this.requestIn = requestIn;
		this.responseOut = responseOut;
	}

	/**
	 * @return the uniqueId
	 */
	public Long getUniqueId() {
		return uniqueId;
	}

	/**
	 * @param uniqueId the uniqueId to set
	 */
	public void setUniqueId(Long uniqueId) {
		this.uniqueId = uniqueId;
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
	 * @return the newBonusFlag
	 */
	public String getNewBonusFlag() {
		return newBonusFlag;
	}

	/**
	 * @param newBonusFlag the newBonusFlag to set
	 */
	public void setNewBonusFlag(String newBonusFlag) {
		this.newBonusFlag = newBonusFlag;
	}

	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the transaction_id
	 */
	public String getTransaction_id() {
		return transaction_id;
	}

	/**
	 * @param transaction_id the transaction_id to set
	 */
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	/**
	 * @return the ticket_id
	 */
	public String getTicket_id() {
		return ticket_id;
	}

	/**
	 * @param ticket_id the ticket_id to set
	 */
	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}

	/**
	 * @return the draw_date
	 */
	public String getDraw_date() {
		return draw_date;
	}

	/**
	 * @param draw_date the draw_date to set
	 */
	public void setDraw_date(String draw_date) {
		this.draw_date = draw_date;
	}

	/**
	 * @return the costPerLine
	 */
	public String getCostPerLine() {
		return costPerLine;
	}

	/**
	 * @param costPerLine the costPerLine to set
	 */
	public void setCostPerLine(String costPerLine) {
		this.costPerLine = costPerLine;
	}

	/**
	 * @return the event_ids
	 */
	public String getEvent_ids() {
		return event_ids;
	}

	/**
	 * @param event_ids the event_ids to set
	 */
	public void setEvent_ids(String event_ids) {
		this.event_ids = event_ids;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the newGameNumbersFlag
	 */
	public String getNewGameNumbersFlag() {
		return newGameNumbersFlag;
	}

	/**
	 * @param newGameNumbersFlag the newGameNumbersFlag to set
	 */
	public void setNewGameNumbersFlag(String newGameNumbersFlag) {
		this.newGameNumbersFlag = newGameNumbersFlag;
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
	 * @return the responseOut
	 */
	public LocalDateTime getResponseOut() {
		return responseOut;
	}

	/**
	 * @param responseOut the responseOut to set
	 */
	public void setResponseOut(LocalDateTime responseOut) {
		this.responseOut = responseOut;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
