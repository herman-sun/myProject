package com.example.demo.job;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

//@Component
public class Test2 implements SchedulingConfigurer {
    int a = 3;
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                a = new Random().nextInt(10) + 1;
                System.out.println("任务结束后重启新线程，修改cron的值");
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {

                String cron = "0/"+a+" * * * * ?";
                System.out.println(cron);
                return new CronTrigger(cron).nextExecutionTime(triggerContext);
            }
        });
    }
}
