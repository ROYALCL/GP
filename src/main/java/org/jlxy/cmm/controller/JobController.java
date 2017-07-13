package org.jlxy.cmm.controller;

import org.jlxy.cmm.entity.Job;
import org.jlxy.cmm.services.JobService;
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
public class JobController {
    @Autowired
    private JobService jobService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/job/selectJob")
    public String selectJob(Model model, Integer pageIndex,
                            @ModelAttribute Job job) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        logger.info("selectJob -->> " + job);
        PageModel pageModel = new PageModel();
        if (pageIndex != null) {
            pageModel.setPageIndex(pageIndex);
        }
        /** 查询用户信息     */
        List<Job> jobs = jobService.selectByParamWithPage(job, pageModel);
        model.addAttribute("jobs", jobs);
        model.addAttribute("pageModel", pageModel);
        return "job/job";
    }

    /**
     * 处理删除职位请求
     *
     * @param ids 需要删除的id字符串
     * @param mv
     */
    @RequestMapping(value = "/job/removeJob")
    public ModelAndView removeJob(String ids, ModelAndView mv) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        // 分解id字符串
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            // 根据id删除职位
            if(!jobService.delete(Integer.parseInt(id))){
                mv.addObject("error","删除失败，请检查是否有员工依赖此职位");
            }
        }
        // 设置客户端跳转到查询请求
        mv.setViewName("redirect:/job/selectJob");
        // 返回ModelAndView
        return mv;
    }

    /**
     * 处理添加请求
     *
     * @param flag 标记， 1表示跳转到添加页面，2表示执行添加操作
     * @param job  要添加的职位对象
     * @param mv
     */
    @RequestMapping(value = "/job/addJob")
    public ModelAndView addJob(
            String flag,
            @ModelAttribute Job job,
            ModelAndView mv) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        if (flag.equals("1")) {
            // 设置跳转到添加页面
            mv.setViewName("job/showAddJob");
        } else {
            // 执行添加操作
            jobService.save(job);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/job/selectJob");
        }
        // 返回
        return mv;
    }


    /**
     * 处理修改职位请求
     *
     * @param flag 标记， 1表示跳转到修改页面，2表示执行修改操作
     * @param job  要修改部门的对象
     * @param mv
     */
    @RequestMapping(value = "/job/updateJob")
    public ModelAndView updateJob(
            String flag,
            @ModelAttribute Job job,
            ModelAndView mv) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        logger.info(job.toString());
        if (flag.equals("1")) {
            // 根据id查询部门
            Job target = jobService.selectById(job.getId());
            // 设置Model数据
            mv.addObject("job", target);
            // 设置跳转到修改页面
            mv.setViewName("job/showUpdateJob");
        } else {
            // 执行修改操作
            jobService.update(job);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/job/selectJob");
        }
        // 返回
        return mv;
    }
}
