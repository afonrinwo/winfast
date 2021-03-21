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
@Table(name = "Agent_Access_Code", uniqueConstraints = @UniqueConstraint(columnNames = { "msisdn" }))
public class AgentAccessCodesObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="uniqueId", nullable = false)
	private long uniqueId;
	
	@Column(name="msisdn", nullable = false)
	private String msisdn;

	@Column(name="hashText", nullable = false)
	private String hashText;
	
	@Column(name="dateCreated", nullable = false)
	private LocalDateTime dateCreated;
	
	@Column(name="lastEditedDate", nullable = false)
	private LocalDateTime lastEditedDate;

	/**
	 * 
	 */
	public AgentAccessCodesObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uniqueId
	 * @param msisdn
	 * @param hashText
	 * @param dateCreated
	 * @param lastEditedDate
	 */
	public AgentAccessCodesObject(long uniqueId, String msisdn, String hashText, LocalDateTime dateCreated,
			LocalDateTime lastEditedDate) {
		super();
		this.uniqueId = uniqueId;
		this.msisdn = msisdn;
		this.hashText = hashText;
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
	 * @return the hashText
	 */
	public String getHashText() {
		return hashText;
	}

	/**
	 * @param hashText the hashText to set
	 */
	public void setHashText(String hashText) {
		this.hashText = hashText;
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
