package org.jlxy.cmm.controller;

import org.jlxy.cmm.entity.User;
import org.jlxy.cmm.services.RoleService;
import org.jlxy.cmm.services.UserService;
import org.jlxy.cmm.utils.BOOLEAN;
import org.jlxy.cmm.utils.MethodName;
import org.jlxy.cmm.utils.PageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

import static org.jlxy.cmm.utils.CmConstants.USER_SESSION;

/**
 * Created by ORCHID on 2017/4/3.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 处理登录请求
     *
     * @param name     登录名
     * @param password 密码
     * @return 跳转的视图
     */
    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam("name") String name,
                              @RequestParam("password") String password,
                              HttpSession session,
                              ModelAndView mv) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        // 调用业务逻辑组件判断用户是否可以登录
        User user = userService.login(name, password);
        if (user != null) {
            // 将用户保存到HttpSession当中
            session.setAttribute(USER_SESSION, user);
            if (user.getUsed() == BOOLEAN.TRUE.getValue()) {
                mv.addObject("used", "true");
            } else if (user.getUsed() == BOOLEAN.FALSE.getValue()) {
                user.setUsed(BOOLEAN.TRUE.getValue());
                userService.update(user);
                mv.addObject("used", "false");
            }
            // 客户端跳转到main页面
            mv.setViewName("redirect:/main");
        } else {
            // 设置登录失败提示信息
            mv.addObject("message", "登录名或密码错误!请重新输入");
            mv.addObject("name", name);
            mv.addObject("password", password);
            // 服务器内部跳转到登录页面
            mv.setViewName("forward:/loginForm");
        }
        return mv;
    }

    /**
     * 处理查询请求
     *
     * @param pageIndex 请求的是第几页
     * @param user      模糊查询参数
     * @param model
     */
    @RequestMapping(value = "/user/selectUser")
    public String selectUser(Integer pageIndex,
                             @ModelAttribute User user,
                             Model model) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        PageModel pageModel = new PageModel();
        if (pageIndex != null) {
            pageModel.setPageIndex(pageIndex);
        }
        /** 查询用户信息     */
        List<User> users = userService.selectByParamWithPage(user, pageModel);
        for (User user1 : users) {
            logger.info(user1.toString());
        }
        model.addAttribute("users", users);
        model.addAttribute("pageModel", pageModel);
        return "user/user";

    }

    /**
     * 处理删除用户请求
     *
     * @param ids 需要删除的id字符串
     * @param mv
     */
    @RequestMapping(value = "/user/removeUser")
    public ModelAndView removeUser(String ids, ModelAndView mv) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        // 分解id字符串
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            // 根据id删除员工
            userService.delete(Integer.parseInt(id));
        }
        // 设置客户端跳转到查询请求
        mv.setViewName("redirect:/user/selectUser");
        // 返回ModelAndView
        return mv;
    }

    /**
     * 处理修改用户请求
     *
     * @param flag 标记， 1表示跳转到修改页面，2表示执行修改操作
     * @param user 要修改用户的对象
     * @param mv
     */
    @RequestMapping(value = "/user/updateUser")
    public ModelAndView updateUser(
            String flag,
            Integer role_id,
            @ModelAttribute User user,
            ModelAndView mv) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        if (flag.equals("1")) {
            // 设置Model数据
            mv.addObject("role", roleService.selectByAll());
            // 根据id查询用户
            mv.addObject("user", userService.selectById(user.getId()));
            // 返回修改员工页面
            mv.setViewName("user/showUpdateUser");
        } else {
            if (!userService.selectByName(user.getName()).getId().equals(user.getId())) {
                mv.addObject("message", "name is be used");
                // 返回修改员工页面
                mv.setViewName("user/showUpdateUser");
                return mv;
            }
            if (!userService.selectByEmail(user.getEmail()).getId().equals(user.getId())) {
                mv.addObject("message", "email is be used");
                // 返回修改员工页面
                mv.setViewName("user/showUpdateUser");
                return mv;
            }
            user.setRole(roleService.selectById(role_id));
            // 执行修改操作
            userService.update(user);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/user/selectUser");
        }
        // 返回
        return mv;
    }


    /**
     * 处理添加请求
     *
     * @param flag 标记， 1表示跳转到添加页面，2表示执行添加操作
     * @param user 要添加用户的对象
     * @param mv
     */
    @RequestMapping(value = "/user/addUser")
    public ModelAndView addUser(
            String flag,
            Integer role_id,
            @ModelAttribute User user,
            ModelAndView mv) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        //logger.info(userService.selectById(user.getId()).toString());
        if (flag.equals("1")) {
            mv.addObject("role", roleService.selectByAll());
            // 设置跳转到添加页面
            mv.setViewName("user/showAddUser");
        } else {
            user.setRole(roleService.selectById(role_id));
            user.setCreateTime(new Date());
            // 执行添加操作
            userService.save(user);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/user/selectUser");
        }
        // 返回
        return mv;
    }

    @RequestMapping(value = "/user/logout")
    public ModelAndView exit(ModelAndView mv, HttpSession session) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        User user = (User) session.getAttribute(USER_SESSION);
        session.setAttribute(USER_SESSION, null);
        mv.addObject("name", user.getName());
        // 服务器内部跳转到登录页面
        return new ModelAndView("forward:/loginForm");
    }
}
