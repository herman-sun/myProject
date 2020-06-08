package com.example.demo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

public class TestSentinel {
    public static void main(String[] args) {
        String masterName = "hanmaster";
        Set<String> sentinelSet = new HashSet<String>();
        sentinelSet.add("192.168.83.133:26379");

        JedisSentinelPool sentinelPool = new JedisSentinelPool(masterName, sentinelSet);

        Jedis jedis = sentinelPool.getResource();

        System.out.println(jedis);
        //        System.out.println(jedis.ping());

        jedis.set("uname","z---s");
        System.out.println(jedis.get("uname"));

        System.out.println(jedis);
    }
}
