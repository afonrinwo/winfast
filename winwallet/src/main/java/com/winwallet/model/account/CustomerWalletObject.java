/**
 * 
 */
package com.winwallet.model.account;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Entity
@Table(name = "Customer_Wallet", uniqueConstraints = @UniqueConstraint(columnNames = { "msisdn" }))
public class CustomerWalletObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name="uniqueId", nullable = false)
	private long uniqueId;
	
	@Column(name="msisdn", nullable = false)
	private String msisdn;
	
	@Column(name="msisdnNetwork")
	private String msisdnNetwork;

	
	@Column(name="lien", nullable = false)
	private double lien;
	
	@Column(name="pnd", nullable = false)
	private int pnd;
	
	@Column(name="availableBalance", nullable = false)
	private double availableBalance;
	
	@Column(name="bookBalance", nullable = false)
	private double bookBalance;
	
	@Column(name="dateCreated", nullable = false)
	private LocalDateTime dateCreated;
	
	@Column(name="lastEditedDate", nullable = false)
	private LocalDateTime lastEditedDate;

	/**
	 * 
	 */
	public CustomerWalletObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uniqueId
	 * @param msisdn
	 * @param msisdnNetwork
	 * @param lien
	 * @param pnd
	 * @param availableBalance
	 * @param bookBalance
	 * @param dateCreated
	 * @param lastEditedDate
	 */
	public CustomerWalletObject(long uniqueId, String msisdn, String msisdnNetwork, double lien, int pnd,
			double availableBalance, double bookBalance, LocalDateTime dateCreated, LocalDateTime lastEditedDate) {
		super();
		this.uniqueId = uniqueId;
		this.msisdn = msisdn;
		this.msisdnNetwork = msisdnNetwork;
		this.lien = lien;
		this.pnd = pnd;
		this.availableBalance = availableBalance;
		this.bookBalance = bookBalance;
		this.dateCreated = dateCreated;
		this.lastEditedDate = lastEditedDate;
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
	 * @return the lien
	 */
	public double getLien() {
		return lien;
	}

	/**
	 * @param lien the lien to set
	 */
	public void setLien(double lien) {
		this.lien = lien;
	}

	/**
	 * @return the pnd
	 */
	public int getPnd() {
		return pnd;
	}

	/**
	 * @param pnd the pnd to set
	 */
	public void setPnd(int pnd) {
		this.pnd = pnd;
	}

	/**
	 * @return the availableBalance
	 */
	public double getAvailableBalance() {
		return availableBalance;
	}

	/**
	 * @param availableBalance the availableBalance to set
	 */
	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	/**
	 * @return the bookBalance
	 */
	public double getBookBalance() {
		return bookBalance;
	}

	/**
	 * @param bookBalance the bookBalance to set
	 */
	public void setBookBalance(double bookBalance) {
		this.bookBalance = bookBalance;
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
	 * @return the lastEditedDate
	 */
	public LocalDateTime getLastEditedDate() {
		return lastEditedDate;
	}

	/**
	 * @param lastEditedDate the lastEditedDate to set
	 */
	public void setLastEditedDate(LocalDateTime lastEditedDate) {
		this.lastEditedDate = lastEditedDate;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
