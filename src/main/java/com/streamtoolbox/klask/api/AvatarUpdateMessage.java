package com.streamtoolbox.klask.api;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AvatarUpdateMessage {

    private String avatarA, avatarB;

    public AvatarUpdateMessage() {
    }

    public AvatarUpdateMessage(String avatarA, String avatarB) {
        this.avatarA = avatarA;
        this.avatarB = avatarB;
    }

}
