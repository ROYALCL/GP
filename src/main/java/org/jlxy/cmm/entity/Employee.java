package org.jlxy.cmm.entity;

import java.util.Date;

/**
 * Created by ORCHID on 2017/4/2.
 */
public class Employee {
    private Integer Id;
    private Dept Dept;
    private Job Job;
    private String Name;
    private String CardId;
    private String Address;
    private String PostCode;
    private String Tellphone;
    private String Phone;
    private String QQ;
    private String Email;
    private String Sex;
    private Date Birthday;
    private String Education;
    private String Hobby;
    private String Description;
    private Date CreateTime;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Dept getDept() {
        return Dept;
    }

    public void setDept(Dept dept) {
        Dept = dept;
    }

    public Job getJob() {
        return Job;
    }

    public void setJob(Job job) {
        Job = job;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCardId() {
        return CardId;
    }

    public void setCardId(String cardId) {
        CardId = cardId;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPostCode() {
        return PostCode;
    }

    public void setPostCode(String postCode) {
        PostCode = postCode;
    }

    public String getTellphone() {
        return Tellphone;
    }

    public void setTellphone(String tellphone) {
        Tellphone = tellphone;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public String getHobby() {
        return Hobby;
    }

    public void setHobby(String hobby) {
        Hobby = hobby;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    public Employee() {
    }

    public Employee(Dept dept,Job job, String name, String cardId, String address, String postCode, String tellphone, String phone, String QQ, String email, String sex, Date birthday, String education, String hobby, String description, Date createTime) {
        Dept = dept;
        Job = job;
        Name = name;
        CardId = cardId;
        Address = address;
        PostCode = postCode;
        Tellphone = tellphone;
        Phone = phone;
        this.QQ = QQ;
        Email = email;
        Sex = sex;
        Birthday = birthday;
        Education = education;
        Hobby = hobby;
        Description = description;
        CreateTime = createTime;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", Dept=" + Dept.getName() +
                ", Job=" + Job.getName() +
                ", Name='" + Name + '\'' +
                ", CardId='" + CardId + '\'' +
                ", Address='" + Address + '\'' +
                ", PostCode='" + PostCode + '\'' +
                ", Tellphone='" + Tellphone + '\'' +
                ", Phone='" + Phone + '\'' +
                ", QQ='" + QQ + '\'' +
                ", Email='" + Email + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Birthday=" + Birthday +
                ", Education='" + Education + '\'' +
                ", Hobby='" + Hobby + '\'' +
                ", Description='" + Description + '\'' +
                ", CreateTime=" + CreateTime +
                '}';
    }
}
