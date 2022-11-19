package com.streamtoolbox.klask.api;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ScoreUpdateMessage {

    private int a, b;

    private String id;

    public ScoreUpdateMessage() {
    }

    public ScoreUpdateMessage(int scoreA, int scoreB) {
        this.a = scoreA;
        this.b = scoreB;
    }

}
