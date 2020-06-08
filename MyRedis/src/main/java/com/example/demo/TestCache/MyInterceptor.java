package com.example.demo.TestCache;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;

public class MyInterceptor implements Interceptor {

    RedisAutoConfiguration redisAutoConfiguration;
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }
}
