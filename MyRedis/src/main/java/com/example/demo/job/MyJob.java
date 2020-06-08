package com.example.demo.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

@Component
public class MyJob {

    @Resource
    private BackSql backSql;

    @Scheduled(cron = "0/3 * * * * ?")
    public void dox(){
        try {
            backSql.back("sql");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
