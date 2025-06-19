package com.example.simpleTimeService.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TimeController {

    @GetMapping("/")
    public Map<String, String> getTimeAndIp(HttpServletRequest request) {
        Map<String, String> response = new HashMap<>();
        response.put("ip", request.getRemoteAddr());
        response.put("timestamp", ZonedDateTime.now().toString());

        return response;
    }
}
