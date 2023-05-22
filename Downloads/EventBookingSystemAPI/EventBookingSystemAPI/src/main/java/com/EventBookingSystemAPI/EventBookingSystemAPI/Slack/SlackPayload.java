package com.EventBookingSystemAPI.EventBookingSystemAPI.Slack;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class SlackPayload {
    private String text;

    public SlackPayload(String text) {
        this.text = text;
    }

}
