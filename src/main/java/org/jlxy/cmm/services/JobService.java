package org.jlxy.cmm.services;

import org.jlxy.cmm.entity.Job;
import org.jlxy.cmm.utils.PageModel;

import java.util.List;

/**
 * Created by ORCHID on 2017/4/2.
 */
public interface JobService {
    /**
     * 添加职位
     *
     * @param job 部门对象
     */
    boolean save(Job job);

    List<Job> selectByParamWithPage(Job job, PageModel pageModel);

    /**
     * 根据id删除职位
     *
     * @param id
     */
    boolean delete(int id);

    /**
     * 修改职位
     *
     * @param job 职位对象
     */
    void update(Job job);

    /**
     * 根据id查询职位
     *
     * @param id
     * @return 职位对象
     */
    Job selectById(int id);

    /**
     * 获得所有职位
     *
     * @return Job对象的List集合
     */
    List<Job> selectByAll();

    /**
     * 获得所有职位数量
     *
     * @return Job对象的数量
     */
    int countByAll();
}
