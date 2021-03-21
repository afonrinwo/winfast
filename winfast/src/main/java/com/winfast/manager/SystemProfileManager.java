/**
 * 
 */
package com.winfast.manager;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.winfast.model.Response;
import com.winfast.model.profile.ProfileActivityLogObject;
import com.winfast.model.profile.system.SystemProfileObject;
import com.winfast.model.profile.system.SystemProfileRequest;
import com.winfast.repository.PasswordProfileRepository;
import com.winfast.repository.SystemProfileRepository;
import com.winfast.repository.ProfileActivityRepository;
import com.winfast.repository.UserProfileRepository;
import com.winfast.utility.AuthenticationUtility;
import com.winfast.utility.ResponseUtility;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Service
public class SystemProfileManager {

	private final Logger logger = LogManager.getLogger();
	private SystemProfileObject systemProfileObject;
	private ProfileActivityLogObject profileActivityLogObject;
	private ProfileActivityRepository profileActivityRepository;
	private Iterable<SystemProfileObject> iSystemProfileObject;

	@Autowired
	PlatformTransactionManager platformTransactionManager;

	@Autowired
	SystemProfileRepository systemProfileRepository;

	@Autowired
	UserProfileRepository userProfileRepository;

	@Autowired
	PasswordProfileRepository passwordProfileRepository;

	@Autowired
	ResponseUtility responseUtility;

	@Autowired
	AuthenticationUtility authenticationUtility;

	public Response createSystemProfile(String appId, SystemProfileRequest systemProfileRequest) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);

		try {
			profileActivityLogObject = new ProfileActivityLogObject();
			profileActivityLogObject.setAppId(appId);
			profileActivityLogObject.setAppKey(systemProfileRequest.getAppKey());
			profileActivityLogObject.setClientId(systemProfileRequest.getClientId());
			profileActivityLogObject.setRequestType("createSystemProfle");
			profileActivityLogObject.setStatus(0);
			profileActivityLogObject.setRequestIn(LocalDateTime.now());
			profileActivityLogObject = profileActivityRepository.save(profileActivityLogObject);

			String appKey = authenticationUtility.base64Encode(systemProfileRequest.getAppKey());
			systemProfileObject = new SystemProfileObject();
			systemProfileObject.setAppId(systemProfileRequest.getAppId());
			systemProfileObject.setAppKey(appKey);
			systemProfileObject.setClientId(systemProfileRequest.getClientId());
			systemProfileObject.setDateCreated(LocalDateTime.now().toString());
			systemProfileObject.setServerIp(systemProfileRequest.getServerIp());
			systemProfileObject.setStatus(0);
			systemProfileObject = systemProfileRepository.save(systemProfileObject);

			platformTransactionManager.commit(transactionStatus);

			return responseUtility.responseBuilder(systemProfileObject.getUniqueId(),
					systemProfileRequest.getClientId(), 0);
		} catch (Exception ex) {
			logger.error("createSystemProfle :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			platformTransactionManager.rollback(transactionStatus);
			return responseUtility.responseBuilder(0L, systemProfileRequest.getClientId(), 99);
		}
	}

	public Response activateSystemProfle(String appId, SystemProfileRequest systemProfileRequest) {

		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);

		try {

			profileActivityLogObject = new ProfileActivityLogObject();
			profileActivityLogObject.setAppId(appId);
			profileActivityLogObject.setAppKey(systemProfileRequest.getAppKey());
			profileActivityLogObject.setClientId(systemProfileRequest.getClientId());
			profileActivityLogObject.setRequestType("activateSystemProfle");
			profileActivityLogObject.setStatus(1);
			profileActivityLogObject.setRequestIn(LocalDateTime.now());
			profileActivityLogObject = profileActivityRepository.save(profileActivityLogObject);

			systemProfileObject = new SystemProfileObject();
			systemProfileObject = systemProfileRepository.findByAppId(systemProfileRequest.getAppId());
			systemProfileObject.setAppId(systemProfileObject.getAppId());
			systemProfileObject.setAppKey(systemProfileObject.getAppKey());
			systemProfileObject.setClientId(systemProfileObject.getClientId());
			systemProfileObject.setDateCreated(systemProfileObject.getDateCreated());
			systemProfileObject.setDateApproved(LocalDateTime.now().toString());
			systemProfileObject.setServerIp(systemProfileObject.getServerIp());
			systemProfileObject.setStatus(1);
			systemProfileObject = systemProfileRepository.save(systemProfileObject);

			platformTransactionManager.commit(transactionStatus);

			return responseUtility.responseBuilder(systemProfileObject.getUniqueId(),
					systemProfileRequest.getClientId(), 0);
		} catch (Exception ex) {
			logger.error("createSystemProfle :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			platformTransactionManager.rollback(transactionStatus);
			return responseUtility.responseBuilder(0L, systemProfileRequest.getClientId(), 99);
		}
	}

	public Iterable<SystemProfileObject> listSystemProfile(int status) {
		try {
			iSystemProfileObject = new ArrayList<>();
			iSystemProfileObject = systemProfileRepository.findByStatus(status);
		} catch (Exception ex) {
			iSystemProfileObject = new ArrayList<>();
			iSystemProfileObject.forEach(null);
		}
		return iSystemProfileObject;
	}

}
