package org.jlxy.cmm.entity;

/**
 * Created by ORCHID on 2017/4/2.
 */
public class Job {
    private Integer Id;
    private String Name;
    private String Description;

    public Job() {
    }

    public Job(String name, String description) {
        Name = name;
        Description = description;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    @Override
    public String toString() {
        return "Job{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
