/**
 * 
 */
package com.winwallet.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Entity
@Table(name = "Access_Log")
public class AccessLogObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="uniqueId", nullable = false)
	private long uniqueId;
	
	@Column(name="agentId")
	private String agentId;
	
	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "msisdn", nullable = false)
	private String msisdn;
	
	@Column(name = "msisdnNetwork", nullable = false)
	private String msisdnNetwork;

	@Column(name = "channel", nullable = false)
	private String channel;

	@Column(name="agentLocationAddress")
	private String agentLocationAddress;
	
	@Column(name="agentLocationTown")
	private String agentLocationTown;
	
	@Column(name="agentLocationLGA")
	private String agentLocationLGA;
	
	@Column(name="agentLocationState")
	private String agentLocationState;
	
	@Column(name="email")
	private String email;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="bankName")
	private String bankName;
	
	@Column(name="bvn")
	private String bvn;
	
	@Column(name="accountName")
	private String accountName;
	
	@Column(name="accountNumber")
	private String accountNumber;
	
	@Column(name = "requestType", nullable = false)
	private String requestType;

	@Column(name = "requestIn", nullable = false)
	private LocalDateTime requestIn;
	
	/**
	 * 
	 */
	public AccessLogObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param uniqueId
	 * @param agentId
	 * @param clientId
	 * @param msisdn
	 * @param msisdnNetwork
	 * @param channel
	 * @param agentLocationAddress
	 * @param agentLocationTown
	 * @param agentLocationLGA
	 * @param agentLocationState
	 * @param email
	 * @param firstName
	 * @param lastName
	 * @param bankName
	 * @param bvn
	 * @param accountName
	 * @param accountNumber
	 * @param requestType
	 * @param requestIn
	 */
	public AccessLogObject(long uniqueId, String agentId, String clientId, String msisdn, String msisdnNetwork,
			String channel, String agentLocationAddress, String agentLocationTown, String agentLocationLGA,
			String agentLocationState, String email, String firstName, String lastName, String bankName, String bvn,
			String accountName, String accountNumber, String requestType, LocalDateTime requestIn) {
		super();
		this.uniqueId = uniqueId;
		this.agentId = agentId;
		this.clientId = clientId;
		this.msisdn = msisdn;
		this.msisdnNetwork = msisdnNetwork;
		this.channel = channel;
		this.agentLocationAddress = agentLocationAddress;
		this.agentLocationTown = agentLocationTown;
		this.agentLocationLGA = agentLocationLGA;
		this.agentLocationState = agentLocationState;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bankName = bankName;
		this.bvn = bvn;
		this.accountName = accountName;
		this.accountNumber = accountNumber;
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
