package com.springlessons.catalog.example.feign;

import com.springlessons.catalog.example.Cat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// добавить аннотацию @EnableFeignClients над классом с методом main,
// иначе бин XXXClient не будет создан и помещен в контекст спринг

// XXX заменить на имя сервера, к которому происходит обращение
// ip заменить на адрес сервера, к которому происходит обращение
// port заменить на адрес сервера, к которому происходит обращение
// endpoint заменить на endpoint сервера, к которому происходит обращение
// (аналогично значению в requestmapping контроллера, к которому происходит обращение)
@FeignClient(value = "XXX", url = "http://ip:port/endpoint")
public interface XXXClient {

    @GetMapping("/{id}") // для отправки GET запроса на указанный endpoint
    Cat getCatById(@PathVariable int id); // для передачи данных как часть строки запроса

    @GetMapping("/filter") // для отправки GET запроса на указанный endpoint
    List<Cat> getCatsByColor(@RequestParam String color); // для передачи данных в параметрах запроса

    @PostMapping // для отправки POST запроса на указанный endpoint
    ResponseEntity<Cat> createCat(@RequestBody Cat cat); // для передачи данных в теле сообщения
}
