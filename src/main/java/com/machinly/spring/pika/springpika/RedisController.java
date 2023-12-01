package com.machinly.spring.pika.springpika;

import io.lettuce.core.ClientOptions;
import io.lettuce.core.RedisClient;
import io.lettuce.core.protocol.ProtocolVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    private final RedisClient redis;

    public RedisController() {
        this.redis = RedisClient.create("redis://:123456@127.0.0.1:9221");
        ClientOptions clientOptions = ClientOptions.builder().
                protocolVersion(ProtocolVersion.RESP2).
                build();
        this.redis.setOptions(clientOptions);
    }

    @PutMapping("/redis/set/{key}/{value}")
    public String setKeyValue(@PathVariable String key, @PathVariable String value) {
        redis.connect().sync().set(key, value);
        return "Value set successfully";
    }

    @GetMapping("/redis/get/{key}")
    public String getKeyValue(@PathVariable String key) {
        return redis.connect().sync().get(key);
    }
}
