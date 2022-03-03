package com.kataer.springbootdemo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class VisitService {
    private final static String KEY = "VisitCount";
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public String getVisitCount() {
        String count = redisTemplate.opsForValue().get(KEY);
        if (count == null || "".equals(count)) {
            redisTemplate.opsForValue().set(KEY, "0");
            return "0";
        }
        return count;
    }

    public void addCount() {
        redisTemplate.opsForValue().increment(KEY, 1);
    }
}
