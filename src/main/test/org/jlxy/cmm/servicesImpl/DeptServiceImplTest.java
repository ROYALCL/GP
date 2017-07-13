package org.jlxy.cmm.servicesImpl;

import org.jlxy.cmm.BaseJunitTest;
import org.jlxy.cmm.entity.Dept;
import org.jlxy.cmm.services.DeptService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ORCHID on 2017/4/3.
 */
public class DeptServiceImplTest extends BaseJunitTest {
    @Autowired
    private DeptService deptService;

    @Test
    public void save() throws Exception {
        Dept dept = new Dept(deptService.selectByParentId(1).getParentId(),"adfhk", "test");
        if (deptService.save(dept)) {
            logger.info("TRUE");
        } else {
            logger.info("FALSE");
        }
    }

    @Test
    public void delete() throws Exception {
        if (deptService.delete(3)) {
            logger.info("TRUE");
        } else {
            logger.info("FALSE");
        }
    }

    @Test
    public void update() throws Exception {
        Dept dept = new Dept(deptService.selectByParentId(1).getParentId(),"test111", "test");
        deptService.update(dept);
    }

    @Test
    public void selectById() throws Exception {
        logger.info(deptService.selectById(1).toString());
    }

    @Test
    public void selectByAll() throws Exception {
        List<Dept> depts = deptService.selectByAll();
        for (Dept dept : depts) {
            logger.info(dept.toString());
        }
    }

    @Test
    public void countByAll() throws Exception {
        System.out.println(deptService.countByAll());
    }

}