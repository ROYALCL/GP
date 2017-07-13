package org.jlxy.cmm.interceptor;

import org.jlxy.cmm.entity.User;
import org.jlxy.cmm.utils.MethodName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.jlxy.cmm.utils.CmConstants.*;

/**
 * Created by ORCHID on 2017/4/2.
 */
public class MainInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        /** 默认用户没有登录 */
        boolean flag = false;
        /** 获得请求的ServletPath */
        String servletPath = request.getServletPath();
        /**  判断请求是否需要拦截 */
        for (String s : IGNORE_URI) {
            if (servletPath.contains(s)) {
                flag = true;
                break;
            }
        }
        /** 拦截请求 */
        if (!flag) {
            /** 1.获取session中的用户  */
            User user = (User) request.getSession().getAttribute(USER_SESSION);
            /** 2.判断用户是否已经登录 */
            if (user == null) {
                /** 如果用户没有登录，跳转到登录页面 */
                request.setAttribute("message", "请先登录再访问网站!");
                request.getRequestDispatcher(LOGIN).forward(request, response);
                return flag;
            } else {
                flag = true;
            }
        }
        return flag;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
