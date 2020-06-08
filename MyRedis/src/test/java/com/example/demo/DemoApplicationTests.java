package com.example.demo;

import com.example.demo.mapper.CarMapper;
import com.example.demo.mapper.UserinfoMapper;
import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    RedisTemplate redisTemplate;
    @Test
    void contextLoads() {

        redisTemplate.opsForValue().set("name","aaa");

        System.out.println(redisTemplate.opsForValue().get("name"));

    }
@Test
    void contextLoads2() {

        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
               redisConnection.flushDb();
                return null;
            }
        });
    redisTemplate.opsForHash().put("laopan","love","girl");
    redisTemplate.opsForHash().put("laopan","age","20");
    redisTemplate.opsForHash().put("laopan","work","teacher");
    redisTemplate.opsForHash().put("laopan","gf","yg");

    List<String> list = redisTemplate.opsForHash().values("laopan");
    for (String s : list) {
        System.out.println(s);
    }
    System.out.println(redisTemplate.opsForHash().get("laopan","love"));

    }
@Test
    void contextLoads3() {

        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
               redisConnection.flushDb();
                return null;
            }
        });
    redisTemplate.opsForZSet().add("students","pan1",20);
    redisTemplate.opsForZSet().add("students","pan2",22);
    redisTemplate.opsForZSet().add("students","pan3",10);
    redisTemplate.opsForZSet().add("students","pan4",25);

redisTemplate.opsForZSet().remove("students","pan2");
    Set set = redisTemplate.opsForZSet().range("students", 0, -1);
    System.out.println(set);

}
@Test
    void contextLoads4() {

        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
               redisConnection.flushDb();
                return null;
            }
        });
    redisTemplate.opsForSet().add("students","pan1");
    redisTemplate.opsForSet().add("students","pan2");
    redisTemplate.opsForSet().add("students","pan3");
    redisTemplate.opsForSet().add("students","pan4");

redisTemplate.opsForSet().remove("students","pan2");
    Set set = redisTemplate.opsForSet().members("students");
    System.out.println(set);

}
@Test
    void contextLoads5() {

        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
               redisConnection.flushDb();
                return null;
            }
        });
    redisTemplate.opsForList().rightPush("students","yg");
    redisTemplate.opsForList().rightPush("students","ay");
    redisTemplate.opsForList().rightPush("students","al");
    redisTemplate.opsForList().rightPush("students","sb");

    Object students = redisTemplate.opsForList().index("students", 1);
    System.out.println(students);
    System.out.println("++++++++++++++++++++");
    List list = redisTemplate.opsForList().range("students", 0, -1);
    for (Object o : list) {
        System.out.println(o);
    }


}

}
