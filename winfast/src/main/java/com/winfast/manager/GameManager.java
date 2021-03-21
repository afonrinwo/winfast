/**
 * 
 */
package com.winfast.manager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.winfast.game.DailyDrawResult;
import com.winfast.game.GamesServices;
import com.winfast.model.games.DailyHammerObject;
import com.winfast.model.games.DailyHammerRequest;
import com.winfast.model.games.DailyHammerResponse;
import com.winfast.model.games.DrawResultRequest;
import com.winfast.model.games.DrawResultResponse;
import com.winfast.model.games.EditConsolationPrizeRequest;
import com.winfast.model.games.EditConsolationPrizetResponse;
import com.winfast.model.games.EditTicketRequest;
import com.winfast.model.games.EditTicketResponse;
import com.winfast.model.games.GameActivityLogObject;
import com.winfast.model.games.GameGeneratorRequest;
import com.winfast.model.games.GameGeneratorResponse;
import com.winfast.model.games.InstantMillionObject;
import com.winfast.model.games.InstantMillionRequest;
import com.winfast.model.games.InstantMillionResponse;
import com.winfast.model.games.TicketInfoByMobileNoRequest;
import com.winfast.model.games.TicketInfoByMobileNoResponse;
import com.winfast.model.games.TicketInfoByTicketIdRequest;
import com.winfast.model.games.TicketInfoByTicketIdResponse;
import com.winfast.repository.DailyHammerRepository;
import com.winfast.repository.GameActivityRepository;
import com.winfast.repository.InstantMillionRepository;
import com.winfast.utility.AuthenticationUtility;
import com.winfast.utility.ResponseUtility;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Service
public class GameManager {

	private final Logger logger = LogManager.getLogger(GameManager.class);
	private DailyHammerObject dailyHammerObject;
	private InstantMillionObject instantMillionObject;
	private GameActivityLogObject gameActivityLogObject;

	@Autowired
	PlatformTransactionManager platformTransactionManager;

	@Autowired
	GameActivityRepository gameActivityRepository;

	@Autowired
	GamesServices gamesServices;

	@Autowired
	DailyDrawResult dailyDrawResult;

	@Autowired
	ResponseUtility responseUtility;

	@Autowired
	DailyHammerRepository dailyHammerRepository;

	@Autowired
	InstantMillionRepository instantMillionRepository;

	@Autowired
	AuthenticationUtility authenticationUtility;

	public DailyHammerResponse dailyHammerTicket(String appId, DailyHammerRequest dailyHammerRequest,
			LocalDateTime requestIn, String sourceUid) {

		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);

