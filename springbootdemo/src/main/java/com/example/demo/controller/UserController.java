package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Jingnan
 * @Date 2021/11/13 15:51
 * @Version
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserMapper userMapper;

//    这个接口用来接收前端给的json数据
//    收到之后，通过insert方法插入到数据库中
    @PostMapping
    public Result<?> save(@RequestBody User user){
        userMapper.insert(user);
        return Result.success();
    }
}
