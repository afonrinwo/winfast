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
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winfast.model.ConfigurationObject;
import com.winfast.model.games.DailyDrawInfoObject;
import com.winfast.model.games.DailyDrawResultObject;
import com.winfast.model.games.DailyHammerObject;
import com.winfast.model.games.DrawResultResponse;
import com.winfast.repository.DailyDrawResultRepository;
import com.winfast.repository.DailyHammerRepository;
import com.winfast.repository.DailyDrawInfoRepository;
import com.winfast.utility.ResponseUtility;
import com.winfast.utility.MessageUtility;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Service
public class DailyDrawResult {

	private static Logger logger = LogManager.getLogger();
	private DailyDrawInfoObject dailyDrawInfoObject;
	private DailyDrawResultObject dailyDrawResultObject;
	private DailyHammerObject dailyHammerObject;

	@Autowired
	DailyHammerRepository dailyHammerRepository;

	@Autowired
	ConfigurationObject configurationObject;

	@Autowired
	DailyDrawInfoRepository dailyDrawInfoRepository;

	@Autowired
	DailyDrawResultRepository dailyDrawResultRepository;

	@Autowired
	ResponseUtility responseUtility;

	@Autowired
	MessageUtility smsUtility;

	public DrawResultResponse drawResult(String clientId, String eventId) {
		try {
			String url = configurationObject.getBaseURL() + "/draws/result";
			String urlParameters = "{" + "\"event_id\": \"" + eventId + "\"," + "\"page\": \" -1 \"" + "}";

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

			StringBuilder infoContent;

			try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
				String line;
				infoContent = new StringBuilder();
				while ((line = br.readLine()) != null) {
					infoContent.append(line);
				}

			}

			logger.info("Response from Lottonetix :: " + infoContent.toString());

			JSONObject object = new JSONObject(infoContent.toString());
			JSONObject drawInfoObject = new JSONObject(object.get("draw_info").toString());
			JSONObject currencyObject = new JSONObject(drawInfoObject.get("currency").toString());

			dailyDrawInfoObject = new DailyDrawInfoObject();
			dailyDrawInfoObject.setActive(drawInfoObject.get("active").toString());
			dailyDrawInfoObject.setCode(currencyObject.get("code").toString());
			dailyDrawInfoObject.setDrawId(drawInfoObject.get("draw_id").toString());
			dailyDrawInfoObject.setDrawVideo(drawInfoObject.get("draw_video").toString());
			dailyDrawInfoObject.setEntries(object.get("entries").toString());
			dailyDrawInfoObject.setEventDraw(drawInfoObject.get("event_draw").toString());
			dailyDrawInfoObject.setGameName(drawInfoObject.get("game_name").toString());
			dailyDrawInfoObject.setJackpotValue(drawInfoObject.get("jackpot_value").toString());
			dailyDrawInfoObject.setNumbersDrawn(drawInfoObject.get("numbers_drawn").toString());
			dailyDrawInfoObject.setPage(object.get("page").toString());
			dailyDrawInfoObject.setPrizeTiers(drawInfoObject.get("draw_video").toString());
			dailyDrawInfoObject.setSymbol(currencyObject.get("symbol").toString());
			dailyDrawInfoObject.setWinnings(drawInfoObject.get("winnings_processed").toString());

			if (!dailyDrawInfoRepository.existsByDrawId(drawInfoObject.get("draw_id").toString())) {
				dailyDrawInfoObject = dailyDrawInfoRepository.save(dailyDrawInfoObject);
			}

			int page = (Integer.valueOf(dailyDrawInfoObject.getEntries()) / 100) + 1;

			for (int i = 0; i < page; i++) {

				urlParameters = "{" + "\"event_id\":\"" + dailyDrawInfoObject.getDrawId() + "\"," + "\"page\": \""
						+ page + "\"," + "\"wins\": \"1\"" + "}";

				postData = urlParameters.getBytes(StandardCharsets.UTF_8);

				logger.info(url + " :: " + urlParameters);

				myurl = new URL(url);
				connection = (HttpURLConnection) myurl.openConnection();

				connection.setDoOutput(true);
				connection.setRequestMethod("POST");
				connection.setRequestProperty("Authorization", basicAuth);
				connection.setRequestProperty("User-Agent", "Java client");
				connection.setRequestProperty("Content-Type", "application/json");

				try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
					wr.write(postData);
				}

				StringBuilder ticketContent;

				try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
					String line;
					ticketContent = new StringBuilder();
					while ((line = br.readLine()) != null) {
						ticketContent.append(line);
					}

				}

