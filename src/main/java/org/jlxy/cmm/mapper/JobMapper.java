package org.jlxy.cmm.mapper;

import org.apache.ibatis.annotations.*;
import org.jlxy.cmm.entity.Job;
import org.jlxy.cmm.mapperImpl.JobMapperDynaSqlProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static org.jlxy.cmm.utils.CmConstants.JOBTABLE;

/**
 * Created by ORCHID on 2017/4/2.
 */
@Repository
public interface JobMapper {
    @Select("SELECT * FROM " + JOBTABLE + " WHERE id=#{id}")
    Job select(Integer id);

    @SelectProvider(type = JobMapperDynaSqlProvider.class, method = "selectByParamWithPage")
    List<Job> selectByParamWithPage(Map<String, Object> params);

    @Select("SELECT * FROM " + JOBTABLE)
    List<Job> selectAll();

    @Select("SELECT COUNT(*) FROM " + JOBTABLE)
    Integer countAll();

    @SelectProvider(type = JobMapperDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    @InsertProvider(type = JobMapperDynaSqlProvider.class, method = "save")
    Integer save(Job job);

    @Delete("delete from " + JOBTABLE + " WHERE id=#{id}")
    int delete(Integer id);

    @UpdateProvider(type = JobMapperDynaSqlProvider.class, method = "update")
    void update(Job job);
}
