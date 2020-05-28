package io.worm.controller;

import io.worm.entity.User;
import io.worm.repository.UserRepository;
import io.worm.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
/**
 * @author worm-c
 *
 *
 * */
//被Spring管理 表明是一个组件
@RestController
public class RedisController {
    //注入
    @Autowired
    private RedisService redisService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/saveUser")
    public String saveUser(Long id, String userName, String userPassword) {
        User user = new User(id, userName, userPassword);
        //redisService.set(id.toString(), user);
        return "成功写入redis";
    }

    @GetMapping("gteUserById")
    public Object getUserById(Long id) {
        return redisService.get(id.toString());
    }

    @GetMapping("save")
    public String save() {
        User user = new User(1l, "worm", "123456");
        return "success";
    }

    @GetMapping("saveUser2")
    public User saveUser2(Long id, String userName, String userPassword) {
        User user = new User(id, userName, userPassword);
        userRepository.save(user);
        return user;
    }

    @GetMapping("getUser")
    public Object getUser(Long id) {
        Object o = redisService.get(id.toString());
        if (o == null) {
            o = (userRepository.findById(id)).get();
            if (o!=null){
                redisService.set(id.toString(),o,100L, TimeUnit.SECONDS);
            }
        }
        return o;
    }

}
