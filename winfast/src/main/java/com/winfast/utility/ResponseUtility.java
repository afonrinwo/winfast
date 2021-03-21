/**
 * 
 */
package com.winfast.utility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winfast.model.Response;
import com.winfast.model.ResponseCode;
import com.winfast.model.games.DailyHammerResponse;
import com.winfast.model.games.DrawResultResponse;
import com.winfast.model.games.EditConsolationPrizetResponse;
import com.winfast.model.games.EditTicketResponse;
import com.winfast.model.games.GameGeneratorResponse;
import com.winfast.model.games.InstantMillionResponse;
import com.winfast.model.games.TicketInfoByMobileNoResponse;
import com.winfast.model.games.TicketInfoByTicketIdResponse;
import com.winfast.model.terminal.MapTerminalResponse;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Service
public class ResponseUtility {

	private Response response;
	private MapTerminalResponse mapTerminalResponse;
	private InstantMillionResponse instantMillionResponse;
	private DailyHammerResponse dailyHammerResponse;
	private TicketInfoByTicketIdResponse ticketInfoByTicketIdResponse;
	private TicketInfoByMobileNoResponse ticketInfoByMobileNoResponse;
	private EditTicketResponse editTicketResponse;
	private EditConsolationPrizetResponse editConsolationPrizetResponse;
	private GameGeneratorResponse gameGeneratorResponse;
	private StringBuilder stringBuilder;

	@Autowired
	ResponseCode responseCode;


	public Response responseBuilder(long uniqueId, String clientId, int code) {
		response = new Response();
		response.setUniqueId(uniqueId);
		response.setClientId(clientId);
		response.setResponseCode(String.format("%03d", code));
		stringBuilder = new StringBuilder();
		response.setResponseMessage(stringBuilder.append(responseCode.getResponse_message()[code]).toString());
		return response;
	}

	public MapTerminalResponse terminalMappingResponseBuilder(String clientId, String agentId, String terminalId, int code) {
		mapTerminalResponse = new MapTerminalResponse();
		mapTerminalResponse.setAgentId(agentId);
		mapTerminalResponse.setClientId(clientId);
		mapTerminalResponse.setTerminalId(String.format("%08d", terminalId));
		mapTerminalResponse.setResponseCode(String.format("%03d", code));
		stringBuilder = new StringBuilder();
		mapTerminalResponse
				.setResponseMessage(stringBuilder.append(responseCode.getResponse_message()[code]).toString());
		return mapTerminalResponse;
	}

	public InstantMillionResponse instantMillionResponseBuilder(long uniqueId, String agentId, String amount,
			String channels, String clientId, String country, String mobileNumber, String psp, String costPerLine,
			String sourceUid, String gameNumbers, String bonus, int transaction_id, String ticket_id, String event_ids,
			String error, String message, String draw_date, String drawn, String hit, String gameMatch, String prize,
			String winnings, int code) {

		instantMillionResponse = new InstantMillionResponse();
		stringBuilder = new StringBuilder();
		instantMillionResponse.setAgentId(agentId);
		instantMillionResponse.setAmount(amount);
		instantMillionResponse.setBonus(bonus);
		instantMillionResponse.setChannels(channels);
		instantMillionResponse.setClientId(clientId);
		instantMillionResponse.setCostPerLine(costPerLine);
		instantMillionResponse.setCountry(country);
		instantMillionResponse.setDraw_date(draw_date);
		instantMillionResponse.setDrawn(drawn);
		instantMillionResponse.setEvent_ids(event_ids);
		instantMillionResponse.setHit(hit);
		instantMillionResponse.setGameMatch(gameMatch);
		instantMillionResponse.setMobileNumber(mobileNumber);
		instantMillionResponse.setPrize(prize);
		instantMillionResponse.setPsp(psp);
		instantMillionResponse.setResponsecode(String.format("%03d", code));
		instantMillionResponse
				.setResponsemessage(stringBuilder.append(responseCode.getResponse_message()[code]).toString());
		instantMillionResponse.setGameNumbers(gameNumbers);
		instantMillionResponse.setSourceUid(ticket_id);
		instantMillionResponse.setTicket_id(sourceUid.substring(sourceUid.length() - 10));
		instantMillionResponse.setTransaction_id(transaction_id);
		instantMillionResponse.setUniqueid(uniqueId);
		instantMillionResponse.setWinnings(winnings);
		instantMillionResponse.setError(error);
		instantMillionResponse.setMessage(message);
		return instantMillionResponse;
	}

