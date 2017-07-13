package org.jlxy.cmm.mapperImpl;

import org.apache.ibatis.jdbc.SQL;
import org.jlxy.cmm.entity.Employee;

import java.util.Map;

import static org.jlxy.cmm.utils.CmConstants.EMPLOYEETABLE;

/**
 * Created by ORCHID on 2017/4/3.
 */
public class EmployeeMapperDynaSqlProvider {
    // 分页动态查询
    public String selectByParamWithPage(final Map<String, Object> params) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM(EMPLOYEETABLE);
                if (params.get("employee") != null) {
                    Employee employee = (Employee) params.get("employee");
                    if (employee.getDept() != null && employee.getDept().getId() != null && employee.getDept().getId() != 0) {
                        WHERE(" dept_id = #{employee.Dept.Id} ");
                    }
                    if (employee.getJob() != null && employee.getJob().getId() != null && employee.getJob().getId() != 0) {
                        WHERE(" job_id = #{employee.Job.Id} ");
                    }
                    if (employee.getName() != null && !employee.getName().equals("")) {
                        WHERE("  name LIKE CONCAT ('%',#{employee.Name},'%') ");
                    }
                    if (employee.getPhone() != null && !employee.getPhone().equals("")) {
                        WHERE(" phone LIKE CONCAT ('%',#{employee.Phone},'%') ");
                    }
                    if (employee.getCardId() != null && !employee.getCardId().equals("")) {
                        WHERE(" card_id LIKE CONCAT ('%',#{employee.CardId},'%') ");
                    }
                    if (employee.getSex() != null && !employee.getSex().equals("")) {
                        WHERE(" sex LIKE CONCAT ('%',#{employee.Sex},'%') ");
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
                FROM(EMPLOYEETABLE);
                if (params.get("employee") != null) {
                    Employee employee = (Employee) params.get("employee");
                    if (employee.getDept() != null && employee.getDept().getId() != null && employee.getDept().getId() != 0) {
                        WHERE(" dept_id = #{employee.Dept.Id} ");
                    }
                    if (employee.getJob() != null && employee.getJob().getId() != null && employee.getJob().getId() != 0) {
                        WHERE(" job_id = #{employee.Job.Id} ");
                    }
                    if (employee.getName() != null && !employee.getName().equals("")) {
                        WHERE("  name LIKE CONCAT ('%',#{employee.Name},'%') ");
                    }
                    if (employee.getPhone() != null && !employee.getPhone().equals("")) {
                        WHERE(" phone LIKE CONCAT ('%',#{employee.Phone},'%') ");
                    }
                    if (employee.getCardId() != null && !employee.getCardId().equals("")) {
                        WHERE(" card_id LIKE CONCAT ('%',#{employee.CardId},'%') ");
                    }
                    if (employee.getSex() != null && employee.getSex().equals("")) {
                        WHERE("sex = #{employee.Sex}");
                    }
                }
            }
        }.toString();
    }

    // 动态插入
    public String save(final Employee employee) {

        return new SQL() {
            {
                INSERT_INTO(EMPLOYEETABLE);
                if (employee.getName() != null) {
                    VALUES("name", "#{Name}");
                }
                if (employee.getCardId() != null) {
                    VALUES("card_id", "#{CardId}");
                }
                if (employee.getAddress() != null) {
                    VALUES("address", "#{Address}");
                }
                if (employee.getPostCode() != null) {
                    VALUES("post_code", "#{PostCode}");
                }
                if (employee.getTellphone() != null) {
                    VALUES("tel", "#{Tellphone}");
                }
                if (employee.getPhone() != null) {
                    VALUES("phone", "#{Phone}");
                }
                if (employee.getQQ() != null) {
                    VALUES("qq", "#{QQ}");
                }
                if (employee.getEmail() != null) {
                    VALUES("email", "#{Email}");
                }
                if (employee.getSex() != null) {
                    VALUES("sex", "#{Sex}");
                }
                if (employee.getBirthday() != null) {
                    VALUES("birthday", "#{Birthday}");
                }
                if (employee.getEducation() != null) {
                    VALUES("education", "#{Education}");
                }
                if (employee.getHobby() != null) {
                    VALUES("hobby", "#{Hobby}");
                }
                if (employee.getDescription() != null) {
                    VALUES("description", "#{Description}");
                }
                if (employee.getCreateTime() != null) {
                    VALUES("create_time", "#{CreateTime}");
                }
                if (employee.getDept() != null) {
                    VALUES("dept_id", "#{Dept.Id}");
                }
                if (employee.getJob() != null) {
                    VALUES("job_id", "#{Job.Id}");
                }
            }
        }.toString();
    }

    // 动态更新
    public String update(final Employee employee) {

        return new SQL() {
            {
                UPDATE(EMPLOYEETABLE);
                if (employee.getName() != null) {
                    SET(" name = #{Name} ");
                }
                if (employee.getCardId() != null) {
                    SET(" card_id = #{CardId} ");
                }
                if (employee.getAddress() != null) {
                    SET(" address = #{Address} ");
                }
                if (employee.getPostCode() != null) {
                    SET(" post_code = #{PostCode} ");
                }
                if (employee.getTellphone() != null) {
                    SET(" tel = #{Tellphone} ");
                }
                if (employee.getPhone() != null) {
                    SET(" phone = #{Phone} ");
                }
                if (employee.getQQ() != null) {
                    SET(" qq= #{QQ} ");
                }
                if (employee.getEmail() != null) {
                    SET(" email = #{Email} ");
                }
                if (employee.getSex() != null) {
                    SET(" sex = #{Sex} ");
                }
                if (employee.getBirthday() != null) {
                    SET(" birthday = #{Birthday} ");
                }
                if (employee.getEducation() != null) {
                    SET(" education = #{Education} ");
                }
                if (employee.getHobby() != null) {
                    SET(" hobby = #{Hobby} ");
                }
                if (employee.getDescription() != null) {
                    SET(" description = #{Description} ");
                }
                if (employee.getCreateTime() != null) {
                    SET(" create_time = #{createTime} ");
                }
                if (employee.getDept() != null) {
                    SET(" dept_id = #{Dept.Id} ");
                }
                if (employee.getJob() != null) {
                    SET(" job_id = #{Job.Id} ");
                }
                WHERE(" id = #{Id} ");
            }
        }.toString();
    }
}
