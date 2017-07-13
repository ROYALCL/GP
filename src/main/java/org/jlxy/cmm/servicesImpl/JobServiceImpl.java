package org.jlxy.cmm.servicesImpl;

import org.jlxy.cmm.entity.Employee;
import org.jlxy.cmm.entity.Job;
import org.jlxy.cmm.mapper.EmployeeMapper;
import org.jlxy.cmm.mapper.JobMapper;
import org.jlxy.cmm.services.JobService;
import org.jlxy.cmm.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ORCHID on 2017/4/2.
 */
@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobMapper jobMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 添加职位
     *
     * @param job 部门对象
     */
    public boolean save(Job job) {
        if (jobMapper.save(job) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<Job> selectByParamWithPage(Job job, PageModel pageModel) {
        /** 当前需要分页的总数据条数  */
        Map<String, Object> map = new HashMap();
        map.put("job", job);
        int recordCount = jobMapper.count(map);
        pageModel.setRecordCount(recordCount);

        if (recordCount > 0) {
            /** 开始分页查询数据：查询第几页的数据 */
            map.put("pageModel", pageModel);
        }
        return jobMapper.selectByParamWithPage(map);
    }

    /**
     * 根据id删除职位
     *
     * @param id
     */
    public boolean delete(int id) {
        List<Employee> job=employeeMapper.selectByJobId();
        if(job.size()>0){
            return false;
        }else {
            if (jobMapper.delete(id) > 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 修改职位
     *
     * @param job 职位对象
     */
    public void update(Job job) {
        jobMapper.update(job);
    }

    /**
     * 根据id查询职位
     *
     * @param id
     * @return 职位对象
     */
    public Job selectById(int id) {
        if(String.valueOf(id)==null){
            return null;
        }else {
            return jobMapper.select(id);
        }
    }

    /**
     * 获得所有职位
     *
     * @return Job对象的List集合
     */
    public List<Job> selectByAll() {
        return jobMapper.selectAll();
    }

    /**
     * 获得所有职位数量
     *
     * @return Job对象的数量
     */
    public int countByAll() {
        return jobMapper.countAll();
    }
}
