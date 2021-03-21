/**
 * 
 */
package com.winwallet.exception;

import java.util.Date;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public class ErrorDetail {
	
	private Date timestamp;
	private String errorMessage;
	private String errorDetails;
	/**
	 * 
	 */
	public ErrorDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param timestamp
	 * @param errorMessage
	 * @param errorDetails
	 */
	public ErrorDetail(Date timestamp, String errorMessage, String errorDetails) {
		super();
		this.timestamp = timestamp;
		this.errorMessage = errorMessage;
		this.errorDetails = errorDetails;
	}
	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the errorDetails
	 */
	public String getErrorDetails() {
		return errorDetails;
	}
	/**
	 * @param errorDetails the errorDetails to set
	 */
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	
	

}
