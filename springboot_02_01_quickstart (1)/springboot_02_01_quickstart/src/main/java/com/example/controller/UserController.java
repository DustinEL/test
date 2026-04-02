package com.example.controller;


import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public String login(@RequestParam String uname, @RequestParam String pass){
        User user = userMapper.findByUnameAndPass(uname,pass);
        if(user!=null){
            return "登陆成功";
        }else{
            return "账号密码错误";
        }

    }

    @PostMapping("/register")
    public String post(@RequestParam String uname,@RequestParam String pass){
        User user = userMapper.findByUname(uname);
        if(user!=null){
            return "用户名已存在";
        }

        int addUser = userMapper.addUnameAndPass(uname,pass);
        if(addUser>0){
            return "注册成功";
        }else{
            return "注册失败";
        }
    }

    @PostMapping("/updatepass")
    public String modify(@RequestParam String uname,@RequestParam String old_pass,@RequestParam String new_pass){
        int user = userMapper.modifyByUnameToPass(uname, old_pass, new_pass);
        if(user > 0){
            return "修改成功,修改了"+user+"条数据";
        }else{
            return "修改失败";
        }

    }

    @PostMapping("/delete")
    public String delete(@RequestParam String uname){
        int user = userMapper.deleteByUname(uname);
        if(user > 0){
            return "删除成功,删除了"+user+"条数据";
        }else{
            return "删除失败";
        }

    }

}
