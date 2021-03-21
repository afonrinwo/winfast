/**
 * 
 */
package com.winfast.model.terminal;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public class MapTerminalRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7830972908399356564L;

	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "appId", nullable = false)
	private String appId;
	
	@Column(name = "agentId", nullable = false)
	private String agentId;
	
	@Column(name = "terminalId", nullable = false)
	private String terminalId;
	
	@Column(name = "terminalLocation", nullable = false)
	private String terminalLocation;
	
	@Column(name="terminalLocationTown", nullable= false)
	private String terminalLocationTown;
	
	@Column(name="terminalLocationLGA", nullable= false)
	private String terminalLocationLGA;
	
	@Column(name="terminalLocationState", nullable= false)
	private String terminalLocationState;

	/**
	 * 
	 */
	public MapTerminalRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param appId
	 * @param agentId
	 * @param terminalId
	 * @param terminalLocation
	 * @param terminalLocationTown
	 * @param terminalLocationLGA
	 * @param terminalLocationState
	 */
	public MapTerminalRequest(String clientId, String appId, String agentId, String terminalId, String terminalLocation,
			String terminalLocationTown, String terminalLocationLGA, String terminalLocationState) {
		super();
		this.clientId = clientId;
		this.appId = appId;
		this.agentId = agentId;
		this.terminalId = terminalId;
		this.terminalLocation = terminalLocation;
		this.terminalLocationTown = terminalLocationTown;
		this.terminalLocationLGA = terminalLocationLGA;
		this.terminalLocationState = terminalLocationState;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
