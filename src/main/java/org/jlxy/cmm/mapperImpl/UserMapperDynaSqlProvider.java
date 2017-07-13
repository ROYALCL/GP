package org.jlxy.cmm.mapperImpl;

import org.apache.ibatis.jdbc.SQL;
import org.jlxy.cmm.entity.User;
import org.jlxy.cmm.utils.BOOLEAN;

import java.util.Map;

import static org.jlxy.cmm.utils.CmConstants.USERTABLE;

/**
 * Created by ORCHID on 2017/4/2.
 */
public class UserMapperDynaSqlProvider {
    public String selectByParamWithPage(final Map<String, Object> params) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM(USERTABLE);
                if (params.get("user") != null) {
                    User user = (User) params.get("user");
                    if (user.getName() != null && !user.getRole().equals("")) {
                        WHERE("  role_id LIKE CONCAT ('%',#{user.Role.Id},'%') ");
                    }
                    if (user.getRole() != null && !user.getName().equals("")) {
                        WHERE("  name LIKE CONCAT ('%',#{user.Name},'%') ");
                    }
                    if (user.getUsed() != null && !user.getUsed().equals("")) {
                        if (user.getUsed().equals(BOOLEAN.TRUE.getKey())) {
                            String used=BOOLEAN.TRUE.getValue();
                            WHERE(" used LIKE CONCAT ('%',#{used},'%') ");
                        } else if (user.getUsed().equals(BOOLEAN.FALSE.getKey())) {
                            String used=BOOLEAN.FALSE.getValue();
                            WHERE(" used LIKE CONCAT ('%',#{used},'%') ");
                        }
                    }
                }
            }
        }.toString();
        if (params.get("pageModel") != null) {
            sql += " limit #{pageModel.firstLimitParam} , #{pageModel.PageSize}  ";
        }
        return sql;
    }

    public String save(final User user) {
        return new SQL() {
            {
                INSERT_INTO(USERTABLE);
                if (user.getName() != null) {
                    VALUES("name", "#{Name}");
                }
                if (user.getPassWord() != null) {
                    VALUES("password", "#{PassWord}");
                }
                if (user.getNickName() != null) {
                    VALUES("nick_name", "#{NickName}");
                }
                if (user.getSex() != null) {
                    VALUES("sex", "#{Sex}");
                }
                if (user.getEmail() != null) {
                    VALUES("email", "#{Email}");
                }
                if (user.getRole() != null) {
                    VALUES("role_id", "#{Role.Id}");
                }
                if (user.getUsed()!=null) {
                    VALUES("used", "#{Used}");
                }
                if (user.getCreateTime() != null) {
                    VALUES("create_time", "#{CreateTime}");
                }
            }
        }.toString();
    }

    public String update(final User user) {
        return new SQL() {
            {
                UPDATE(USERTABLE);
                if (user.getName() != null) {
                    SET("name=#{Name}");
                }
                if (user.getPassWord() != null) {
                    SET("password=#{PassWord}");
                }
                if (user.getNickName() != null) {
                    SET("nick_name=#{NickName}");
                }
                if (user.getSex() != null) {
                    SET("sex=#{Sex}");
                }
                if (user.getEmail() != null) {
                    SET("email=#{Email}");
                }
                if (user.getRole() != null) {
                    SET("role_id=#{Role.Id}");
                }
                if (user.getUsed()!=null) {
                    if (user.getUsed()== BOOLEAN.TRUE.getKey()) {
                        String used=BOOLEAN.TRUE.getValue();
                        SET(" used =#{used}");
                    } else if (user.getUsed()== BOOLEAN.FALSE.getKey()) {
                        String used=BOOLEAN.FALSE.getValue();
                        SET(" used =#{used}");
                    }
                }
                if (user.getCreateTime() != null) {
                    SET("create_time=#{CreateTime}");
                }
                WHERE("user.Id=#{Id}");
            }
        }.toString();
    }

    // 动态查询总数量
    public String count(final Map<String, Object> params) {
        return new SQL() {
            {
                SELECT("count(*)");
                FROM(USERTABLE);
                if (params.get("user") != null) {
                    User user = (User) params.get("user");
                    if (user.getName() != null && !user.getName().equals("")) {
                        WHERE(" username LIKE CONCAT ('%',#{user.Name},'%') ");
                    }
                    if (user.getRole() != null && !user.getRole().equals("")) {
                        WHERE(" role_id LIKE CONCAT ('%',#{user.Role.Id},'%') ");
                    }
                    if (user.getUsed() != null && !user.getUsed().equals("")) {
                        if (user.getUsed()== BOOLEAN.TRUE.getKey()) {
                            String used=BOOLEAN.TRUE.getValue();
                            WHERE(" used LIKE CONCAT ('%',#{used},'%') ");
                        } else if (user.getUsed()== BOOLEAN.FALSE.getKey()) {
                            String used=BOOLEAN.FALSE.getValue();
                            WHERE(" used LIKE CONCAT ('%',#{used},'%') ");
                        }
                    }
                }
            }
        }.toString();
    }
}
