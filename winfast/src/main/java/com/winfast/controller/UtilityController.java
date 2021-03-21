/**
 * 
 */
package com.winfast.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.winfast.manager.UtilityManager;
import com.winfast.model.Response;
import com.winfast.model.utility.EmailRequest;
import com.winfast.model.utility.SMSRequest;
import com.winfast.utility.AuthenticationUtility;
import com.winfast.utility.ResponseUtility;


/**
 * @author Emmanuel Afonrinwo
 *
 */
@RestController
public class UtilityController {
	
	@Autowired
	AuthenticationUtility authenticationUtility;
	
	@Autowired
	ResponseUtility responseUtility;
	
	@Autowired
	UtilityManager utilityManager;
	
	@RequestMapping(value = "/sendSMS", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response sendSMS(HttpServletRequest request,
			@Validated @RequestBody SMSRequest smsRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return utilityManager.sendSMS(smsRequest, LocalDateTime.now());
		} else {
			return responseUtility.responseBuilder(0L, smsRequest.getClientId(), 96);
		}
	}

	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response sendEmail(HttpServletRequest request,
			@Validated @RequestBody EmailRequest emailRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return utilityManager.sendEmail(emailRequest, request.getHeader("app-id"), LocalDateTime.now());
		} else {
			return responseUtility.responseBuilder(0L, emailRequest.getClientId(), 96);
		}
	}
	
}
