package org.jlxy.cmm.mapperImpl;

import org.apache.ibatis.jdbc.SQL;
import org.jlxy.cmm.entity.Job;

import java.util.Map;

import static org.jlxy.cmm.utils.CmConstants.JOBTABLE;

/**
 * Created by ORCHID on 2017/4/2.
 */
public class JobMapperDynaSqlProvider {

    // 分页动态查询
    public String selectByParamWithPage(final Map<String, Object> params) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM(JOBTABLE);
                if (params.get("job") != null) {
                    Job job = (Job) params.get("job");
                    if (job.getName() != null && !job.getName().equals("")) {
                        WHERE("  name LIKE CONCAT ('%',#{job.Name},'%') ");
                    }
                }
            }
        }.toString();

        if (params.get("pageModel") != null) {
            sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
        }

        return sql;
    }

    public String save(final Job job) {
        return new SQL() {
            {
                INSERT_INTO(JOBTABLE);
                if (job.getName() != null) {
                    VALUES("name", "#{Name}");
                }
                if (job.getDescription() != null) {
                    VALUES("description", "#{Description}");
                }
            }
        }.toString();
    }

    public String update(final Job job) {
        return new SQL() {
            {
                UPDATE(JOBTABLE);
                if (job.getName() != null) {
                    SET("name=#{Name}");
                }
                if (job.getDescription() != null) {
                    SET("description=#{Description}");
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
                FROM(JOBTABLE);
                if (params.get("job") != null) {
                    Job job = (Job) params.get("job");
                    if (job.getName() != null && !job.getName().equals("")) {
                        WHERE("  name LIKE CONCAT ('%',#{job.Name},'%') ");
                    }
                }
            }
        }.toString();
    }
}