	public InstantMillionResponse instantMillionResponseBuilder(long uniqueid, String clientId, int code) {
		instantMillionResponse = new InstantMillionResponse();
		stringBuilder = new StringBuilder();
		instantMillionResponse.setUniqueid(uniqueid);
		instantMillionResponse.setClientId(clientId);
		instantMillionResponse.setResponsecode(String.format("%03d", code));
		instantMillionResponse
				.setResponsemessage(stringBuilder.append(responseCode.getResponse_message()[code]).toString());
		return instantMillionResponse;
	}

	public DailyHammerResponse dailyHammerTicketResponseBuilder(Long uniqueId, String agentId, String amount,
			String channels, String clientId, String country, String error, String message, String mobileNumber,
			String costPerLine, String psp, String sourceUid, String gameNumbers, String bonus, String transaction_id,
			String ticket_id, String event_ids, String draw_date, int code) {

		dailyHammerResponse = new DailyHammerResponse();
		stringBuilder = new StringBuilder();
		dailyHammerResponse.setAgentId(agentId);
		dailyHammerResponse.setAmount(amount);
		dailyHammerResponse.setBonus(bonus);
		dailyHammerResponse.setChannels(channels);
		dailyHammerResponse.setClientId(clientId);
		dailyHammerResponse.setCountry(country);
		dailyHammerResponse.setDraw_date(draw_date);
		dailyHammerResponse.setEvent_ids(event_ids);
		dailyHammerResponse.setError(error);
		dailyHammerResponse.setMessage(message);
		dailyHammerResponse.setMobileNumber(mobileNumber);
		dailyHammerResponse.setCostPerLine(costPerLine);
		dailyHammerResponse.setPsp(psp);
		dailyHammerResponse.setResponsecode(String.format("%03d", code));
		dailyHammerResponse
				.setResponsemessage(stringBuilder.append(responseCode.getResponse_message()[code]).toString());
		dailyHammerResponse.setGameNumbers(gameNumbers);
		dailyHammerResponse.setSourceUid(ticket_id); // We interchange sourceUidfor TicketId for the purpose of
														// simplicity for our customers
		dailyHammerResponse.setTicket_id(sourceUid.substring(sourceUid.length() - 10));
		dailyHammerResponse.setTransaction_id(transaction_id);
		dailyHammerResponse.setUniqueid(uniqueId);
		return dailyHammerResponse;
	}

	public DailyHammerResponse dailyHammerTicketResponseBuilder(long uniqueid, String clientId, int code) {

		dailyHammerResponse = new DailyHammerResponse();
		stringBuilder = new StringBuilder();
		dailyHammerResponse.setUniqueid(uniqueid);
		dailyHammerResponse.setClientId(clientId);
		dailyHammerResponse.setResponsecode(String.format("%03d", code));
		dailyHammerResponse
				.setResponsemessage(stringBuilder.append(responseCode.getResponse_message()[code]).toString());
		return dailyHammerResponse;
	}

	public TicketInfoByMobileNoResponse ticketInfoByMobileResponseBuilder(String clientId, String gameString,
			int code) {
		stringBuilder = new StringBuilder();
		ticketInfoByMobileNoResponse = new TicketInfoByMobileNoResponse();
		ticketInfoByMobileNoResponse.setClientId(clientId);
		ticketInfoByMobileNoResponse.setGameString(gameString);
		ticketInfoByMobileNoResponse.setResponsecode(String.format("%03d", code));
		ticketInfoByMobileNoResponse
				.setResponsemessage(stringBuilder.append(responseCode.getResponse_message()[code]).toString());
		return ticketInfoByMobileNoResponse;
	}

