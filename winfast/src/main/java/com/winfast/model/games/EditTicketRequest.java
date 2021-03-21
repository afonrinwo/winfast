/**
 * 
 */
package com.winfast.model.games;

import java.io.Serializable;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public class EditTicketRequest implements Serializable {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String bonus;
	private String clientId;
	private String sourceUid;
    private String ticketId;
    private String multiplier;
    private String newGameNumbers;

	/**
	 * 
	 */
	public EditTicketRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param bonus
	 * @param clientId
	 * @param sourceUid
	 * @param ticketId
	 * @param multiplier
	 * @param newGameNumbers
	 */
	public EditTicketRequest(String bonus, String clientId, String sourceUid, String ticketId, String multiplier,
			String newGameNumbers) {
		super();
		this.bonus = bonus;
		this.clientId = clientId;
		this.sourceUid = sourceUid;
		this.ticketId = ticketId;
		this.multiplier = multiplier;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}
