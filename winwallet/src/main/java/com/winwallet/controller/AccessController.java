/**
 * 
 */
package com.winwallet.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.winwallet.manager.AccessManager;
import com.winwallet.model.Response;
import com.winwallet.model.access.ChangeAgentPinRequest;
import com.winwallet.model.access.ChangePinRequest;
import com.winwallet.model.access.CreateAgentPinRequest;
import com.winwallet.model.access.CreateAgentWalletRequest;
import com.winwallet.model.access.CreatePinRequest;
import com.winwallet.model.access.CreateWalletRequest;
import com.winwallet.model.access.ResetAgentPinRequest;
import com.winwallet.model.access.ResetPinRequest;
import com.winwallet.model.balance.WalletBalanceRequest;
import com.winwallet.model.balance.WalletBalanceResponse;
import com.winwallet.model.enquiry.WalletEnquiryRequest;
import com.winwallet.model.enquiry.WalletEnquiryResponse;
import com.winwallet.utility.AuthUtility;
import com.winwallet.utility.ResponseUtility;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@RestController
public class AccessController {

	@Autowired
	AuthUtility authUtility;

	@Autowired
	AccessManager accessManager;

	@Autowired
	ResponseUtility responseUtility;

	@RequestMapping("/")
	public @ResponseBody String displayStartPage() {
		return "Welcome to the WINFAST Wallet interface";

	}
	
	@RequestMapping(value = "/createWallet", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response createWallet(HttpServletRequest request, @Validated @RequestBody CreateWalletRequest createWalletRequest) {
		if (authUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return accessManager.createWallet(createWalletRequest, LocalDateTime.now());
		} else {
			return responseUtility.response(0L, createWalletRequest.getClientId(), 96);
		}
		
	}
	
	@RequestMapping(value = "/createAgentWallet", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response createAgentWallet(HttpServletRequest request, @Validated @RequestBody CreateAgentWalletRequest createAgentWalletRequest) {
		if (authUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return accessManager.createAgentWallet(createAgentWalletRequest, LocalDateTime.now());
		} else {
			return responseUtility.response(0L, createAgentWalletRequest.getClientId(), 96);
		}
		
	}
	
	@RequestMapping(value = "/createPin", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response createPin(HttpServletRequest request, @Validated @RequestBody CreatePinRequest createPinRequest) {
		if (authUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return accessManager.createPin(createPinRequest, LocalDateTime.now());
		} else {
			return responseUtility.response(0L, createPinRequest.getClientId(), 96);
		}
		
	}
	
	@RequestMapping(value = "/createAgentPin", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response createAgentPin(HttpServletRequest request, @Validated @RequestBody CreateAgentPinRequest createAgentPinRequest) {
		if (authUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return accessManager.createAgentPin(createAgentPinRequest, LocalDateTime.now());
		} else {
			return responseUtility.response(0L, createAgentPinRequest.getClientId(), 96);
		}
		
	}
	
	@RequestMapping(value = "/changePin", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response changePin(HttpServletRequest request, @Validated @RequestBody ChangePinRequest changePinRequest) {
		if (authUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return accessManager.changePin(changePinRequest, LocalDateTime.now());
		} else {
			return responseUtility.response(0L, changePinRequest.getClientId(), 96);
		}
		
	}
	
	@RequestMapping(value = "/changeAgentPin", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response changeAgentPin(HttpServletRequest request, @Validated @RequestBody ChangeAgentPinRequest changeAgentPinRequest) {
		if (authUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return accessManager.changeAgentPin(changeAgentPinRequest, LocalDateTime.now()  );
		} else {
			return responseUtility.response(0L, changeAgentPinRequest.getClientId(), 96);
		}
		
	}


	@RequestMapping(value = "/resetPin", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response resetPin(HttpServletRequest request, @Validated @RequestBody ResetPinRequest resetPinRequest) {
		if (authUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return accessManager.resetPin(resetPinRequest, LocalDateTime.now());
		} else {
			return responseUtility.response(0L, resetPinRequest.getClientId(), 96);
		}
		
	}	
	
	@RequestMapping(value = "/resetAgentPin", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response resetAgentPin(HttpServletRequest request, @Validated @RequestBody ResetAgentPinRequest resetAgentPinRequest) {
		if (authUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return accessManager.resetAgentPin(resetAgentPinRequest, LocalDateTime.now().toString());
		} else {
			return responseUtility.response(0L, resetAgentPinRequest.getClientId(), 96);
		}
		
	}	

}
