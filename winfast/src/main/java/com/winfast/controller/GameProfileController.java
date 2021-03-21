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

import com.winfast.manager.GameProfileManager;
import com.winfast.model.Response;
import com.winfast.model.profile.game.ActivateGameProfileRequest;
import com.winfast.model.profile.game.ChangeGamePasswordRequest;
import com.winfast.model.profile.game.DisableGameProfileRequest;
import com.winfast.model.profile.game.GameMiniProfileRequest;
import com.winfast.model.profile.game.ResetGamePasswordRequest;
import com.winfast.model.profile.game.GameProfileObject;
import com.winfast.model.profile.game.GameProfileRequest;
import com.winfast.utility.AuthenticationUtility;
import com.winfast.utility.ResponseUtility;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@RestController
public class GameProfileController {

	@Autowired
	AuthenticationUtility authenticationUtility;

	@Autowired
	ResponseUtility responseUtility;
	
	@Autowired
	GameProfileManager gameProfileManager;
	
	@RequestMapping(value = "/createGameProfile", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response createGameProfile(HttpServletRequest request, @Validated @RequestBody GameProfileRequest gameProfileRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return gameProfileManager.createGameProfile(gameProfileRequest, request.getHeader("app-id"), LocalDateTime.now());
		} else {
			return responseUtility.responseBuilder(0L, gameProfileRequest.getClientId(), 99);
		}
	}
	
	@RequestMapping(value = "/createMiniGameProfile", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response createMiniGameProfile(HttpServletRequest request, @Validated @RequestBody GameMiniProfileRequest gameMiniProfileRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return gameProfileManager.createMiniGameProfile(request.getHeader("app-id"), gameMiniProfileRequest, LocalDateTime.now());
		} else {
			return responseUtility.responseBuilder(0L, gameMiniProfileRequest.getClientId(), 99);
		}
	}
	
	@RequestMapping(value = "/listGameProfile", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Iterable<GameProfileObject> listGameProfile(HttpServletRequest request) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return gameProfileManager.listGameProfile();
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/listActiveGameProfile", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Iterable<GameProfileObject> listActiveGameProfile(HttpServletRequest request) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return gameProfileManager.listGameProfile(1);
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/listInActiveGameProfile", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Iterable<GameProfileObject> listUuserProfile(HttpServletRequest request) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return gameProfileManager.listGameProfile(0);
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/activateGameProfle", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response activateGameProfle(HttpServletRequest request,
			@Validated @RequestBody ActivateGameProfileRequest activateGameProfileRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return gameProfileManager.activateGameProfile(request.getHeader("app-id"), activateGameProfileRequest, LocalDateTime.now());
		} else {
			return responseUtility.responseBuilder(0L, activateGameProfileRequest.getClientId(), 96);
		}
	}
	
	@RequestMapping(value = "/disableGameProfile", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response disableGameProfile(HttpServletRequest request,
			@Validated @RequestBody DisableGameProfileRequest disableGameProfileRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return gameProfileManager.disableGameProfile(request.getHeader("app-id"), disableGameProfileRequest, LocalDateTime.now());
		} else {
			return responseUtility.responseBuilder(0L, disableGameProfileRequest.getClientId(), 96);
		}
	}

	@RequestMapping(value = "/changeGamePassword", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response changeGamePassword(HttpServletRequest request,
			@Validated @RequestBody ChangeGamePasswordRequest changeGamePasswordRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return gameProfileManager.changeGamePassword(request.getHeader("app-id"), changeGamePasswordRequest, LocalDateTime.now());
		} else {
			return responseUtility.responseBuilder(0L, changeGamePasswordRequest.getClientId(), 96);
		}
	}

	@RequestMapping(value = "/resetGamePassword", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response resetGamePassword(HttpServletRequest request,
			@Validated @RequestBody ResetGamePasswordRequest resetGamePasswordRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return gameProfileManager.resetGamePassword(request.getHeader("app-id"), resetGamePasswordRequest, LocalDateTime.now());
		} else {
			return responseUtility.responseBuilder(0L, resetGamePasswordRequest.getClientId(), 96);
		}
	}

}
