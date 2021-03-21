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
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.winwallet.model.ConfigurationObject;
import com.winwallet.model.Response;
import com.winwallet.model.utility.EmailObject;
import com.winwallet.model.utility.SMSObject;
import com.winwallet.repository.EmailRepository;
import com.winwallet.repository.SMSRepository;


/**
 * @author Emmanuel Afonrinwo
 *
 */
@Service
public class MessageUtility {

	private Logger logger = LogManager.getLogger();
	private SMSObject smsObject;
	private EmailObject emailObject;

	@Autowired
	JavaMailSender mailSender;

	@Autowired
	ConfigurationObject configurationObject;

	@Autowired
	ResponseUtility responseUtility;
	
	@Autowired
	SMSRepository smsRepository;
	
	@Autowired
	EmailRepository emailRepository;

	public Response sendsms(String clientId, String network, String msisdn, String message, LocalDateTime requestIn) {

		try {
			String url = configurationObject.getSmsURL();
			String urlParameters = "{" + "\"network\": \"" + network + "\"," + "\"msisdn\" : \"" + msisdn + "\","
					+ "\"message\" : \"" + message + "" + "}";

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

			logger.info("sendsms :: Response from Cloud SMS Gateway :: ClientId : " + clientId + " | Network : "
					+ network + " |MSISDN : " + msisdn + " |Message : " + message + " |TimeIn : " + requestIn
					+ " |Status : " + content.toString());
			
			smsObject = new SMSObject();
			smsObject.setClientId(clientId);
			smsObject.setMessage(message);
			smsObject.setMsisdn(msisdn);
			smsObject.setNetwork(network);
			smsObject.setRequestIn(requestIn);
			smsObject.setResponseOut(LocalDateTime.now());
			smsObject.setStatus(content.toString());
			smsObject = smsRepository.save(smsObject);
			
			return responseUtility.response(smsObject.getUniqueId(), clientId, 0);

		} catch (Exception ex) {
			logger.error("sendsms :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return responseUtility.response(0L, clientId, 99);
		}

	}
	
	/**
	 * This method will send compose and send the message
	 * @return 
	 */
	public Response sendMail(String clientId, String appId, String from, String to, String subject, String body, LocalDateTime requestIn) {
		
		try {	
			
			emailObject = new EmailObject();
			emailObject.setAppId(appId);
			emailObject.setClientId(clientId);
			emailObject.setBody(body);
			emailObject.setClientId(clientId);
			emailObject.setSource(from);
			emailObject.setRequestIn(requestIn);
			emailObject.setSubject(subject);
			emailObject.setDestination(to);
			
			emailObject = emailRepository.save(emailObject);
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(emailObject.getSource());
			message.setTo(emailObject.getDestination());
			message.setSubject(emailObject.getSubject());
			message.setText(emailObject.getBody());
			mailSender.send(message);
			
			logger.info("sendMail :: Response from Cloud SMTP Gateway :: ClientId : " + clientId + " | Sender : "
					+ from + " |Destination : " + to + " |Subject : " + subject + " |Body : " + body + " |TimeIn : " + requestIn);
			
			return responseUtility.response(emailObject.getUniqueId(), clientId, 0);
			
		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return responseUtility.response(emailObject.getUniqueId(), clientId, 99);
		}
	}

}
