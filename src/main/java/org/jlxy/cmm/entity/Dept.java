package org.jlxy.cmm.entity;

/**
 * Created by ORCHID on 2017/4/2.
 */
public class Dept {
    private Integer Id;
    private Integer ParentId;
    private String Name;
    private String Description;

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

    public Dept() {
    }

    public Dept(Integer parentId, String name, String description) {
        ParentId = parentId;
        Name = name;
        Description = description;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "Id=" + Id +
                ", ParentId=" + ParentId +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
