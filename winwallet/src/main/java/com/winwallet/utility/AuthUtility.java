/**
 * 
 */
package com.winwallet.utility;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Base64;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winwallet.model.system.SystemProfileObject;
import com.winwallet.repository.SystemProfileRepository;


/**
 * @author Emmanuel Afonrinwo
 *
 */
@Service
public class AuthUtility {
	
	private Logger logger = LogManager.getLogger();
	private SystemProfileObject systemProfileObject;
	
	@Autowired
	SystemProfileRepository systemProfileRepository;

	public boolean accessValidation(String header, String header2) {
		try {
			systemProfileObject = new SystemProfileObject();
			systemProfileObject = systemProfileRepository.findByAppId(header2);
			if (header.replace("Basic ", "").equals(base64Encode(header2 + ":" + systemProfileObject.getAppKey()))) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return false;
		}
	}

	// Base64 Basic Decoding
	public String base64Decode(String value) {
		return new String(Base64.getDecoder().decode(value));
	}

	// Base64 Basic Encoding
	public String base64Encode(String value) {
		return Base64.getEncoder().encodeToString(value.getBytes());
	}
	
	public String encryptString(String key, String userName) {
		String hashtext = null;

		try {
			// getInstance() method is called with algorithm SHA-512
			MessageDigest md = MessageDigest.getInstance("SHA-512");

			// digest() method is called
			// to calculate message digest of the input string
			// returned as array of byte
			byte[] messageDigest = md.digest(key.concat(userName).getBytes());

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
