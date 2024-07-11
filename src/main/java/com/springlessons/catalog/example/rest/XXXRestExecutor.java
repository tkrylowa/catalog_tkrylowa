package com.springlessons.catalog.example.rest;

import com.springlessons.catalog.example.Cat;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.ParameterizedType;
import java.net.URI;
import java.util.List;

@Service
public class XXXRestExecutor {

    private final RestTemplate restTemplate;

    public XXXRestExecutor(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void restExecutor(){
        // используется для передачи данных в теле сообщения
        HttpEntity<Cat> requestBody = new HttpEntity<>(new Cat());

        // Отправка post запроса и получение тела сообщения
        Cat postCat = restTemplate.postForObject(
                "http://localhost:8080/cat",
                requestBody,
                Cat.class); // что ожидаем в теле

        // Отправка post запроса и получение ResponseEntity
        ResponseEntity<Cat> postCatResponseEntity = restTemplate.postForEntity(
                "http://localhost:8080/cat",
                requestBody,
                Cat.class); // что ожидаем в теле

        URI catUri = restTemplate.postForLocation(
                "http://localhost:8080/cat",
                requestBody);

        // Отправка post запроса и получение location - ссылка на созданный ресурс
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8080/cat")
                .queryParam("color", "black")
                .build()
                .toUri();
        Cat cat = restTemplate.getForObject(
                uri,
                Cat.class); // что ожидаем в теле

        // Отправка get запроса и получение ResponseEntity (в теле не generic)
        ResponseEntity<Cat> catResponseEntity = restTemplate.getForEntity(
                uri,
                Cat.class); // что ожидаем в теле

        // Отправка get запроса и получение generic в теле
        ResponseEntity<List<Cat>> listResponseEntity = restTemplate.exchange(
                uri,
                HttpMethod.POST,
                null,
                new ParameterizedTypeReference<List<Cat>>() {} // что ожидаем в теле
        );
    }

}
