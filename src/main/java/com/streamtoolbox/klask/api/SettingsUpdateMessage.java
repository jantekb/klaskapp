package com.streamtoolbox.klask.api;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SettingsUpdateMessage {

    private String teamNameA, teamNameB;

    public SettingsUpdateMessage() {

    }

    public SettingsUpdateMessage(String nameA, String nameB) {
        this.teamNameA = nameA;
        this.teamNameB = nameB;
    }

}
