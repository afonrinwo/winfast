/**
 * 
 */
package com.winfast.game;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Base64;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winfast.model.ConfigurationObject;
import com.winfast.model.games.DailyHammerObject;
import com.winfast.model.games.DailyHammerResponse;
import com.winfast.model.games.EditConsolationPrizetResponse;
import com.winfast.model.games.EditTicketResponse;
import com.winfast.model.games.InstantMillionObject;
import com.winfast.model.games.InstantMillionResponse;
import com.winfast.model.games.TicketInfoByMobileNoResponse;
import com.winfast.model.games.TicketInfoByTicketIdResponse;
import com.winfast.repository.DailyHammerRepository;
import com.winfast.repository.InstantMillionRepository;
import com.winfast.utility.ResponseUtility;
import com.winfast.utility.MessageUtility;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Service
public class GamesServices {

	private static Logger logger = LogManager.getLogger(GamesServices.class);
	private DailyHammerObject dailyHammerObject;
	private InstantMillionObject instantMillionObject;

	@Autowired
	ConfigurationObject configurationObject;

	@Autowired
	DailyHammerRepository dailyHammerRepository;

	@Autowired
	InstantMillionRepository instantMillionRepository;

	@Autowired
	ResponseUtility responseUtility;

	@Autowired
	MessageUtility smsUtility;

	public DailyHammerResponse dailyHammerTicket(long uniqueId, String clientId, Boolean random, String multiplier,
			String gameNumbers, String bonus, String mobileNumber, String agentId, String channelId, String country,
			String sourceUId, String amount, String psp) {

		try {
			String urlParameters = null;
			String url = configurationObject.getBaseURL() + "/tickets/create";

			if (agentId.equals("")) {

				urlParameters = "{\"game\":\"daily_hammer\"," + "\"prodID\":\"201\"," + "\"random\":\" " + random
						+ " \"" + ",\"lines\":[" + "{" + "\"multiplier\":" + multiplier + "," + "\"main\":" + gameNumbers
						+ "," + "\"bonus\": " + bonus + "" + "}]," + "\"customer\":" + "{\"MSISDN\":\"" + mobileNumber
						+ "\"," + "\"channel\":\"" + channelId + "\"," + "\"country\":\"" + country + "\"" + "},"
						+ "\"transaction\":" + "{\"source_uid\":\"" + sourceUId + "\"," + "\"amount\":\"" + amount
						+ "\"," + "\"psp\":\" " + psp + "\"" + "},"
						+ "\"callback\":\"https://www.example.com/script.php?ticket_id=12345678\"}";

			} else {
				urlParameters = "{\"game\":\"daily_hammer\"," + "\"prodID\":\"201\"," + "\"random\":\" " + random
						+ " \"" + ",\"lines\":[" + "{\"multiplier\":" + multiplier + "," + "\"main\":" + gameNumbers
						+ "," + "\"bonus\": " + bonus + "" + "}]," + "\"customer\":" + "{\"MSISDN\":\"" + mobileNumber
						+ "\"," + "\"agent\":\"" + agentId + "\"," + "\"channel\":\"" + channelId + "\","
						+ "\"country\":\"" + country + "\"" + "}," + "\"transaction\":" + "{\"source_uid\":\""
						+ sourceUId + "\"," + "\"amount\":\"" + amount + "\"," + "\"psp\":\" " + psp + "\"" + "},"
						+ "\"callback\":\"https://www.example.com/script.php?ticket_id=12345678\"}";
			}

			byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

			logger.info(url + " :: " + urlParameters);

			URL myurl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) myurl.openConnection();

			connection.setDoOutput(true);
			connection.setRequestMethod("POST");

			String userCredentials = configurationObject.getUserid() + ":" + configurationObject.getPassword();
			String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
			connection.setRequestProperty("Authorization", basicAuth);
			connection.setRequestProperty("User-Agent", "Java client");
			connection.setRequestProperty("Content-Type", "application/json");

			try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
				wr.write(postData);
			}

			StringBuilder content;

