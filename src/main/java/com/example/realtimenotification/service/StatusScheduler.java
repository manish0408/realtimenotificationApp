package com.example.realtimenotification.service;

import com.example.realtimenotification.config.MyWebSocketHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StatusScheduler {
    private static final Logger LOGGER = LoggerFactory.getLogger(StatusScheduler.class);

    @Autowired
    private ExternalApplicationStatusService serviceStatus;

    @Autowired
    private MyWebSocketHandler webSocketHandler;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Scheduled(fixedDelay = 10000)
    private void sendStatusUpdate() {
        LOGGER.info("Entered into sendStatusUpdate");
        Map<String, String> applicationStatusMap = new HashMap<>();
        applicationStatusMap.put("Google", serviceStatus.getStatusFromApp("https://www.google.com/"));
        applicationStatusMap.put("Google1", serviceStatus.getStatusFromApp("https://www.google1.com/"));
        LOGGER.debug("applicationStatusMap - {}", applicationStatusMap);
        webSocketHandler.broadcastStatus(convertMapToJson(applicationStatusMap));
    }

    private String convertMapToJson(Map<String, String> applicationStatusMap) {
        try {
            LOGGER.info("Entered into method - convertMapToJson");
            return objectMapper.writeValueAsString(applicationStatusMap);
        } catch (Exception e) {
            LOGGER.error("Exception occured while converting to Json - {}", e.getMessage());
            return "Exception occured while converting to Json";
        }
    }
}
