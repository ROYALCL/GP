package org.jlxy.cmm.mapper;

import org.apache.ibatis.annotations.*;
import org.jlxy.cmm.entity.Dept;
import org.jlxy.cmm.mapperImpl.DeptMapperDynaSqlProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static org.jlxy.cmm.utils.CmConstants.DEPTTABLE;


/**
 * Created by ORCHID on 2017/4/2.
 */
@Repository
public interface DeptMapper {
    @Select("select * from " + DEPTTABLE + " where id=#{id}")
    @Results({
            @Result(id = true, column = "id", property = "Id"),
            @Result(column = "parent_id", property = "ParentId"),
            @Result(column = "name", property = "Name"),
            @Result(column = "description", property = "Description")
    })
    Dept selectById(Integer id);

    @Select("select * from " + DEPTTABLE + " where parent_id=#{id}")
    @Results({
            @Result(id = true, column = "id", property = "Id"),
            @Result(column = "parent_id", property = "ParentId"),
            @Result(column = "name", property = "Name"),
            @Result(column = "description", property = "Description")
    })
    Dept selectByParentId(Integer id);

    @Select("select * from " + DEPTTABLE)
    @Results({
            @Result(id = true, column = "id", property = "Id"),
            @Result(column = "parent_id", property = "ParentId"),
            @Result(column = "name", property = "Name"),
            @Result(column = "description", property = "Description")
    })
    List<Dept> selectAll();

    @SelectProvider(type = DeptMapperDynaSqlProvider.class, method = "selectByParamWithPage")
    @Results({
            @Result(id = true, column = "id", property = "Id"),
            @Result(column = "parent_id", property = "ParentId"),
            @Result(column = "name", property = "Name"),
            @Result(column = "description", property = "Description")
    })
    List<Dept> selectByParamWithPage(Map<String, Object> params);

    @SelectProvider(type = DeptMapperDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    @Select("select count(*) from " + DEPTTABLE)
    Integer countAll();

    @InsertProvider(type = DeptMapperDynaSqlProvider.class, method = "save")
    @Results({
            @Result(id = true, column = "id", property = "Id"),
            @Result(column = "parent_id", property = "ParentId"),
            @Result(column = "name", property = "Name"),
            @Result(column = "description", property = "Description")
    })
    Integer save(Dept dept);

    @Delete("delete from " + DEPTTABLE + " where id=#{id}")
    int delete(Integer id);

    @UpdateProvider(type = DeptMapperDynaSqlProvider.class, method = "update")
    @Results({
            @Result(id = true, column = "id", property = "Id"),
            @Result(column = "parent_id", property = "ParentId"),
            @Result(column = "name", property = "Name"),
            @Result(column = "description", property = "Description")
    })
    void update(Dept dept);
}
