package com.example.entity;


public class User {
    private Integer id;
    private String uname;
    private String pass;

    // getter 和 setter 方法（IDEA 可以自动生成：右键 → Generate → Getter and Setter）
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getUsername() { return uname; }
    public void setUsername(String username) { this.uname = uname; }
    public String getPassword() { return pass; }
    public void setPassword(String password) { this.pass = pass; }
}