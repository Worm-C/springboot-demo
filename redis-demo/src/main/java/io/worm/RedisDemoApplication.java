package io.worm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author worm-c
 *
 *
 *
 * 重新启动项目，
 * 为了保证效果清晰，
 * 先使用flushall（这个指令用于清空Redis的所有key）清空key，
 * 再调用刚刚保存的方法，这时使用redis-cli查看刚刚保存的key
 * */
@SpringBootApplication
public class RedisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisDemoApplication.class, args);
    }

}
