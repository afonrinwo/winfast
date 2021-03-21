/**
 * 
 */
package com.winwallet.model.account;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Entity
@Table( name="PND_Table" )
public class PNDObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "uniqueId", nullable = false)
	private String uniqueId;

	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "msisdn", nullable = false)
	private String msisdn;
	
	@Column(name = "msisdnNetwork", nullable = false)
	private String msisdnNetwork;
	
	@Column(name = "channel", nullable = false)
	private String channel;
	
	@Column(name = "pndFlag", nullable = false)
	private int pndFlag;
	
	@Column(name = "pndReason", nullable = false)
	private int pndReason;
	
	@Column(name = "datePlaced", nullable = false)
	private String datePlaced;
	
	@Column(name = "dateRemoved")
	private String dateRemoved;

	/**
	 * 
	 */
	public PNDObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param msisdn
	 * @param msisdnNetwork
	 * @param channel
	 * @param pndFlag
	 * @param pndReason
	 * @param datePlaced
	 * @param dateRemoved
	 */
	public PNDObject(String clientId, String msisdn, String msisdnNetwork, String channel, int pndFlag, int pndReason,
			String datePlaced, String dateRemoved) {
		super();
		this.clientId = clientId;
		this.msisdn = msisdn;
		this.msisdnNetwork = msisdnNetwork;
		this.channel = channel;
		this.pndFlag = pndFlag;
		this.pndReason = pndReason;
		this.datePlaced = datePlaced;
		this.dateRemoved = dateRemoved;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	 * @return the msisdnNetwork
	 */
	public String getMsisdnNetwork() {
		return msisdnNetwork;
	}

	/**
	 * @param msisdnNetwork the msisdnNetwork to set
	 */
	public void setMsisdnNetwork(String msisdnNetwork) {
		this.msisdnNetwork = msisdnNetwork;
	}

	/**
	 * @return the channel
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * @param channel the channel to set
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}

	/**
	 * @return the pndFlag
	 */
	public int getPndFlag() {
		return pndFlag;
	}

	/**
	 * @param pndFlag the pndFlag to set
	 */
	public void setPndFlag(int pndFlag) {
		this.pndFlag = pndFlag;
	}

	/**
	 * @return the pndReason
	 */
	public int getPndReason() {
		return pndReason;
	}

	/**
	 * @param pndReason the pndReason to set
	 */
	public void setPndReason(int pndReason) {
		this.pndReason = pndReason;
	}

	/**
	 * @return the datePlaced
	 */
	public String getDatePlaced() {
		return datePlaced;
	}

	/**
	 * @param datePlaced the datePlaced to set
	 */
	public void setDatePlaced(String datePlaced) {
		this.datePlaced = datePlaced;
	}

	/**
	 * @return the dateRemoved
	 */
	public String getDateRemoved() {
		return dateRemoved;
	}

	/**
	 * @param dateRemoved the dateRemoved to set
	 */
	public void setDateRemoved(String dateRemoved) {
		this.dateRemoved = dateRemoved;
	}

}
