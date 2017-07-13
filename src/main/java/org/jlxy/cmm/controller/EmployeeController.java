package org.jlxy.cmm.controller;

import org.jlxy.cmm.entity.Dept;
import org.jlxy.cmm.entity.Employee;
import org.jlxy.cmm.entity.Job;
import org.jlxy.cmm.services.DeptService;
import org.jlxy.cmm.services.EmployeeService;
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
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JobService jobService;

    @Autowired
    private DeptService deptService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 处理查询请求
     *
     * @param pageIndex 请求的是第几页
     * @param job_id    职位编号
     * @param dept_id   部门编号
     * @param employee  模糊查询参数
     * @param model
     */
    @RequestMapping(value = "/employee/selectEmployee")
    public String selectEmployee(Integer pageIndex,
                                 Integer job_id, Integer dept_id,
                                 @ModelAttribute Employee employee,
                                 Model model) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        // 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
        //this.genericAssociation(job_id, dept_id, employee);
        // 创建分页对象
        //logger.info(employee.toString());
        PageModel pageModel = new PageModel();
        // 如果参数pageIndex不为null，设置pageIndex，即显示第几页
        if (pageIndex != null) {
            pageModel.setPageIndex(pageIndex);
        }
        // 查询职位信息，用于模糊查询
        List<Job> jobs = jobService.selectByAll();
        // 查询部门信息 ，用于模糊查询
        List<Dept> depts = deptService.selectByAll();
        // 查询员工信息
        List<Employee> employees = employeeService.selectByParamWithPage(employee, pageModel);
        // 设置Model数据
        model.addAttribute("employees", employees);
        model.addAttribute("jobs", jobs);
        model.addAttribute("depts", depts);
        model.addAttribute("pageModel", pageModel);
        // 返回员工页面
        return "employee/employee";
    }

    /**
     * 处理添加员工请求
     *
     * @param flag     标记， 1表示跳转到添加页面，2表示执行添加操作
     * @param job_id   职位编号
     * @param dept_id  部门编号
     * @param employee 接收添加参数
     * @param mv
     */
    @RequestMapping(value = "/employee/addEmployee")
    public ModelAndView addEmployee(
            String flag,
            Integer job_id, Integer dept_id,
            @ModelAttribute Employee employee,
            ModelAndView mv) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        logger.info(employee.toString());
        if (flag.equals("1")) {
            // 查询职位信息
            List<Job> jobs = jobService.selectByAll();
            // 查询部门信息
            List<Dept> depts = deptService.selectByAll();
            // 设置Model数据
            mv.addObject("jobs", jobs);
            mv.addObject("depts", depts);
            // 返回添加员工页面
            mv.setViewName("employee/showAddEmployee");
        } else {
            // 判断是否有关联对象传递，如果有，创建关联对象
            this.genericAssociation(job_id, dept_id, employee);
            // 添加操作
            employeeService.save(employee);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/employee/selectEmployee");
        }
        // 返回
        return mv;

    }

    /**
     * 处理删除员工请求
     *
     * @param ids 需要删除的id字符串
     * @param mv
     */
    @RequestMapping(value = "/employee/removeEmployee")
    public ModelAndView removeEmployee(String ids, ModelAndView mv) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        // 分解id字符串
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            // 根据id删除员工
            employeeService.delete(Integer.parseInt(id));
        }
        // 设置客户端跳转到查询请求
//		mv.setView(new RedirectView("/hrmapp/employee/selectEmployee"));
//		mv.setViewName("forward:/employee/selectEmployee");
        mv.setViewName("redirect:/employee/selectEmployee");
        // 返回ModelAndView
        return mv;
    }

    /**
     * 处理修改员工请求
     *
     * @param flag     标记，1表示跳转到修改页面，2表示执行修改操作
     * @param job_id   职位编号
     * @param dept_id  部门编号
     * @param employee 要修改员工的对象
     * @param mv
     */
    @RequestMapping(value = "/employee/updateEmployee")
    public ModelAndView updateEmployee(
            String flag,
            Integer job_id, Integer dept_id,
            @ModelAttribute Employee employee,
            ModelAndView mv) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        if (flag.equals("1")) {
            // 根据id查询员工
            Employee target = employeeService.selectById(employee.getId());
            // 需要查询职位信息
            List<Job> jobs = jobService.selectByAll();
            // 需要查询部门信息
            List<Dept> depts = deptService.selectByAll();
            // 设置Model数据
            mv.addObject("jobs", jobs);
            mv.addObject("depts", depts);
            mv.addObject("employee", target);
            // 返回修改员工页面
            mv.setViewName("employee/showUpdateEmployee");
        } else {
            // 创建并封装关联对象
            this.genericAssociation(job_id, dept_id, employee);
            System.out.println("updateEmployee -->> " + employee);
            // 执行修改操作
            employeeService.update(employee);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/employee/selectEmployee");
        }
        // 返回
        return mv;
    }

    /**
     * 由于部门和职位在Employee中是对象关联映射，
     * 所以不能直接接收参数，需要创建Job对象和Dept对象
     */
    private void genericAssociation(Integer job_id,
                                    Integer dept_id, Employee employee) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        if (job_id != null) {
            Job job = new Job();
            job.setId(job_id);
            employee.setJob(job);
        }
        if (dept_id != null) {
            Dept dept = new Dept();
            dept.setId(dept_id);
            employee.setDept(dept);
        }
    }
}