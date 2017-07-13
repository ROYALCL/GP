package org.jlxy.cmm.mapperImpl;

import org.apache.ibatis.jdbc.SQL;
import org.jlxy.cmm.entity.Dept;

import java.util.Map;

import static org.jlxy.cmm.utils.CmConstants.DEPTTABLE;

/**
 * Created by ORCHID on 2017/4/3.
 */
public class DeptMapperDynaSqlProvider {
    // 分页动态查询
    public String selectByParamWithPage(final Map<String, Object> params) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM(DEPTTABLE);
                if (params.get("dept") != null) {
                    Dept dept = (Dept) params.get("dept");
                    if (dept.getName() != null && !dept.getName().equals("")) {
                        WHERE("  name LIKE CONCAT ('%',#{dept.Name},'%') ");
                    }
                }
            }
        }.toString();
        if (params.get("pageModel") != null) {
            sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
        }
        return sql;
    }

    // 动态查询总数量
    public String count(final Map<String, Object> params) {
        return new SQL() {
            {
                SELECT("count(*)");
                FROM(DEPTTABLE);
                if (params.get("dept") != null) {
                    Dept dept = (Dept) params.get("dept");
                    if (dept.getName() != null && !dept.getName().equals("")) {
                        WHERE("  name LIKE CONCAT ('%',#{dept.Name},'%') ");
                    }
                    if (dept.getParentId() != null && !dept.getParentId().equals("")) {
                        WHERE("  parent_id LIKE CONCAT ('%',#{dept.ParentId},'%') ");
                    }
                }
            }
        }.toString();
    }

    // 动态插入
    public String save(final Dept dept) {

        return new SQL() {
            {
                INSERT_INTO(DEPTTABLE);
                if (dept.getName() != null && !dept.getName().equals("")) {
                    VALUES("name", "#{Name}");
                }
                if (dept.getParentId() != null && !dept.getParentId().equals("")) {
                    VALUES("parent_id", "#{ParentId}");
                }
                if (dept.getDescription() != null && !dept.getDescription().equals("")) {
                    VALUES("description", "#{Description}");
                }
            }
        }.toString();
    }

    // 动态更新
    public String update(final Dept dept) {

        return new SQL() {
            {
                UPDATE(DEPTTABLE);
                if (dept.getParentId() != null) {
                    SET(" parent_id = #{ParentId} ");
                }
                if (dept.getName() != null) {
                    SET(" name = #{Name} ");
                }
                if (dept.getDescription() != null) {
                    SET(" description = #{Description} ");
                }
                WHERE(" id = #{Id} ");
            }
        }.toString();
    }
}
