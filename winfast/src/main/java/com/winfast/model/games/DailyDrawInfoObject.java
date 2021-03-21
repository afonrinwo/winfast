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
@Table(name = "Daily_Draw_Info", uniqueConstraints = @UniqueConstraint(columnNames = {"drawId", "eventDraw"}))
public class DailyDrawInfoObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uniqueId", nullable = false)
	private Long uniqueId;
	
	@Column(name = "entries", nullable = false)
	private String entries;
	
	@Column(name = "page", nullable = false)
	private String page;
	
	@Column(name = "winnings", nullable = false)
	private String winnings;
	
	@Column(name = "drawId", nullable = false)
	private String drawId;
	
	@Column(name = "eventDraw", nullable = false)
	private String eventDraw;
	
	@Column(name = "symbol", nullable = false)
	private String symbol;
	
	@Column(name = "code", nullable = false)
	private String code;
	
	@Column(name = "gameName", nullable = false)
	private String gameName;	
	
	@Column(name = "active", nullable = false)
	private String active;
	
	@Column(name = "jackpotValue", nullable = false)
	private String jackpotValue;
	
	@Column(name = "numbersDrawn", nullable = false)
	private String numbersDrawn;
	
	@Column(name = "drawVideo", nullable = false)
	private String drawVideo;
	
	@Column(name = "prizeTiers", nullable = false)
	private String prizeTiers;

	/**
	 * 
	 */
	public DailyDrawInfoObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uniqueId
	 * @param entries
	 * @param page
	 * @param winnings
	 * @param drawId
	 * @param eventDraw
	 * @param symbol
	 * @param code
	 * @param gameName
	 * @param active
	 * @param jackpotValue
	 * @param numbersDrawn
	 * @param drawVideo
	 * @param prizeTiers
	 */
	public DailyDrawInfoObject(Long uniqueId, String entries, String page, String winnings, String drawId,
			String eventDraw, String symbol, String code, String gameName, String active, String jackpotValue,
			String numbersDrawn, String drawVideo, String prizeTiers) {
		super();
		this.uniqueId = uniqueId;
		this.entries = entries;
		this.page = page;
		this.winnings = winnings;
		this.drawId = drawId;
		this.eventDraw = eventDraw;
		this.symbol = symbol;
		this.code = code;
		this.gameName = gameName;
		this.active = active;
		this.jackpotValue = jackpotValue;
		this.numbersDrawn = numbersDrawn;
		this.drawVideo = drawVideo;
		this.prizeTiers = prizeTiers;
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
	 * @return the entries
	 */
	public String getEntries() {
		return entries;
	}

	/**
	 * @param entries the entries to set
	 */
	public void setEntries(String entries) {
		this.entries = entries;
	}

	/**
	 * @return the page
	 */
	public String getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(String page) {
		this.page = page;
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
	 * @return the drawId
	 */
	public String getDrawId() {
		return drawId;
	}

	/**
	 * @param drawId the drawId to set
	 */
	public void setDrawId(String drawId) {
		this.drawId = drawId;
	}

	/**
	 * @return the eventDraw
	 */
	public String getEventDraw() {
		return eventDraw;
	}

	/**
	 * @param eventDraw the eventDraw to set
	 */
	public void setEventDraw(String eventDraw) {
		this.eventDraw = eventDraw;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the gameName
	 */
	public String getGameName() {
		return gameName;
	}

	/**
	 * @param gameName the gameName to set
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}

	/**
	 * @return the jackpotValue
	 */
	public String getJackpotValue() {
		return jackpotValue;
	}

	/**
	 * @param jackpotValue the jackpotValue to set
	 */
	public void setJackpotValue(String jackpotValue) {
		this.jackpotValue = jackpotValue;
	}

	/**
	 * @return the numbersDrawn
	 */
	public String getNumbersDrawn() {
		return numbersDrawn;
	}

	/**
	 * @param numbersDrawn the numbersDrawn to set
	 */
	public void setNumbersDrawn(String numbersDrawn) {
		this.numbersDrawn = numbersDrawn;
	}

	/**
	 * @return the drawVideo
	 */
	public String getDrawVideo() {
		return drawVideo;
	}

	/**
	 * @param drawVideo the drawVideo to set
	 */
	public void setDrawVideo(String drawVideo) {
		this.drawVideo = drawVideo;
	}

	/**
	 * @return the prizeTiers
	 */
	public String getPrizeTiers() {
		return prizeTiers;
	}

	/**
	 * @param prizeTiers the prizeTiers to set
	 */
	public void setPrizeTiers(String prizeTiers) {
		this.prizeTiers = prizeTiers;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
