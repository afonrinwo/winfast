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
public class InstantMillionResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "uniqueid", nullable = false)
	private long uniqueid;
	
	@Column(name = "agentId")
	String agentId;
	
	@Column(name = "amount")
	String amount;
	
	@Column(name = "channels")
	String channels;
	
	@Column(name = "clientId", nullable = false)
	String clientId;
	
	@Column(name = "country")
	String country;
	
	@Column(name = "mobileNumber")
	String mobileNumber;
	
	@Column(name = "psp")
	String psp;
	
	@Column(name = "sourceUid")
	String sourceUid;
	
	@Column(name = "gameNumbers")
	String gameNumbers;
	
	@Column(name = "bonus")
	String bonus;
	
	@Column(name = "transactionId")
	int transaction_id;
	
	@Column(name = "ticketId")
	String ticket_id;
	
	@Column(name = "eventIds")
	String event_ids;
	
	@Column(name = "drawDate")
	String draw_date;
	
	@Column(name = "drawn")
	private String drawn;
	
	@Column(name = "gameMatch")
	private String gameMatch;
	
	@Column(name = "hit")
	private String hit;
	
	@Column(name = "prize")
	private String prize;
	
	@Column(name = "winnings")
	private String winnings;
	
	@Column(name = "error")
	private String error;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "costPerLine")
	private String costPerLine;
	
	@Column(name = "responsecode", nullable = false)
	private String responsecode;
	
	@Column(name = "responsemessage", nullable = false)
	private String responsemessage;

	/**
	 * 
	 */
	public InstantMillionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uniqueid
	 * @param agentId
	 * @param amount
	 * @param channels
	 * @param clientId
	 * @param country
	 * @param mobileNumber
	 * @param psp
	 * @param sourceUid
	 * @param gameNumbers
	 * @param bonus
	 * @param transaction_id
	 * @param ticket_id
	 * @param event_ids
	 * @param draw_date
	 * @param drawn
	 * @param gameMatch
	 * @param hit
	 * @param prize
	 * @param winnings
	 * @param error
	 * @param message
	 * @param costPerLine
	 * @param responsecode
	 * @param responsemessage
	 */
	public InstantMillionResponse(long uniqueid, String agentId, String amount, String channels, String clientId,
			String country, String mobileNumber, String psp, String sourceUid, String gameNumbers, String bonus,
			int transaction_id, String ticket_id, String event_ids, String draw_date, String drawn, String gameMatch,
			String hit, String prize, String winnings, String error, String message, String costPerLine,
			String responsecode, String responsemessage) {
		super();
		this.uniqueid = uniqueid;
		this.agentId = agentId;
		this.amount = amount;
		this.channels = channels;
		this.clientId = clientId;
		this.country = country;
		this.mobileNumber = mobileNumber;
		this.psp = psp;
		this.sourceUid = sourceUid;
		this.gameNumbers = gameNumbers;
		this.bonus = bonus;
		this.transaction_id = transaction_id;
		this.ticket_id = ticket_id;
		this.event_ids = event_ids;
		this.draw_date = draw_date;
		this.drawn = drawn;
		this.gameMatch = gameMatch;
		this.hit = hit;
		this.prize = prize;
		this.winnings = winnings;
		this.error = error;
		this.message = message;
		this.costPerLine = costPerLine;
		this.responsecode = responsecode;
		this.responsemessage = responsemessage;
	}

	/**
	 * @return the uniqueid
	 */
	public long getUniqueid() {
		return uniqueid;
	}

	/**
	 * @param uniqueid the uniqueid to set
	 */
	public void setUniqueid(long uniqueid) {
		this.uniqueid = uniqueid;
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
	 * @return the channels
	 */
	public String getChannels() {
		return channels;
	}

	/**
	 * @param channels the channels to set
	 */
	public void setChannels(String channels) {
		this.channels = channels;
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
	 * @return the transaction_id
	 */
	public int getTransaction_id() {
		return transaction_id;
	}

	/**
	 * @param transaction_id the transaction_id to set
	 */
	public void setTransaction_id(int transaction_id) {
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
	 * @return the drawn
	 */
	public String getDrawn() {
		return drawn;
	}

	/**
	 * @param drawn the drawn to set
	 */
	public void setDrawn(String drawn) {
		this.drawn = drawn;
	}

	/**
	 * @return the gameMatch
	 */
	public String getGameMatch() {
		return gameMatch;
	}

	/**
	 * @param gameMatch the gameMatch to set
	 */
	public void setGameMatch(String gameMatch) {
		this.gameMatch = gameMatch;
	}

	/**
	 * @return the hit
	 */
	public String getHit() {
		return hit;
	}

	/**
	 * @param hit the hit to set
	 */
	public void setHit(String hit) {
		this.hit = hit;
	}

	/**
	 * @return the prize
	 */
	public String getPrize() {
		return prize;
	}

	/**
	 * @param prize the prize to set
	 */
	public void setPrize(String prize) {
		this.prize = prize;
	}

	/**
	 * @return the winnings
	 */
	public String getWinnings() {
		return winnings;
	}

	/**
	 * @param winnings the winnings to set
	 */
	public void setWinnings(String winnings) {
		this.winnings = winnings;
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
