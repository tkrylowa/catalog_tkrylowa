package com.springlessons.catalog.task1.controller;

import com.springlessons.catalog.task1.dto.TraderDto;
import com.springlessons.catalog.task1.service.TradersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/catalog")
public class CatalogController {
    TradersService tradersService;

    public CatalogController(TradersService tradersService) {
        this.tradersService = tradersService;
    }

    @GetMapping("/traders")
    public List<TraderDto> getTradersByCityIds(@RequestHeader("x-city-id") int cityId) {
        return tradersService.getTradersByCityId(cityId);
    }
}
