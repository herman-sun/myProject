package com.ssh.test;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class RedisSet {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.83.132",6379);
        jedis.auth("123456");
        System.out.println(jedis.ping());


        jedis.flushDB();
        jedis.flushAll();

        jedis.sadd("a","张1");
        jedis.sadd("a","张2");
        jedis.sadd("a","张3");
        jedis.sadd("a","张4");

        System.out.println(jedis.sismember("a","张2"));
        System.out.println("-==========");
        System.out.println(jedis.srem("a","张2"));
        System.out.println("-==========");
        Set set = jedis.smembers("a");
        System.out.println(set);

    }
}
