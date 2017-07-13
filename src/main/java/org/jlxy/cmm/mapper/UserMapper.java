package org.jlxy.cmm.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.jlxy.cmm.entity.User;
import org.jlxy.cmm.mapperImpl.UserMapperDynaSqlProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static org.jlxy.cmm.utils.CmConstants.USERTABLE;


/**
 * Created by ORCHID on 2017/4/2.
 */
@Repository
public interface UserMapper {
    @Select("SELECT * FROM " + USERTABLE + " WHERE id=#{id}")
    @Results({
            @Result(id=true,column = "id",property = "Id"),
            @Result(column = "name",property = "Name"),
            @Result(column = "password",property = "PassWord"),
            @Result(column = "nick_name",property = "NickName"),
            @Result(column = "sex",property = "Sex"),
            @Result(column = "email",property = "Email"),
            @Result(column = "used",property = "Used"),
            @Result(column = "role_id",property = "Role",one = @One(select = "org.jlxy.cmm.mapper.RoleMapper.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "create_time",property = "CreateTime")
    })
    User selectById(Integer id);

    @SelectProvider(type = UserMapperDynaSqlProvider.class, method = "selectByParamWithPage")
    @Results({
            @Result(id=true,column = "id",property = "Id"),
            @Result(column = "name",property = "Name"),
            @Result(column = "password",property = "PassWord"),
            @Result(column = "nick_name",property = "NickName"),
            @Result(column = "sex",property = "Sex"),
            @Result(column = "email",property = "Email"),
            @Result(column = "used",property = "Used"),
            @Result(column = "role_id",property = "Role",one = @One(select = "org.jlxy.cmm.mapper.RoleMapper.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "create_time",property = "CreateTime")
    })
    List<User> selectByParamWithPage(Map<String, Object> params);

    @Select("SELECT * FROM " + USERTABLE + " WHERE name=#{name}")
    @Results({
            @Result(id=true,column = "id",property = "Id"),
            @Result(column = "name",property = "Name"),
            @Result(column = "password",property = "PassWord"),
            @Result(column = "nick_name",property = "NickName"),
            @Result(column = "sex",property = "Sex"),
            @Result(column = "email",property = "Email"),
            @Result(column = "used",property = "Used"),
            @Result(column = "role_id",property = "Role",one = @One(select = "org.jlxy.cmm.mapper.RoleMapper.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "create_time",property = "CreateTime")
    })
    User selectByName(String name);

    @Select("SELECT * FROM " + USERTABLE + " WHERE email=#{email}")
    @Results({
            @Result(id=true,column = "id",property = "Id"),
            @Result(column = "name",property = "Name"),
            @Result(column = "password",property = "PassWord"),
            @Result(column = "nick_name",property = "NickName"),
            @Result(column = "sex",property = "Sex"),
            @Result(column = "email",property = "Email"),
            @Result(column = "used",property = "Used"),
            @Result(column = "role_id",property = "Role",one = @One(select = "org.jlxy.cmm.mapper.RoleMapper.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "create_time",property = "CreateTime")
    })
    User selectByEmail(String email);

    @Select("SELECT * FROM " + USERTABLE + " WHERE name=#{name} and password=#{password}")
    @Results({
            @Result(id=true,column = "id",property = "Id"),
            @Result(column = "name",property = "Name"),
            @Result(column = "password",property = "PassWord"),
            @Result(column = "nick_name",property = "NickName"),
            @Result(column = "sex",property = "Sex"),
            @Result(column = "email",property = "Email"),
            @Result(column = "used",property = "Used"),
            @Result(column = "role_id",property = "Role",one = @One(select = "org.jlxy.cmm.mapper.RoleMapper.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "create_time",property = "CreateTime")
    })
    User selectByLogin(@Param("name") String name, @Param("password") String password);

    @Select("SELECT * FROM " + USERTABLE+ " WHERE role_id=#{id}")
    @Results({
            @Result(id=true,column = "id",property = "Id"),
            @Result(column = "name",property = "Name"),
            @Result(column = "password",property = "PassWord"),
            @Result(column = "nick_name",property = "NickName"),
            @Result(column = "sex",property = "Sex"),
            @Result(column = "email",property = "Email"),
            @Result(column = "used",property = "Used"),
            @Result(column = "role_id",property = "Role",one = @One(select = "org.jlxy.cmm.mapper.RoleMapper.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "create_time",property = "CreateTime")
    })
    List<User> selectByRole(Integer id);

    @Select("SELECT * FROM " + USERTABLE)
    @Results({
            @Result(id=true,column = "id",property = "Id"),
            @Result(column = "name",property = "Name"),
            @Result(column = "password",property = "PassWord"),
            @Result(column = "nick_name",property = "NickName"),
            @Result(column = "sex",property = "Sex"),
            @Result(column = "email",property = "Email"),
            @Result(column = "used",property = "Used"),
            @Result(column = "role_id",property = "Role",one = @One(select = "org.jlxy.cmm.mapper.RoleMapper.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "create_time",property = "CreateTime")
    })
    List<User> selectAll();

    @SelectProvider(type = UserMapperDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    @Select("SELECT COUNT(*) FROM " + USERTABLE)
    Integer countAll();

    @InsertProvider(type = UserMapperDynaSqlProvider.class, method = "save")
    @Results({
            @Result(id=true,column = "id",property = "Id"),
            @Result(column = "name",property = "Name"),
            @Result(column = "password",property = "PassWord"),
            @Result(column = "nick_name",property = "NickName"),
            @Result(column = "sex",property = "Sex"),
            @Result(column = "email",property = "Email"),
            @Result(column = "used",property = "Used"),
            @Result(column = "role_id",property = "Role",one = @One(select = "org.jlxy.cmm.mapper.RoleMapper.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "create_time",property = "CreateTime")
    })
    Integer save(User user);

    @Delete("DELETE FROM " + USERTABLE + " WHERE id=#{id}")
    int delete(@Param("id") Integer id);

    @UpdateProvider(type = UserMapperDynaSqlProvider.class, method = "update")
    @Results({
            @Result(id=true,column = "id",property = "Id"),
            @Result(column = "name",property = "Name"),
            @Result(column = "password",property = "PassWord"),
            @Result(column = "nick_name",property = "NickName"),
            @Result(column = "sex",property = "Sex"),
            @Result(column = "email",property = "Email"),
            @Result(column = "used",property = "Used"),
            @Result(column = "role_id",property = "Role",one = @One(select = "org.jlxy.cmm.mapper.RoleMapper.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "create_time",property = "CreateTime")
    })
    void update(User user);
}
