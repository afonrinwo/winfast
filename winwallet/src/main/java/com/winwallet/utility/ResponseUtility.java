/**
 * 
 */
package com.winwallet.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winwallet.model.Response;
import com.winwallet.model.ResponseCode;
import com.winwallet.model.access.CustomerDataObject;
import com.winwallet.model.account.CustomerWalletObject;
import com.winwallet.model.balance.WalletBalanceResponse;
import com.winwallet.model.enquiry.WalletEnquiryResponse;

/**
 * @author Emmanuel Afonrinwo
 *
 */

@Service
public class ResponseUtility {

	private Response response;
	private StringBuilder stringBuilder;
	private WalletEnquiryResponse walletEnquiryResponse;
	private WalletBalanceResponse walletBalanceResponse;

	@Autowired
	ResponseCode responseCode;

	public Response response(long uniqueId, String clientId, int code) {
		stringBuilder = new StringBuilder();
		response = new Response();
		response.setUniqueId(uniqueId);
		response.setClientId(clientId);
		response.setResponseCode(String.format("%03d", code));
		response.setResponseMessage(
				stringBuilder.append(responseCode.getResponse_message()[Integer.valueOf(code)]).toString());
		return response;
	}

	public WalletEnquiryResponse walletEnquiryResponse(long uniqueId, String clientId, int code) {
		stringBuilder = new StringBuilder();
		walletEnquiryResponse = new WalletEnquiryResponse();
		walletEnquiryResponse.setUniqueId(uniqueId);
		walletEnquiryResponse.setClientId(clientId);
		walletEnquiryResponse.setResponseCode(String.format("%03d", code));
		walletEnquiryResponse.setResponseMessage(
				stringBuilder.append(responseCode.getResponse_message()[Integer.valueOf(code)]).toString());
		return walletEnquiryResponse;
	}

	public WalletEnquiryResponse walletEnquiryResponse(long uniqueId, String clientId,
			CustomerDataObject customerDataObject, int code) {
		stringBuilder = new StringBuilder();
		walletEnquiryResponse = new WalletEnquiryResponse();
		walletEnquiryResponse.setUniqueId(uniqueId);
		walletEnquiryResponse.setClientId(clientId);
		walletEnquiryResponse.setMsisdn(customerDataObject.getMsisdn());
		walletEnquiryResponse.setMsisdnNetwork(customerDataObject.getMsisdnNetwork());
		walletEnquiryResponse.setResponseCode(String.format("%03d", code));
		walletEnquiryResponse.setResponseMessage(
				stringBuilder.append(responseCode.getResponse_message()[Integer.valueOf(code)]).toString());
		return walletEnquiryResponse;
	}

	public WalletBalanceResponse walletBalanceResponse(String clientId, String msisdn, int code) {
		stringBuilder = new StringBuilder();
		walletBalanceResponse = new WalletBalanceResponse();
		walletBalanceResponse.setClientId(clientId);
		walletBalanceResponse.setMsisdn(msisdn);
		walletBalanceResponse.setResponseCode(String.format("%03d", code));
		walletBalanceResponse.setResponseMessage(
				stringBuilder.append(responseCode.getResponse_message()[Integer.valueOf(code)]).toString());
		return walletBalanceResponse;
	}

	public WalletBalanceResponse walletBalanceResponse(CustomerWalletObject customerWalletObject, String clientId, int code) {
		stringBuilder = new StringBuilder();
		walletBalanceResponse = new WalletBalanceResponse();
		walletBalanceResponse.setClientId(clientId);
		walletBalanceResponse.setMsisdn(customerWalletObject.getMsisdn());
		walletBalanceResponse.setBalance(customerWalletObject.getAvailableBalance());
		walletBalanceResponse.setResponseCode(String.format("%03d", code));
		walletBalanceResponse.setResponseMessage(
				stringBuilder.append(responseCode.getResponse_message()[Integer.valueOf(code)]).toString());
		return walletBalanceResponse;
	}

}