	public TicketInfoByMobileNoResponse ticketInfoByMobileNoResponseBuilder(String clientId, int code) {
		stringBuilder = new StringBuilder();
		ticketInfoByMobileNoResponse = new TicketInfoByMobileNoResponse();
		ticketInfoByMobileNoResponse.setClientId(clientId);
		ticketInfoByMobileNoResponse.setResponsecode(String.format("%03d", code));
		ticketInfoByMobileNoResponse
				.setResponsemessage(stringBuilder.append(responseCode.getResponse_message()[code]).toString());
		return ticketInfoByMobileNoResponse;
	}

	public TicketInfoByTicketIdResponse ticketInfoByTicketIdResponseBuilder(String clientId, String bonus,
			String draw_date, String event_id, String main, String multiplier, String prodID, String sourceUid,
			String ticket_id, int code) {

		stringBuilder = new StringBuilder();
		ticketInfoByTicketIdResponse = new TicketInfoByTicketIdResponse();
		ticketInfoByTicketIdResponse.setClientId(clientId);
		ticketInfoByTicketIdResponse.setBonus(bonus);
		ticketInfoByTicketIdResponse.setDraw_date(draw_date);
		ticketInfoByTicketIdResponse.setEvent_ids(event_id);
		ticketInfoByTicketIdResponse.setGameNumbers(main);
		ticketInfoByTicketIdResponse.setMultiplier(multiplier);
		ticketInfoByTicketIdResponse.setProdID(prodID);
		ticketInfoByTicketIdResponse.setResponsecode(String.format("%03d", code));
		ticketInfoByTicketIdResponse.setSourceUid(ticket_id); // We interchange sourceUidfor TicketId for the purpose of
																// simplicity for our customers
		ticketInfoByTicketIdResponse.setTicket_id(sourceUid.substring(sourceUid.length() - 10));
		ticketInfoByTicketIdResponse
				.setResponsemessage(stringBuilder.append(responseCode.getResponse_message()[code]).toString());
		return ticketInfoByTicketIdResponse;
	}

	public TicketInfoByTicketIdResponse ticketInfoByTicketIdResponseBuilder(String clientId, int code) {
		ticketInfoByTicketIdResponse = new TicketInfoByTicketIdResponse();
		stringBuilder = new StringBuilder();
		ticketInfoByTicketIdResponse.setClientId(clientId);
		ticketInfoByTicketIdResponse.setResponsecode(String.format("%03d", code));
		ticketInfoByTicketIdResponse
				.setResponsemessage(stringBuilder.append(responseCode.getResponse_message()[code]).toString());
		return ticketInfoByTicketIdResponse;
	}

	public EditTicketResponse editDailyTicketResponseBuilder(long uniqueid, String clientId, int code) {
		editTicketResponse = new EditTicketResponse();
		stringBuilder = new StringBuilder();
		editTicketResponse.setClientId(clientId);
		editTicketResponse.setResponsecode(String.format("%03d", code));
		editTicketResponse
				.setResponsemessage(stringBuilder.append(responseCode.getResponse_message()[code]).toString());
		return editTicketResponse;
	}

	public EditTicketResponse editDailyTicketResponseBuilder(Long uniqueId, String agentId, String amount,
			String channels, String clientId, String country, String mobileNumber, String multiplier, String psp,
			String sourceUid, String newGameNumbers, String bonus, String transaction_id, String ticket_id,
			String event_ids, String draw_date, int code) {
		editTicketResponse = new EditTicketResponse();
		stringBuilder = new StringBuilder();
		editTicketResponse.setAgentId(agentId);
		editTicketResponse.setAmount(amount);
		editTicketResponse.setBonus(bonus);
		editTicketResponse.setChannels(channels);
		editTicketResponse.setClientId(clientId);
		editTicketResponse.setCountry(country);
		editTicketResponse.setDraw_date(draw_date);
		editTicketResponse.setEvent_ids(event_ids);
		editTicketResponse.setMobileNumber(mobileNumber);
		editTicketResponse.setMultiplier(multiplier);
		editTicketResponse.setPsp(psp);
		editTicketResponse.setResponsecode(String.format("%03d", code));
		editTicketResponse
				.setResponsemessage(stringBuilder.append(responseCode.getResponse_message()[code]).toString());
		editTicketResponse.setGameNumbers(newGameNumbers);
		editTicketResponse.setSourceUid(ticket_id);
		editTicketResponse.setTicket_id(sourceUid.substring(sourceUid.length() - 10));
		editTicketResponse.setTransaction_id(transaction_id);
		editTicketResponse.setUniqueid(uniqueId);
		return editTicketResponse;
	}

