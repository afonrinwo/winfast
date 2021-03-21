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
import com.winfast.model.profile.game.ActivateGameProfileRequest;
import com.winfast.model.profile.game.ChangeGamePasswordRequest;
import com.winfast.model.profile.game.DisableGameProfileRequest;
import com.winfast.model.profile.game.GameMiniProfileRequest;
import com.winfast.model.profile.game.GamePasswordProfileObject;
import com.winfast.model.profile.game.GameProfileObject;
import com.winfast.model.profile.game.GameProfileRequest;
import com.winfast.model.profile.game.ResetGamePasswordRequest;
import com.winfast.repository.GamePasswordProfileRepository;
import com.winfast.repository.GameProfileRepository;
import com.winfast.repository.ProfileActivityRepository;
import com.winfast.utility.AuthenticationUtility;
import com.winfast.utility.MessageUtility;
import com.winfast.utility.ResponseUtility;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Service
public class GameProfileManager {

	private final Logger logger = LogManager.getLogger();
	private ProfileActivityLogObject profileActivityLogObject;
	private GameProfileObject gameProfileObject;
	private Iterable<GameProfileObject> iGameProfileObject;
	private GamePasswordProfileObject gamePasswordProfileObject;

	@Autowired
	PlatformTransactionManager platformTransactionManager;

	@Autowired
	ResponseUtility responseUtility;

	@Autowired
	ProfileActivityRepository profileActivityRepository;

	@Autowired
	GameProfileRepository gameProfileRepository;

	@Autowired
	AuthenticationUtility authenticationUtility;

	@Autowired
	GamePasswordProfileRepository gamePasswordProfileRepository;

	@Autowired
	MessageUtility messageUtility;

	public Response createGameProfile(GameProfileRequest gameProfileRequest, String appId, LocalDateTime requestIn) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
		try {
			profileActivityLogObject = new ProfileActivityLogObject();
			profileActivityLogObject.setAppId(appId);
			profileActivityLogObject.setClientId(gameProfileRequest.getClientId());
			profileActivityLogObject.setEmail(gameProfileRequest.getEmail());
			profileActivityLogObject.setMsisdnNetwork(gameProfileRequest.getMsisdnNetwork());
			profileActivityLogObject.setMsisdnNumber(gameProfileRequest.getMsisdnNumber());
			profileActivityLogObject.setRequestIn(requestIn);
			profileActivityLogObject.setRequestType("createGameProfile");
			profileActivityLogObject.setUserId(gameProfileRequest.getUserId());
			profileActivityLogObject = profileActivityRepository.save(profileActivityLogObject);

			gameProfileObject = new GameProfileObject();
			gameProfileObject.setClientId(gameProfileRequest.getClientId());
			gameProfileObject.setDateCreated(requestIn);
			gameProfileObject.setEmail(gameProfileRequest.getEmail());
			gameProfileObject.setLastModified(LocalDateTime.now());
			gameProfileObject.setMsisdnNetwork(gameProfileRequest.getMsisdnNetwork());
			gameProfileObject.setMsisdnNumber(gameProfileRequest.getMsisdnNumber());
			gameProfileObject.setStatus(0);
			gameProfileObject.setUserId(gameProfileRequest.getUserId());
			gameProfileObject = gameProfileRepository.save(gameProfileObject);

			gamePasswordProfileObject = new GamePasswordProfileObject();
			gamePasswordProfileObject.setChangeCount(0);
			String password = authenticationUtility.encryptString(gameProfileObject.getUserId());
			gamePasswordProfileObject.setPassword(password);
			gamePasswordProfileObject.setDateCreated(LocalDateTime.now());
			gamePasswordProfileObject.setPassword(password);
			gamePasswordProfileObject.setLastUpdated(LocalDateTime.now());
			gamePasswordProfileObject.setUniqueId(gameProfileObject.getUniqueId());
			gamePasswordProfileObject.setUserId(gameProfileObject.getUserId());
			gamePasswordProfileObject = gamePasswordProfileRepository.save(gamePasswordProfileObject);

			platformTransactionManager.commit(transactionStatus);

			messageUtility.sendMail(gameProfileObject.getClientId(), appId, "notification@winfast.ng",
					gameProfileObject.getEmail(), "Winfast Game Account",
					"Game Profile was created successfully, your default password is " + password
							+ " please login and change to a password of your choice before you start gaming.",
					requestIn);

			return responseUtility.responseBuilder(profileActivityLogObject.getUniqueId(),
					gameProfileRequest.getClientId(), 0);

		} catch (Exception ex) {
			logger.error("createGameProfile :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			platformTransactionManager.rollback(transactionStatus);
			return responseUtility.responseBuilder(0L, gameProfileRequest.getClientId(), 99);
		}
	}
	
