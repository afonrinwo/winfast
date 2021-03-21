/**
 * 
 */
package com.winfast.manager;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winfast.model.Response;
import com.winfast.model.utility.EmailRequest;
import com.winfast.model.utility.SMSRequest;
import com.winfast.utility.MessageUtility;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Service
public class UtilityManager {

	@Autowired
	MessageUtility messageUtility;

	public Response sendSMS(SMSRequest smsRequest, LocalDateTime requestIn) {
			return messageUtility.sendsms(smsRequest.getClientId(), smsRequest.getNetwork(), smsRequest.getMsisdn(),
					smsRequest.getMessage(), requestIn);
	}

	public Response sendEmail(EmailRequest emailRequest, String appId, LocalDateTime requestIn) {
		return messageUtility.sendMail(emailRequest.getClientId(), appId, emailRequest.getFrom(), emailRequest.getTo(), 
				emailRequest.getSubject(), emailRequest.getBody(), requestIn);
	}
}
