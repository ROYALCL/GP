package org.jlxy.cmm.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.jlxy.cmm.entity.Employee;
import org.jlxy.cmm.mapperImpl.EmployeeMapperDynaSqlProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static org.jlxy.cmm.utils.CmConstants.EMPLOYEETABLE;

/**
 * Created by ORCHID on 2017/4/2.
 */
@Repository
public interface EmployeeMapper {
    @Select("select * from " + EMPLOYEETABLE + " where id=#{id}")
    @Results({
            @Result(id = true, column = "id", property = "Id"),
            @Result(column = "dept_id", property = "Dept", one = @One(select = "org.jlxy.cmm.mapper.DeptMapper.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "job_id", property = "Job", one = @One(select = "org.jlxy.cmm.mapper.JobMapper.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "name", property = "Name"),
            @Result(column = "car_id", property = "CarId"),
            @Result(column = "address", property = "Address"),
            @Result(column = "post_code", property = "PostCode"),
            @Result(column = "tel", property = "Tellphone"),
            @Result(column = "phone", property = "Phone"),
            @Result(column = "qq", property = "QQ"),
            @Result(column = "email", property = "Email"),
            @Result(column = "sex", property = "Sex"),
            @Result(column = "birthday", property = "Birthday"),
            @Result(column = "education", property = "Education"),
            @Result(column = "hobby", property = "Hobby"),
            @Result(column = "description", property = "Description"),
            @Result(column = "create_time", property = "CreateTime")
    })
    Employee selectById(Integer id);

    @Select("SELECT * FOM "+EMPLOYEETABLE+" where job_id=#{id}")
    List<Employee> selectByJobId();

    @Select("SELECT * FOM "+EMPLOYEETABLE+" where dept_id=#{id}")
    List<Employee> selectByDeptId();

    @Select("select * from " + EMPLOYEETABLE + " where name=#{name}")
    @Results({
            @Result(id = true, column = "id", property = "Id"),
            @Result(column = "dept_id", property = "Dept", one = @One(select = "org.jlxy.cmm.mapper.DeptMapper.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "job_id", property = "Job", one = @One(select = "org.jlxy.cmm.mapper.JobMapper.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "name", property = "Name"),
            @Result(column = "car_id", property = "CarId"),
            @Result(column = "address", property = "Address"),
            @Result(column = "post_code", property = "PostCode"),
            @Result(column = "tel", property = "Tellphone"),
            @Result(column = "phone", property = "Phone"),
            @Result(column = "qq", property = "QQ"),
            @Result(column = "email", property = "Email"),
            @Result(column = "sex", property = "Sex"),
            @Result(column = "birthday", property = "Birthday"),
            @Result(column = "education", property = "Education"),
            @Result(column = "hobby", property = "Hobby"),
            @Result(column = "description", property = "Description"),
            @Result(column = "create_time", property = "CreateTime")
    })
    Employee selectByName(String name);

    ;

    @Select("select * from " + EMPLOYEETABLE + " where email=#{email}")
    @Results({
            @Result(id = true, column = "id", property = "Id"),
            @Result(column = "dept_id", property = "Dept", one = @One(select = "org.jlxy.cmm.mapper.DeptMapper.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "job_id", property = "Job", one = @One(select = "org.jlxy.cmm.mapper.JobMapper.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "name", property = "Name"),
            @Result(column = "car_id", property = "CarId"),
            @Result(column = "address", property = "Address"),
            @Result(column = "post_code", property = "PostCode"),
            @Result(column = "tel", property = "Tellphone"),
            @Result(column = "phone", property = "Phone"),
            @Result(column = "qq", property = "QQ"),
            @Result(column = "email", property = "Email"),
            @Result(column = "sex", property = "Sex"),
            @Result(column = "birthday", property = "Birthday"),
            @Result(column = "education", property = "Education"),
            @Result(column = "hobby", property = "Hobby"),
            @Result(column = "description", property = "Description"),
            @Result(column = "create_time", property = "CreateTime")
    })
    Employee selectByEmail(String email);

    @SelectProvider(type = EmployeeMapperDynaSqlProvider.class, method = "selectByParamWithPage")
    @Results({
            @Result(id = true, column = "id", property = "Id"),
            @Result(column = "dept_id", property = "Dept", one = @One(select = "org.jlxy.cmm.mapper.DeptMapper.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "job_id", property = "Job", one = @One(select = "org.jlxy.cmm.mapper.JobMapper.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "name", property = "Name"),
            @Result(column = "car_id", property = "CarId"),
            @Result(column = "address", property = "Address"),
            @Result(column = "post_code", property = "PostCode"),
            @Result(column = "tel", property = "Tellphone"),
            @Result(column = "phone", property = "Phone"),
            @Result(column = "qq", property = "QQ"),
            @Result(column = "email", property = "Email"),
            @Result(column = "sex", property = "Sex"),
            @Result(column = "birthday", property = "Birthday"),
            @Result(column = "education", property = "Education"),
            @Result(column = "hobby", property = "Hobby"),
            @Result(column = "description", property = "Description"),
            @Result(column = "create_time", property = "CreateTime")
    })
    List<Employee> selectByParamWithPage(Map<String, Object> params);

    @Select("select * from " + EMPLOYEETABLE)
    @Results({
            @Result(id = true, column = "id", property = "Id"),
            @Result(column = "dept_id", property = "Dept", one = @One(select = "org.jlxy.cmm.mapper.DeptMapper.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "job_id", property = "Job", one = @One(select = "org.jlxy.cmm.mapper.JobMapper.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "name", property = "Name"),
            @Result(column = "car_id", property = "CarId"),
            @Result(column = "address", property = "Address"),
            @Result(column = "post_code", property = "PostCode"),
            @Result(column = "tel", property = "Tellphone"),
            @Result(column = "phone", property = "Phone"),
            @Result(column = "qq", property = "QQ"),
            @Result(column = "email", property = "Email"),
            @Result(column = "sex", property = "Sex"),
            @Result(column = "birthday", property = "Birthday"),
            @Result(column = "education", property = "Education"),
            @Result(column = "hobby", property = "Hobby"),
            @Result(column = "description", property = "Description"),
            @Result(column = "create_time", property = "CreateTime")
    })
    List<Employee> selectAll();

    @SelectProvider(type = EmployeeMapperDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    @Select("select count(*) from" + EMPLOYEETABLE)
    Integer countAll();

    @InsertProvider(type = EmployeeMapperDynaSqlProvider.class, method = "save")
    Integer save(Employee employee);

    @Delete("delete from " + EMPLOYEETABLE + " where id=#{id}")
    Integer delete(Integer id);

    //@Delete("delete from "+EMPLOYEETABLE+" where name=#{name}")
    //Integer delete(String name);

    @UpdateProvider(type = EmployeeMapperDynaSqlProvider.class, method = "update")
    void update(Employee employee);
}
