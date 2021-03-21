/**
 * 
 */
package com.winfast.model.profile;

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
@Table(name = "Profile_Activity_Log")
public class ProfileActivityLogObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4570714430213003860L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uniqueId", nullable = false)
	private long uniqueId;
	
	@Column(name = "appId", nullable = false)
	private String appId;
	
	@Column(name = "clientId", nullable = false)
	private String clientId;

	@Column(name="userName")
	private String userName;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="department")
	private String department;
	
	@Column(name="userRole")
	private String userRole;
	
	@Column(name="userId")
	private String userId;
	
	@Column(name="msisdnNumber")
	private String msisdnNumber;
	
	@Column(name="msisdnNetwork")
	private String msisdnNetwork;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="newPassword")
	private String newPassword;
	
	@Column(name = "appKey", nullable = false)
	private String appKey;

	@Column(name = "serverIp", nullable = false)
	private String serverIp;
	
	@Column(name = "status", nullable = false)
	private int status;
	
	@Column(name = "requestType", nullable = false)
	private String requestType;
	
	@Column(name = "requestIn", nullable = false)
	private LocalDateTime requestIn;


	/**
	 * 
	 */
	public ProfileActivityLogObject() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param uniqueId
	 * @param appId
	 * @param clientId
	 * @param userName
	 * @param firstName
	 * @param lastName
	 * @param department
	 * @param userRole
	 * @param userId
	 * @param msisdnNumber
	 * @param msisdnNetwork
	 * @param email
	 * @param password
	 * @param newPassword
	 * @param appKey
	 * @param serverIp
	 * @param status
	 * @param requestType
	 * @param requestIn
	 */
	public ProfileActivityLogObject(long uniqueId, String appId, String clientId, String userName, String firstName,
			String lastName, String department, String userRole, String userId, String msisdnNumber,
			String msisdnNetwork, String email, String password, String newPassword, String appKey, String serverIp,
			int status, String requestType, LocalDateTime requestIn) {
		super();
		this.uniqueId = uniqueId;
		this.appId = appId;
		this.clientId = clientId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.userRole = userRole;
		this.userId = userId;
		this.msisdnNumber = msisdnNumber;
		this.msisdnNetwork = msisdnNetwork;
		this.email = email;
		this.password = password;
		this.newPassword = newPassword;
		this.appKey = appKey;
		this.serverIp = serverIp;
		this.status = status;
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}


	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}


	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}


	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}


	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * @return the appKey
	 */
	public String getAppKey() {
		return appKey;
	}


	/**
	 * @param appKey the appKey to set
	 */
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}


	/**
	 * @return the serverIp
	 */
	public String getServerIp() {
		return serverIp;
	}


	/**
	 * @param serverIp the serverIp to set
	 */
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
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
