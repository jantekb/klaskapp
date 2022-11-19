package com.streamtoolbox.klask.stamp;

import com.streamtoolbox.klask.stamp.api.CaptionInstruction;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
public class StampClient {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${stamp.api.url}")
    String stampApiUrl;

    @Value("${stamp.api.token}")
    String jwtToken;

    public void updateInstruction(CaptionInstruction ci) {
        log.info("Updating instruction with id {} and text {}", ci.getId(), ci.getText());

        HttpEntity<CaptionInstruction> entityReq = new HttpEntity(ci, authHeaders());
        try {
            restTemplate.exchange(stampApiUrl + "/instructions/{id}",
                    HttpMethod.POST, entityReq, String.class, Map.of("id", ci.getId()));
        } catch (HttpClientErrorException e) {
            if(e.getStatusCode() == HttpStatus.NOT_FOUND) {
                // not existing yet, creating it
                restTemplate.exchange(stampApiUrl + "/instructions", HttpMethod.POST, entityReq, String.class);
            } else {
                log.error(e.getMessage(), e);
            }
        }
    }

    @NotNull
    private HttpHeaders authHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", jwtToken);
        return headers;
    }

    public void removeInstruction(String id) {
        log.info("Removing instruction with id {}", id);
        ResponseEntity<String> result;

        try {
            result = restTemplate.exchange(stampApiUrl + "/instructions/{id}", HttpMethod.DELETE,
                    new HttpEntity(authHeaders()), String.class, Map.of("id", id));
        } catch (HttpClientErrorException e) {
            log.error(e.getMessage(), e);
        }

    }
}
