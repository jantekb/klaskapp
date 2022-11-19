package com.streamtoolbox.klask.api;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GoalMessage {

    private String side;

    private int delta;
}
