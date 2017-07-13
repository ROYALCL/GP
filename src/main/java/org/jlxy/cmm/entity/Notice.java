package org.jlxy.cmm.entity;

import java.util.Date;

/**
 * Created by ORCHID on 2017/4/2.
 */
public class Notice {
    private Integer Id;
    private User User;
    private String Title;
    private String Content;
    private Date CreateTime;

    public Notice() {
    }

    public Notice(User user, String title, String content, Date createTime) {
        User = user;
        Title = title;
        Content = content;
        CreateTime = createTime;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        User = user;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "Id=" + Id +
                ", User=" + User.getName() +
                ", Title='" + Title + '\'' +
                ", Content='" + Content + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                '}';
    }
}