		try {
			gameActivityLogObject = new GameActivityLogObject();
			gameActivityLogObject.setAgentId(dailyHammerRequest.getAgentId());
			gameActivityLogObject.setAmount(dailyHammerRequest.getAmount());
			gameActivityLogObject.setAppId(appId);
			gameActivityLogObject.setBonus(dailyHammerRequest.getBonus());
			gameActivityLogObject.setChannelId(dailyHammerRequest.getChannelId());
			gameActivityLogObject.setClientId(dailyHammerRequest.getClientId());
			gameActivityLogObject.setCountry(dailyHammerRequest.getCountry());
			gameActivityLogObject.setGameNumbers(dailyHammerRequest.getGameNumbers());
			gameActivityLogObject.setMobileNetwork(dailyHammerRequest.getMobileNetwork());
			gameActivityLogObject.setMobileNumber(dailyHammerRequest.getMobileNumber());
			gameActivityLogObject.setMultiplier(dailyHammerRequest.getMultiplier());
			gameActivityLogObject.setPsp(dailyHammerRequest.getPsp());
			gameActivityLogObject.setRandom(dailyHammerRequest.getRandom());
			gameActivityLogObject.setRequestIn(requestIn);
			gameActivityLogObject.setRequestType("dailyHammerTicket");
			gameActivityLogObject.setSourceUid(sourceUid);
			gameActivityLogObject = gameActivityRepository.save(gameActivityLogObject);

			dailyHammerObject = new DailyHammerObject();
			dailyHammerObject.setAgentId(dailyHammerRequest.getAgentId());
			dailyHammerObject.setAmount(dailyHammerRequest.getAmount());
			dailyHammerObject.setChannelId(dailyHammerRequest.getChannelId());
			dailyHammerObject.setClientId(dailyHammerRequest.getClientId());
			dailyHammerObject.setCountry(dailyHammerRequest.getCountry());
			dailyHammerObject.setMobileNetwork(dailyHammerRequest.getMobileNetwork());
			dailyHammerObject.setMobileNumber(dailyHammerRequest.getMobileNumber());
			dailyHammerObject.setMultiplier(dailyHammerRequest.getMultiplier());
			dailyHammerObject.setPsp(dailyHammerRequest.getPsp());
			dailyHammerObject.setRandom(dailyHammerRequest.getRandom());
			dailyHammerObject.setRequestIn(requestIn);
			dailyHammerObject.setBonus(dailyHammerRequest.getBonus());
			dailyHammerObject.setGameNumbers(dailyHammerRequest.getGameNumbers());
			dailyHammerObject.setSourceUid(sourceUid);
			dailyHammerObject = dailyHammerRepository.save(dailyHammerObject);

			platformTransactionManager.commit(transactionStatus);

			if (dailyHammerObject.getUniqueId() <= 0) {
				logger.info("onDemandDailyHammer :: ClientId:" + dailyHammerObject.getClientId() 
				+ "| Random: " + dailyHammerObject.getRandom() + "|Multiplier: " + dailyHammerObject.getMultiplier()
				+ "|GameNumber: " + dailyHammerObject.getGameNumbers() + "|Bonus: " + dailyHammerObject.getBonus() 
				+ "|MobleNumber: " + dailyHammerObject.getMobileNumber() + "|AgentId: " + dailyHammerObject.getAgentId() 
				+ "|ChannelId: " + dailyHammerObject.getChannelId() + "|Country: " + dailyHammerObject.getCountry()
				+ "|sourceUid: " + dailyHammerObject.getSourceUid() + "|Amount: " + dailyHammerObject.getAmount() 
				+ "|PSP: " + dailyHammerObject.getPsp() + "|RequestIn: " + dailyHammerObject.getRequestIn());
			}

			return gamesServices.dailyHammerTicket(dailyHammerObject.getUniqueId(), dailyHammerObject.getClientId(),
					dailyHammerObject.getRandom(), dailyHammerObject.getMultiplier(),
					dailyHammerObject.getGameNumbers(), dailyHammerObject.getBonus(),
					dailyHammerObject.getMobileNumber(), dailyHammerObject.getAgentId(),
					dailyHammerObject.getChannelId(), dailyHammerObject.getCountry(), dailyHammerObject.getSourceUid(),
					dailyHammerObject.getAmount(), dailyHammerObject.getPsp());

		} catch (DataIntegrityViolationException ex) {
			logger.error("dailyHammerTicket :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			platformTransactionManager.rollback(transactionStatus);
			return responseUtility.dailyHammerTicketResponseBuilder(0L, dailyHammerRequest.getClientId(), 7);
		} catch (Exception ex) {
			logger.error("dailyHammerTicket :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			platformTransactionManager.rollback(transactionStatus);
			return responseUtility.dailyHammerTicketResponseBuilder(0L, dailyHammerRequest.getClientId(), 99);
		}
	}

	public InstantMillionResponse instantMillionTicket(String appId, InstantMillionRequest instantMillionRequest,
			LocalDateTime requestIn, String sourceUid) {

		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);

		try {

			gameActivityLogObject = new GameActivityLogObject();
			gameActivityLogObject.setAgentId(instantMillionRequest.getAgentId());
			gameActivityLogObject.setAppId(appId);
			gameActivityLogObject.setAmount(instantMillionRequest.getAmount());
			gameActivityLogObject.setBonus(instantMillionRequest.getBonus());
			gameActivityLogObject.setChannelId(instantMillionRequest.getChannelId());
			gameActivityLogObject.setClientId(instantMillionRequest.getClientId());
			gameActivityLogObject.setCountry(instantMillionRequest.getCountry());
			gameActivityLogObject.setGameNumbers(instantMillionRequest.getGameNumbers());
			gameActivityLogObject.setMobileNetwork(instantMillionRequest.getMobileNetwork());
			gameActivityLogObject.setMobileNumber(instantMillionRequest.getMobileNumber());
			gameActivityLogObject.setMultiplier(instantMillionRequest.getMultiplier());
			gameActivityLogObject.setPsp(instantMillionRequest.getPsp());
			gameActivityLogObject.setRandom(instantMillionRequest.getRandom());
			gameActivityLogObject.setRequestIn(requestIn);
			gameActivityLogObject.setRequestType("instantMillionTicket");
			gameActivityLogObject.setSourceUid(sourceUid);
			gameActivityLogObject = gameActivityRepository.save(gameActivityLogObject);

			instantMillionObject = new InstantMillionObject();
			instantMillionObject.setAgentId(instantMillionRequest.getAgentId());
			instantMillionObject.setAmount(instantMillionRequest.getAmount());
			instantMillionObject.setChannelId(instantMillionRequest.getChannelId());
			instantMillionObject.setClientId(instantMillionRequest.getClientId());
			instantMillionObject.setCountry(instantMillionRequest.getCountry());
			instantMillionObject.setInstantMillionType("OnDemand");
			instantMillionObject.setMobileNumber(instantMillionRequest.getMobileNumber());
			instantMillionObject.setMobileNetwork(instantMillionRequest.getPsp());
			instantMillionObject.setMultiplier(instantMillionRequest.getMultiplier());
			instantMillionObject.setPsp(instantMillionRequest.getPsp());
			instantMillionObject.setRandom(instantMillionRequest.getRandom());
			instantMillionObject.setRequestIn(requestIn);
			instantMillionObject.setBonus(instantMillionRequest.getBonus());
			instantMillionObject.setGameNumbers(instantMillionRequest.getGameNumbers());
			instantMillionObject.setSourceUid(sourceUid);
			instantMillionObject = instantMillionRepository.save(instantMillionObject);

			platformTransactionManager.commit(transactionStatus);

			logger.info("instantMillion :: ClientId: " + instantMillionObject.getClientId() 
			+ "|Random: " + instantMillionObject.getRandom() + "|Multiplier: " + instantMillionObject.getMultiplier() 
			+ "|GameNumber: " + instantMillionObject.getGameNumbers() + "|Bonus: " + instantMillionObject.getBonus() 
			+ "|MobleNumber: " + instantMillionObject.getMobileNumber() + "|AgentId: " + instantMillionObject.getAgentId()  
			+ "|ChannelId: " + instantMillionObject.getChannelId() + "|Country: " + instantMillionObject.getCountry() 
			+ "|SourceId: " + instantMillionObject.getSourceUid() + "| Amount: " + instantMillionObject.getAmount()
			+ "|PSP: " + instantMillionObject.getPsp() + "|RequestIn: " + instantMillionObject.getRequestIn());

			return gamesServices.instantMillionTicket(instantMillionObject.getUniqueId(),
					instantMillionObject.getClientId(), instantMillionObject.getRandom(),
					instantMillionObject.getMultiplier(), instantMillionObject.getGameNumbers(),
					instantMillionObject.getBonus(), instantMillionObject.getMobileNumber(),
					instantMillionObject.getAgentId(), instantMillionObject.getChannelId(),
					instantMillionObject.getCountry(), instantMillionObject.getSourceUid(),
					instantMillionObject.getAmount(), instantMillionObject.getPsp());

		} catch (DataIntegrityViolationException ex) {
			logger.error("instantMillionTicket :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			platformTransactionManager.rollback(transactionStatus);
			return responseUtility.instantMillionResponseBuilder(0L, instantMillionRequest.getClientId(), 7);

		} catch (Exception ex) {
			logger.error("instantMillionTicket :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			platformTransactionManager.rollback(transactionStatus);
			return responseUtility.instantMillionResponseBuilder(0L, instantMillionRequest.getClientId(), 99);
		}
	}

	public TicketInfoByMobileNoResponse ticketInfoByMobileNumber(String appId,
			TicketInfoByMobileNoRequest ticketInfoByMobileNoRequest, LocalDateTime requestIn) {
		try {
			gameActivityLogObject = new GameActivityLogObject();
			gameActivityLogObject.setAppId(appId);
			gameActivityLogObject.setClientId(ticketInfoByMobileNoRequest.getClientId());
			gameActivityLogObject.setMobileNumber(ticketInfoByMobileNoRequest.getMobileNumber());
			gameActivityLogObject.setRequestIn(requestIn);
			gameActivityLogObject.setRequestType("dailyTicketInfoByMobileNumber");
			gameActivityLogObject = gameActivityRepository.save(gameActivityLogObject);

			return gamesServices.ticketInfoByMobileNumber(ticketInfoByMobileNoRequest.getClientId(),
					ticketInfoByMobileNoRequest.getMobileNumber(), ticketInfoByMobileNoRequest.getPeriod());
		} catch (Exception ex) {
			logger.error("dailyTicketInfoByMobileNumber :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.ticketInfoByMobileNoResponseBuilder(ticketInfoByMobileNoRequest.getClientId(), 99);
		}
	}

	public TicketInfoByTicketIdResponse ticketInfoByTicketId(String appId,
			TicketInfoByTicketIdRequest ticketInfoByTicketIdRequest, LocalDateTime requestIn) {
		try {

			gameActivityLogObject = new GameActivityLogObject();
			gameActivityLogObject.setAppId(appId);
			gameActivityLogObject.setClientId(ticketInfoByTicketIdRequest.getClientId());
			gameActivityLogObject.setMobileNumber(ticketInfoByTicketIdRequest.getMobileNumber());
			gameActivityLogObject.setRequestIn(requestIn);
			gameActivityLogObject.setRequestType("dailyTicketInfoByTicketId");
			gameActivityLogObject.setTicketId(ticketInfoByTicketIdRequest.getTicketId());
			gameActivityLogObject = gameActivityRepository.save(gameActivityLogObject);

			dailyHammerObject = new DailyHammerObject();
			dailyHammerObject = dailyHammerRepository.findByMobileNumberAndSourceUidContains(
					ticketInfoByTicketIdRequest.getMobileNumber(), ticketInfoByTicketIdRequest.getTicketId());

			return gamesServices.ticketInfoByTicketId(gameActivityLogObject.getClientId(),
					dailyHammerObject.getSourceUid());

		} catch (Exception ex) {
			logger.error("dailyTicketInfoByTicketId :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.ticketInfoByTicketIdResponseBuilder(ticketInfoByTicketIdRequest.getClientId(), 99);
		}
	}

	public EditTicketResponse editDailyTicket(String appId, EditTicketRequest editTicketRequest,
			LocalDateTime requestIn) {
		try {

			gameActivityLogObject = new GameActivityLogObject();
			gameActivityLogObject.setAppId(appId);
			gameActivityLogObject.setBonus(editTicketRequest.getBonus());
			gameActivityLogObject.setClientId(editTicketRequest.getClientId());
			gameActivityLogObject.setMultiplier(editTicketRequest.getMultiplier());
			gameActivityLogObject.setNewGameNumbers(editTicketRequest.getNewGameNumbers());
			gameActivityLogObject.setRequestIn(requestIn);
			gameActivityLogObject.setRequestType("editDailyTicket");
			gameActivityLogObject.setSourceUid(editTicketRequest.getSourceUid());
			gameActivityLogObject.setTicketId(editTicketRequest.getTicketId());
			gameActivityLogObject = gameActivityRepository.save(gameActivityLogObject);

			dailyHammerObject = new DailyHammerObject();
			dailyHammerObject = dailyHammerRepository.findBySourceUidContains(editTicketRequest.getTicketId());

			return gamesServices.editDailyTicket(editTicketRequest.getClientId(), editTicketRequest.getMultiplier(),
					editTicketRequest.getBonus(), editTicketRequest.getNewGameNumbers(),
					dailyHammerObject.getSourceUid(), dailyHammerObject.getTicket_id());

		} catch (Exception ex) {
			logger.error("editDailyTicket :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.editDailyTicketResponseBuilder(0L, editTicketRequest.getClientId(), 99);
		}
	}
	
	public EditConsolationPrizetResponse editConsolatinPrize(String appId, EditConsolationPrizeRequest editConsolationPrizeRequest, LocalDateTime requestIn) {
		try {

			gameActivityLogObject = new GameActivityLogObject();
			gameActivityLogObject.setAppId(appId);
			gameActivityLogObject.setBonus(editConsolationPrizeRequest.getNewBonus());
			gameActivityLogObject.setClientId(editConsolationPrizeRequest.getClientId());
			gameActivityLogObject.setMultiplier(editConsolationPrizeRequest.getMultiplier());
			gameActivityLogObject.setNewGameNumbers(editConsolationPrizeRequest.getGameNumbers());
			gameActivityLogObject.setRequestIn(requestIn);
			gameActivityLogObject.setRequestType("editDailyTicket");
			gameActivityLogObject.setSourceUid(editConsolationPrizeRequest.getSourceUid());
			gameActivityLogObject.setTicketId(editConsolationPrizeRequest.getTicketId());
			gameActivityLogObject = gameActivityRepository.save(gameActivityLogObject);

			dailyHammerObject = new DailyHammerObject();
			dailyHammerObject = dailyHammerRepository.findBySourceUidContains(editConsolationPrizeRequest.getTicketId());

			return gamesServices.editConsolatinPrize(dailyHammerObject.getClientId(), dailyHammerObject.getNewBonus(), dailyHammerObject.getGameNumbers(),
					dailyHammerObject.getSourceUid(), dailyHammerObject.getTicket_id());

		} catch (Exception ex) {
			logger.error("editConsolatinPrize :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.editConsolationPrizeResponseBuilder(0L, editConsolationPrizeRequest.getClientId(), 99);
		}
	}


	public GameGeneratorResponse gameGenerator(String appId, GameGeneratorRequest gameGeneratorRequest,
			LocalDateTime requestIn) {
		try {

			gameActivityLogObject = new GameActivityLogObject();
			gameActivityLogObject.setAppId(appId);
			gameActivityLogObject.setAgentId(gameGeneratorRequest.getAgentId());
			gameActivityLogObject.setClientId(gameGeneratorRequest.getClientId());
			gameActivityLogObject.setMobileNumber(gameGeneratorRequest.getMobileNumber());
			gameActivityLogObject.setPsp(gameGeneratorRequest.getPsp());
			gameActivityLogObject.setRequestIn(requestIn);
			gameActivityLogObject.setRequestType("gameGenerator");
			gameActivityLogObject = gameActivityRepository.save(gameActivityLogObject);

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
				list.clear();
			} while (checkList.contains(0));

			logger.info("Client Id: " + gameGeneratorRequest.getClientId() + " |Agent Id: "
					+ gameGeneratorRequest.getAgentId() + " |PSP: " + gameGeneratorRequest.getPsp()
					+ " |Mobile Number: " + gameGeneratorRequest.getMobileNumber() + " |Game Numbers: " + checkList);

			return responseUtility.gameGeneratorsResponseBuilder(gameGeneratorRequest.getClientId(),
					gameGeneratorRequest.getAgentId(), gameGeneratorRequest.getPsp(),
					gameGeneratorRequest.getMobileNumber(), checkList, 0);

		} catch (Exception ex) {
			logger.error("gameGenerator :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n"
					+ ex.getStackTrace());
			return responseUtility.gameGeneratorsResponseBuilder(gameGeneratorRequest.getClientId(), 99);
		}
	}

	public DrawResultResponse drawResult(String appId, DrawResultRequest drawResultRequest, LocalDateTime requestIn) {
		try {

			gameActivityLogObject = new GameActivityLogObject();
			gameActivityLogObject.setAppId(appId);
			gameActivityLogObject.setClientId(drawResultRequest.getClientId());
			gameActivityLogObject.setEventId(drawResultRequest.getEventId());
			gameActivityLogObject.setRequestIn(requestIn);
			gameActivityLogObject.setRequestType("drawResult");
			gameActivityLogObject = gameActivityRepository.save(gameActivityLogObject);

			return dailyDrawResult.drawResult(drawResultRequest.getClientId(), drawResultRequest.getEventId());
		} catch (Exception ex) {
			logger.error(
					"drawResult :: " + ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			return responseUtility.drawResultResponseBuilder(drawResultRequest.getClientId(), 99);
		}
	}

}
