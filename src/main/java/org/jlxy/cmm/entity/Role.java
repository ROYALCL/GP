package org.jlxy.cmm.entity;

import java.util.Date;

/**
 * Created by ORCHID on 2017/4/9.
 */
public class Role {
    private Integer Id;
    private Integer ParentId;
    private String Name;
    private String Description;
    private Date CreateTime;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getParentId() {
        return ParentId;
    }

    public void setParentId(Integer parentId) {
        ParentId = parentId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public Role() {
    }

    public Role(Integer parentId, String name, String description, Date createTime) {
        ParentId = parentId;
        Name = name;
        Description = description;
        CreateTime = createTime;
    }

    @Override
    public String toString() {
        return "Role{" +
                "Id=" + Id +
                ", ParentId=" + ParentId +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", CreateTime=" + CreateTime +
                '}';
    }
}
