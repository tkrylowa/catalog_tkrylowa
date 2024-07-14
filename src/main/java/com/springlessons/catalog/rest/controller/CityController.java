package com.springlessons.catalog.rest.controller;

import com.springlessons.catalog.rest.entity.City;
import com.springlessons.catalog.rest.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cities")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping()
    public String getCities(Model model) {
        List<City> cities = cityService.getAllCity();
        model.addAttribute("cities_list", cities);
        return "city/cities";
    }
}
