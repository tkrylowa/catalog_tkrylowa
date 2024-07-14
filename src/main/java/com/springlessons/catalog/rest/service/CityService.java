package com.springlessons.catalog.rest.service;

import com.springlessons.catalog.rest.entity.City;
import com.springlessons.catalog.rest.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCity(){
        return cityRepository.findAll();
    }
}
