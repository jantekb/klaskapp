package com.streamtoolbox.klask.game;

import com.streamtoolbox.klask.api.AvatarUpdateMessage;
import com.streamtoolbox.klask.api.ScoreUpdateMessage;
import com.streamtoolbox.klask.api.SettingsUpdateMessage;
import com.streamtoolbox.klask.stamp.StampClient;
import com.streamtoolbox.klask.stamp.api.CaptionInstruction;
import com.streamtoolbox.klask.stamp.api.CaptionPosition;
import com.streamtoolbox.klask.stamp.api.CaptionStyle;
import com.streamtoolbox.klask.stamp.api.Shadow;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class GameState {

    private int scoreA = 0;

    private int scoreB = 0;

    private String nameA = "Team A";

    private String nameB = "Team B";

    private final StampClient stampClient;

    private CaptionInstruction scoreAId, scoreBId, teamAId, teamBId, avatarAId, avatarBId, clock;

    private static final String EMPTY_AVATAR = "data:image/png;base64,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";

    private final SimpMessagingTemplate simpMessagingTemplate;

    private AtomicBoolean initialized = new AtomicBoolean(false);

    private float sideMargin = 0.03f;

    private float scoreMargin = 0.17f;

    private int avatarY = 20;

    private int teamY = 130;

    private int scoreY = 37;

    private Instant start = Instant.now();

    private ScheduledExecutorService threadPoolExecutor = Executors.newScheduledThreadPool(1);

    public GameState(StampClient stampClient, SimpMessagingTemplate simpMessagingTemplate) {
        this.stampClient = stampClient;
        this.simpMessagingTemplate = simpMessagingTemplate;

        scoreAId = basicTextAttributes("0", 60);
        scoreAId.setPosition(new CaptionPosition(scoreMargin, scoreY, "top-left", 0));

        scoreBId = basicTextAttributes("0", 60);
        scoreBId.setPosition(new CaptionPosition(1 - scoreMargin, scoreY, "top-right", 0));

        teamAId = basicTextAttributes(nameA, 35);
        teamAId.setPosition(new CaptionPosition(sideMargin, teamY, "top-left", 0));

        teamBId = basicTextAttributes(nameB, 35);
        teamBId.setPosition(new CaptionPosition(1 - sideMargin, teamY, "top-right", 0));

        avatarAId = basicImage(EMPTY_AVATAR);
        avatarAId.setPosition(new CaptionPosition(sideMargin, avatarY, "top-left", 0));

        avatarBId = basicImage(EMPTY_AVATAR);
        avatarBId.setPosition(new CaptionPosition(1 - sideMargin, avatarY, "top-right", 0));

        clock = basicTextAttributes("00:00", 60);
        clock.setPosition(new CaptionPosition(0.5, scoreY, "top-center", 0));
    }

    private CaptionInstruction basicImage(String image) {
        CaptionInstruction res = new CaptionInstruction();
        res.setDuration(999999);
        res.setImage(image);
        res.setStart(new Date());
        return res;
    }

    private CaptionInstruction basicTextAttributes(String text, int size) {
        CaptionInstruction res = new CaptionInstruction();
        res.setText(text);
        res.setStyle(new CaptionStyle(
                "Verdana", "white", "bold", size
        ));
        res.setShadow(new Shadow(1,1, 0.8f, 6));
        res.setDuration(999999);
        res.setStart(new Date());
        return res;
    }

    public void updateScores(int a, int b) {
        if(!initialized.getAndSet(true)) {
            initialize();
        }

        if(a != scoreA) {
            scoreA = a;
            scoreAId.setText("" + scoreA);
            stampClient.updateInstruction(scoreAId);
        }
        if(b != scoreB) {
            scoreB = b;
            scoreBId.setText("" + scoreB);
            stampClient.updateInstruction(scoreBId);
        }
        simpMessagingTemplate.convertAndSend("/topic/scores", new ScoreUpdateMessage(scoreA, scoreB));
    }

    public void setTeamNames(String teamNameA, String teamNameB) {
        if(!initialized.getAndSet(true)) {
            initialize();
        }
        if(teamNameA != null && !teamNameA.isEmpty() && !nameA.equals(teamNameA)) {
            nameA = teamNameA;
            teamAId.setText(nameA);
            stampClient.updateInstruction(teamAId);
        }
        if(teamNameB != null && !teamNameB.isEmpty() && !nameB.equals(teamNameB)) {
            nameB = teamNameB;
            teamBId.setText(nameB);
            stampClient.updateInstruction(teamBId);
        }
        simpMessagingTemplate.convertAndSend("/topic/settings", new SettingsUpdateMessage(nameA, nameB));
    }

    private void initialize() {
        sendInitialUpdate();
        start = Instant.now();
        log.info("Initializing game state");
        threadPoolExecutor.scheduleAtFixedRate(() -> {
            try {
                final Duration between = Duration.between(start, Instant.now());
                clock.setText(String.format("%02d:%02d", between.toMinutes(), between.toSecondsPart()));
                stampClient.updateInstruction(clock);
            } catch (Exception e) {
                log.error("Error updating clock" + e.getMessage(), e);
            }
        }, 1, 1, TimeUnit.SECONDS);
    }


    private void sendInitialUpdate() {
        log.info("Initializing score instructions in Stamp");
        stampClient.updateInstruction(scoreAId);
        stampClient.updateInstruction(scoreBId);
        stampClient.updateInstruction(teamAId);
        stampClient.updateInstruction(teamBId);
        stampClient.updateInstruction(clock);

        if(avatarAId.getImage() != null) {
            stampClient.updateInstruction(avatarAId);
        }
        if(avatarBId.getImage() != null) {
            stampClient.updateInstruction(avatarBId);
        }
    }

    public void clear() {
        stampClient.removeInstruction(scoreAId.getId());
        stampClient.removeInstruction(scoreBId.getId());
        stampClient.removeInstruction(teamAId.getId());
        stampClient.removeInstruction(teamBId.getId());
        stampClient.removeInstruction(avatarAId.getId());
        stampClient.removeInstruction(avatarBId.getId());
        stampClient.removeInstruction(clock.getId());
    }

    public void setAvatarA(String avatarA) {
        if(avatarA != null && !avatarA.equals(avatarAId.getImage())) {
            avatarAId.setImage(avatarA);
            stampClient.updateInstruction(avatarAId);
            simpMessagingTemplate.convertAndSend("/topic/settings", new AvatarUpdateMessage(avatarA, null));
        }
    }

    public void setAvatarB(String avatarB) {
        if(avatarB != null && !avatarB.equals(avatarBId.getImage())) {
            avatarBId.setImage(avatarB);
            stampClient.updateInstruction(avatarBId);
            simpMessagingTemplate.convertAndSend("/topic/settings", new AvatarUpdateMessage(null, avatarB));
        }
    }

    public int getScoreA() {
        return scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    public String getNameA() {
        return nameA;
    }

    public String getNameB() {
        return nameB;
    }

    public String getAvatarA() {
        return avatarAId.getImage();
    }

    public String getAvatarB() {
        return avatarBId.getImage();
    }

    public void broadcastScoresAndSettings() {
        simpMessagingTemplate.convertAndSend("/topic/scores", new ScoreUpdateMessage(scoreA, scoreB));

        simpMessagingTemplate.convertAndSend("/topic/settings", new AvatarUpdateMessage(getAvatarA(), getAvatarB()));
        simpMessagingTemplate.convertAndSend("/topic/settings", new SettingsUpdateMessage(nameA, nameB));
    }

    public void resetClock() {
        start = Instant.now();
        stampClient.updateInstruction(clock);
    }
}
