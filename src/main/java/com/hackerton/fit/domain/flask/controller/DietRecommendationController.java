package com.hackerton.fit.domain.flask.controller;

import com.hackerton.fit.global.properties.FlaskProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DietRecommendationController {

    @Autowired
    private RestTemplate restTemplate;
    private FlaskProperties flaskProperties;

    @RequestMapping(value = "/recommendDietFromFlask", method = RequestMethod.POST)
    public ResponseEntity<String> recommendDiet(@RequestBody String requestBody) {
        final String flaskApiUrl = "http://127.0.0.1:5000/recommend_diet";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(flaskApiUrl, HttpMethod.POST, entity, String.class);

        return response;
    }
}
