/**
 * 
 */
package com.winwallet.model.access;

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
@Table(name= "Customer_Data", uniqueConstraints = @UniqueConstraint(columnNames = {"msisdn"}))
public class CustomerDataObject implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="uniqueId", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uniqueId;
	
	@Column(name="msisdn", nullable = false)
	private String msisdn;
	
	@Column(name="msisdnNetwork", nullable = false)
	private String msisdnNetwork;
	
	@Column(name="dateCreated", nullable = false)
	private LocalDateTime dateCreated;

	/**
	 * 
	 */
	public CustomerDataObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uniqueId
	 * @param msisdn
	 * @param msisdnNetwork
	 * @param dateCreated
	 */
	public CustomerDataObject(long uniqueId, String msisdn, String msisdnNetwork, LocalDateTime dateCreated) {
		super();
		this.uniqueId = uniqueId;
		this.msisdn = msisdn;
		this.msisdnNetwork = msisdnNetwork;
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the uniqueId
	 */
	public long getUniqueId() {
		return uniqueId;
	}

	/**
	 * @param uniqueId the uniqueId to set
	 */
	public void setUniqueId(long uniqueId) {
		this.uniqueId = uniqueId;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
