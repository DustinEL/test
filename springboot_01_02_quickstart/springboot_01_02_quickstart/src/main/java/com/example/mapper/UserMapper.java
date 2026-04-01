package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper  // 这个注解告诉 Spring 这是一个 MyBatis 的 Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE uname = #{uname} AND pass = #{pass}")
    User findByUnameAndPass(String uname, String pass);
}