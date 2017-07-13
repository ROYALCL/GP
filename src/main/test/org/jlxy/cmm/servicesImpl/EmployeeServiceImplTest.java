package org.jlxy.cmm.servicesImpl;

import org.jlxy.cmm.BaseJunitTest;
import org.jlxy.cmm.entity.Employee;
import org.jlxy.cmm.services.DeptService;
import org.jlxy.cmm.services.EmployeeService;
import org.jlxy.cmm.services.JobService;
import org.jlxy.cmm.utils.SEX;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by ORCHID on 2017/4/3.
 */
public class EmployeeServiceImplTest extends BaseJunitTest {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private JobService jobService;

    @Test
    public void save() throws Exception {
//        Employee employee = new Employee();
//        employee.setName("test1");
//        employee.setAddress("sdlfgjks");
//        employee.setBirthday(new Date());
//        employee.setCardId("23446457563432");
//        employee.setCreateTime(new Date());
//        employee.setDept(deptService.selectById(1));
//        employee.setDescription("aslkdjfalskdjfalksjdfha");
//        employee.setEmail("111@163.com");
//        employee.setEducation("sdfadsa");
//        employee.setHobby("play");
//        employee.setTellphone("sdgfasd");
//        employee.setJob(jobService.selectById(3));
//        employee.setPhone("sdgsfdsdfs");
//        employee.setQQ("sfgsdfgs");
//        employee.setSex(SEX.MALE.getKey());
//        if (employeeService.save(employee)) {
//            logger.info("TRUE");
//        } else {
//            logger.info("FALSE");
//        }

    }

    @Test
    public void delete() throws Exception {
        if (employeeService.delete(3)) {
            logger.info("TRUE");
        } else {
            logger.info("FALSE");
        }
    }

    @Test
    public void update() throws Exception {
        Employee employee = new Employee();
        employee.setSex(SEX.FEMALE.getKey());
        employeeService.update(employee);
    }

    @Test
    public void selectById() throws Exception {
        //logger.info(employeeService.selectById(1).toString());
    }

    @Test
    public void selectByParamWithPage() throws Exception {

    }

    @Test
    public void selectByAll() throws Exception {
//        List<Employee> employees = employeeService.selectByAll();
//        for (Employee employee : employees) {
//            logger.info(employee.toString());
//        }
    }

    @Test
    public void countByAll() throws Exception {
        System.out.println(employeeService.countByAll());
    }

}