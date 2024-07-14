package com.springlessons.catalog.task1.controller;

import com.springlessons.catalog.task1.dto.TraderDto;
import com.springlessons.catalog.task1.service.TradersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog")
public class CatalogController {
    private final TradersService tradersService;

    public CatalogController(TradersService tradersService) {
        this.tradersService = tradersService;
    }

    @GetMapping("/traders")
    public List<TraderDto> getTradersByCityId(@RequestHeader("x-city-id") int cityId) {
        return tradersService.getTradersByCityId(cityId);
    }
}
