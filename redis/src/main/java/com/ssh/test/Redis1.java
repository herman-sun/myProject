package com.ssh.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class Redis1 {


    public static void main(String[] args) {

        Jedis JEDIS = new Jedis("127.0.0.1", 6379);
        JEDIS.auth("123456");
        System.out.println(JEDIS.ping());
        JEDIS.flushDB();
        JEDIS.flushAll();
        JEDIS.set("aaa", "???");
        JEDIS.watch("aaa");
        Transaction multi = JEDIS.multi();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*
        String方法
         */


        multi.set("aaa".getBytes(), "asas".getBytes());
        multi.exec();
        JEDIS.close();


    }
}
