package org.jlxy.cmm.mapperImpl;

import org.apache.ibatis.jdbc.SQL;
import org.jlxy.cmm.entity.Role;

import java.util.Map;

import static org.jlxy.cmm.utils.CmConstants.ROLETABLE;

/**
 * Created by ORCHID on 2017/4/9.
 */
public class RoleMapperDynaSqlProvider {

    // 分页动态查询
    public String selectByParamWithPage(final Map<String, Object> params) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM(ROLETABLE);
                if (params.get("role") != null) {
                    Role role = (Role) params.get("role");
                    if (role.getName() != null && !role.getName().equals("")) {
                        WHERE("  name LIKE CONCAT ('%',#{role.Name},'%') ");
                    }
                    if (role.getParentId() != null && !role.getParentId().equals("")) {
                        WHERE("  parent_id LIKE CONCAT ('%',#{role.ParentId},'%') ");
                    }
                }
            }
        }.toString();
        if (params.get("pageModel") != null) {
            sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
        }
        return sql;
    }

    public String save(final Role role) {
        return new SQL() {
            {
                INSERT_INTO(ROLETABLE);
                if (role.getParentId() != null) {
                    VALUES("parent_id", "#{ParentId}");
                }
                if (role.getName() != null) {
                    VALUES("name", "#{Name}");
                }
                if (role.getDescription() != null) {
                    VALUES("description", "#{Description}");
                }
                if (role.getCreateTime() != null) {
                    VALUES("create_time", "#{CreateTime}");
                }
            }
        }.toString();
    }

    public String update(final Role role) {
        return new SQL() {
            {
                UPDATE(ROLETABLE);
                if (role.getName() != null) {
                    SET("name=#{Name}");
                }
                if (role.getParentId() != null) {
                    SET("parent_id=#{ParentId}");
                }
                if (role.getDescription() != null) {
                    SET("description=#{Description}");
                }
                if (role.getCreateTime() != null) {
                    SET("create_time=#{CreateTime}");
                }
                WHERE("id=#{Id}");
            }
        }.toString();
    }

    // 动态查询总数量
    public String count(final Map<String, Object> params) {
        return new SQL() {
            {
                SELECT("count(*)");
                FROM(ROLETABLE);
                if (params.get("role") != null) {
                    Role role = (Role) params.get("role");
                    if (role.getName() != null && !role.getName().equals("")) {
                        WHERE("  name LIKE CONCAT ('%',#{role.Name},'%') ");
                    }
                    if (role.getParentId() != null && !role.getCreateTime().equals("")) {
                        WHERE("  parent_id LIKE CONCAT ('%',#{role.ParentId},'%') ");
                    }
                }
            }
        }.toString();
    }
}
