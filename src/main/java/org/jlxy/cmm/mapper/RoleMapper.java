package org.jlxy.cmm.mapper;

import org.apache.ibatis.annotations.*;
import org.jlxy.cmm.entity.Role;
import org.jlxy.cmm.mapperImpl.RoleMapperDynaSqlProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static org.jlxy.cmm.utils.CmConstants.ROLETABLE;


/**
 * Created by ORCHID on 2017/4/2.
 */
@Repository
public interface RoleMapper {
    @Select("SELECT * FROM " + ROLETABLE + " WHERE id=#{id}")
    Role selectById(Integer id);

    @SelectProvider(type = RoleMapperDynaSqlProvider.class, method = "selectByParamWithPage")
    List<Role> selectByParamWithPage(Map<String, Object> params);

    @Select("SELECT * FROM " + ROLETABLE + " WHERE name=#{name}")
    Role selectByName(String name);

    @Select("SELECT * FROM " + ROLETABLE + " WHERE parent_id=#{parentId}")
    Role selectByParentId(Integer parentId);

    @Select("SELECT * FROM " + ROLETABLE)
    List<Role> selectAll();

    @SelectProvider(type = RoleMapperDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    @Select("SELECT COUNT(*) FROM " + ROLETABLE+" WHERE parent_id=#{id}")
    Integer countByParent(Integer id);

    @Select("SELECT COUNT(*) FROM " + ROLETABLE)
    Integer countAll();

    @InsertProvider(type = RoleMapperDynaSqlProvider.class, method = "save")
    Integer save(Role role);

    @Delete("DELETE FROM " + ROLETABLE + " WHERE id=#{id}")
    int delete(@Param("id") Integer id);

    @UpdateProvider(type = RoleMapperDynaSqlProvider.class, method = "update")
    void update(Role role);
}
