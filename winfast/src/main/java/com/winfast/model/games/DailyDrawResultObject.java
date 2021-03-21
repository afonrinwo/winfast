/**
 * 
 */
package com.winfast.model.games;

import java.io.Serializable;

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
@Table(name = "daily_draw_result", uniqueConstraints = @UniqueConstraint(columnNames = {"ticketId", "sourceUid"}))
public class DailyDrawResultObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uniqueId", nullable = false)
	private long uniqueId;
	
	@Column(name = "userId", nullable = false)
	private String userId;
	
	@Column(name = "msisdn", nullable = false)
	private String msisdn;
	
	@Column(name = "ticketId", nullable = false)
	private String ticketId;
	
	@Column(name = "sourceUid", nullable = false)
	private String sourceUid;
	
	@Column(name = "multiplier", nullable = false)
	private String multiplier;
	
	@Column(name = "bonus", nullable = false)
	private String bonus;
	
	@Column(name = "main", nullable = false)
	private String main;
	
	@Column(name = "hits", nullable = false)
	private String hits;
	
	@Column(name = "line", nullable = false)
	private String line;
	
	@Column(name = "winings", nullable = false)
	private String winings;
	
	@Column(name = "drawn", nullable = false)
	private String drawn;
	
	@Column(name = "prize", nullable = false)
	private String prize;

	/**
	 * 
	 */
	public DailyDrawResultObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param userId
	 * @param msisdn
	 * @param ticketId
	 * @param sourceUid
	 * @param multiplier
	 * @param bonus
	 * @param main
	 * @param hits
	 * @param line
	 * @param winings
	 * @param drawn
	 * @param prize
	 */
	public DailyDrawResultObject(String userId, String msisdn, String ticketId, String sourceUid, String multiplier,
			String bonus, String main, String hits, String line, String winings, String drawn, String prize) {
		super();
		this.userId = userId;
		this.msisdn = msisdn;
		this.ticketId = ticketId;
		this.sourceUid = sourceUid;
		this.multiplier = multiplier;
		this.bonus = bonus;
		this.main = main;
		this.hits = hits;
		this.line = line;
		this.winings = winings;
		this.drawn = drawn;
		this.prize = prize;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the msisdn
	 */
	public String getMsisdn() {
		return msisdn;
	}

	/**
	 * @param msisdn the msisdn to set
	 */
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
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
	 * @return the main
	 */
	public String getMain() {
		return main;
	}

	/**
	 * @param main the main to set
	 */
	public void setMain(String main) {
		this.main = main;
	}

	/**
	 * @return the hits
	 */
	public String getHits() {
		return hits;
	}

	/**
	 * @param hits the hits to set
	 */
	public void setHits(String hits) {
		this.hits = hits;
	}

	/**
	 * @return the line
	 */
	public String getLine() {
		return line;
	}

	/**
	 * @param line the line to set
	 */
	public void setLine(String line) {
		this.line = line;
	}

	/**
	 * @return the winings
	 */
	public String getWinings() {
		return winings;
	}

	/**
	 * @param winings the winings to set
	 */
	public void setWinings(String winings) {
		this.winings = winings;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
