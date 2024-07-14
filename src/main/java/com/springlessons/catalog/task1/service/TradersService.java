package com.springlessons.catalog.task1.service;

import com.springlessons.catalog.task1.TraderClient;
import com.springlessons.catalog.task1.dto.TraderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradersService {
    private final TraderClient traderClient;

    public TradersService(TraderClient traderClient) {
        this.traderClient = traderClient;
    }

    public List<TraderDto> getTradersByCityId(int cityId) {
        return traderClient.getTraders().stream().filter(trader -> trader.getCityId() == cityId).toList();
    }
}
