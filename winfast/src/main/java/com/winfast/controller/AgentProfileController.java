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

import com.winfast.manager.AgentProfileManager;
import com.winfast.model.Response;
import com.winfast.model.profile.agent.ActivateAgentProfileRequest;
import com.winfast.model.profile.agent.AgentProfileObject;
import com.winfast.model.profile.agent.CreateAgentProfileRequest;
import com.winfast.model.profile.agent.ChangeAgentPasswordRequest;
import com.winfast.model.profile.agent.DisableAgentProfileRequest;
import com.winfast.model.profile.agent.ResetAgentPasswordRequest;
import com.winfast.model.terminal.ActivateTerminalRequest;
import com.winfast.model.terminal.DeactivateTerminalRequest;
import com.winfast.model.terminal.MapTerminalRequest;
import com.winfast.model.terminal.MapTerminalResponse;
import com.winfast.utility.AuthenticationUtility;
import com.winfast.utility.ResponseUtility;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@RestController
public class AgentProfileController {

	@Autowired
	AuthenticationUtility authenticationUtility;

	@Autowired
	ResponseUtility responseUtility;

	@Autowired
	AgentProfileManager agentProfileManager;

	@RequestMapping(value = "/createAgentProfile", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response createAgentProfile(HttpServletRequest request,
			@Validated @RequestBody CreateAgentProfileRequest createAgentProfileRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return agentProfileManager.createAgentProfile(createAgentProfileRequest, request.getHeader("app-id"),
					LocalDateTime.now());
		} else {
			return responseUtility.responseBuilder(0L, createAgentProfileRequest.getClientId(), 99);
		}
	}

	@RequestMapping(value = "/listAgentProfile", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Iterable<AgentProfileObject> listAgentProfile(HttpServletRequest request) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return agentProfileManager.listAgentProfile();
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/listActiveAgentProfile", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Iterable<AgentProfileObject> listActiveAgentProfile(HttpServletRequest request) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return agentProfileManager.listAgentProfile(1);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/listInActiveAgentProfile", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Iterable<AgentProfileObject> listInActiveAgentProfile(HttpServletRequest request) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return agentProfileManager.listAgentProfile(0);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/activateAgentProfle", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response activateAgentProfle(HttpServletRequest request,
			@Validated @RequestBody ActivateAgentProfileRequest activateAgentProfileRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return agentProfileManager.activateAgentProfle(request.getHeader("app-id"), activateAgentProfileRequest,
					LocalDateTime.now());
		} else {
			return responseUtility.responseBuilder(0L, activateAgentProfileRequest.getClientId(), 96);
		}
	}

	@RequestMapping(value = "/disableAgentProfile", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response disableAgentProfile(HttpServletRequest request,
			@Validated @RequestBody DisableAgentProfileRequest disableAgentProfileRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return agentProfileManager.disableAgentProfile(request.getHeader("app-id"), disableAgentProfileRequest,
					LocalDateTime.now());
		} else {
			return responseUtility.responseBuilder(0L, disableAgentProfileRequest.getClientId(), 96);
		}
	}

	@RequestMapping(value = "/changeAgentPassword", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response changeAgentPassword(HttpServletRequest request,
			@Validated @RequestBody ChangeAgentPasswordRequest changeAgentPasswordRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return agentProfileManager.changeAgentPassword(request.getHeader("app-id"), changeAgentPasswordRequest,
					LocalDateTime.now());
		} else {
			return responseUtility.responseBuilder(0L, changeAgentPasswordRequest.getClientId(), 96);
		}
	}

	@RequestMapping(value = "/resetAgentPassword", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response resetAgentPassword(HttpServletRequest request,
			@Validated @RequestBody ResetAgentPasswordRequest resetAgentPasswordRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return agentProfileManager.resetAgentPassword(request.getHeader("app-id"), resetAgentPasswordRequest,
					LocalDateTime.now());
		} else {
			return responseUtility.responseBuilder(0L, resetAgentPasswordRequest.getClientId(), 96);
		}
	}

	@RequestMapping(value = "/mapTerminal", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody MapTerminalResponse mapTerminal(HttpServletRequest request,
			@Validated @RequestBody MapTerminalRequest mapTerminalRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return agentProfileManager.mapTerminal(request.getHeader("app-id"), mapTerminalRequest,
					LocalDateTime.now());
		} else {
			return responseUtility.terminalMappingResponseBuilder(mapTerminalRequest.getClientId(), mapTerminalRequest.getAgentId(), null,  96);
		}
	}

	@RequestMapping(value = "/activateTerminal", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response activateTerminal(HttpServletRequest request,
			@Validated @RequestBody ActivateTerminalRequest activateTerminalRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return agentProfileManager.activateTerminal(request.getHeader("app-id"), activateTerminalRequest,
					LocalDateTime.now());
		} else {
			return responseUtility.responseBuilder(0L, activateTerminalRequest.getClientId(), 96);
		}
	}
	
	@RequestMapping(value = "/deactivateTerminal", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response deactivateTerminal(HttpServletRequest request,
			@Validated @RequestBody DeactivateTerminalRequest deactivateTerminalRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return agentProfileManager.deactivateTerminal(request.getHeader("app-id"), deactivateTerminalRequest,
					LocalDateTime.now());
		} else {
			return responseUtility.responseBuilder(0L, deactivateTerminalRequest.getClientId(), 96);
		}
	}
}
