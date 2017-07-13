package org.jlxy.cmm.entity;

import java.util.Date;

/**
 * Created by ORCHID on 2017/4/2.
 */
public class User {
    private Integer Id;
    private Role Role;
    private String Name;
    private String PassWord;
    private String NickName;
    private String Sex;
    private String Email;
    private String Used;
    private Date CreateTime;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Role getRole() {
        return Role;
    }

    public void setRole(Role role) {
        Role = role;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsed() {
        return Used;
    }

    public void setUsed(String used) {
        Used = used;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    public User() {
    }

    public User(Role role, String name, String passWord, String nickName, String sex, String email, String used, Date createTime) {
        Role = role;
        Name = name;
        PassWord = passWord;
        NickName = nickName;
        Sex = sex;
        Email = email;
        Used = used;
        CreateTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Role=" + Role.getName() +
                ", Name='" + Name + '\'' +
                ", PassWord='" + PassWord + '\'' +
                ", NickName='" + NickName + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Email='" + Email + '\'' +
                ", Used='" + Used + '\'' +
                ", CreateTime=" + CreateTime +
                '}';
    }
}
