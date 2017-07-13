package org.jlxy.cmm.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.jlxy.cmm.entity.Document;
import org.jlxy.cmm.mapperImpl.DocumentMapperDynaSqlProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static org.jlxy.cmm.utils.CmConstants.DOCUMENTTABLE;

/**
 * Created by ORCHID on 2017/4/2.
 */
@Repository
public interface DocumentMapper {
    @Select("select * from " + DOCUMENTTABLE + " where id=#{id}")
    @Results({
            @Result(id = true, column = "id", property = "Id"),
            @Result(column = "user_id", property = "User", one = @One(select = "org.jlxy.cmm.mapper.UserMapper.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "filename", property = "FileName"),
            @Result(column = "title", property = "Title"),
            @Result(column = "description", property = "Description"),
            @Result(column = "create_time", property = "CreateTime")
    })
    Document selectById(Integer id);

    @SelectProvider(type = DocumentMapperDynaSqlProvider.class, method = "selectByParamWithPage")
    @Results({
            @Result(id = true, column = "id", property = "Id"),
            @Result(column = "user_id", property = "User", one = @One(select = "org.jlxy.cmm.mapper.UserMapper.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "filename", property = "FileName"),
            @Result(column = "title", property = "Title"),
            @Result(column = "description", property = "Description"),
            @Result(column = "create_time", property = "CreateTime")
    })
    List<Document> selectByParamWithPage(Map<String, Object> params);

    @Select("select * from " + DOCUMENTTABLE)
    @Results({
            @Result(id = true, column = "id", property = "Id"),
            @Result(column = "user_id", property = "User", one = @One(select = "org.jlxy.cmm.mapper.UserMapper.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "filename", property = "FileName"),
            @Result(column = "title", property = "Title"),
            @Result(column = "description", property = "Description"),
            @Result(column = "create_time", property = "CreateTime")
    })
    List<Document> selectAll();

    @SelectProvider(type = DocumentMapperDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    @Select("select count(*) from " + DOCUMENTTABLE)
    Integer countAll();

    @InsertProvider(type = DocumentMapperDynaSqlProvider.class, method = "save")
    @Results({
            @Result(id = true, column = "id", property = "Id"),
            @Result(column = "title", property = "Title"),
            @Result(column = "filname", property = "FileName"),
            @Result(column = "user_id", property = "User", one = @One(select = "org.jlxy.cmm.mapperUserMapper.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "description", property = "Description"),
            @Result(column = "create_time", property = "CreateTime")
    })
    Integer save(Document document);

    @Delete("delete from " + DOCUMENTTABLE + " where id=#{id}")
    Integer delete(Integer id);

    @SelectProvider(type = DocumentMapperDynaSqlProvider.class, method = "update")
    void update(Document document);
}
