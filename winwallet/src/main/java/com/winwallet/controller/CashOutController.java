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

import com.winwallet.manager.CashOutManager;
import com.winwallet.manager.UtilityManager;
import com.winwallet.model.Response;
import com.winwallet.model.cashout.ATMCashOutRequest;
import com.winwallet.model.cashout.AgentCashOutRequest;
import com.winwallet.model.cashout.BankCashOutRequest;
import com.winwallet.utility.AuthUtility;
import com.winwallet.utility.ResponseUtility;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@RestController
public class CashOutController {
	
	@Autowired 
	AuthUtility authUtility;
	
	@Autowired
	CashOutManager cashOutManager;
	
	@Autowired
	UtilityManager utilityManager;
	
	@Autowired
	ResponseUtility responseUtility;
	
	@RequestMapping(value = "/bankCashOut", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response bankCashOut(HttpServletRequest request, @Validated @RequestBody BankCashOutRequest bankCashOutRequest) {
		if (authUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return cashOutManager.bankCashOut(bankCashOutRequest, LocalDateTime.now().toString());
		} else {
			return responseUtility.response(0L, bankCashOutRequest.getClientId(), 96);
		}
	}
	
	@RequestMapping(value = "/agentCashOut", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response agentCashOut(HttpServletRequest request, @Validated @RequestBody AgentCashOutRequest agentCashOutRequest) {
		if (authUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return cashOutManager.agentCashOut(agentCashOutRequest, LocalDateTime.now().toString());
		} else {
			return responseUtility.response(0L, agentCashOutRequest.getClientId(), 96);
		}
	}
	
	@RequestMapping(value = "/atmCashOut", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response atmCashOut(HttpServletRequest request, @Validated @RequestBody ATMCashOutRequest atmCashOutRequest) {
		if (authUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return cashOutManager.atmCashOut(atmCashOutRequest, LocalDateTime.now().toString());
		} else {
			return responseUtility.response(0L, atmCashOutRequest.getClientId(), 96);
		}
	}

}
