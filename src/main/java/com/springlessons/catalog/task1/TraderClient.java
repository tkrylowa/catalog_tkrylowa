package com.springlessons.catalog.task1;

import com.springlessons.catalog.task1.dto.TraderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "Traders", url = "http://localhost:8088/traders")
public interface TraderClient {
    @GetMapping
    List<TraderDto> getTraders();
}
