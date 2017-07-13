package org.jlxy.cmm.controller;

import org.jlxy.cmm.entity.Dept;
import org.jlxy.cmm.services.DeptService;
import org.jlxy.cmm.utils.MethodName;
import org.jlxy.cmm.utils.PageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by ORCHID on 2017/4/3.
 */
@Controller
public class DeptController {
    @Autowired
    private DeptService deptService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/dept/selectDept")
    public String selectDept(Model model, Integer pageIndex, @ModelAttribute Dept dept) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        logger.info("selectDept -->>");
        logger.info("pageIndex = " + pageIndex);
        logger.info("dept = " + dept);
        PageModel pageModel = new PageModel();
        logger.info("getPageIndex = " + pageModel.getPageIndex());
        logger.info("getPageSize = " + pageModel.getPageSize());
        logger.info("getRecordCount = " + pageModel.getRecordCount());
        if (pageIndex != null) {
            pageModel.setPageIndex(pageIndex);
        }
        List<Dept> depts = deptService.selectByParamWithPage(dept, pageModel);
        model.addAttribute("depts", depts);
        model.addAttribute("pageModel", pageModel);
        return "dept/dept";
    }

    /**
     * 处理删除部门请求
     *
     * @param ids 需要删除的id字符串
     * @param mv
     */
    @RequestMapping(value = "/dept/removeDept")
    public ModelAndView removeDept(String ids, ModelAndView mv) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        // 分解id字符串
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            // 根据id删除部门
            deptService.delete(Integer.parseInt(id));
        }
        // 设置客户端跳转到查询请求
        mv.setViewName("redirect:/dept/selectDept");
        // 返回ModelAndView
        return mv;
    }

    /**
     * 处理添加请求
     *
     * @param flag 标记， 1表示跳转到添加页面，2表示执行添加操作
     * @param dept 要添加的部门对象
     * @param mv
     */
    @RequestMapping(value = "/dept/addDept")
    public ModelAndView addDept(String flag, @ModelAttribute Dept dept, ModelAndView mv) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        if (flag.equals("1")) {
            // 设置跳转到添加页面
            mv.setViewName("dept/showAddDept");
        } else {
            // 执行添加操作
            deptService.save(dept);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/dept/selectDept");
        }
        // 返回
        return mv;
    }


    /**
     * 处理修改部门请求
     *
     * @param flag 标记， 1表示跳转到修改页面，2表示执行修改操作
     * @param dept 要修改部门的对象
     * @param mv
     */
    @RequestMapping(value = "/dept/updateDept")
    public ModelAndView updateDpet(
            String flag,
            @ModelAttribute Dept dept,
            ModelAndView mv) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        if (flag.equals("1")) {
            // 根据id查询部门
            Dept target = deptService.selectById(dept.getId());
            // 设置Model数据
            mv.addObject("dept", target);
            // 设置跳转到修改页面
            mv.setViewName("dept/showUpdateDept");
        } else {
            // 执行修改操作
            deptService.update(dept);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/dept/selectDept");
        }
        // 返回
        return mv;
    }
}
