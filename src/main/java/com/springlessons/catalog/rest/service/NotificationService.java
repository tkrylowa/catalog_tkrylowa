package com.springlessons.catalog.rest.service;

import com.springlessons.catalog.rest.executor.CityRestExecutor;
import com.springlessons.catalog.rest.repository.CityRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class NotificationService {
    private final CityRepository cityRepository;
    private final CityRestExecutor cityRestExecutor;

    public NotificationService(CityRepository cityRepository, CityRestExecutor cityRestExecutor) {
        this.cityRepository = cityRepository;
        this.cityRestExecutor = cityRestExecutor;
    }

    @Async("city-executor")
    @Scheduled(fixedRate = 24, timeUnit = TimeUnit.HOURS)
    public void updateCityInformation() {
        cityRepository.saveAll(cityRestExecutor.restExecutor());
    }
}
