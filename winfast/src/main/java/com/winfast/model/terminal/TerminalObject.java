/**
 * 
 */
package com.winfast.model.terminal;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Entity
@Table(name = "Map_Terminal")
public class TerminalObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7830972908399356564L;
	
	@Id
	@Column(name = "terminalId", nullable = false)
	private String terminalId;

	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "appId", nullable = false)
	private String appId;
	
	@Column(name = "agentId", nullable = false)
	private String agentId;
	
	@Column(name = "terminalLocation", nullable = false)
	private String terminalLocation;
	
	@Column(name="terminalLocationTown", nullable= false)
	private String terminalLocationTown;
	
	@Column(name="terminalLocationLGA", nullable= false)
	private String terminalLocationLGA;
	
	@Column(name="terminalLocationState", nullable= false)
	private String terminalLocationState;
	
	@Column(name="status", nullable= false)
	private int status;
	
	@Column(name="reason")
	private String reason;
	
	@Column(name = "dateCreated", nullable = false)
	private LocalDateTime dateCreated;

	@Column(name = "lastUpdated", nullable = false)
	private LocalDateTime lastUpdated;

	/**
	 * 
	 */
	public TerminalObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param terminalId
	 * @param clientId
	 * @param appId
	 * @param agentId
	 * @param terminalLocation
	 * @param terminalLocationTown
	 * @param terminalLocationLGA
	 * @param terminalLocationState
	 * @param status
	 * @param reason
	 * @param dateCreated
	 * @param lastUpdated
	 */
	public TerminalObject(String terminalId, String clientId, String appId, String agentId, String terminalLocation,
			String terminalLocationTown, String terminalLocationLGA, String terminalLocationState, int status,
			String reason, LocalDateTime dateCreated, LocalDateTime lastUpdated) {
		super();
		this.terminalId = terminalId;
		this.clientId = clientId;
		this.appId = appId;
		this.agentId = agentId;
		this.terminalLocation = terminalLocation;
		this.terminalLocationTown = terminalLocationTown;
		this.terminalLocationLGA = terminalLocationLGA;
		this.terminalLocationState = terminalLocationState;
		this.status = status;
		this.reason = reason;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
	}

	/**
	 * @return the terminalId
	 */
	public String getTerminalId() {
		return terminalId;
	}

	/**
	 * @param terminalId the terminalId to set
	 */
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
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
	 * @return the terminalLocation
	 */
	public String getTerminalLocation() {
		return terminalLocation;
	}

	/**
	 * @param terminalLocation the terminalLocation to set
	 */
	public void setTerminalLocation(String terminalLocation) {
		this.terminalLocation = terminalLocation;
	}

	/**
	 * @return the terminalLocationTown
	 */
	public String getTerminalLocationTown() {
		return terminalLocationTown;
	}

	/**
	 * @param terminalLocationTown the terminalLocationTown to set
	 */
	public void setTerminalLocationTown(String terminalLocationTown) {
		this.terminalLocationTown = terminalLocationTown;
	}

	/**
	 * @return the terminalLocationLGA
	 */
	public String getTerminalLocationLGA() {
		return terminalLocationLGA;
	}

	/**
	 * @param terminalLocationLGA the terminalLocationLGA to set
	 */
	public void setTerminalLocationLGA(String terminalLocationLGA) {
		this.terminalLocationLGA = terminalLocationLGA;
	}

	/**
	 * @return the terminalLocationState
	 */
	public String getTerminalLocationState() {
		return terminalLocationState;
	}

	/**
	 * @param terminalLocationState the terminalLocationState to set
	 */
	public void setTerminalLocationState(String terminalLocationState) {
		this.terminalLocationState = terminalLocationState;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the dateCreated
	 */
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the lastUpdated
	 */
	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * @param lastUpdated the lastUpdated to set
	 */
	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
