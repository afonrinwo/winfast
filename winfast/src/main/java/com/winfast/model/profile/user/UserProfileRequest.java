/**
 * 
 */
package com.winfast.model.profile.user;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public class UserProfileRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1350300961015893639L;
	
	@Column(name="clientId", nullable = false)
	private String clientId;
	
	@Column(name="firstName", nullable = false)
	private String firstName;
	
	@Column(name="lastName", nullable = false)
	private String lastName;
	
	@Column(name="department", nullable = false)
	private String department;
	
	@Column(name="userRole", nullable = false)
	private String userRole;

	/**
	 * 
	 */
	public UserProfileRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param firstName
	 * @param lastName
	 * @param department
	 * @param userRole
	 */
	public UserProfileRequest(String clientId, String firstName, String lastName, String department,
			String userRole) {
		super();
		this.clientId = clientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.userRole = userRole;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
