/**
 * 
 */
package com.winwallet.model.utility;

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
@Table(name = "Email_Log")
public class EmailObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4973560816689781406L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uniqueId", nullable = false)
	private long uniqueId;
	
	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "appId", nullable = false)
	private String appId;
	
	@Column(name = "source", nullable = false)
	private String source;
	
	@Column(name = "destination", nullable = false)
	private String destination;
	
	@Column(name = "subject", nullable = false)
	private String subject;
	
	@Column(name = "body", nullable = false)
	private String body;
	
	@Column(name = "requestIn", nullable = false)
	private LocalDateTime requestIn;

	/**
	 * 
	 */
	public EmailObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uniqueId
	 * @param clientId
	 * @param appId
	 * @param source
	 * @param destination
	 * @param subject
	 * @param body
	 * @param requestIn
	 */
	public EmailObject(long uniqueId, String clientId, String appId, String source, String destination, String subject,
			String body, LocalDateTime requestIn) {
		super();
		this.uniqueId = uniqueId;
		this.clientId = clientId;
		this.appId = appId;
		this.source = source;
		this.destination = destination;
		this.subject = subject;
		this.body = body;
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
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
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
