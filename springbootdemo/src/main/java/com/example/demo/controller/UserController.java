package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    // 用户名和密码用user对象进行接收
    public Result<?> login(@RequestBody User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        queryWrapper.eq("password", user.getPassword());
        User res = userMapper.selectOne(queryWrapper);
        if (res == null) {
            return Result.error("-1", "用户名或密码错误");
        }
        // 生成token
//        String token = TokenUtils.genToken(res);
//        res.setToken(token);
        return Result.success();
    }


    // 这个接口用来接收前端给的json数据
    // 收到之后，通过insert方法插入到数据库中
    // 新增
    @PostMapping
    public Result<?> save(@RequestBody User user) {
        if (user.getPassword() == null) {
            user.setPassword("123456");
        }
//        mybatisPlus提供的方法
        userMapper.insert(user);
        return Result.success();
    }

    // put一般用来更新
    @PutMapping
    public Result<?> update(@RequestBody User user) {
//        mybatisPlus提供的方法
        userMapper.updateById(user);
        return Result.success();
    }

    // delete功能
    @DeleteMapping("/{id}")
    public Result<?> update(@PathVariable Long id) {
        userMapper.deleteById(id);
        return Result.success();
    }

    /**
     * 用户分页列表查询，包含书籍表的一对多查询
     *
     * @param pageNum
     * @param pageSize
     * @param search   在前台定义了关键字
     * @return
     */
    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search) {
        // new Page<>(pageNum, pageSize)这个是mybatis提供的分页对象
        // Wrappers也是myBatisPlus提供的对象
        //Page<User> userPage = userMapper.selectPage(new Page<>(pageNum,pageSize),Wrappers.<User>lambdaQuery().like(User::getUsername,search));
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        if (StringUtils.isNotBlank(search)) {
            wrapper.like(User::getUsername, search);
        }
        Page<User> userPage = userMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(userPage);
    }
}
