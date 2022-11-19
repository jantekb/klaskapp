package com.streamtoolbox.klask.controller;

import com.streamtoolbox.klask.api.ScoreUpdateMessage;
import com.streamtoolbox.klask.api.TeamData;
import com.streamtoolbox.klask.game.GameState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {

	@Autowired
	GameState gameState;

	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@RequestMapping(value = "/score", method = RequestMethod.POST)
	public String scoreUpdate(@RequestBody ScoreUpdateMessage scoreUpdateMessage) {
		logger.info("Incoming score update message: {}", scoreUpdateMessage);
		gameState.updateScores(scoreUpdateMessage.getA(), scoreUpdateMessage.getB());
		return "{\"status\": \"ok\"}";
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public void submit(@RequestBody TeamData teamData) {
		logger.info("Updating team data from UI");
		gameState.setTeamNames(teamData.getTeamNameA(), teamData.getTeamNameB());

		if(teamData.getAvatarA() != null && !teamData.getAvatarA().isEmpty()) {
			gameState.setAvatarA(teamData.getAvatarA());
		}

		if(teamData.getAvatarB() != null && !teamData.getAvatarB().isEmpty()) {
			gameState.setAvatarB(teamData.getAvatarB());
		}
	}


	@RequestMapping(value = "/clear", method = RequestMethod.POST)
	public void clear() {
		logger.info("Clearing overlays");
		gameState.clear();
	}

	@RequestMapping("/version")
	public String version() {
		return "1.0.0";
	}


}