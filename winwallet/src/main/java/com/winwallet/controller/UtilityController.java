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

import com.winwallet.manager.UtilityManager;
import com.winwallet.model.Response;
import com.winwallet.model.account.LienRequest;
import com.winwallet.model.account.PNDRequest;
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
public class UtilityController {
	
	@Autowired 
	AuthUtility authUtility;
	
	@Autowired
	UtilityManager utilityManager;
	
	@Autowired
	ResponseUtility responseUtility;
	
	@RequestMapping(value = "/walletEnquiry", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody WalletEnquiryResponse walletEnquiry(HttpServletRequest request, @Validated @RequestBody WalletEnquiryRequest walletEnquiryRequest) {
		if (authUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return utilityManager.walletEnquiry(walletEnquiryRequest, LocalDateTime.now());
		} else {
			return responseUtility.walletEnquiryResponse(0L, walletEnquiryRequest.getClientId(), 96);
		}
	}
	
	
	@RequestMapping(value = "/walletBalance", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody WalletBalanceResponse walletBalance(HttpServletRequest request, @Validated @RequestBody WalletBalanceRequest walletBalanceRequest) {
		if (authUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return utilityManager.walletBalance(walletBalanceRequest, LocalDateTime.now().toString());
		} else {
			return responseUtility.walletBalanceResponse(0L, walletBalanceRequest.getClientId(), 96);
		}
	}

	@RequestMapping(value = "/removeLien", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response removeLien(HttpServletRequest request, @Validated @RequestBody LienRequest lienRequest) {
		if (authUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return utilityManager.removeLien(lienRequest, LocalDateTime.now().toString());
		} else {
			return responseUtility.response(0L, lienRequest.getClientId(), 96);
		}
	}
	
	@RequestMapping(value = "/placeLien", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response placeLien(HttpServletRequest request, @Validated @RequestBody LienRequest lienRequest) {
		if (authUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return utilityManager.placeLien(lienRequest, LocalDateTime.now().toString());
		} else {
			return responseUtility.response(0L, lienRequest.getClientId(), 96);
		}
	}
	
	@RequestMapping(value = "/placePnd", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response pnd(HttpServletRequest request, @Validated @RequestBody PNDRequest pndRequest) {
		if (authUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return utilityManager.placePnd(pndRequest, LocalDateTime.now().toString());
		} else {
			return responseUtility.response(0L, pndRequest.getClientId(), 96);
		}
		
	}
	
	@RequestMapping(value = "/removePnd", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response removePnd(HttpServletRequest request, @Validated @RequestBody PNDRequest pNDRequest) {
		if (authUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return utilityManager.removePND(pNDRequest, LocalDateTime.now().toString());
		} else {
			return responseUtility.response(0L, pNDRequest.getClientId(), 96);
		}
		
	}
}
