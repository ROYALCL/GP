package org.jlxy.cmm.mapperImpl;

import org.apache.ibatis.jdbc.SQL;
import org.jlxy.cmm.entity.Document;

import java.util.Map;

import static org.jlxy.cmm.utils.CmConstants.DOCUMENTTABLE;

/**
 * Created by ORCHID on 2017/4/3.
 */
public class DocumentMapperDynaSqlProvider {
    // 分页动态查询
    public String selectByParamWithPage(final Map<String, Object> params) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM(DOCUMENTTABLE);
                if (params.get("document") != null) {
                    Document document = (Document) params.get("document");
                    if (document.getTitle() != null && !document.getTitle().equals("")) {
                        WHERE("  title LIKE CONCAT ('%',#{document.Title},'%') ");
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
                FROM(DOCUMENTTABLE);
                if (params.get("document") != null) {
                    Document document = (Document) params.get("document");
                    if (document.getTitle() != null && !document.getTitle().equals("")) {
                        WHERE("  title LIKE CONCAT ('%',#{document.Title},'%') ");
                    }
                }
            }
        }.toString();
    }

    // 动态插入
    public String save(final Document document) {
        return new SQL() {
            {
                INSERT_INTO(DOCUMENTTABLE);
                if (document.getTitle() != null && !document.getTitle().equals("")) {
                    VALUES("title", "#{title}");
                }
                if (document.getFileName() != null && !document.getFileName().equals("")) {
                    VALUES("filename", "#{fileName}");
                }
                if (document.getDescription() != null && !document.getDescription().equals("")) {
                    VALUES("description", "#{Description}");
                }
                if (document.getUser() != null && document.getUser().getId() != null) {
                    VALUES("user_id", "#{user.Id}");
                }
                if (document.getCreateTime() != null && document.getCreateTime() != null) {
                    VALUES("create_time", "#{CreateTime}");
                }
            }
        }.toString();
    }

    // 动态更新
    public String update(final Document document) {
        return new SQL() {
            {
                UPDATE(DOCUMENTTABLE);
                if (document.getTitle() != null && !document.getTitle().equals("")) {
                    SET(" title = #{Title} ");
                }
                if (document.getFileName() != null && !document.getFileName().equals("")) {
                    SET(" filename = #{FileName} ");
                }
                if (document.getDescription() != null && !document.getDescription().equals("")) {
                    SET("description = #{Description}");
                }
                if (document.getUser() != null && document.getUser().getId() != null) {
                    SET("user_id = #{user.Id}");
                }
                WHERE(" id = #{Id} ");
            }
        }.toString();
    }
}
