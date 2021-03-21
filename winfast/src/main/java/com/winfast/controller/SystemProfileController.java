/**
 * 
 */
package com.winfast.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.winfast.manager.SystemProfileManager;
import com.winfast.model.Response;
import com.winfast.model.profile.system.SystemProfileObject;
import com.winfast.model.profile.system.SystemProfileRequest;
import com.winfast.utility.AuthenticationUtility;
import com.winfast.utility.ResponseUtility;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@RestController
public class SystemProfileController {

	@Autowired
	SystemProfileManager systemProfileManager;

	@Autowired
	AuthenticationUtility authenticationUtility;

	@Autowired
	ResponseUtility responseUtility;

	@RequestMapping("/")
	public @ResponseBody String displayStartPage() {
		return "Welcome to WINFAST Core Application";
	}

	@RequestMapping(value = "/listSystemProfile", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Iterable<SystemProfileObject> listUASystemProfile(HttpServletRequest request) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return systemProfileManager.listSystemProfile(0);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/createSystemProfile", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response createSystemProfile(HttpServletRequest request,
			@Validated @RequestBody SystemProfileRequest systemProfileRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return systemProfileManager.createSystemProfile(request.getHeader("app-id"), systemProfileRequest);
		} else {
			return responseUtility.responseBuilder(0L, systemProfileRequest.getClientId(), 96);
		}
	}

	@RequestMapping(value = "/activateSystemProfle", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response activateSystemProfle(HttpServletRequest request,
			@Validated @RequestBody SystemProfileRequest systemProfileRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return systemProfileManager.activateSystemProfle(request.getHeader("app-id"), systemProfileRequest);
		} else {
			return responseUtility.responseBuilder(0L, systemProfileRequest.getClientId(), 96);
		}
	}

	@RequestMapping(value = "/changeAppKey", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response changeAppKey(HttpServletRequest request,
			@Validated @RequestBody SystemProfileRequest systemProfileRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return systemProfileManager.activateSystemProfle(request.getHeader("app-id"), systemProfileRequest);
		} else {
			return responseUtility.responseBuilder(0L, systemProfileRequest.getClientId(), 96);
		}
	}
}
