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
import com.winfast.model.profile.user.ActivateUserProfileRequest;
import com.winfast.model.profile.user.ChangeUserPasswordRequest;
import com.winfast.model.profile.user.DisableUserProfileRequest;
import com.winfast.model.profile.user.UserPasswordProfileObject;
import com.winfast.model.profile.user.ResetUserPasswordRequest;
import com.winfast.model.profile.user.UserProfileObject;
import com.winfast.model.profile.user.UserProfileRequest;
import com.winfast.repository.PasswordProfileRepository;
import com.winfast.repository.ProfileActivityRepository;
import com.winfast.repository.SystemProfileRepository;
import com.winfast.repository.UserProfileRepository;
import com.winfast.utility.AuthenticationUtility;
import com.winfast.utility.ResponseUtility;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Service
public class UserProfileManager {
	
	private final Logger logger = LogManager.getLogger();
	private ProfileActivityLogObject profileActivityLogObject;
	private UserProfileObject userProfileObject;
	private UserPasswordProfileObject userPasswordProfileObject;
	private ProfileActivityRepository profileActivityRepository;
	private Iterable<UserProfileObject> iUserProfileObject;

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
	
	
	public Iterable<UserProfileObject> listUserProfile(int status) {
		try {
			iUserProfileObject = new ArrayList<>();
			iUserProfileObject = userProfileRepository.findByStatus(status);
		} catch (Exception ex) {
			iUserProfileObject = new ArrayList<>();
			iUserProfileObject.forEach(null);
		}
		return iUserProfileObject;
	}
	
	public Iterable<UserProfileObject> listUserProfile() {
		try {
			iUserProfileObject = new ArrayList<>();
			iUserProfileObject = userProfileRepository.findAll();
		} catch (Exception ex) {
			iUserProfileObject = new ArrayList<>();
			iUserProfileObject.forEach(null);
		}
		return iUserProfileObject;
	}

	public Response createUserProfile(String appId, UserProfileRequest userProfileRequest) {

		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);

		try {
			profileActivityLogObject = new ProfileActivityLogObject();
			profileActivityLogObject.setAppId(appId);
			profileActivityLogObject.setClientId(userProfileRequest.getClientId());
			profileActivityLogObject.setDepartment(userProfileRequest.getDepartment());
			profileActivityLogObject.setFirstName(userProfileRequest.getFirstName());
			profileActivityLogObject.setLastName(userProfileRequest.getLastName());
			profileActivityLogObject.setRequestType("createUserProfle");
			profileActivityLogObject.setRequestIn(LocalDateTime.now());
			profileActivityLogObject.setUserName(userProfileRequest.getFirstName() + "." + userProfileRequest.getLastName());
			profileActivityLogObject.setUserRole(userProfileRequest.getUserRole());
			profileActivityLogObject = profileActivityRepository.save(profileActivityLogObject);

			userProfileObject = new UserProfileObject();
			userProfileObject.setAppId(profileActivityLogObject.getAppId());
			userProfileObject.setClientId(profileActivityLogObject.getClientId());
			userProfileObject.setDepartment(profileActivityLogObject.getDepartment());
			userProfileObject.setFirstName(profileActivityLogObject.getFirstName());
			userProfileObject.setLastName(profileActivityLogObject.getLastName());
			userProfileObject.setRequestTime(LocalDateTime.now());
			userProfileObject.setUserName(profileActivityLogObject.getUserName());
			userProfileObject.setUserRole(profileActivityLogObject.getUserRole());
			userProfileObject.setStatus(0);
			userProfileObject = userProfileRepository.save(userProfileObject);

			userPasswordProfileObject = new UserPasswordProfileObject();
			userPasswordProfileObject.setChangeCount(0);
			String password = authenticationUtility.encryptString(userProfileObject.getUserName());
			userPasswordProfileObject.setPassword(password);
			userPasswordProfileObject.setDateCreated(LocalDateTime.now());
			userPasswordProfileObject.setNewPassword(password);
			userPasswordProfileObject.setLastUpdated(LocalDateTime.now());
			userPasswordProfileObject.setUniqueId(userProfileObject.getUniqueId());
			userPasswordProfileObject.setUserName(userProfileObject.getUserName());
			userPasswordProfileObject = passwordProfileRepository.save(userPasswordProfileObject);

			platformTransactionManager.commit(transactionStatus);

			return responseUtility.responseBuilder(profileActivityLogObject.getUniqueId(), userProfileRequest.getClientId(), 0);

		} catch (Exception ex) {
			logger.error("createUserProfile :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			platformTransactionManager.rollback(transactionStatus);
			return responseUtility.responseBuilder(0L, userProfileRequest.getClientId(), 99);
		}
	}

