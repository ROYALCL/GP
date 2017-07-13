package org.jlxy.cmm.mapperImpl;

import org.apache.ibatis.jdbc.SQL;
import org.jlxy.cmm.entity.Notice;

import java.util.Map;

import static org.jlxy.cmm.utils.CmConstants.NOTICETABLE;

/**
 * Created by ORCHID on 2017/4/2.
 */
public class NoticeMapperDynaSqlProvider {
    public String selectByParamWithPage(final Map<String, Object> params) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM(NOTICETABLE);
                if (params.get("notice") != null) {
                    Notice notice = (Notice) params.get("notice");
                    if (notice.getTitle() != null && !notice.getTitle().equals("")) {
                        WHERE("  title LIKE CONCAT ('%',#{notice.Title},'%') ");
                    }
                    if (notice.getContent() != null && !notice.getContent().equals("")) {
                        WHERE("  content LIKE CONCAT ('%',#{notice.Content},'%') ");
                    }

                }
            }
        }.toString();
        if (params.get("pageModel") != null) {
            sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
        }
        return sql;
    }

    public String save(final Notice notice) {
        return new SQL() {
            {
                INSERT_INTO(NOTICETABLE);
                if (notice.getTitle() != null) {
                    VALUES("title", "#{Title}");
                }
                if (notice.getUser() != null) {
                    VALUES("user_id", "#{User.Id}");
                }
                if (notice.getContent() != null) {
                    VALUES("content", "#{Content}");
                }
                if (notice.getCreateTime() != null) {
                    VALUES("create_time", "#{CreateTime}");
                }
            }
        }.toString();
    }

    public String update(final Notice notice) {
        return new SQL() {
            {
                UPDATE(NOTICETABLE);
                if (notice.getTitle() != null) {
                    SET("title=#{Title}");
                }
                if (notice.getUser() != null) {
                    SET("user_id=#{User.Id}");
                }
                if (notice.getContent() != null) {
                    SET("content=#{Content}");
                }
                if (notice.getCreateTime() != null) {
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
                FROM(NOTICETABLE);
                if (params.get("notice") != null) {
                    Notice notice = (Notice) params.get("notice");
                    if (notice.getTitle() != null && !notice.getTitle().equals("")) {
                        WHERE("  title LIKE CONCAT ('%',#{notice.Title},'%') ");
                    }
                    if (notice.getContent() != null && !notice.getContent().equals("")) {
                        WHERE("  content LIKE CONCAT ('%',#{notice.Content},'%') ");
                    }
                }
            }
        }.toString();
    }
}
