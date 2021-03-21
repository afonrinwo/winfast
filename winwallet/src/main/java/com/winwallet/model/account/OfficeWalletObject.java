/**
 * 
 */
package com.winwallet.model.account;

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
@Table(name="Office_Wallet", uniqueConstraints = @UniqueConstraint(columnNames = { "walletNumber" }))
public class OfficeWalletObject implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8356649710923930670L;

	@Id
	@Column(name="walletNumber", nullable = false)
	private String walletNumber;
	
	@Column(name="uniqueId", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uniqueId;

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
	public OfficeWalletObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param officeWallet
	 * @param uniqueId
	 * @param availableBalance
	 * @param bookBalance
	 * @param dateCreated
	 * @param lastEditedDate
	 */
	public OfficeWalletObject(String walletNumber, long uniqueId, double availableBalance, double bookBalance,
			LocalDateTime dateCreated, LocalDateTime lastEditedDate) {
		super();
		this.walletNumber = walletNumber;
		this.uniqueId = uniqueId;
		this.availableBalance = availableBalance;
		this.bookBalance = bookBalance;
		this.dateCreated = dateCreated;
		this.lastEditedDate = lastEditedDate;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the officeWallet
	 */
	public String getWalletNumber() {
		return walletNumber;
	}

	/**
	 * @param officeWallet the officeWallet to set
	 */
	public void setWalletNumber(String walletNumber) {
		this.walletNumber = walletNumber;
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

}
