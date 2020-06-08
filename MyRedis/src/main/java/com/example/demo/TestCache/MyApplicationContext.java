package com.example.demo.TestCache;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyApplicationContext implements ApplicationContextAware {
    private static ApplicationContext ac;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        ac=applicationContext;

    }

    public static Object getBean(String name) {
        return ac.getBean(name);
    }
    public static <E>E getBean(Class<E> cls) {
        return ac.getBean(cls);


    }

}
