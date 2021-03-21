/**
 * 
 */
package com.winfast.model.profile;

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
@Table(name = "Agent_Profile_Activity_Log")
public class AgentProfileActivityLogObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2709723300481716933L;
	
	@Id
	@Column(name="uniqueId", nullable= false)
	private long uniqueId;
	
	@Column(name="clientId", nullable= false)
	private String clientId;
	
	@Column(name="appId", nullable = false)
	private String appId;
	
	@Column(name="agentId")
	private String agentId;
	
	@Column(name="agentResidentialAddress")
	private String agentResidentialAddress;
	
	@Column(name="agentResidentialTown")
	private String agentResidentialTown;
	
	@Column(name="agentResidentialLGA")
	private String agentResidentialLGA;
	
	@Column(name="agentResidentialState")
	private String agentResidentialState;
		
	@Column(name="msisdnNumber")
	private String msisdnNumber;
	
	@Column(name="msisdnNetwork")
	private String msisdnNetwork;
	
	@Column(name="email")
	private String email;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
		
	@Column(name="meansOfId")
	private String meansOfId;

	@Column(name="BusinessNature")
	private String businessNature;
	
	@Column(name="BusinessLocation")
	private String businessLocation;
	
	@Column(name="businessLocationLGA")
	private String businessLocationLGA;
	
	@Column(name="bankName")
	private String bankName;
	
	@Column(name="bvn")
	private String bvn;
	
	@Column(name="accountName")
	private String accountName;
	
	@Column(name="accountNumber")
	private String accountNumber;
	
	@Column(name="guarantorName")
	private String guarantorName;
	
	@Column(name="guarantorAddress")
	private String guarantorAddress;
	
	@Column(name="guarantorEmail")
	private String guarantorEmail;
	
	@Column(name="guarantorMobileNumber")
	private String guarantorMobileNumber;
	
	@Column(name="relationshipWithGuarantor")
	private String relationshipWithGuarantor;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "reason")
	private String reason;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "newPassword")
	private String newPassword;
	
	@Column(name = "terminalId")
	private String terminalId;
	
	@Column(name = "terminalLocation")
	private String terminalLocation;
	
	@Column(name="terminalLocationTown")
	private String terminalLocationTown;
	
	@Column(name="terminalLocationLGA")
	private String terminalLocationLGA;
	
	@Column(name="terminalLocationState")
	private String terminalLocationState;
	
	@Column(name = "requestType", nullable = false)
	private String requestType;
	
	@Column(name = "requestIn", nullable = false)
	private LocalDateTime requestIn;

	/**
	 * 
	 */
	public AgentProfileActivityLogObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uniqueId
	 * @param clientId
	 * @param appId
	 * @param agentId
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
	 * @param reason
	 * @param password
	 * @param newPassword
	 * @param terminalId
	 * @param terminalLocation
	 * @param terminalLocationTown
	 * @param terminalLocationLGA
	 * @param terminalLocationState
	 * @param requestType
	 * @param requestIn
	 */
	public AgentProfileActivityLogObject(long uniqueId, String clientId, String appId, String agentId,
			String agentResidentialAddress, String agentResidentialTown, String agentResidentialLGA,
			String agentResidentialState, String msisdnNumber, String msisdnNetwork, String email, String firstName,
			String lastName, String meansOfId, String businessNature, String businessLocation,
			String businessLocationLGA, String bankName, String bvn, String accountName, String accountNumber,
			String guarantorName, String guarantorAddress, String guarantorEmail, String guarantorMobileNumber,
			String relationshipWithGuarantor, int status, String reason, String password, String newPassword,
			String terminalId, String terminalLocation, String terminalLocationTown, String terminalLocationLGA,
			String terminalLocationState, String requestType, LocalDateTime requestIn) {
		super();
		this.uniqueId = uniqueId;
		this.clientId = clientId;
		this.appId = appId;
		this.agentId = agentId;
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
		this.reason = reason;
		this.password = password;
		this.newPassword = newPassword;
		this.terminalId = terminalId;
		this.terminalLocation = terminalLocation;
		this.terminalLocationTown = terminalLocationTown;
		this.terminalLocationLGA = terminalLocationLGA;
		this.terminalLocationState = terminalLocationState;
		this.requestType = requestType;
		this.requestIn = requestIn;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
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
	 * @return the requestType
	 */
	public String getRequestType() {
		return requestType;
	}

	/**
	 * @param requestType the requestType to set
	 */
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	/**
	 * @return the requestIn
	 */
	public LocalDateTime getRequestIn() {
		return requestIn;
	}

	/**
	 * @param requestIn the requestIn to set
	 */
	public void setRequestIn(LocalDateTime requestIn) {
		this.requestIn = requestIn;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
