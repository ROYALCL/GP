package org.jlxy.cmm.entity;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * Created by ORCHID on 2017/4/2.
 */
public class Document {
    private Integer Id;
    private User User;
    private String Title;
    private String FileName;
    private MultipartFile File;
    private String Description;
    private Date CreateTime;

    public Document(User user, String title, String fileName, String description, Date createTime) {
        User = user;
        Title = title;
        FileName = fileName;
        Description = description;
        CreateTime = createTime;
    }

    public Document() {
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

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
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

    public MultipartFile getFile() {
        return File;
    }

    public void setFile(MultipartFile file) {
        File = file;
    }

    @Override
    public String toString() {
        return "Document{" +
                "Id=" + Id +
                ", User=" + User +
                ", Title='" + Title + '\'' +
                ", FileName='" + FileName + '\'' +
                ", Description='" + Description + '\'' +
                ", CreateTime=" + CreateTime +
                '}';
    }
}
