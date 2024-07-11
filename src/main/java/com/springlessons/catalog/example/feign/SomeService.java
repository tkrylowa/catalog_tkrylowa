package com.springlessons.catalog.example.feign;

import com.springlessons.catalog.example.Cat;
import org.springframework.stereotype.Service;

@Service
public class SomeService {

    private final XXXClient xxxClient;

    // внедрение зависимсоти
    public SomeService(XXXClient xxxClient) {
        this.xxxClient = xxxClient;
    }

    public Cat getCatById(int id) {
        // использование feign клиента
        return xxxClient.getCatById(id);
    }
}
