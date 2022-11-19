package com.streamtoolbox.klask.controller;

import com.streamtoolbox.klask.api.GoalMessage;
import com.streamtoolbox.klask.game.GameState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class StompController {

    private static final Logger logger = LoggerFactory.getLogger(StompController.class);

    @Autowired
    GameState gameState;

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    public void greeting(String message) throws Exception {
        logger.info("Received greeting message {}", message);
        gameState.broadcastScoresAndSettings();
    }

    @MessageMapping("/reset")
    public void reset(String message) throws Exception {
        logger.info("Received reset message {}", message);
        gameState.updateScores(0, 0);
        gameState.resetClock();
    }

    @MessageMapping("/goal")
    public void reset(GoalMessage message) throws Exception {
        logger.info("Goal message {}", message);
        if("a".equalsIgnoreCase(message.getSide())) {
            gameState.updateScores(Math.max(0, Math.min(6, gameState.getScoreA() + message.getDelta())),  gameState.getScoreB());
        }
        if("B".equalsIgnoreCase(message.getSide())) {
            gameState.updateScores(gameState.getScoreA(), Math.max(0, Math.min(6, gameState.getScoreB() + message.getDelta())));
        }
    }

}
