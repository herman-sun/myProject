package com.ssh.test;

import redis.clients.jedis.Jedis;

import java.sql.SQLOutput;
import java.util.List;

public class RedisHash {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.auth("123456");
        System.out.println(jedis.ping());


        jedis.flushDB();
        jedis.flushAll();

        jedis.hset("person","name","老张");
        jedis.hset("person","age","12");
        jedis.hset("person","gender","男");
        jedis.hset("person","love","dog");



        System.out.println(jedis.hget("person","name"));
        jedis.hdel("person","love");
        System.out.println("============");
        jedis.hset("person","name","老王");
        System.out.println(jedis.hget("person","name"));
        System.out.println("============");
        List list = jedis.hvals("person");
        for (Object o : list) {
            System.out.println(o);
        }

    }
}
