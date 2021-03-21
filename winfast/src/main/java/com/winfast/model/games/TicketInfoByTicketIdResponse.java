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
public class TicketInfoByTicketIdResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "event_ids", nullable = false)
	private String event_ids;
	
	@Column(name = "draw_date", nullable = false)
	private String draw_date;
	
	@Column(name = "prodID", nullable = false)
	private String prodID;
	
	@Column(name = "ticket_id", nullable = false)
	private String ticket_id;
	
	@Column(name = "sourceUid", nullable = false)
	private String sourceUid;
	
	@Column(name = "multiplier", nullable = false)
	private String multiplier;
	
	@Column(name = "gameNumbers", nullable = false)
	private String gameNumbers;
	
	@Column(name = "bonus", nullable = false)
	private String bonus;
	
	@Column(name = "responsecode", nullable = false)
	private String responsecode;
	
	@Column(name = "responsemessage", nullable = false)
	private String responsemessage;
	


	/**
	 * 
	 */
	public TicketInfoByTicketIdResponse() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param clientId
	 * @param event_ids
	 * @param draw_date
	 * @param prodID
	 * @param ticket_id
	 * @param sourceUid
	 * @param multiplier
	 * @param gameNumbers
	 * @param bonus
	 * @param responsecode
	 * @param responsemessage
	 */
	public TicketInfoByTicketIdResponse(String clientId, String event_ids, String draw_date, String prodID,
			String ticket_id, String sourceUid, String multiplier, String gameNumbers, String bonus,
			String responsecode, String responsemessage) {
		super();
		this.clientId = clientId;
		this.event_ids = event_ids;
		this.draw_date = draw_date;
		this.prodID = prodID;
		this.ticket_id = ticket_id;
		this.sourceUid = sourceUid;
		this.multiplier = multiplier;
		this.gameNumbers = gameNumbers;
		this.bonus = bonus;
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
	 * @return the prodID
	 */
	public String getProdID() {
		return prodID;
	}



	/**
	 * @param prodID the prodID to set
	 */
	public void setProdID(String prodID) {
		this.prodID = prodID;
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
