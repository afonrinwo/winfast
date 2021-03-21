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

import com.winfast.manager.UserProfileManager;
import com.winfast.model.Response;
import com.winfast.model.profile.user.ActivateUserProfileRequest;
import com.winfast.model.profile.user.ChangeUserPasswordRequest;
import com.winfast.model.profile.user.DisableUserProfileRequest;
import com.winfast.model.profile.user.ResetUserPasswordRequest;
import com.winfast.model.profile.user.UserProfileObject;
import com.winfast.model.profile.user.UserProfileRequest;
import com.winfast.utility.AuthenticationUtility;
import com.winfast.utility.ResponseUtility;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@RestController
public class UserProfileController {

	@Autowired
	UserProfileManager userProfileManager;

	@Autowired
	AuthenticationUtility authenticationUtility;

	@Autowired
	ResponseUtility responseUtility;

	@RequestMapping(value = "/listUserProfile", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Iterable<UserProfileObject> listUuserProfile(HttpServletRequest request) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return userProfileManager.listUserProfile();
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/listActiveUserProfile", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Iterable<UserProfileObject> listActiveUserProfile(HttpServletRequest request) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return userProfileManager.listUserProfile(1);
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/listInActiveUserProfile", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Iterable<UserProfileObject> listInActiveUserProfile(HttpServletRequest request) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return userProfileManager.listUserProfile(0);
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/createUserProfle", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response createUserProfile(HttpServletRequest request,
			@Validated @RequestBody UserProfileRequest userProfileRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return userProfileManager.createUserProfile(request.getHeader("app-id"), userProfileRequest);
		} else {
			return responseUtility.responseBuilder(0L, userProfileRequest.getClientId(), 96);
		}
	}
	
	@RequestMapping(value = "/activateUserProfile", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response activateUserProfle(HttpServletRequest request,
			@Validated @RequestBody ActivateUserProfileRequest activateUserProfileRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return userProfileManager.activateUserProfile(request.getHeader("app-id"), activateUserProfileRequest, LocalDateTime.now());
		} else {
			return responseUtility.responseBuilder(0L, activateUserProfileRequest.getClientId(), 96);
		}
	}
	
	@RequestMapping(value = "/disableUserProfile", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response disableUserProfile(HttpServletRequest request,
			@Validated @RequestBody DisableUserProfileRequest disableUserProfileRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return userProfileManager.disableUserProfile(request.getHeader("app-id"), disableUserProfileRequest, LocalDateTime.now());
		} else {
			return responseUtility.responseBuilder(0L, disableUserProfileRequest.getClientId(), 96);
		}
	}

	@RequestMapping(value = "/changeUserPassword", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response changeUserPassword(HttpServletRequest request,
			@Validated @RequestBody ChangeUserPasswordRequest changeUserPasswordRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return userProfileManager.changeUserPassword(request.getHeader("app-id"), changeUserPasswordRequest, LocalDateTime.now());
		} else {
			return responseUtility.responseBuilder(0L, changeUserPasswordRequest.getClientId(), 96);
		}
	}

	@RequestMapping(value = "/resetUserPassword", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response resetUserPassword(HttpServletRequest request,
			@Validated @RequestBody ResetUserPasswordRequest resetUserPasswordRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return userProfileManager.resetUserPassword(request.getHeader("app-id"), resetUserPasswordRequest, LocalDateTime.now());
		} else {
			return responseUtility.responseBuilder(0L, resetUserPasswordRequest.getClientId(), 96);
		}
	}

}
