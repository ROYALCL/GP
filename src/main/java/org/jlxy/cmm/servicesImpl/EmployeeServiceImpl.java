package org.jlxy.cmm.servicesImpl;

import org.jlxy.cmm.entity.Employee;
import org.jlxy.cmm.mapper.EmployeeMapper;
import org.jlxy.cmm.services.EmployeeService;
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
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 添加员工
     *
     * @param employee 员工对象
     */
    public boolean save(Employee employee) {
        if (employeeMapper.save(employee) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据id删除员工
     *
     * @param id
     */
    public boolean delete(int id) {
        if (employeeMapper.delete(id) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改员工
     *
     * @param employee 员工对象
     */
    public void update(Employee employee) {
        employeeMapper.update(employee);
    }

    /**
     * 根据id查询员工
     *
     * @param id
     * @return 员工对象
     */
    public Employee selectById(int id) {
        return employeeMapper.selectById(id);
    }

    public List<Employee> selectByParamWithPage(Employee employee, PageModel pageModel) {
        /** 当前需要分页的总数据条数  */
        Map<String, Object> map = new HashMap();
        map.put("employee", employee);
        int recordCount = employeeMapper.count(map);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0) {
            /** 开始分页查询数据：查询第几页的数据 */
            map.put("pageModel", pageModel);
        }
        return employeeMapper.selectByParamWithPage(map);
    }

    /**
     * 获得所有员工
     *
     * @return Employee对象的List集合
     */
    public List<Employee> selectByAll() {
        return employeeMapper.selectAll();
    }

    /**
     * 获得所有员工数量统计
     *
     * @return Employee对象的数量统计
     */
    public int countByAll() {
        return employeeMapper.countAll();
    }
}