				logger.info("Response from Lottonetix :: " + ticketContent.toString());
				JSONObject ticketObject = new JSONObject(ticketContent.toString());
				JSONArray jsonArray = (JSONArray) ticketObject.get("tickets_list");
				Iterator<Object> iterator = jsonArray.iterator();
				while (iterator.hasNext()) {
					Object element = iterator.next();
					JSONObject resultObject = new JSONObject(element.toString());

					String lines = resultObject.get("lines").toString();
					JSONObject linesObject = new JSONObject(lines.substring(1, lines.length() - 1));

					String result = resultObject.get("result").toString();
					JSONObject rstObject = new JSONObject(result.substring(1, result.length() - 1));

					dailyDrawResultObject = new DailyDrawResultObject();
					dailyDrawResultObject.setBonus(linesObject.get("bonus").toString());
					dailyDrawResultObject.setDrawn(rstObject.get("drawn").toString());
					dailyDrawResultObject.setHits(rstObject.get("hits").toString());
					dailyDrawResultObject.setLine(rstObject.get("line").toString());
					dailyDrawResultObject.setMain(linesObject.get("main").toString());
					dailyDrawResultObject.setWinings(rstObject.get("match").toString());
					dailyDrawResultObject.setMsisdn(resultObject.get("MSISDN").toString());
					dailyDrawResultObject.setMultiplier(linesObject.get("multiplier").toString());
					dailyDrawResultObject.setPrize(rstObject.get("prize").toString());
					dailyDrawResultObject.setSourceUid(resultObject.get("source_uid").toString());
					dailyDrawResultObject.setTicketId(resultObject.get("ticket_id").toString());
					dailyDrawResultObject.setUserId(resultObject.get("userID").toString());
					dailyDrawResultObject = dailyDrawResultRepository.save(dailyDrawResultObject);

					// get winners network
					dailyHammerObject = new DailyHammerObject();
					dailyHammerObject = dailyHammerRepository.findByMobileNumber(dailyDrawResultObject.getMsisdn());
					if (Integer.valueOf(dailyDrawResultObject.getHits()) > 2) {
						
					// send SMS to winner
					smsUtility.sendsms(clientId, dailyHammerObject.getMobileNetwork(), dailyDrawResultObject.getMsisdn(),
							"Congratulations! You won NGN " + dailyDrawResultObject.getPrize()
									+ " in the winfast Lotto you played on " + dailyDrawResultObject.getDrawn(), LocalDateTime.now());
					}
				}

			}

			return responseUtility.drawResultResponseBuilder(clientId, 0);

		} catch (Exception ex) {
			logger.error("drawResult" + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return responseUtility.drawResultResponseBuilder(clientId, 99);
		}
	}

	public DrawResultResponse consolationDrawResult(String clientId, String eventId) {
		try {
			String url = configurationObject.getBaseURL() + "/draws/result";
			String urlParameters = "{" + "\"event_id\":\"" + eventId + "\"," + "\"wins\": \" 1 \"" + "}";

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

			StringBuilder infoContent;

			try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
				String line;
				infoContent = new StringBuilder();
				while ((line = br.readLine()) != null) {
					infoContent.append(line);
				}

			}

			logger.info("Response from Lottonetix :: " + infoContent.toString());

			JSONObject object = new JSONObject(infoContent.toString());
			JSONObject drawInfoObject = new JSONObject(object.get("draw_info").toString());
			JSONObject currencyObject = new JSONObject(drawInfoObject.get("currency").toString());

			dailyDrawInfoObject = new DailyDrawInfoObject();
			dailyDrawInfoObject.setActive(drawInfoObject.get("active").toString());
			dailyDrawInfoObject.setCode(currencyObject.get("code").toString());
			dailyDrawInfoObject.setDrawId(drawInfoObject.get("draw_id").toString());
			dailyDrawInfoObject.setDrawVideo(drawInfoObject.get("draw_video").toString());
			dailyDrawInfoObject.setEntries(object.get("entries").toString());
			dailyDrawInfoObject.setEventDraw(drawInfoObject.get("event_draw").toString());
			dailyDrawInfoObject.setGameName(drawInfoObject.get("game_name").toString());
			dailyDrawInfoObject.setJackpotValue(drawInfoObject.get("jackpot_value").toString());
			dailyDrawInfoObject.setNumbersDrawn(drawInfoObject.get("numbers_drawn").toString());
			dailyDrawInfoObject.setPage(object.get("page").toString());
			dailyDrawInfoObject.setPrizeTiers(drawInfoObject.get("draw_video").toString());
			dailyDrawInfoObject.setSymbol(currencyObject.get("symbol").toString());
			dailyDrawInfoObject.setWinnings(drawInfoObject.get("winnings_processed").toString());

			if (!dailyDrawInfoRepository.existsByDrawId(drawInfoObject.get("draw_id").toString())) {
				dailyDrawInfoObject = dailyDrawInfoRepository.save(dailyDrawInfoObject);
			}

			int page = (Integer.valueOf(dailyDrawInfoObject.getEntries()) / 100) + 1;

			for (int i = 0; i < page; i++) {

				urlParameters = "{" + "\"event_id\":\"" + dailyDrawInfoObject.getDrawId() + "\"," + "\"page\": \""
						+ page + "\"," + "\"wins\": \"1\"" + "}";

				postData = urlParameters.getBytes(StandardCharsets.UTF_8);

				logger.info(url + " :: " + urlParameters);

				myurl = new URL(url);
				connection = (HttpURLConnection) myurl.openConnection();

				connection.setDoOutput(true);
				connection.setRequestMethod("POST");
				connection.setRequestProperty("Authorization", basicAuth);
				connection.setRequestProperty("User-Agent", "Java client");
				connection.setRequestProperty("Content-Type", "application/json");

				try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
					wr.write(postData);
				}

				StringBuilder ticketContent;

				try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
					String line;
					ticketContent = new StringBuilder();
					while ((line = br.readLine()) != null) {
						ticketContent.append(line);
					}

				}

				logger.info("Response from Lottonetix :: " + ticketContent.toString());
				JSONObject ticketObject = new JSONObject(ticketContent.toString());
				JSONArray jsonArray = (JSONArray) ticketObject.get("tickets_list");
				Iterator<Object> iterator = jsonArray.iterator();
				while (iterator.hasNext()) {
					Object element = iterator.next();
					JSONObject resultObject = new JSONObject(element.toString());

					String lines = resultObject.get("lines").toString();
					JSONObject linesObject = new JSONObject(lines.substring(1, lines.length() - 1));

					String result = resultObject.get("result").toString();
					JSONObject rstObject = new JSONObject(result.substring(1, result.length() - 1));

					dailyDrawResultObject = new DailyDrawResultObject();
					dailyDrawResultObject.setBonus(linesObject.get("bonus").toString());
					dailyDrawResultObject.setDrawn(rstObject.get("drawn").toString());
					dailyDrawResultObject.setHits(rstObject.get("hits").toString());
					dailyDrawResultObject.setLine(rstObject.get("line").toString());
					dailyDrawResultObject.setMain(linesObject.get("main").toString());
					dailyDrawResultObject.setWinings(rstObject.get("match").toString());
					dailyDrawResultObject.setMsisdn(resultObject.get("MSISDN").toString());
					dailyDrawResultObject.setMultiplier(linesObject.get("multiplier").toString());
					dailyDrawResultObject.setPrize(rstObject.get("prize").toString());
					dailyDrawResultObject.setSourceUid(resultObject.get("source_uid").toString());
					dailyDrawResultObject.setTicketId(resultObject.get("ticket_id").toString());
					dailyDrawResultObject.setUserId(resultObject.get("userID").toString());
					dailyDrawResultObject = dailyDrawResultRepository.save(dailyDrawResultObject);

					// get winners network
					dailyHammerObject = new DailyHammerObject();
					dailyHammerObject = dailyHammerRepository.findByMobileNumber(dailyDrawResultObject.getMsisdn());

					// send SMS for consolation prize to winner
					smsUtility.sendsms(clientId, dailyHammerObject.getMobileNetwork(), dailyDrawResultObject.getMsisdn(),
							"Congratulations! You won consolation price of NGN " + dailyDrawResultObject.getPrize()
									+ " in the winfast Lotto you played on " + dailyDrawResultObject.getDrawn(), LocalDateTime.now());

				}

			}

			return responseUtility.drawResultResponseBuilder(clientId, 0);

		} catch (Exception ex) {
			logger.error("drawResult" + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return responseUtility.drawResultResponseBuilder(clientId, 99);
		}
	}

}
