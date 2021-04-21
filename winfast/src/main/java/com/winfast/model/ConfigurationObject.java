/**
 * 
 */
package com.winfast.model;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Component
@ConfigurationProperties
//@PropertySource("file:D:\\Workspace-spring-tool-suite\\winfast\\configuration.properties")
@PropertySource("file:/usr/winfast/configuration.properties")
public class ConfigurationObject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String baseURL;
	private String userid;
	private String password;
	private String smsURL;
	private String smsUserId;
	private String smsPassword;
	private String smsHash;
	
	/**
	 * 
	 */
	public ConfigurationObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param baseURL
	 * @param userid
	 * @param password
	 * @param smsURL
	 * @param smsUserId
	 * @param smsPassword
	 * @param smsHash
	 */
	public ConfigurationObject(String baseURL, String userid, String password, String smsURL, String smsUserId,
			String smsPassword, String smsHash) {
		super();
		this.baseURL = baseURL;
		this.userid = userid;
		this.password = password;
		this.smsURL = smsURL;
		this.smsUserId = smsUserId;
		this.smsPassword = smsPassword;
		this.smsHash = smsHash;
	}

	/**
	 * @return the baseURL
	 */
	public String getBaseURL() {
		return baseURL;
	}

	/**
	 * @param baseURL the baseURL to set
	 */
	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}

	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
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
	 * @return the smsURL
	 */
	public String getSmsURL() {
		return smsURL;
	}

	/**
	 * @param smsURL the smsURL to set
	 */
	public void setSmsURL(String smsURL) {
		this.smsURL = smsURL;
	}

	/**
	 * @return the smsUserId
	 */
	public String getSmsUserId() {
		return smsUserId;
	}

	/**
	 * @param smsUserId the smsUserId to set
	 */
	public void setSmsUserId(String smsUserId) {
		this.smsUserId = smsUserId;
	}

	/**
	 * @return the smsPassword
	 */
	public String getSmsPassword() {
		return smsPassword;
	}

	/**
	 * @param smsPassword the smsPassword to set
	 */
	public void setSmsPassword(String smsPassword) {
		this.smsPassword = smsPassword;
	}

	/**
	 * @return the smsHash
	 */
	public String getSmsHash() {
		return smsHash;
	}

	/**
	 * @param smsHash the smsHash to set
	 */
	public void setSmsHash(String smsHash) {
		this.smsHash = smsHash;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