	public GameGeneratorResponse gameGeneratorsResponseBuilder(String clientId, int code) {
		gameGeneratorResponse = new GameGeneratorResponse();
		stringBuilder = new StringBuilder();
		gameGeneratorResponse.setClientId(clientId);
		gameGeneratorResponse.setResponsecode(String.format("%03d", code));
		gameGeneratorResponse
				.setResponsemessage(stringBuilder.append(responseCode.getResponse_message()[code]).toString());
		return gameGeneratorResponse;
	}

	public GameGeneratorResponse gameGeneratorsResponseBuilder(String clientId, String agentId, String psp,
			String mobileNumber, List<Integer> gameNumbers, int code) {
		gameGeneratorResponse = new GameGeneratorResponse();
		stringBuilder = new StringBuilder();
		gameGeneratorResponse.setAgentId(agentId);
		gameGeneratorResponse.setClientId(clientId);
		gameGeneratorResponse.setGameNumbers(gameNumbers);
		gameGeneratorResponse.setMobileNumber(mobileNumber);
		gameGeneratorResponse.setPsp(psp);
		gameGeneratorResponse.setResponsecode(String.format("%03d", code));
		gameGeneratorResponse
				.setResponsemessage(stringBuilder.append(responseCode.getResponse_message()[code]).toString());
		return gameGeneratorResponse;
	}

	public EditConsolationPrizetResponse editConsolationPrizeResponseBuilder(long uniqueId, String clientId, int code) {
		editConsolationPrizetResponse = new EditConsolationPrizetResponse();
		stringBuilder = new StringBuilder();
		editConsolationPrizetResponse.setClientId(clientId);
		editConsolationPrizetResponse.setResponsecode(String.format("%03d", code));
		editConsolationPrizetResponse
				.setResponsemessage(stringBuilder.append(responseCode.getResponse_message()[code]).toString());
		return editConsolationPrizetResponse;
	}

	public EditConsolationPrizetResponse editConsolationPrizeResponseBuilder(Long uniqueId,
			String agentId, String amount, String channelId, String clientId, String country, String mobileNumber,
			String costPerLine, String psp, String sourceUid, String gameNumbers, String newBonus,
			String transaction_id, String ticket_id, String event_ids, String draw_date, int code) {
		editConsolationPrizetResponse = new EditConsolationPrizetResponse();
		stringBuilder = new StringBuilder();
		editConsolationPrizetResponse.setAgentId(agentId);
		editConsolationPrizetResponse.setAmount(amount);
		editConsolationPrizetResponse.setBonus(newBonus);
		editConsolationPrizetResponse.setChannels(channelId);
		editConsolationPrizetResponse.setClientId(clientId);
		editConsolationPrizetResponse.setCountry(country);
		editConsolationPrizetResponse.setDraw_date(draw_date);
		editConsolationPrizetResponse.setEvent_ids(event_ids);
		editConsolationPrizetResponse.setMobileNumber(mobileNumber);
		editConsolationPrizetResponse.setPsp(psp);
		editConsolationPrizetResponse.setResponsecode(String.format("%03d", code));
		editConsolationPrizetResponse
				.setResponsemessage(stringBuilder.append(responseCode.getResponse_message()[code]).toString());
		editConsolationPrizetResponse.setGameNumbers(gameNumbers);
		editConsolationPrizetResponse.setSourceUid(ticket_id);
		editConsolationPrizetResponse.setTicket_id(sourceUid.substring(sourceUid.length() - 10));
		editConsolationPrizetResponse.setTransaction_id(transaction_id);
		editConsolationPrizetResponse.setUniqueid(uniqueId);
		return editConsolationPrizetResponse;
	}
	
	public DrawResultResponse drawResultResponseBuilder(String clientId, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public DrawResultResponse drawResultResponseBuilder(String clientId, String string, String string2, String string3,
			String string4, String string5, String string6, int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
