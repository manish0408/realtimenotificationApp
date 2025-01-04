package com.example.realtimenotification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalApplicationStatusService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExternalApplicationStatusService.class);

    private final RestTemplate restTemplate = new RestTemplate();

    public String getStatusFromApp(String url) {
        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                return "SUCCESS";
            } else {
                return "FAILED";
            }
        } catch (Exception e) {
            LOGGER.error("Exception occurred while making the external call - {}", e.getMessage());
            return "FAILED";
        }
    }
}
