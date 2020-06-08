package com.ssh.test;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class RedisZset {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.83.132",6379);
        jedis.auth("123456");
        System.out.println(jedis.ping());


        jedis.flushDB();
        jedis.flushAll();

        jedis.zadd("name",150,"张1");
        jedis.zadd("name",110,"张2");
        jedis.zadd("name",160,"张3");
        jedis.zadd("name",155,"张4");

        jedis.zrem("name","张3");


        Set set = jedis.zrange("name",0,-1);
        System.out.println(set);
    }
}
