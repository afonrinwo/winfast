/**
 * 
 */
package com.winwallet.model.cashout;

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
@Table(name="CashOut_Token")
public class CashOutTokenObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 535204853506360369L;
	
	@Id
	@Column(name = "uniqueId", nullable = false)
	private long uniqueId;
	
	@Column(name = "clientId", nullable = false)
	private String clientId;
	
	@Column(name = "msisdn2Debit", nullable = false)
	private String msisdn2Debit;
	
	@Column(name = "msisdn2DebitNetwork", nullable = false)
	private String msisdn2DebitNetwork;
	
	@Column(name = "amount", nullable = false)
	private double amount;
	
	@Column(name = "channel", nullable = false)
	private String channel;
	
	@Column(name = "narration", nullable = false)
	private String narration;
	
	@Column(name = "payToken", nullable = false)
	private String payToken;
	
	@Column(name = "payFlag", nullable = false)
	private int payFlag;
	
	@Column(name = "payDate")
	private LocalDateTime payDate;
	
	
	
	/**
	 * 
	 */
	public CashOutTokenObject() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param uniqueId
	 * @param clientId
	 * @param msisdn2Debit
	 * @param msisdn2DebitNetwork
	 * @param amount
	 * @param channel
	 * @param narration
	 * @param payToken
	 * @param payFlag
	 * @param payDate
	 */
	public CashOutTokenObject(long uniqueId, String clientId, String msisdn2Debit, String msisdn2DebitNetwork,
			double amount, String channel, String narration, String payToken, int payFlag, LocalDateTime payDate) {
		super();
		this.uniqueId = uniqueId;
		this.clientId = clientId;
		this.msisdn2Debit = msisdn2Debit;
		this.msisdn2DebitNetwork = msisdn2DebitNetwork;
		this.amount = amount;
		this.channel = channel;
		this.narration = narration;
		this.payToken = payToken;
		this.payFlag = payFlag;
		this.payDate = payDate;
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
	 * @return the msisdn2Debit
	 */
	public String getMsisdn2Debit() {
		return msisdn2Debit;
	}



	/**
	 * @param msisdn2Debit the msisdn2Debit to set
	 */
	public void setMsisdn2Debit(String msisdn2Debit) {
		this.msisdn2Debit = msisdn2Debit;
	}



	/**
	 * @return the msisdn2DebitNetwork
	 */
	public String getMsisdn2DebitNetwork() {
		return msisdn2DebitNetwork;
	}



	/**
	 * @param msisdn2DebitNetwork the msisdn2DebitNetwork to set
	 */
	public void setMsisdn2DebitNetwork(String msisdn2DebitNetwork) {
		this.msisdn2DebitNetwork = msisdn2DebitNetwork;
	}



	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}



	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
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
	 * @return the narration
	 */
	public String getNarration() {
		return narration;
	}



	/**
	 * @param narration the narration to set
	 */
	public void setNarration(String narration) {
		this.narration = narration;
	}



	/**
	 * @return the payToken
	 */
	public String getPayToken() {
		return payToken;
	}



	/**
	 * @param payToken the payToken to set
	 */
	public void setPayToken(String payToken) {
		this.payToken = payToken;
	}



	/**
	 * @return the payFlag
	 */
	public int getPayFlag() {
		return payFlag;
	}



	/**
	 * @param payFlag the payFlag to set
	 */
	public void setPayFlag(int payFlag) {
		this.payFlag = payFlag;
	}



	/**
	 * @return the payDate
	 */
	public LocalDateTime getPayDate() {
		return payDate;
	}



	/**
	 * @param payDate the payDate to set
	 */
	public void setPayDate(LocalDateTime payDate) {
		this.payDate = payDate;
	}



	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
