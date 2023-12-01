package com.machinly.spring.pika.springpika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    private final RedisExample redisExample;

    @Autowired
    public RedisController(RedisExample redisExample) {
        this.redisExample = redisExample;
    }

    @PutMapping("/redis/set/{key}/{value}")
    public String setKeyValue(@PathVariable String key, @PathVariable String value) {
        redisExample.setValue(key, value);
        return "Value set successfully";
    }

    @GetMapping("/redis/get/{key}")
    public String getKeyValue(@PathVariable String key) {
        return redisExample.getValue(key);
    }
}
