/**
 * 
 */
package com.winfast.model.profile.user;

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
@Table(name="User_Profile", uniqueConstraints = @UniqueConstraint(columnNames = {"userName"}))
public class UserProfileObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6607706058158370206L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uniqueId", nullable = false)
	private long uniqueId;
	
	@Column(name = "appId", nullable = false)
	private String appId;
	
	@Column(name = "clientId", nullable = false)
	private String clientId;

	@Column(name="userName", nullable = false)
	private String userName;
	
	@Column(name="firstName", nullable = false)
	private String firstName;
	
	@Column(name="lastName", nullable = false)
	private String lastName;
	
	@Column(name="department", nullable = false)
	private String department;
	
	@Column(name="userRole", nullable = false)
	private String userRole;
	
	@Column(name="status", nullable = false)
	private int status;
	
	@Column(name = "requestTime", nullable = false)
	private LocalDateTime requestTime;

	/**
	 * 
	 */
	public UserProfileObject() {
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
	 * @param status
	 * @param requestTime
	 */
	public UserProfileObject(long uniqueId, String appId, String clientId, String userName, String firstName,
			String lastName, String department, String userRole, int status, LocalDateTime requestTime) {
		super();
		this.uniqueId = uniqueId;
		this.appId = appId;
		this.clientId = clientId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.userRole = userRole;
		this.status = status;
		this.requestTime = requestTime;
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
	 * @return the requestTime
	 */
	public LocalDateTime getRequestTime() {
		return requestTime;
	}

	/**
	 * @param requestTime the requestTime to set
	 */
	public void setRequestTime(LocalDateTime requestTime) {
		this.requestTime = requestTime;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
