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

import com.winwallet.manager.PaymentManager;
import com.winwallet.manager.UtilityManager;
import com.winwallet.model.Response;
import com.winwallet.model.account.LienRequest;
import com.winwallet.model.account.PNDRequest;
import com.winwallet.model.payment.Wallet2WalletRequest;
import com.winwallet.model.payment.WalletCreditRequest;
import com.winwallet.model.payment.WalletDebitRequest;
import com.winwallet.model.payment.WalletDepositRequest;
import com.winwallet.utility.AuthUtility;
import com.winwallet.utility.ResponseUtility;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@RestController
public class PaymentController {
	
	@Autowired 
	AuthUtility authUtility;
	
	@Autowired
	PaymentManager paymentManager;
	
	@Autowired
	ResponseUtility responseUtility;

	@RequestMapping(value = "/walletDeposit", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response walletDeposit(HttpServletRequest request, @Validated @RequestBody WalletDepositRequest walletDepositRequest) {
		if (authUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return paymentManager.walletDeposit(walletDepositRequest, LocalDateTime.now().toString());
		} else {
			return responseUtility.response(0L, walletDepositRequest.getClientId(), 96);
		}
	}
	
	@RequestMapping(value = "/walletDebit", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response walletDebit(HttpServletRequest request, @Validated @RequestBody WalletDebitRequest walletDebitRequest) {
		if (authUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return paymentManager.walletDebit(walletDebitRequest, LocalDateTime.now().toString());
		} else {
			return responseUtility.response(0L, walletDebitRequest.getClientId(), 96);
		}
	}
	
	@RequestMapping(value = "/walletCredit", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response walletCredit(HttpServletRequest request, @Validated @RequestBody WalletCreditRequest walletCreditRequest) {
		if (authUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return paymentManager.walletCredit(walletCreditRequest, LocalDateTime.now().toString());
		} else {
			return responseUtility.response(0L, walletCreditRequest.getClientId(), 96);
		}
	}
	
	@RequestMapping(value = "/wallet2Wallet", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Response wallet2Wallet(HttpServletRequest request, @Validated @RequestBody Wallet2WalletRequest wallet2WalletRequest) {
		if (authUtility.accessValidation(request.getHeader("Authorization"), request.getHeader("app-id"))) {
			return paymentManager.wallet2Wallet(wallet2WalletRequest, LocalDateTime.now().toString());
		} else {
			return responseUtility.response(0L, wallet2WalletRequest.getClientId(), 96);
		}
	}

}