	public Response createMiniGameProfile(String appId, GameMiniProfileRequest gameMiniProfileRequest, LocalDateTime requestIn) {
		
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
		try {
			profileActivityLogObject = new ProfileActivityLogObject();
			profileActivityLogObject.setAppId(appId);
			profileActivityLogObject.setClientId(gameMiniProfileRequest.getClientId());
			profileActivityLogObject.setMsisdnNetwork(gameMiniProfileRequest.getMsisdnNetwork());
			profileActivityLogObject.setMsisdnNumber(gameMiniProfileRequest.getMsisdnNumber());
			profileActivityLogObject.setRequestIn(requestIn);
			profileActivityLogObject.setRequestType("createMiniGameProfile");
			profileActivityLogObject.setUserId(gameMiniProfileRequest.getUserId());
			profileActivityLogObject = profileActivityRepository.save(profileActivityLogObject);

			gameProfileObject = new GameProfileObject();
			gameProfileObject.setClientId(gameMiniProfileRequest.getClientId());
			gameProfileObject.setDateCreated(requestIn);
			gameProfileObject.setLastModified(LocalDateTime.now());
			gameProfileObject.setMsisdnNetwork(gameMiniProfileRequest.getMsisdnNetwork());
			gameProfileObject.setMsisdnNumber(gameMiniProfileRequest.getMsisdnNumber());
			gameProfileObject.setStatus(0);
			gameProfileObject.setUserId(gameMiniProfileRequest.getUserId());
			gameProfileObject = gameProfileRepository.save(gameProfileObject);

			gamePasswordProfileObject = new GamePasswordProfileObject();
			gamePasswordProfileObject.setChangeCount(0);
			String password = authenticationUtility.encryptString(gameProfileObject.getUserId());
			gamePasswordProfileObject.setPassword(password);
			gamePasswordProfileObject.setDateCreated(LocalDateTime.now());
			gamePasswordProfileObject.setPassword(password);
			gamePasswordProfileObject.setLastUpdated(LocalDateTime.now());
			gamePasswordProfileObject.setUniqueId(gameProfileObject.getUniqueId());
			gamePasswordProfileObject.setUserId(gameProfileObject.getUserId());
			gamePasswordProfileObject = gamePasswordProfileRepository.save(gamePasswordProfileObject);

			platformTransactionManager.commit(transactionStatus);

			return responseUtility.responseBuilder(profileActivityLogObject.getUniqueId(),
					profileActivityLogObject.getClientId(), 0);

		} catch (Exception ex) {
			logger.error("createMiniGameProfile :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			platformTransactionManager.rollback(transactionStatus);
			return responseUtility.responseBuilder(0L, gameMiniProfileRequest.getClientId(), 99);
		}
	}

	public Iterable<GameProfileObject> listGameProfile() {
		try {
			iGameProfileObject = new ArrayList<>();
			iGameProfileObject = gameProfileRepository.findAll();
		} catch (Exception ex) {
			iGameProfileObject = new ArrayList<>();
			iGameProfileObject.forEach(null);
		}
		return iGameProfileObject;
	}

	public Iterable<GameProfileObject> listGameProfile(int status) {
		try {
			iGameProfileObject = new ArrayList<>();
			iGameProfileObject = gameProfileRepository.findByStatus(status);
		} catch (Exception ex) {
			iGameProfileObject = new ArrayList<>();
			iGameProfileObject.forEach(null);
		}
		return iGameProfileObject;
	}

	public Response disableGameProfile(String appId, DisableGameProfileRequest disableGameProfileRequest, LocalDateTime requestIn) {

		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
		try {
			profileActivityLogObject = new ProfileActivityLogObject();
			profileActivityLogObject.setAppId(appId);
			profileActivityLogObject.setClientId(disableGameProfileRequest.getClientId());
			profileActivityLogObject.setRequestType("disableGameProfile");
			profileActivityLogObject.setRequestIn(LocalDateTime.now());
			profileActivityLogObject.setUserId(disableGameProfileRequest.getUserId());
			profileActivityLogObject = profileActivityRepository.save(profileActivityLogObject);

			gameProfileObject = new GameProfileObject();
			if ((gameProfileRepository.findByUserId(disableGameProfileRequest.getUserId())) == null) {
				logger.info("disableUserProfile" + disableGameProfileRequest.getUserId()
						+ " is not a user on the platform");
				platformTransactionManager.commit(transactionStatus);
				return responseUtility.responseBuilder(profileActivityLogObject.getUniqueId(),
						disableGameProfileRequest.getClientId(), 39);

			} else {
				
				gameProfileObject.setClientId(gameProfileObject.getClientId());
				gameProfileObject.setDateCreated(gamePasswordProfileObject.getDateCreated());
				gameProfileObject.setEmail(gameProfileObject.getEmail());
				gameProfileObject.setLastModified(requestIn);
				gameProfileObject.setMsisdnNetwork(gameProfileObject.getMsisdnNetwork());
				gameProfileObject.setMsisdnNumber(gameProfileObject.getMsisdnNumber());
				gameProfileObject.setStatus(0);
				gameProfileObject.setUserId(gameProfileObject.getUserId());
				gameProfileObject = gameProfileRepository.save(gameProfileObject);

				platformTransactionManager.commit(transactionStatus);
				
				return responseUtility.responseBuilder(profileActivityLogObject.getUniqueId(),
						gameProfileObject.getClientId(), 0);
			}

		} catch (Exception ex) {
			logger.error("disableUserProfile :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			platformTransactionManager.rollback(transactionStatus);
			return responseUtility.responseBuilder(0L, disableGameProfileRequest.getClientId(), 99);
		}
	}

	public Response activateGameProfile(String appId, ActivateGameProfileRequest activateGameProfileRequest, LocalDateTime requestIn) {

		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
		try {
			profileActivityLogObject = new ProfileActivityLogObject();
			profileActivityLogObject.setAppId(appId);
			profileActivityLogObject.setClientId(activateGameProfileRequest.getClientId());
			profileActivityLogObject.setRequestType("activateGameProfile");
			profileActivityLogObject.setRequestIn(LocalDateTime.now());
			profileActivityLogObject.setUserId(activateGameProfileRequest.getUserId());
			profileActivityLogObject = profileActivityRepository.save(profileActivityLogObject);

			gameProfileObject = new GameProfileObject();
			if ((gameProfileRepository.findByUserId(activateGameProfileRequest.getUserId())) == null) {
				logger.info("disableUserProfile" + activateGameProfileRequest.getUserId()
						+ " is not a user on the platform");
				platformTransactionManager.commit(transactionStatus);
				return responseUtility.responseBuilder(profileActivityLogObject.getUniqueId(),
						activateGameProfileRequest.getClientId(), 39);

			} else {
				
				gameProfileObject.setClientId(gameProfileObject.getClientId());
				gameProfileObject.setDateCreated(gamePasswordProfileObject.getDateCreated());
				gameProfileObject.setEmail(gameProfileObject.getEmail());
				gameProfileObject.setLastModified(requestIn);
				gameProfileObject.setMsisdnNetwork(gameProfileObject.getMsisdnNetwork());
				gameProfileObject.setMsisdnNumber(gameProfileObject.getMsisdnNumber());
				gameProfileObject.setStatus(1);
				gameProfileObject.setUserId(gameProfileObject.getUserId());
				gameProfileObject = gameProfileRepository.save(gameProfileObject);

				platformTransactionManager.commit(transactionStatus);
				
				return responseUtility.responseBuilder(profileActivityLogObject.getUniqueId(),
						gameProfileObject.getClientId(), 0);
			}

		} catch (Exception ex) {
			logger.error("activateUserProfile :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			platformTransactionManager.rollback(transactionStatus);
			return responseUtility.responseBuilder(0L, activateGameProfileRequest.getClientId(), 99);
		}
	}

	public Response changeGamePassword(String appId, ChangeGamePasswordRequest changeGamePasswordRequest, LocalDateTime requestIn) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
		try {
			profileActivityLogObject = new ProfileActivityLogObject();
			profileActivityLogObject.setAppId(appId);
			profileActivityLogObject.setClientId(changeGamePasswordRequest.getClientId());
			profileActivityLogObject.setNewPassword(changeGamePasswordRequest.getNewPassword());
			profileActivityLogObject.setPassword(changeGamePasswordRequest.getPassword());
			profileActivityLogObject.setRequestType("changeUserPassword");
			profileActivityLogObject.setRequestIn(requestIn);
			profileActivityLogObject.setUserId(changeGamePasswordRequest.getUserId());
			profileActivityLogObject = profileActivityRepository.save(profileActivityLogObject);

			gamePasswordProfileObject = new GamePasswordProfileObject();
			if ((gamePasswordProfileRepository.findByUserId(changeGamePasswordRequest.getUserId())) == null) {
				logger.info("changePassword" + changeGamePasswordRequest.getUserId() + " is not a user on the platform");
				platformTransactionManager.commit(transactionStatus);
				return responseUtility.responseBuilder(profileActivityLogObject.getUniqueId(), changeGamePasswordRequest.getClientId(),
						39);

			} else {
				gamePasswordProfileObject.setChangeCount(gamePasswordProfileObject.getChangeCount() + 1);
				gamePasswordProfileObject.setPassword(gamePasswordProfileObject.getPassword());
				gamePasswordProfileObject.setDateCreated(gamePasswordProfileObject.getDateCreated());
				gamePasswordProfileObject.setNewPassword(gamePasswordProfileObject.getNewPassword());
				gamePasswordProfileObject.setLastUpdated(LocalDateTime.now());
				gamePasswordProfileObject.setUserId(gamePasswordProfileObject.getUserId());
				gamePasswordProfileObject = gamePasswordProfileRepository.save(gamePasswordProfileObject);

				platformTransactionManager.commit(transactionStatus);
				return responseUtility.responseBuilder(profileActivityLogObject.getUniqueId(), changeGamePasswordRequest.getClientId(),
						0);
			}

		} catch (Exception ex) {
			logger.error("changePassword :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			platformTransactionManager.rollback(transactionStatus);
			return responseUtility.responseBuilder(0L, changeGamePasswordRequest.getClientId(), 99);
		}
	}

	public Response resetGamePassword(String appId, ResetGamePasswordRequest resetGamePasswordRequest, LocalDateTime requestIn) {
		
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
		
		try {
			profileActivityLogObject = new ProfileActivityLogObject();
			profileActivityLogObject.setAppId(appId);
			profileActivityLogObject.setClientId(resetGamePasswordRequest.getClientId());
			profileActivityLogObject.setRequestType("resetPassword");
			profileActivityLogObject.setRequestIn(requestIn);
			profileActivityLogObject.setUserId(resetGamePasswordRequest.getUserId());
			profileActivityLogObject = profileActivityRepository.save(profileActivityLogObject);

			gamePasswordProfileObject = new GamePasswordProfileObject();
			if ((gamePasswordProfileRepository.findByUserId(resetGamePasswordRequest.getUserId())) == null) {
				logger.info("changePassword" + resetGamePasswordRequest.getUserId() + " is not a user on the platform");
				platformTransactionManager.commit(transactionStatus);
				return responseUtility.responseBuilder(profileActivityLogObject.getUniqueId(), profileActivityLogObject.getClientId(),
						39);

			} else {
				
				gamePasswordProfileObject.setChangeCount(gamePasswordProfileObject.getChangeCount() + 1);
				String password = authenticationUtility.encryptString(gamePasswordProfileObject.getUserId());
				gamePasswordProfileObject.setNewPassword(password);
				gamePasswordProfileObject.setDateCreated(gamePasswordProfileObject.getDateCreated());
				gamePasswordProfileObject.setPassword(gamePasswordProfileObject.getPassword());
				gamePasswordProfileObject.setLastUpdated(LocalDateTime.now());
				gamePasswordProfileObject.setUniqueId(gamePasswordProfileObject.getUniqueId());
				gamePasswordProfileObject.setUserId(gamePasswordProfileObject.getUserId());
				gamePasswordProfileObject = gamePasswordProfileRepository.save(gamePasswordProfileObject);

				platformTransactionManager.commit(transactionStatus);
				return responseUtility.responseBuilder(profileActivityLogObject.getUniqueId(), profileActivityLogObject.getClientId(),
						0);
			}

		} catch (Exception ex) {
			logger.error("changePassword :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			platformTransactionManager.rollback(transactionStatus);
			return responseUtility.responseBuilder(0L, resetGamePasswordRequest.getClientId(), 99);
		}
	}

}
