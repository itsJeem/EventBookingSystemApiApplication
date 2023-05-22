package com.EventBookingSystemAPI.EventBookingSystemAPI.Slack;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class SlackClient {

    public String sendMessage(String text) {
        return WebClient.create().post()
                .uri("https://hooks.slack.com/services/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")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new SlackPayload(text))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