	public Response disableUserProfile(String appId, DisableUserProfileRequest disableUserProfileRequest, LocalDateTime requestIn) {

		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
		try {
			profileActivityLogObject = new ProfileActivityLogObject();
			profileActivityLogObject.setAppId(appId);
			profileActivityLogObject.setClientId(disableUserProfileRequest.getClientId());
			profileActivityLogObject.setRequestType("disableUserProfile");
			profileActivityLogObject.setRequestIn(LocalDateTime.now());
			profileActivityLogObject.setUserName(disableUserProfileRequest.getUserName());
			profileActivityLogObject = profileActivityRepository.save(profileActivityLogObject);

			userProfileObject = new UserProfileObject();
			if ((userProfileRepository.findByUserName(disableUserProfileRequest.getUserName())) == null) {
				logger.info("disableUserProfile" + disableUserProfileRequest.getUserName()
						+ " is not a user on the platform");
				platformTransactionManager.commit(transactionStatus);
				return responseUtility.responseBuilder(profileActivityLogObject.getUniqueId(),
						disableUserProfileRequest.getClientId(), 39);

			} else {
				userProfileObject.setAppId(userProfileObject.getAppId());
				userProfileObject.setClientId(userProfileObject.getClientId());
				userProfileObject.setDepartment(userProfileObject.getDepartment());
				userProfileObject.setFirstName(userProfileObject.getFirstName());
				userProfileObject.setLastName(userProfileObject.getLastName());
				userProfileObject.setRequestTime(requestIn);
				userProfileObject.setUserName(userProfileObject.getUserName());
				userProfileObject.setUserRole(userProfileObject.getUserRole());
				userProfileObject.setStatus(0);
				userProfileObject = userProfileRepository.save(userProfileObject);

				platformTransactionManager.commit(transactionStatus);
				return responseUtility.responseBuilder(profileActivityLogObject.getUniqueId(),
						disableUserProfileRequest.getClientId(), 0);
			}

		} catch (Exception ex) {
			logger.error("disableUserProfile :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			platformTransactionManager.rollback(transactionStatus);
			return responseUtility.responseBuilder(0L, disableUserProfileRequest.getClientId(), 99);
		}
	}

	public Response activateUserProfile(String appId, ActivateUserProfileRequest activateUserProfileRequest, LocalDateTime requestIn) {

		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
		try {
			profileActivityLogObject = new ProfileActivityLogObject();
			profileActivityLogObject.setAppId(appId);
			profileActivityLogObject.setClientId(activateUserProfileRequest.getClientId());
			profileActivityLogObject.setRequestType("activateUserProfile");
			profileActivityLogObject.setRequestIn(requestIn);
			profileActivityLogObject.setUserName(activateUserProfileRequest.getUserName());
			profileActivityLogObject = profileActivityRepository.save(profileActivityLogObject);

			userProfileObject = new UserProfileObject();
			if ((userProfileRepository.findByUserName(activateUserProfileRequest.getUserName())) == null) {
				logger.info("activateUserProfile" + activateUserProfileRequest.getUserName()
						+ " is not a user on the platform");
				platformTransactionManager.commit(transactionStatus);
				return responseUtility.responseBuilder(profileActivityLogObject.getUniqueId(),
						activateUserProfileRequest.getClientId(), 39);

			} else {
				userProfileObject.setAppId(userProfileObject.getAppId());
				userProfileObject.setClientId(userProfileObject.getClientId());
				userProfileObject.setDepartment(userProfileObject.getDepartment());
				userProfileObject.setFirstName(userProfileObject.getFirstName());
				userProfileObject.setLastName(userProfileObject.getLastName());
				userProfileObject.setRequestTime(LocalDateTime.now());
				userProfileObject.setUserName(userProfileObject.getUserName());
				userProfileObject.setUserRole(userProfileObject.getUserRole());
				userProfileObject.setStatus(1);
				userProfileObject = userProfileRepository.save(userProfileObject);

				platformTransactionManager.commit(transactionStatus);
				return responseUtility.responseBuilder(profileActivityLogObject.getUniqueId(),
						activateUserProfileRequest.getClientId(), 0);
			}

		} catch (Exception ex) {
			logger.error("activateUserProfile :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			platformTransactionManager.rollback(transactionStatus);
			return responseUtility.responseBuilder(0L, activateUserProfileRequest.getClientId(), 99);
		}
	}

	public Response changeUserPassword(String appId, ChangeUserPasswordRequest changeUserPasswordRequest, LocalDateTime requestIn) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
		try {
			profileActivityLogObject = new ProfileActivityLogObject();
			profileActivityLogObject.setAppId(appId);
			profileActivityLogObject.setClientId(changeUserPasswordRequest.getClientId());
			profileActivityLogObject.setNewPassword(changeUserPasswordRequest.getNewPassword());
			profileActivityLogObject.setPassword(changeUserPasswordRequest.getPassword());
			profileActivityLogObject.setRequestType("changePassword");
			profileActivityLogObject.setRequestIn(requestIn);
			profileActivityLogObject.setUserName(changeUserPasswordRequest.getUserName());
			profileActivityLogObject = profileActivityRepository.save(profileActivityLogObject);

			userPasswordProfileObject = new UserPasswordProfileObject();
			if ((passwordProfileRepository.findByUserName(changeUserPasswordRequest.getUserName())) == null) {
				logger.info("changePassword" + changeUserPasswordRequest.getUserName() + " is not a user on the platform");
				platformTransactionManager.commit(transactionStatus);
				return responseUtility.responseBuilder(profileActivityLogObject.getUniqueId(), changeUserPasswordRequest.getClientId(),
						39);

			} else {
				userPasswordProfileObject.setChangeCount(userPasswordProfileObject.getChangeCount() + 1);
				userPasswordProfileObject.setNewPassword(changeUserPasswordRequest.getNewPassword());
				userPasswordProfileObject.setDateCreated(userPasswordProfileObject.getDateCreated());
				userPasswordProfileObject.setPassword(userPasswordProfileObject.getPassword());
				userPasswordProfileObject.setLastUpdated(LocalDateTime.now());
				userPasswordProfileObject.setUserName(userPasswordProfileObject.getUserName());
				userPasswordProfileObject = passwordProfileRepository.save(userPasswordProfileObject);

				platformTransactionManager.commit(transactionStatus);
				return responseUtility.responseBuilder(profileActivityLogObject.getUniqueId(), changeUserPasswordRequest.getClientId(),
						0);
			}

		} catch (Exception ex) {
			logger.error("changePassword :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			platformTransactionManager.rollback(transactionStatus);
			return responseUtility.responseBuilder(0L, changeUserPasswordRequest.getClientId(), 99);
		}
	}

	public Response resetUserPassword(String appId, ResetUserPasswordRequest resetUserPasswordRequest, LocalDateTime requestIn) {
		
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
		
		try {
			profileActivityLogObject = new ProfileActivityLogObject();
			profileActivityLogObject.setAppId(appId);
			profileActivityLogObject.setClientId(resetUserPasswordRequest.getClientId());
			profileActivityLogObject.setRequestType("resetPassword");
			profileActivityLogObject.setRequestIn(requestIn);
			profileActivityLogObject.setUserName(resetUserPasswordRequest.getUserName());
			profileActivityLogObject = profileActivityRepository.save(profileActivityLogObject);

			userPasswordProfileObject = new UserPasswordProfileObject();
			if ((passwordProfileRepository.findByUserName(resetUserPasswordRequest.getUserName())) == null) {
				logger.info("changePassword" + resetUserPasswordRequest.getUserName() + " is not a user on the platform");
				platformTransactionManager.commit(transactionStatus);
				return responseUtility.responseBuilder(profileActivityLogObject.getUniqueId(), resetUserPasswordRequest.getClientId(),
						39);

			} else {
				
				userPasswordProfileObject.setChangeCount(userPasswordProfileObject.getChangeCount() + 1);
				String password = authenticationUtility.encryptString(userPasswordProfileObject.getUserName());
				userPasswordProfileObject.setNewPassword(password);
				userPasswordProfileObject.setDateCreated(userPasswordProfileObject.getDateCreated());
				userPasswordProfileObject.setPassword(userPasswordProfileObject.getPassword());
				userPasswordProfileObject.setLastUpdated(LocalDateTime.now());
				userPasswordProfileObject.setUniqueId(userPasswordProfileObject.getUniqueId());
				userPasswordProfileObject.setUserName(userPasswordProfileObject.getUserName());
				userPasswordProfileObject = passwordProfileRepository.save(userPasswordProfileObject);

				platformTransactionManager.commit(transactionStatus);
				return responseUtility.responseBuilder(profileActivityLogObject.getUniqueId(), resetUserPasswordRequest.getClientId(),
						0);
			}

		} catch (Exception ex) {
			logger.error("changePassword :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			platformTransactionManager.rollback(transactionStatus);
			return responseUtility.responseBuilder(0L, resetUserPasswordRequest.getClientId(), 99);
		}
	}

}
