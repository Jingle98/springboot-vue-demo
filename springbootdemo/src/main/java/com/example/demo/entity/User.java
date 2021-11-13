package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName Usere
 * @Description TODO
 * @Author Jingnan
 * @Date 2021/11/13 15:53
 * @Version
 **/
@Data
@TableName("user")
public class User {
    /**
     * Id自增
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String sex;
    private String address;
}
