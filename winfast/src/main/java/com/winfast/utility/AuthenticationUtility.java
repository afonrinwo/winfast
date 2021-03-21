/**
 * 
 */
package com.winfast.utility;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winfast.model.profile.system.SystemProfileObject;
import com.winfast.repository.SystemProfileRepository;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Service
public class AuthenticationUtility {
	
	private final Logger logger = LogManager.getLogger();
	private SystemProfileObject systemProfileObject;
	
	@Autowired
	SystemProfileRepository systemProfileRepository;

	// Base64 Basic Encoding
	public String base64Encode(String value) {
		return Base64.getEncoder().encodeToString(value.getBytes());
	}

	// Access Validation Encoding 1 parameter
	public String accessValidation(String secretKey) {
		return base64Encode(secretKey);
	}

	// Access Validation Encoding 2 parameters
	public boolean accessValidation(String authorization, String appId) {
		try {
			systemProfileObject = new SystemProfileObject();
			systemProfileObject = systemProfileRepository.findByAppId(appId);
			if (authorization.replace("Basic ", "")
					.equals(base64Encode(appId + ":" + systemProfileObject.getAppKey()))) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return false;
		}
	}
	
	public String getRandomAlphabet() {
		Random r = new Random();
		return String.valueOf((char) (r.nextInt(26) + 'a')) + String.valueOf((char) (r.nextInt(26) + 'a'));
	}

	public ArrayList<Integer> getRandomNumbers() {

		ArrayList<Integer> list = null;
		ArrayList<Integer> checkList = null;
		Random random = new Random();
		list = new ArrayList<Integer>(6);
		do {
			for (int i = 0; i < 6; i++) {
				list.add(random.nextInt(59) + 1);
			}
			checkList = new ArrayList<Integer>(6);
			for (Integer i : list) {
				if (checkList.contains(i)) {
					checkList.add(0);
				} else {
					checkList.add(i);
				}
			}

		} while (checkList.contains(0));

		return list;
	}
	
	public String encryptString(String password) {
		String hashtext = null;

		try {
			// getInstance() method is called with algorithm SHA-512
			MessageDigest md = MessageDigest.getInstance("SHA-512");

			// digest() method is called
			// to calculate message digest of the input string
			// returned as array of byte
			byte[] messageDigest = md.digest(password.getBytes());

			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);

			// Convert message digest into hex value
			hashtext = no.toString(16);

			// Add preceding 0s to make it 32 bit
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}

			// For specifying wrong message digest algorithms
		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			hashtext = "0";
		}
		return hashtext;
	}

}
