package com.example.mapper;


import com.example.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("SELECT *FROM users WHERE uname = #{uname} AND pass = #{pass}")
    User findByUnameAndPass(String uname, String pass);
    @Select("SELECT *FROM users WHERE uname = #{uname}")
    User findByUname(String uname);


    @Insert("INSERT users (uname,pass) VALUES (#{uname},#{pass})")
    int addUnameAndPass(String uname,String pass);

    @Update("UPDATE users SET pass = #{new_pass} WHERE uname = #{uname} AND pass = #{old_pass}")
    int modifyByUnameToPass(String uname,String old_pass,String new_pass);


    @Delete("DELETE FROM users WHERE uname = #{uname}")
    int deleteByUname(String uname);


}
