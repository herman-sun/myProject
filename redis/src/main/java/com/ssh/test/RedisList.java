package com.ssh.test;

import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisList {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.83.132",6379);
        jedis.auth("123456");
        System.out.println(jedis.ping());


        jedis.flushDB();
        jedis.flushAll();

        jedis.rpush("a","老潘");
        jedis.rpush("a","老韩");
        jedis.rpush("a","老高");
        jedis.rpush("a","老张");

        System.out.println(jedis.lindex("a",2));



        jedis.lrem("a",0,"老高");
        System.out.println(jedis.lindex("a",2));

        jedis.lset("a",2,"老郭");
        System.out.println(jedis.lindex("a",2));

        List<String> list = jedis.lrange("a",0,-1);
        for (String s : list) {
            System.out.println(s);
        }




    }
}
