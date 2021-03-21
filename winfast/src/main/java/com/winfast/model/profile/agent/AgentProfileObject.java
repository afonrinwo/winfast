/**
 * 
 */
package com.winfast.model.profile.agent;

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
@Table(name ="Agent_Profile", uniqueConstraints = @UniqueConstraint(columnNames = {"msisdnNumber"}))
public class AgentProfileObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -422275830701728084L;
	
	@Id
	@Column(name="agentId", nullable= false)
	private long agentId;
	
	@Column(name="clientId", nullable= false)
	private String clientId;
	
	@Column(name="agentResidentialAddress", nullable= false)
	private String agentResidentialAddress;
	
	@Column(name="agentResidentialTown", nullable= false)
	private String agentResidentialTown;
	
	@Column(name="agentResidentialLGA", nullable= false)
	private String agentResidentialLGA;
	
	@Column(name="agentResidentialState", nullable= false)
	private String agentResidentialState;
		
	@Column(name="msisdnNumber", nullable= false)
	private String msisdnNumber;
	
	@Column(name="msisdnNetwork", nullable= false)
	private String msisdnNetwork;
	
	@Column(name="email", nullable= false)
	private String email;
	
	@Column(name="firstName", nullable= false)
	private String firstName;
	
	@Column(name="lastName", nullable= false)
	private String lastName;
		
	@Column(name="meansOfId", nullable = false)
	private String meansOfId;

	@Column(name="BusinessNature", nullable = false)
	private String businessNature;
	
	@Column(name="BusinessLocation", nullable = false)
	private String businessLocation;
	
	@Column(name="businessLocationLGA", nullable = false)
	private String businessLocationLGA;
	
	@Column(name="bankName", nullable = false)
	private String bankName;
	
	@Column(name="bvn", nullable = false)
	private String bvn;
	
	@Column(name="accountName", nullable = false)
	private String accountName;
	
	@Column(name="accountNumber", nullable = false)
	private String accountNumber;
	
	@Column(name="guarantorName", nullable = false)
	private String guarantorName;
	
	@Column(name="guarantorAddress", nullable = false)
	private String guarantorAddress;
	
	@Column(name="guarantorEmail", nullable = false)
	private String guarantorEmail;
	
	@Column(name="guarantorMobileNumber", nullable = false)
	private String guarantorMobileNumber;
	
	@Column(name="relationshipWithGuarantor", nullable = false)
	private String relationshipWithGuarantor;
	
	@Column(name = "status", nullable = false)
	private int status;
	
	@Column(name="dateCreated", nullable= false)
	private LocalDateTime dateCreated;
	
	@Column(name="lastModified", nullable= false)
	private LocalDateTime lastModified;

	/**
	 * 
	 */
	public AgentProfileObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @param agentId
	 * @param clientId
	 * @param agentResidentialAddress
	 * @param agentResidentialTown
	 * @param agentResidentialLGA
	 * @param agentResidentialState
	 * @param msisdnNumber
	 * @param msisdnNetwork
	 * @param email
	 * @param firstName
	 * @param lastName
	 * @param meansOfId
	 * @param businessNature
	 * @param businessLocation
	 * @param businessLocationLGA
	 * @param bankName
	 * @param bvn
	 * @param accountName
	 * @param accountNumber
	 * @param guarantorName
	 * @param guarantorAddress
	 * @param guarantorEmail
	 * @param guarantorMobileNumber
	 * @param relationshipWithGuarantor
	 * @param status
	 * @param dateCreated
	 * @param lastModified
	 */
	public AgentProfileObject(long agentId, String clientId, String agentResidentialAddress,
			String agentResidentialTown, String agentResidentialLGA, String agentResidentialState, String msisdnNumber,
			String msisdnNetwork, String email, String firstName, String lastName, String meansOfId,
			String businessNature, String businessLocation, String businessLocationLGA, String bankName, String bvn,
			String accountName, String accountNumber, String guarantorName, String guarantorAddress,
			String guarantorEmail, String guarantorMobileNumber, String relationshipWithGuarantor, int status,
			LocalDateTime dateCreated, LocalDateTime lastModified) {
		super();
		this.agentId = agentId;
		this.clientId = clientId;
		this.agentResidentialAddress = agentResidentialAddress;
		this.agentResidentialTown = agentResidentialTown;
		this.agentResidentialLGA = agentResidentialLGA;
		this.agentResidentialState = agentResidentialState;
		this.msisdnNumber = msisdnNumber;
		this.msisdnNetwork = msisdnNetwork;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.meansOfId = meansOfId;
		this.businessNature = businessNature;
		this.businessLocation = businessLocation;
		this.businessLocationLGA = businessLocationLGA;
		this.bankName = bankName;
		this.bvn = bvn;
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.guarantorName = guarantorName;
		this.guarantorAddress = guarantorAddress;
		this.guarantorEmail = guarantorEmail;
		this.guarantorMobileNumber = guarantorMobileNumber;
		this.relationshipWithGuarantor = relationshipWithGuarantor;
		this.status = status;
		this.dateCreated = dateCreated;
		this.lastModified = lastModified;
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
	 * @return the agentId
	 */
	public long getAgentId() {
		return agentId;
	}

	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}

	/**
	 * @return the agentResidentialAddress
	 */
	public String getAgentResidentialAddress() {
		return agentResidentialAddress;
	}

	/**
	 * @param agentResidentialAddress the agentResidentialAddress to set
	 */
	public void setAgentResidentialAddress(String agentResidentialAddress) {
		this.agentResidentialAddress = agentResidentialAddress;
	}

	/**
	 * @return the agentResidentialTown
	 */
	public String getAgentResidentialTown() {
		return agentResidentialTown;
	}

	/**
	 * @param agentResidentialTown the agentResidentialTown to set
	 */
	public void setAgentResidentialTown(String agentResidentialTown) {
		this.agentResidentialTown = agentResidentialTown;
	}

	/**
	 * @return the agentResidentialLGA
	 */
	public String getAgentResidentialLGA() {
		return agentResidentialLGA;
	}

	/**
	 * @param agentResidentialLGA the agentResidentialLGA to set
	 */
	public void setAgentResidentialLGA(String agentResidentialLGA) {
		this.agentResidentialLGA = agentResidentialLGA;
	}

	/**
	 * @return the agentResidentialState
	 */
	public String getAgentResidentialState() {
		return agentResidentialState;
	}

	/**
	 * @param agentResidentialState the agentResidentialState to set
	 */
	public void setAgentResidentialState(String agentResidentialState) {
		this.agentResidentialState = agentResidentialState;
	}

	/**
	 * @return the msisdnNumber
	 */
	public String getMsisdnNumber() {
		return msisdnNumber;
	}

	/**
	 * @param msisdnNumber the msisdnNumber to set
	 */
	public void setMsisdnNumber(String msisdnNumber) {
		this.msisdnNumber = msisdnNumber;
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
	 * @return the meansOfId
	 */
	public String getMeansOfId() {
		return meansOfId;
	}

	/**
	 * @param meansOfId the meansOfId to set
	 */
	public void setMeansOfId(String meansOfId) {
		this.meansOfId = meansOfId;
	}

	/**
	 * @return the businessNature
	 */
	public String getBusinessNature() {
		return businessNature;
	}

	/**
	 * @param businessNature the businessNature to set
	 */
	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	}

	/**
	 * @return the businessLocation
	 */
	public String getBusinessLocation() {
		return businessLocation;
	}

	/**
	 * @param businessLocation the businessLocation to set
	 */
	public void setBusinessLocation(String businessLocation) {
		this.businessLocation = businessLocation;
	}

	/**
	 * @return the businessLocationLGA
	 */
	public String getBusinessLocationLGA() {
		return businessLocationLGA;
	}

	/**
	 * @param businessLocationLGA the businessLocationLGA to set
	 */
	public void setBusinessLocationLGA(String businessLocationLGA) {
		this.businessLocationLGA = businessLocationLGA;
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
	 * @return the guarantorName
	 */
	public String getGuarantorName() {
		return guarantorName;
	}

	/**
	 * @param guarantorName the guarantorName to set
	 */
	public void setGuarantorName(String guarantorName) {
		this.guarantorName = guarantorName;
	}

	/**
	 * @return the guarantorAddress
	 */
	public String getGuarantorAddress() {
		return guarantorAddress;
	}

	/**
	 * @param guarantorAddress the guarantorAddress to set
	 */
	public void setGuarantorAddress(String guarantorAddress) {
		this.guarantorAddress = guarantorAddress;
	}

	/**
	 * @return the guarantorEmail
	 */
	public String getGuarantorEmail() {
		return guarantorEmail;
	}

	/**
	 * @param guarantorEmail the guarantorEmail to set
	 */
	public void setGuarantorEmail(String guarantorEmail) {
		this.guarantorEmail = guarantorEmail;
	}

	/**
	 * @return the guarantorMobileNumber
	 */
	public String getGuarantorMobileNumber() {
		return guarantorMobileNumber;
	}

	/**
	 * @param guarantorMobileNumber the guarantorMobileNumber to set
	 */
	public void setGuarantorMobileNumber(String guarantorMobileNumber) {
		this.guarantorMobileNumber = guarantorMobileNumber;
	}

	/**
	 * @return the relationshipWithGuarantor
	 */
	public String getRelationshipWithGuarantor() {
		return relationshipWithGuarantor;
	}

	/**
	 * @param relationshipWithGuarantor the relationshipWithGuarantor to set
	 */
	public void setRelationshipWithGuarantor(String relationshipWithGuarantor) {
		this.relationshipWithGuarantor = relationshipWithGuarantor;
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
	 * @return the lastModified
	 */
	public LocalDateTime getLastModified() {
		return lastModified;
	}

	/**
	 * @param lastModified the lastModified to set
	 */
	public void setLastModified(LocalDateTime lastModified) {
		this.lastModified = lastModified;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
