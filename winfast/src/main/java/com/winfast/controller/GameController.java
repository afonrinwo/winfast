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

import com.winfast.manager.GameManager;
import com.winfast.model.games.DailyHammerRequest;
import com.winfast.model.games.DailyHammerResponse;
import com.winfast.model.games.DrawResultRequest;
import com.winfast.model.games.DrawResultResponse;
import com.winfast.model.games.EditConsolationPrizeRequest;
import com.winfast.model.games.EditConsolationPrizetResponse;
import com.winfast.model.games.EditTicketRequest;
import com.winfast.model.games.EditTicketResponse;
import com.winfast.model.games.GameGeneratorRequest;
import com.winfast.model.games.GameGeneratorResponse;
import com.winfast.model.games.InstantMillionRequest;
import com.winfast.model.games.InstantMillionResponse;
import com.winfast.model.games.TicketInfoByMobileNoRequest;
import com.winfast.model.games.TicketInfoByMobileNoResponse;
import com.winfast.model.games.TicketInfoByTicketIdRequest;
import com.winfast.model.games.TicketInfoByTicketIdResponse;
import com.winfast.utility.AuthenticationUtility;
import com.winfast.utility.ResponseUtility;

@RestController
public class GameController {

	@Autowired
	AuthenticationUtility authenticationUtility;

	@Autowired
	ResponseUtility responseUtility;

	@Autowired
	GameManager gameManager;

	
	@RequestMapping(value = "/dailyHammerTicket", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody DailyHammerResponse dailyHammerTicket(HttpServletRequest request,
			@Validated @RequestBody DailyHammerRequest dailyHammerRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			LocalDateTime requestIn = LocalDateTime.now();
			String sourceUid = (requestIn.toString().replace("-", "").replace("T", "").replace(":", "").replace(".", "")
					+ authenticationUtility.getRandomAlphabet().toUpperCase());
  			return gameManager.dailyHammerTicket(request.getHeader("app-id"), dailyHammerRequest, requestIn, sourceUid);
		} else {
			return responseUtility.dailyHammerTicketResponseBuilder(0L, dailyHammerRequest.getClientId(), 96);
		}
	}
	
	@RequestMapping(value = "/instantMillionTicket", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody InstantMillionResponse instantMillionTicket(HttpServletRequest request,
			@Validated @RequestBody InstantMillionRequest instantMillionRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			LocalDateTime requestIn = LocalDateTime.now();
			String sourceUid = (requestIn.toString().replace("-", "").replace("T", "").replace(":", "").replace(".", "")
					+ authenticationUtility.getRandomAlphabet().toUpperCase());
			return gameManager.instantMillionTicket(request.getHeader("app-id"), instantMillionRequest, requestIn, sourceUid);
		} else {
			return responseUtility.instantMillionResponseBuilder(0L, instantMillionRequest.getClientId(), 96);
		}
	}


	@RequestMapping(value = "/editDailyTicket", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody EditTicketResponse editDailyTicket(HttpServletRequest request,
			@Validated @RequestBody EditTicketRequest editTicketRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return gameManager.editDailyTicket(request.getHeader("app-id"), editTicketRequest, LocalDateTime.now());
		} else {
			return responseUtility.editDailyTicketResponseBuilder(0L, editTicketRequest.getClientId(), 96);
		}
	}
	
	@RequestMapping(value = "/editConsolatinPrize", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody EditConsolationPrizetResponse editConsolatinPrize(HttpServletRequest request,
			@Validated @RequestBody EditConsolationPrizeRequest editConsolationPrizeRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return gameManager.editConsolatinPrize(request.getHeader("app-id"), editConsolationPrizeRequest, LocalDateTime.now());
		} else {
			return responseUtility.editConsolationPrizeResponseBuilder(0L, editConsolationPrizeRequest.getClientId(), 96);
		}
	}

	@RequestMapping(value = "/ticketInfoByMobileNumber", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody TicketInfoByMobileNoResponse ticketInfoByMobileNumber(HttpServletRequest request,
			@Validated @RequestBody TicketInfoByMobileNoRequest ticketInfoByMobileNoRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			LocalDateTime requestIn = LocalDateTime.now();
			return gameManager.ticketInfoByMobileNumber(request.getHeader("app-id"), ticketInfoByMobileNoRequest, requestIn);
		} else {
			return responseUtility.ticketInfoByMobileNoResponseBuilder(ticketInfoByMobileNoRequest.getClientId(),
					96);
		}
	}

	@RequestMapping(value = "/ticketInfoByTicketId", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody TicketInfoByTicketIdResponse ticketInfoByTicketId(HttpServletRequest request,
			@Validated @RequestBody TicketInfoByTicketIdRequest ticketInfoByTicketIdRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return gameManager.ticketInfoByTicketId(request.getHeader("app-id"), ticketInfoByTicketIdRequest, LocalDateTime.now());
		} else {
			return responseUtility.ticketInfoByTicketIdResponseBuilder(ticketInfoByTicketIdRequest.getClientId(), 96);
		}
	}

	@RequestMapping(value = "/gameGenerator", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody GameGeneratorResponse gameGenerator(HttpServletRequest request,
			@Validated @RequestBody GameGeneratorRequest gameGeneratorRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return gameManager.gameGenerator(request.getHeader("app-id"), gameGeneratorRequest, LocalDateTime.now());
		} else {
			return responseUtility.gameGeneratorsResponseBuilder(gameGeneratorRequest.getClientId(), 96);
		}
	}

	@RequestMapping(value = "/drawResult", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody DrawResultResponse drawResult(HttpServletRequest request,
			@Validated @RequestBody DrawResultRequest drawResultRequest) {
		if (authenticationUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return gameManager.drawResult(request.getHeader("app-id"), drawResultRequest, LocalDateTime.now());
		} else {
			return responseUtility.drawResultResponseBuilder(drawResultRequest.getClientId(), 96);
		}
	}
	
	

}
