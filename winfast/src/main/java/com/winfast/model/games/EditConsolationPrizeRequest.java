/**
 * 
 */
package com.winfast.model.games;

import java.io.Serializable;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public class EditConsolationPrizeRequest implements Serializable {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String newBonus;
	private String clientId;
	private String sourceUid;
    private String ticketId;
    private String multiplier;
    private String gameNumbers;

	/**
	 * 
	 */
	public EditConsolationPrizeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param newBonus
	 * @param clientId
	 * @param sourceUid
	 * @param ticketId
	 * @param multiplier
	 * @param gameNumbers
	 */
	public EditConsolationPrizeRequest(String newBonus, String clientId, String sourceUid, String ticketId,
			String multiplier, String gameNumbers) {
		super();
		this.newBonus = newBonus;
		this.clientId = clientId;
		this.sourceUid = sourceUid;
		this.ticketId = ticketId;
		this.multiplier = multiplier;
		this.gameNumbers = gameNumbers;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
