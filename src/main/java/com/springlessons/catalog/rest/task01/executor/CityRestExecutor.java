package com.springlessons.catalog.rest.task01.executor;

import com.springlessons.catalog.rest.task01.entity.City;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CityRestExecutor {
    private final RestTemplate restTemplate;

    public CityRestExecutor(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<City> restExecutor() {
        ResponseEntity<List<City>> listResponseEntity = restTemplate.exchange(
                "http://localhost:8089/cities",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return listResponseEntity.getBody();
    }
}
