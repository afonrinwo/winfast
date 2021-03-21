/**
 * 
 */
package com.winwallet.utility;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winwallet.model.ConfigurationObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Service
public class SMSUtility {
	
	private Logger logger = LogManager.getLogger();
	
	@Autowired
	ConfigurationObject configurationObject;

	
	public void sendsms(String network, String msisdn, String message) {

		try {
			String url = configurationObject.getSmsURL();
			String urlParameters = "{" + "\"network\": \"" + network + "\","
					+ "\"msisdn\" : \"" + msisdn + "\","
					+ "\"message\" : \"" + message + ""
					+ "}";

			byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

			logger.info(url + " :: " + urlParameters);

			URL myurl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) myurl.openConnection();

			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("User-Agent", "Java client");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Username", configurationObject.getSmsUserId());
			connection.setRequestProperty("Password", configurationObject.getSmsPassword());
			connection.setRequestProperty("hash", configurationObject.getSmsHash());

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

			logger.info("sendsms :: Response from Lottonetix :: " + content.toString());

		} catch (Exception ex) {
			logger.error("sendsms :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
		}

	}

}
