package com.example.demo;

import java.util.Timer;
import java.util.TimerTask;
public class RedisApplication {
    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("老子生气了");
            }
        },5000,2000);
    }
}
