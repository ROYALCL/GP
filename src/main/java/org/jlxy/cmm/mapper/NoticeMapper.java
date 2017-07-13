package org.jlxy.cmm.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.jlxy.cmm.entity.Notice;
import org.jlxy.cmm.mapperImpl.NoticeMapperDynaSqlProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static org.jlxy.cmm.utils.CmConstants.NOTICETABLE;

/**
 * Created by ORCHID on 2017/4/2.
 */
@Repository
public interface NoticeMapper {

    @Select("SELECT * FROM " + NOTICETABLE + " WHERE id=#{id}")
    @Results({
            @Result(id = true, column = "id", property = "Id"),
            @Result(column = "title", property = "Title"),
            @Result(column = "content", property = "Content"),
            @Result(column = "create_time", property = "CreateTime"),
            @Result(column = "user_id", property = "User", one = @One(select = "org.jlxy.cmm.mapper.UserMapper.selectById", fetchType = FetchType.EAGER))
    })
    Notice select(@Param("id") Integer id);

    @Select("SELECT * FROM " + NOTICETABLE)
    @Results({
            @Result(id = true, column = "id", property = "Id"),
            @Result(column = "title", property = "Title"),
            @Result(column = "content", property = "Content"),
            @Result(column = "create_time", property = "CreateTime"),
            @Result(column = "user_id", property = "User", one = @One(select = "org.jlxy.cmm.mapper.UserMapper.selectById", fetchType = FetchType.EAGER))
    })
    List<Notice> selectAll();

    @SelectProvider(type = NoticeMapperDynaSqlProvider.class, method = "selectByParamWithPage")
    @Results({
            @Result(id = true, column = "id", property = "Id"),
            @Result(column = "title", property = "Title"),
            @Result(column = "content", property = "Content"),
            @Result(column = "create_time", property = "CreateTime"),
            @Result(column = "user_id", property = "User", one = @One(select = "org.jlxy.cmm.mapper.UserMapper.selectById", fetchType = FetchType.EAGER))
    })
    List<Notice> selectByParamWithPage(Map<String, Object> params);

    @SelectProvider(type = NoticeMapperDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    @Select("select count(*) from" + NOTICETABLE)
    Integer countAll();

    @InsertProvider(type = NoticeMapperDynaSqlProvider.class, method = "save")
    @Results({
            @Result(id = true, column = "id", property = "Id"),
            @Result(column = "title", property = "Title"),
            @Result(column = "content", property = "Content"),
            @Result(column = "create_time", property = "CreateTime"),
            @Result(column = "user_id", property = "User", one = @One(select = "org.jlxy.cmm.mapper.UserMapper.selectById", fetchType = FetchType.EAGER))
    })
    Integer save(Notice notice);

    @Delete("DELETE FROM " + NOTICETABLE + " WHERE id=#{Id}")
    int delete(Integer id);

    @UpdateProvider(type = NoticeMapperDynaSqlProvider.class, method = "update")
    void update(Notice notice);
}
