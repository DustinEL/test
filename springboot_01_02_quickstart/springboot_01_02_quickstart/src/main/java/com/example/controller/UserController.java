package com.example.controller;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public String login(@RequestParam String uname, @RequestParam String pass) {
        User user = userMapper.findByUnameAndPass(uname, pass);  // 注意方法名
        if (user != null) {
            return "登录成功";
        } else {
            return "账号或密码错误";
        }
    }
}