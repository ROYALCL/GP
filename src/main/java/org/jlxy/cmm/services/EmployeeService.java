package org.jlxy.cmm.services;

import org.jlxy.cmm.entity.Employee;
import org.jlxy.cmm.utils.PageModel;

import java.util.List;

/**
 * Created by ORCHID on 2017/4/2.
 */
public interface EmployeeService {
    /**
     * 添加员工
     *
     * @param employee 员工对象
     */
    boolean save(Employee employee);

    /**
     * 根据id删除员工
     *
     * @param id
     */
    boolean delete(int id);

    /**
     * 修改员工
     *
     * @param employee 员工对象
     */
    void update(Employee employee);

    /**
     * 根据id查询员工
     *
     * @param id
     * @return 员工对象
     */
    Employee selectById(int id);

    List<Employee> selectByParamWithPage(Employee employee, PageModel pageModel);

    /**
     * 获得所有员工
     *
     * @return Employee对象的List集合
     */
    List<Employee> selectByAll();

    /**
     * 获得所有员工数量统计
     *
     * @return Employee对象的数量统计
     */
    int countByAll();
}
