/**
 * 
 */
package com.winwallet.model.utility;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public class EmailRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 763932482290137316L;
	
	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "from", nullable = false)
	private String from;
	
	@Column(name = "to", nullable = false)
	private String to;
	
	@Column(name = "subject", nullable = false)
	private String subject;
	
	@Column(name = "body", nullable = false)
	private String body;

	/**
	 * 
	 */
	public EmailRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param from
	 * @param to
	 * @param subject
	 * @param body
	 */
	public EmailRequest(String clientId, String from, String to, String subject, String body) {
		super();
		this.clientId = clientId;
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.body = body;
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
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
