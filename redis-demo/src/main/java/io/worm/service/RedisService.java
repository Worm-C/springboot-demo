package io.worm.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

//表明这是一个受Spring管理的JavaBean对象
@Service
public class RedisService {
    //注入

    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    /**
     *创建两个方法：
     * Set方法和Get方法，
     * 分别用于使用RedisTemplate进行存放数据和取出数据
     *
     * */
    //public void set(String key,Object value){
        //设置redis里面的编码问题
        //redisTemplate.setKeySerializer(new StringRedisSerializer());
        //Jackson2JsonRedisSerializer对User类数据进行实例化编码
        //redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Object.class));
        //vo.set(key,value);

    //}
    public void set(String key, Object value, Long time, TimeUnit t){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Object.class));
        ValueOperations<String, Object> so = redisTemplate.opsForValue();
        so.set(key,value,time,t);
    }
    public Object get(String key){
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }


}