			try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
				String line;
				content = new StringBuilder();
				while ((line = br.readLine()) != null) {
					content.append(line);
				}

			}

			logger.info("Response from Lottonetix :: " + content.toString());

			JSONObject object = new JSONObject(content.toString());
			int code;

			if (object.has("status")) {

				JSONObject innerObject = new JSONObject(object.get("status").toString());
				dailyHammerObject = new DailyHammerObject();
				dailyHammerObject = dailyHammerRepository.findBySourceUid(sourceUId);

				if (dailyHammerObject.getUniqueId() > 0) {
					dailyHammerObject.setAgentId(dailyHammerObject.getAgentId());
					dailyHammerObject.setAmount(dailyHammerObject.getAmount());
					dailyHammerObject.setChannelId(dailyHammerObject.getChannelId());
					dailyHammerObject.setClientId(dailyHammerObject.getClientId());
					dailyHammerObject.setCountry(dailyHammerObject.getCountry());
					dailyHammerObject.setBonus(dailyHammerObject.getBonus());
					dailyHammerObject.setDraw_date(null);
					dailyHammerObject.setEvent_ids(null);
					dailyHammerObject.setError(innerObject.getString("error"));
					dailyHammerObject.setMessage(innerObject.getString("type"));
					dailyHammerObject.setMobileNumber(dailyHammerObject.getMobileNumber());
					dailyHammerObject.setCostPerLine(null);
					dailyHammerObject.setPsp(dailyHammerObject.getPsp());
					dailyHammerObject.setRandom(dailyHammerObject.getRandom());
					dailyHammerObject.setRequestIn(dailyHammerObject.getRequestIn());
					dailyHammerObject.setResponseOut(LocalDateTime.now());
					dailyHammerObject.setGameNumbers(dailyHammerObject.getGameNumbers());
					dailyHammerObject.setSourceUid(dailyHammerObject.getSourceUid());
					dailyHammerObject.setTicket_id(null);
					dailyHammerObject.setTransaction_id(null);
					dailyHammerObject.setUniqueId(dailyHammerObject.getUniqueId());
					dailyHammerObject.setUser_id(null);
					dailyHammerRepository.save(dailyHammerObject);
				}

				code = 90;

			} else {

				dailyHammerObject = new DailyHammerObject();
				dailyHammerObject = dailyHammerRepository.findBySourceUid(object.getString("source_uid"));

				if (dailyHammerObject.getUniqueId() > 0) {
					dailyHammerObject.setAgentId(dailyHammerObject.getAgentId());
					dailyHammerObject.setAmount(dailyHammerObject.getAmount());
					dailyHammerObject.setChannelId(dailyHammerObject.getChannelId());
					dailyHammerObject.setClientId(dailyHammerObject.getClientId());
					dailyHammerObject.setCountry(dailyHammerObject.getCountry());
					dailyHammerObject.setBonus(dailyHammerObject.getBonus());
					dailyHammerObject.setDraw_date(object.getString("draw_date"));
					dailyHammerObject.setCostPerLine(object.get("costperline").toString());
					dailyHammerObject.setEvent_ids(String.valueOf(object.getJSONArray("event_ids")));
					dailyHammerObject.setError("false");
					dailyHammerObject.setMessage("SUCCESSFUL");
					dailyHammerObject.setMobileNumber(dailyHammerObject.getMobileNumber());
					dailyHammerObject.setPsp(dailyHammerObject.getPsp());
					dailyHammerObject.setRandom(dailyHammerObject.getRandom());
					dailyHammerObject.setRequestIn(dailyHammerObject.getRequestIn());
					dailyHammerObject.setResponseOut(LocalDateTime.now());
					dailyHammerObject.setGameNumbers(dailyHammerObject.getGameNumbers());
					dailyHammerObject.setSourceUid(dailyHammerObject.getSourceUid());
					dailyHammerObject.setTicket_id(object.getString("ticket_id"));
					dailyHammerObject.setTransaction_id(String.valueOf(object.getInt("transaction_id")));
					dailyHammerObject.setUniqueId(dailyHammerObject.getUniqueId());
					dailyHammerObject.setUser_id(String.valueOf(object.getInt("user_id")));
					dailyHammerRepository.save(dailyHammerObject);
				}

				code = 0;

			}

			logger.info("dailyHammerTicket :: AgentId: " + dailyHammerObject.getAgentId() + "|Amount: "
					+ dailyHammerObject.getAmount() + "|Channels: " + dailyHammerObject.getChannelId() + "|ClientId: "
					+ dailyHammerObject.getClientId() + "|Country: " + dailyHammerObject.getCountry()
					+ "|Mobilenumber: " + dailyHammerObject.getMobileNumber() + "|costperline: "
					+ dailyHammerObject.getCostPerLine() + "|PSP: " + dailyHammerObject.getPsp() + "|Random: "
					+ dailyHammerObject.getRandom() + "|RequestIn: " + dailyHammerObject.getRequestIn() + "|Bonus: "
					+ dailyHammerObject.getBonus() + "|SelectedNumbers: " + dailyHammerObject.getGameNumbers()
					+ "|sourceUid: " + dailyHammerObject.getSourceUid() + "|TransactionId: "
					+ dailyHammerObject.getTransaction_id() + "|TicketId: " + dailyHammerObject.getTicket_id()
					+ "|EventIds: " + dailyHammerObject.getEvent_ids() + "|DrawDate: "
					+ dailyHammerObject.getDraw_date() + "|UserId: " + dailyHammerObject.getUser_id() + "|ResponseOut: "
					+ dailyHammerObject.getResponseOut() + "|UniqueId: " + dailyHammerObject.getUniqueId() + "|Error: "
					+ dailyHammerObject.getError() + "|Message: " + dailyHammerObject.getMessage());

			return responseUtility.dailyHammerTicketResponseBuilder(dailyHammerObject.getUniqueId(),
					dailyHammerObject.getAgentId(), dailyHammerObject.getAmount(), dailyHammerObject.getChannelId(),
					dailyHammerObject.getClientId(), dailyHammerObject.getCountry(), dailyHammerObject.getError(),
					dailyHammerObject.getMessage(), dailyHammerObject.getMobileNumber(),
					dailyHammerObject.getCostPerLine(), dailyHammerObject.getPsp(), dailyHammerObject.getSourceUid(),
					dailyHammerObject.getGameNumbers(), dailyHammerObject.getBonus(),
					dailyHammerObject.getTransaction_id(), dailyHammerObject.getTicket_id(),
					dailyHammerObject.getEvent_ids(), dailyHammerObject.getDraw_date(), code);

		} catch (Exception ex) {
			logger.error("dailyHammerTicket :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.dailyHammerTicketResponseBuilder(0L, clientId, 99);
		}

	}

	public InstantMillionResponse instantMillionTicket(long uniqueId, String clientId, Boolean random,
			String multiplier, String gameNumbers, String bonus, String mobileNumber, String agentId, String channelId,
			String country, String sourceUId, String amount, String psp) {
		try {
 			String urlParameters = null;
			String url = configurationObject.getBaseURL() + "/tickets/create";

			if (agentId.equals("")) {
				urlParameters = "{\"game\":\"Instant_Million\"," + "\"prodID\":\"200\"," + "\"random\":\" " + random
						+ " \"" + ",\"lines\":[" + "{" + "\"main\":" + gameNumbers
						+ "," + "\"bonus\": " + bonus + "" + "}]," + "\"customer\":" + "{\"MSISDN\":\"" + mobileNumber
						+ "\"," + "\"agent\":\"" + agentId + "\"," + "\"channel\":\"" + channelId + "\","
						+ "\"country\":\"" + country + "\"" + "}," + "\"transaction\":" + "{\"source_uid\":\""
						+ sourceUId + "\"," + "\"amount\":\"" + amount + "\"," + "\"psp\":\" " + psp + "\"" + "},"
						+ "\"callback\":\"https://www.example.com/script.php?ticket_id=12345678\"}";
			} else {
				urlParameters = "{\"game\":\"Instant_Million\"," + "\"prodID\":\"200\"," + "\"random\":\" " + random
						+ " \"" + ",\"lines\":[" + "{\"multiplier\":" + multiplier + "," + "\"main\":" + gameNumbers
						+ "," + "\"bonus\": " + bonus + "" + "}]," + "\"customer\":" + "{\"MSISDN\":\"" + mobileNumber
						+ "\"," + "\"agent\":\"" + agentId + "\"," + "\"channel\":\"" + channelId + "\","
						+ "\"country\":\"" + country + "\"" + "}," + "\"transaction\":" + "{\"source_uid\":\""
						+ sourceUId + "\"," + "\"amount\":\"" + amount + "\"," + "\"psp\":\" " + psp + "\"" + "},"
						+ "\"callback\":\"https://www.example.com/script.php?ticket_id=12345678\"}";
			}

			byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

			logger.info(url + " :: " + urlParameters);

			URL myurl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) myurl.openConnection();

			connection.setDoOutput(true);
			connection.setRequestMethod("POST");

			String userCredentials = configurationObject.getUserid() + ":" + configurationObject.getPassword();
			String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
			connection.setRequestProperty("Authorization", basicAuth);
			connection.setRequestProperty("User-Agent", "Java client");
			connection.setRequestProperty("Content-Type", "application/json");

			try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
				wr.write(postData);
			}

			StringBuilder content;

			try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
				String line;
				content = new StringBuilder();
				while ((line = br.readLine()) != null) {
					content.append(line);
				}

			}

			logger.info("Response from Lottonetix :: " + content.toString());

			JSONObject object = new JSONObject(content.toString());
			int code;

			if (object.has("status")) {

				JSONObject innerObject = new JSONObject(object.get("status").toString());

				instantMillionObject = new InstantMillionObject();
				instantMillionObject = instantMillionRepository.findBySourceUid(sourceUId);

				if (instantMillionObject.getUniqueId() > 0) {
					instantMillionObject.setAgentId(instantMillionObject.getAgentId());
					instantMillionObject.setAmount(instantMillionObject.getAmount());
					instantMillionObject.setBonus(instantMillionObject.getBonus());
					instantMillionObject.setChannelId(instantMillionObject.getChannelId());
					instantMillionObject.setClientId(instantMillionObject.getClientId());
					instantMillionObject.setCountry(instantMillionObject.getCountry());
					instantMillionObject.setDraw_date(null);
					instantMillionObject.setDrawn(null);
					instantMillionObject.setCostPerLine(null);
					instantMillionObject.setEvent_ids(null);
					instantMillionObject.setError(innerObject.getString("error"));
					instantMillionObject.setMessage(innerObject.getString("type"));
					instantMillionObject.setHit(null);
					instantMillionObject.setInstantMillionType(instantMillionObject.getInstantMillionType());
					instantMillionObject.setGameMatch(null);
					instantMillionObject.setMobileNumber(instantMillionObject.getMobileNumber());
					instantMillionObject.setPrize(null);
					instantMillionObject.setPsp(instantMillionObject.getPsp());
					instantMillionObject.setRandom(instantMillionObject.getRandom());
					instantMillionObject.setRequestIn(instantMillionObject.getRequestIn());
					instantMillionObject.setResponseOut(LocalDateTime.now());
					instantMillionObject.setGameNumbers(instantMillionObject.getGameNumbers());
					instantMillionObject.setSourceUid(instantMillionObject.getSourceUid());
					instantMillionObject.setTicket_id(null);
					instantMillionObject.setTransaction_id(0);
					instantMillionObject.setUniqueId(instantMillionObject.getUniqueId());
					instantMillionObject.setUser_id(0);
					instantMillionObject.setWinnings(null);
					instantMillionRepository.save(instantMillionObject);
				}

				code = 90;

			} else {
				instantMillionObject = new InstantMillionObject();
				instantMillionObject = instantMillionRepository.findBySourceUid((object.getString("source_uid")));

				String lines = object.get("lines").toString();
				JSONObject linesObject = new JSONObject(lines.substring(1, lines.length() - 1));

				String result = object.get("result").toString();
				JSONObject resultObject = new JSONObject(result.substring(1, result.length() - 1));

				if (instantMillionObject.getUniqueId() > 0) {
					instantMillionObject.setAgentId(instantMillionObject.getAgentId());
					instantMillionObject.setAmount(instantMillionObject.getAmount());
					instantMillionObject.setBonus(instantMillionObject.getBonus());
					instantMillionObject.setChannelId(instantMillionObject.getChannelId());
					instantMillionObject.setClientId(instantMillionObject.getClientId());
					instantMillionObject.setCountry(instantMillionObject.getCountry());
					instantMillionObject.setDraw_date(object.getString("draw_date"));
					instantMillionObject.setDrawn(resultObject.get("drawn").toString());
					instantMillionObject.setCostPerLine(object.get("costperline").toString());
					instantMillionObject.setEvent_ids(object.get("event_ids").toString());
					instantMillionObject.setHit(resultObject.get("hits").toString());
					instantMillionObject.setInstantMillionType(instantMillionObject.getInstantMillionType());
					instantMillionObject.setGameMatch(resultObject.get("match").toString());
					instantMillionObject.setMobileNumber(instantMillionObject.getMobileNumber());
					instantMillionObject.setPrize(resultObject.get("prize").toString());
					instantMillionObject.setPsp(instantMillionObject.getPsp());
					instantMillionObject.setRandom(instantMillionObject.getRandom());
					instantMillionObject.setRequestIn(instantMillionObject.getRequestIn());
					instantMillionObject.setResponseOut(LocalDateTime.now());
					instantMillionObject.setGameNumbers(instantMillionObject.getGameNumbers());
					instantMillionObject.setSourceUid(instantMillionObject.getSourceUid());
					instantMillionObject.setTicket_id(object.getString("ticket_id"));
					instantMillionObject.setTransaction_id(object.getInt("transaction_id"));
					instantMillionObject.setUniqueId(instantMillionObject.getUniqueId());
					instantMillionObject.setUser_id(object.getInt("user_id"));
					instantMillionObject.setWinnings(linesObject.get("winnings").toString());
					instantMillionRepository.save(instantMillionObject);
				}

				code = 0;

				if (Integer.valueOf(instantMillionObject.getHit()) > 2) {
					// send SMS for consolation prize to winner
					smsUtility.sendsms(String.valueOf(uniqueId), instantMillionObject.getMobileNetwork(),
							instantMillionObject.getMobileNumber(),
							"Congratulations! You won consolation price of NGN " + instantMillionObject.getPrize()
									+ " in the winfast Lotto you played on " + instantMillionObject.getDrawn(),
							LocalDateTime.now());
				}
			}

			logger.info("instantMillionTicket :: AgentId: " + instantMillionObject.getAgentId() + "|Amount: "
					+ instantMillionObject.getAmount() + "|Channels: " + instantMillionObject.getChannelId()
					+ "|ClientId: " + instantMillionObject.getClientId() + "|Country: "
					+ instantMillionObject.getCountry() + "|Mobilenumber: " + instantMillionObject.getMobileNumber()
					+ "|costPerLine: " + instantMillionObject.getCostPerLine() + "|PSP: "
					+ instantMillionObject.getPsp() + "|Random: " + instantMillionObject.getRandom() + "|RequestIn: "
					+ instantMillionObject.getRequestIn() + "|Bonus: " + instantMillionObject.getBonus()
					+ "|SelectedNumbers: " + instantMillionObject.getGameNumbers() + "|sourceUid: "
					+ instantMillionObject.getSourceUid() + "|TransactionId: "
					+ instantMillionObject.getTransaction_id() + "|TicketId: " + instantMillionObject.getTicket_id()
					+ "|EventIds: " + instantMillionObject.getEvent_ids() + "|DrawDate: "
					+ instantMillionObject.getDraw_date() + "|UserId: " + instantMillionObject.getUser_id()
					+ "|ResponseOut: " + instantMillionObject.getResponseOut() + "|UniqueId: "
					+ instantMillionObject.getUniqueId() + "|Drawn: " + instantMillionObject.getDrawn() + "|Hit: "
					+ instantMillionObject.getHit() + "|Match: " + instantMillionObject.getGameMatch() + "|Prize: "
					+ instantMillionObject.getPrize() + "|Winnings: " + instantMillionObject.getWinnings() + "|Error: "
					+ instantMillionObject.getError() + "|Message: " + instantMillionObject.getMessage());

			return responseUtility.instantMillionResponseBuilder(instantMillionObject.getUniqueId(),
					instantMillionObject.getAgentId(), instantMillionObject.getAmount(),
					instantMillionObject.getChannelId(), instantMillionObject.getClientId(),
					instantMillionObject.getCountry(), instantMillionObject.getMobileNumber(),
					instantMillionObject.getPsp(), instantMillionObject.getCostPerLine(),
					instantMillionObject.getSourceUid(), instantMillionObject.getGameNumbers(),
					instantMillionObject.getBonus(), instantMillionObject.getTransaction_id(),
					instantMillionObject.getTicket_id(), instantMillionObject.getEvent_ids(),
					instantMillionObject.getError(), instantMillionObject.getMessage(),
					instantMillionObject.getDraw_date(), instantMillionObject.getDrawn(), instantMillionObject.getHit(),
					instantMillionObject.getGameMatch(), instantMillionObject.getPrize(),
					instantMillionObject.getWinnings(), code);

		} catch (Exception ex) {
			logger.error("instantMillionTicket :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.instantMillionResponseBuilder(0L, clientId, 99);
		}
	}

	public TicketInfoByMobileNoResponse ticketInfoByMobileNumber(String clientId, String mobileNumber, int period) {

		try {
			String urlParameters;
			LocalDate date = LocalDate.now();
			String url = configurationObject.getBaseURL() + "/tickets/read";
			if (period == 0) {
				urlParameters = "{" + "\"customer\": " + "{" + "\"MSISDN\": " + mobileNumber + "}" + "}";

			} else {
				urlParameters = "{" + "\"customer\": " + "{" + "\"MSISDN\": " + mobileNumber + "," + "\"draw_date\": "
						+ date.minusDays(period) + "}" + "}";
			}

			byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

			logger.info(url + " :: " + urlParameters);

			URL myurl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) myurl.openConnection();

			connection.setDoOutput(true);
			connection.setRequestMethod("POST");

			String userCredentials = configurationObject.getUserid() + ":" + configurationObject.getPassword();
			String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
			connection.setRequestProperty("Authorization", basicAuth);
			connection.setRequestProperty("User-Agent", "Java client");
			connection.setRequestProperty("Content-Type", "application/json");

			try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
				wr.write(postData);
			}

			StringBuilder content;

			try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
				String line;
				content = new StringBuilder();
				while ((line = br.readLine()) != null) {
					content.append(line);
				}

			}

			logger.info("ticketInfoByMobileNumber :: Response from Lottonetix :: " + content.toString());

			return responseUtility.ticketInfoByMobileResponseBuilder(clientId, content.toString(), 0);

		} catch (Exception ex) {
			logger.error("ticketInfoByMobileNumber :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.ticketInfoByMobileNoResponseBuilder(clientId, 99);
		}

	}

	public TicketInfoByTicketIdResponse ticketInfoByTicketId(String clientId, String sourceUid) {
		try {
			String url = configurationObject.getBaseURL() + "/tickets/read";
			String urlParameters = "{" + "\"customer\": " + "{" + "\"source_uid\": \"" + sourceUid + "\"" + "}" + "}";

			byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

			logger.info(url + " :: " + urlParameters);

			URL myurl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) myurl.openConnection();

			connection.setDoOutput(true);
			connection.setRequestMethod("POST");

			String userCredentials = configurationObject.getUserid() + ":" + configurationObject.getPassword();
			String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
			connection.setRequestProperty("Authorization", basicAuth);
			connection.setRequestProperty("User-Agent", "Java client");
			connection.setRequestProperty("Content-Type", "application/json");

			try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
				wr.write(postData);
			}

			StringBuilder content;

			try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
				String line;
				content = new StringBuilder();
				while ((line = br.readLine()) != null) {
					content.append(line);
				}

			}

			logger.info("Response from Lottonetix :: " + content.toString());

			String result = content.toString();
			JSONObject object = new JSONObject(result.substring(1, result.length() - 1));
			JSONObject linesObject = null;

			if (object.has("error")) {
				return responseUtility.ticketInfoByTicketIdResponseBuilder(clientId, 92);
			} else {
				String lines = object.get("lines").toString();
				linesObject = new JSONObject(lines.substring(1, lines.length() - 1));
				return responseUtility.ticketInfoByTicketIdResponseBuilder(clientId,
						linesObject.get("bonus").toString(), object.getString("draw_date"),
						object.get("event_id").toString(), linesObject.get("main").toString(),
						linesObject.get("multiplier").toString(), object.get("prodID").toString(),
						object.get("source_uid").toString(), object.get("ticket_id").toString(), 0);
			}

		} catch (Exception ex) {
			logger.error("ticketInfoByTicketId :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.ticketInfoByTicketIdResponseBuilder(clientId, 99);
		}
	}

	public EditTicketResponse editDailyTicket(String clientId, String multiplier, String bonus, String newGameNumbers,
			String sourceUid, String ticketId) {

		try {
			String url = configurationObject.getBaseURL() + "/tickets/edit";

			String urlParameters = "{" + "\"prodID\":\"201\"," + "\"transaction\": " + "{" + "\"source_uid\": \""
					+ sourceUid + "\"," + "\"ticket_id\": \"" + ticketId + "\"" + "}," + "\"lines\": " + "[" + "{"
					+ "\"multiplier\": " + multiplier + "," + "\"main\": " + newGameNumbers + "," + "\"bonus\": "
					+ bonus + "" + "}" + "]" + "}";

			byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

			logger.info(url + " :: " + urlParameters);

			URL myurl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) myurl.openConnection();

			connection.setDoOutput(true);
			connection.setRequestMethod("POST");

			String userCredentials = configurationObject.getUserid() + ":" + configurationObject.getPassword();
			String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
			connection.setRequestProperty("Authorization", basicAuth);
			connection.setRequestProperty("User-Agent", "Java client");
			connection.setRequestProperty("Content-Type", "application/json");

			try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
				wr.write(postData);
			}

			StringBuilder content;

			try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
				String line;
				content = new StringBuilder();
				while ((line = br.readLine()) != null) {
					content.append(line);
				}

			}

			logger.info("Response from Lottonetix :: " + content.toString());

			dailyHammerObject = new DailyHammerObject();
			dailyHammerObject = dailyHammerRepository.findBySourceUid(sourceUid);
			dailyHammerObject.setAgentId(dailyHammerObject.getAgentId());
			dailyHammerObject.setAmount(dailyHammerObject.getAmount());
			dailyHammerObject.setChannelId(dailyHammerObject.getChannelId());
			dailyHammerObject.setClientId(dailyHammerObject.getClientId());
			dailyHammerObject.setCountry(dailyHammerObject.getCountry());
			dailyHammerObject.setBonus(dailyHammerObject.getBonus());
			dailyHammerObject.setNewBonus(dailyHammerObject.getNewBonus());
			dailyHammerObject.setNewBonusFlag(dailyHammerObject.getNewBonusFlag());
			dailyHammerObject.setDraw_date(dailyHammerObject.getDraw_date());
			dailyHammerObject.setEvent_ids(dailyHammerObject.getEvent_ids());
			dailyHammerObject.setMobileNumber(dailyHammerObject.getMobileNumber());
			dailyHammerObject.setCostPerLine(dailyHammerObject.getCostPerLine());
			dailyHammerObject.setNewGameNumbers(newGameNumbers);
			Object gameFlag = dailyHammerObject.getNewGameNumbersFlag() != null
					? dailyHammerObject.getNewGameNumbersFlag()
					: 0;
			dailyHammerObject.setNewGameNumbersFlag(String.valueOf((Integer.valueOf(gameFlag.toString()) + 1)));
			dailyHammerObject.setPsp(dailyHammerObject.getPsp());
			dailyHammerObject.setRandom(dailyHammerObject.getRandom());
			dailyHammerObject.setRequestIn(dailyHammerObject.getRequestIn());
			dailyHammerObject.setResponseOut(LocalDateTime.now());
			dailyHammerObject.setGameNumbers(dailyHammerObject.getGameNumbers());
			dailyHammerObject.setSourceUid(dailyHammerObject.getSourceUid());
			dailyHammerObject.setTicket_id(dailyHammerObject.getTicket_id());
			dailyHammerObject.setTransaction_id(dailyHammerObject.getTransaction_id());
			dailyHammerObject.setUniqueId(dailyHammerObject.getUniqueId());
			dailyHammerObject.setUser_id(dailyHammerObject.getUser_id());
			dailyHammerRepository.save(dailyHammerObject);

			logger.info("createDailyHammerTicket :: AgentId: " + dailyHammerObject.getAgentId() + "|Amount: "
					+ dailyHammerObject.getAmount() + "|Channels: " + dailyHammerObject.getChannelId() + "|ClientId: "
					+ dailyHammerObject.getClientId() + "|Country: " + dailyHammerObject.getCountry()
					+ "|Mobilenumber: " + dailyHammerObject.getMobileNumber() + "|Multiplier: "
					+ dailyHammerObject.getCostPerLine() + "|PSP: " + dailyHammerObject.getPsp() + "|Random: "
					+ dailyHammerObject.getRandom() + "|RequestIn: " + dailyHammerObject.getRequestIn() + "|Bonus: "
					+ dailyHammerObject.getBonus() + "|SelectedNumbers: " + dailyHammerObject.getGameNumbers()
					+ "|sourceUid: " + dailyHammerObject.getSourceUid() + "|TransactionId: "
					+ dailyHammerObject.getTransaction_id() + "|TicketId: " + dailyHammerObject.getTicket_id()
					+ "|EventIds: " + dailyHammerObject.getEvent_ids() + "|DrawDate: "
					+ dailyHammerObject.getDraw_date() + "|UserId: " + dailyHammerObject.getUser_id() + "|ResponseOut: "
					+ dailyHammerObject.getResponseOut() + "|UniqueId: " + dailyHammerObject.getUniqueId()
					+ "|newGameNumbers:  " + dailyHammerObject.getNewGameNumbers() + "|newGameNumbersFlag: "
					+ Integer.valueOf(dailyHammerObject.getNewGameNumbersFlag() + 1));

			return responseUtility.editDailyTicketResponseBuilder(dailyHammerObject.getUniqueId(),
					dailyHammerObject.getAgentId(), dailyHammerObject.getAmount(), dailyHammerObject.getChannelId(),
					dailyHammerObject.getClientId(), dailyHammerObject.getCountry(),
					dailyHammerObject.getMobileNumber(), dailyHammerObject.getCostPerLine(), dailyHammerObject.getPsp(),
					dailyHammerObject.getSourceUid(), dailyHammerObject.getNewGameNumbers(),
					dailyHammerObject.getBonus(), dailyHammerObject.getTransaction_id(),
					dailyHammerObject.getTicket_id(), dailyHammerObject.getEvent_ids(),
					dailyHammerObject.getDraw_date(), 0);

		} catch (Exception ex) {
			logger.error("editDailyTicket :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.editDailyTicketResponseBuilder(0L, clientId, 99);
		}

	}
	
	public EditConsolationPrizetResponse editConsolatinPrize(String clientId, String newBonus, String gameNumbers, String sourceUid, String ticketId) {

		try {
			String url = configurationObject.getBaseURL() + "/tickets/edit";

			String urlParameters = "{" + "\"transaction\": " + "{" + "\"source_uid\": \""
					+ sourceUid + "\"," + "\"ticket_id\": \"" + ticketId + "\"" + "}," + "\"lines\": " + "[" + "{"
					+ "\"main\": " + gameNumbers + "," + "\"bonus\": "
					+ newBonus + "" + "}" + "]" + "}";

			byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

			logger.info(url + " :: " + urlParameters);

			URL myurl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) myurl.openConnection();

			connection.setDoOutput(true);
			connection.setRequestMethod("POST");

			String userCredentials = configurationObject.getUserid() + ":" + configurationObject.getPassword();
			String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
			connection.setRequestProperty("Authorization", basicAuth);
			connection.setRequestProperty("User-Agent", "Java client");
			connection.setRequestProperty("Content-Type", "application/json");

			try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
				wr.write(postData);
			}

			StringBuilder content;

			try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
				String line;
				content = new StringBuilder();
				while ((line = br.readLine()) != null) {
					content.append(line);
				}

			}

			logger.info("Response from Lottonetix :: " + content.toString());

			dailyHammerObject = new DailyHammerObject();
			dailyHammerObject = dailyHammerRepository.findBySourceUid(sourceUid);
			dailyHammerObject.setAgentId(dailyHammerObject.getAgentId());
			dailyHammerObject.setAmount(dailyHammerObject.getAmount());
			dailyHammerObject.setChannelId(dailyHammerObject.getChannelId());
			dailyHammerObject.setClientId(dailyHammerObject.getClientId());
			dailyHammerObject.setCountry(dailyHammerObject.getCountry());
			dailyHammerObject.setBonus(dailyHammerObject.getBonus());
			dailyHammerObject.setNewBonus(newBonus);
			Object bonusFlag = dailyHammerObject.getNewBonusFlag() != null
					? dailyHammerObject.getNewBonusFlag()
					: 0;
			dailyHammerObject.setNewBonusFlag(String.valueOf((Integer.valueOf(bonusFlag.toString()) + 1)));
			dailyHammerObject.setDraw_date(dailyHammerObject.getDraw_date());
			dailyHammerObject.setEvent_ids(dailyHammerObject.getEvent_ids());
			dailyHammerObject.setMobileNumber(dailyHammerObject.getMobileNumber());
			dailyHammerObject.setCostPerLine(dailyHammerObject.getCostPerLine());
			dailyHammerObject.setGameNumbers(dailyHammerObject.getGameNumbers()); 
			dailyHammerObject.setNewGameNumbers(dailyHammerObject.getGameNumbers());
			dailyHammerObject.setNewGameNumbersFlag(dailyHammerObject.getNewGameNumbersFlag());
			dailyHammerObject.setPsp(dailyHammerObject.getPsp());
			dailyHammerObject.setRandom(dailyHammerObject.getRandom());
			dailyHammerObject.setRequestIn(dailyHammerObject.getRequestIn());
			dailyHammerObject.setResponseOut(LocalDateTime.now());
			dailyHammerObject.setSourceUid(dailyHammerObject.getSourceUid());
			dailyHammerObject.setTicket_id(dailyHammerObject.getTicket_id());
			dailyHammerObject.setTransaction_id(dailyHammerObject.getTransaction_id());
			dailyHammerObject.setUniqueId(dailyHammerObject.getUniqueId());
			dailyHammerObject.setUser_id(dailyHammerObject.getUser_id());
			dailyHammerRepository.save(dailyHammerObject);

			logger.info("createDailyHammerTicket :: AgentId: " + dailyHammerObject.getAgentId() + "|Amount: "
					+ dailyHammerObject.getAmount() + "|Channels: " + dailyHammerObject.getChannelId() + "|ClientId: "
					+ dailyHammerObject.getClientId() + "|Country: " + dailyHammerObject.getCountry()
					+ "|Mobilenumber: " + dailyHammerObject.getMobileNumber() + "|Multiplier: "
					+ dailyHammerObject.getCostPerLine() + "|PSP: " + dailyHammerObject.getPsp() + "|Random: "
					+ dailyHammerObject.getRandom() + "|RequestIn: " + dailyHammerObject.getRequestIn() + "|Bonus: "
					+ dailyHammerObject.getBonus() + "|SelectedNumbers: " + dailyHammerObject.getGameNumbers()
					+ "|sourceUid: " + dailyHammerObject.getSourceUid() + "|TransactionId: "
					+ dailyHammerObject.getTransaction_id() + "|TicketId: " + dailyHammerObject.getTicket_id()
					+ "|EventIds: " + dailyHammerObject.getEvent_ids() + "|DrawDate: "
					+ dailyHammerObject.getDraw_date() + "|UserId: " + dailyHammerObject.getUser_id() + "|ResponseOut: "
					+ dailyHammerObject.getResponseOut() + "|UniqueId: " + dailyHammerObject.getUniqueId()
					+ "|newGameNumbers:  " + dailyHammerObject.getNewGameNumbers() + "|newGameNumbersFlag: "
					+ Integer.valueOf(dailyHammerObject.getNewGameNumbersFlag() + 1));

			return responseUtility.editConsolationPrizeResponseBuilder(dailyHammerObject.getUniqueId(),
					dailyHammerObject.getAgentId(), dailyHammerObject.getAmount(), dailyHammerObject.getChannelId(),
					dailyHammerObject.getClientId(), dailyHammerObject.getCountry(),
					dailyHammerObject.getMobileNumber(), dailyHammerObject.getCostPerLine(), dailyHammerObject.getPsp(),
					dailyHammerObject.getSourceUid(), dailyHammerObject.getNewGameNumbers(),
					dailyHammerObject.getBonus(), dailyHammerObject.getTransaction_id(),
					dailyHammerObject.getTicket_id(), dailyHammerObject.getEvent_ids(),
					dailyHammerObject.getDraw_date(), 0);

		} catch (Exception ex) {
			logger.error("editConsolatinPrize :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.editConsolationPrizeResponseBuilder(0L, clientId, 99);
		}

	}

}
