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
@Table(name= "Agent_Data", uniqueConstraints = @UniqueConstraint(columnNames = {"msisdn"}))
public class AgentDataObject implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="uniqueId", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uniqueId;
	
	@Column(name="agentId", nullable= false)
	private String agentId;
	
	@Column(name="clientId", nullable= false)
	private String clientId;
	
	@Column(name="agentLocationAddress", nullable= false)
	private String agentLocationAddress;
	
	@Column(name="agentLocationTown", nullable= false)
	private String agentLocationTown;
	
	@Column(name="agentLocationLGA", nullable= false)
	private String agentLocationLGA;
	
	@Column(name="agentLocationState", nullable= false)
	private String agentLocationState;
		
	@Column(name="msisdn", nullable= false)
	private String msisdn;
	
	@Column(name="msisdnNetwork", nullable= false)
	private String msisdnNetwork;
	
	@Column(name="email", nullable= false)
	private String email;
	
	@Column(name="firstName", nullable= false)
	private String firstName;
	
	@Column(name="lastName", nullable= false)
	private String lastName;
	
	@Column(name="bankName", nullable = false)
	private String bankName;
	
	@Column(name="bvn", nullable = false)
	private String bvn;
	
	@Column(name="accountName", nullable = false)
	private String accountName;
	
	@Column(name="accountNumber", nullable = false)
	private String accountNumber;
	
	@Column(name="dateCreated", nullable = false)
	private LocalDateTime dateCreated;

	/**
	 * 
	 */
	public AgentDataObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uniqueId
	 * @param agentId
	 * @param clientId
	 * @param agentLocationAddress
	 * @param agentLocationTown
	 * @param agentLocationLGA
	 * @param agentLocationState
	 * @param msisdn
	 * @param msisdnNetwork
	 * @param email
	 * @param firstName
	 * @param lastName
	 * @param bankName
	 * @param bvn
	 * @param accountName
	 * @param accountNumber
	 * @param dateCreated
	 */
	public AgentDataObject(long uniqueId, String agentId, String clientId, String agentLocationAddress,
			String agentLocationTown, String agentLocationLGA, String agentLocationState, String msisdn,
			String msisdnNetwork, String email, String firstName, String lastName, String bankName, String bvn,
			String accountName, String accountNumber, LocalDateTime dateCreated) {
		super();
		this.uniqueId = uniqueId;
		this.agentId = agentId;
		this.clientId = clientId;
		this.agentLocationAddress = agentLocationAddress;
		this.agentLocationTown = agentLocationTown;
		this.agentLocationLGA = agentLocationLGA;
		this.agentLocationState = agentLocationState;
		this.msisdn = msisdn;
		this.msisdnNetwork = msisdnNetwork;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bankName = bankName;
		this.bvn = bvn;
		this.accountName = accountName;
		this.accountNumber = accountNumber;
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
	 * @return the agentLocationAddress
	 */
	public String getAgentLocationAddress() {
		return agentLocationAddress;
	}

	/**
	 * @param agentLocationAddress the agentLocationAddress to set
	 */
	public void setAgentLocationAddress(String agentLocationAddress) {
		this.agentLocationAddress = agentLocationAddress;
	}

	/**
	 * @return the agentLocationTown
	 */
	public String getAgentLocationTown() {
		return agentLocationTown;
	}

	/**
	 * @param agentLocationTown the agentLocationTown to set
	 */
	public void setAgentLocationTown(String agentLocationTown) {
		this.agentLocationTown = agentLocationTown;
	}

	/**
	 * @return the agentLocationLGA
	 */
	public String getAgentLocationLGA() {
		return agentLocationLGA;
	}

	/**
	 * @param agentLocationLGA the agentLocationLGA to set
	 */
	public void setAgentLocationLGA(String agentLocationLGA) {
		this.agentLocationLGA = agentLocationLGA;
	}

	/**
	 * @return the agentLocationState
	 */
	public String getAgentLocationState() {
		return agentLocationState;
	}

	/**
	 * @param agentLocationState the agentLocationState to set
	 */
	public void setAgentLocationState(String agentLocationState) {
		this.agentLocationState = agentLocationState;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return the bvn
	 */
	public String getBvn() {
		return bvn;
	}

	/**
	 * @param bvn the bvn to set
	 */
	public void setBvn(String bvn) {
		this.bvn = bvn;
	}

	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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
