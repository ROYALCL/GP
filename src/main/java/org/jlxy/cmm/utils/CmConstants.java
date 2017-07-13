package org.jlxy.cmm.utils;

/**
 * Created by ORCHID on 2017/4/1.
 */
public class CmConstants {
    // 数据库表常量
    public static final String USERTABLE = "user";
    public static final String DEPTTABLE = "dept";
    public static final String JOBTABLE = "job";
    public static final String EMPLOYEETABLE = "employee";
    public static final String NOTICETABLE = "notice";
    public static final String DOCUMENTTABLE = "document";
    public static final String ROLETABLE = "role";

    /**
     * 定义不需要拦截的请求
     */
    public static final String[] IGNORE_URI = {"/loginForm", "/login", "/404.html"};
    // 登录
    public static final String LOGIN = "/loginForm";
    // 用户的session对象
    public static final String USER_SESSION = "user_session";

    // 默认每页4条数据
    public static int PAGE_DEFAULT_SIZE = 5;
}
