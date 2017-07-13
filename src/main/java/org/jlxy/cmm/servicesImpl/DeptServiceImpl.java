package org.jlxy.cmm.servicesImpl;

import org.jlxy.cmm.entity.Dept;
import org.jlxy.cmm.entity.Employee;
import org.jlxy.cmm.mapper.DeptMapper;
import org.jlxy.cmm.mapper.EmployeeMapper;
import org.jlxy.cmm.services.DeptService;
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
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 保存文件
     *
     * @param dept 待保存文件
     * @return 操作成功为true，反之则为false
     */
    public boolean save(Dept dept) {
        if (deptMapper.save(dept) > 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据id删除部门
     *
     * @param id
     **/
    public boolean delete(int id) {
        List<Employee> dept=employeeMapper.selectByDeptId();
        if(dept.size()>0){
            return false;
        }else {
            if (deptMapper.delete(id) > 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 修改部门
     *
     * @param dept 部门对象
     */
    public void update(Dept dept) {
        deptMapper.update(dept);
    }

    /**
     * 根据id查询部门
     *
     * @param id
     * @return 部门对象
     */
    public Dept selectById(int id) {
        return deptMapper.selectById(id);
    }

    public Dept selectByParentId(int id) {
        return deptMapper.selectByParentId(id);
    }

    public List<Dept> selectByParamWithPage(Dept dept, PageModel pageModel) {
        /** 当前需要分页的总数据条数  */
        Map<String, Object> map = new HashMap();
        map.put("dept", dept);
        int recordCount = deptMapper.count(map);
        pageModel.setRecordCount(recordCount);

        if (recordCount > 0) {
            /** 开始分页查询数据：查询第几页的数据 */
            map.put("pageModel", pageModel);
        }
        return deptMapper.selectByParamWithPage(map);
    }

    /**
     * 获得所有部门
     *
     * @return Dept对象的List集合
     */
    public List<Dept> selectByAll() {
        return deptMapper.selectAll();
    }

    /**
     * 统计所有部门数量
     *
     * @return 返回查询数量
     */
    public int countByAll() {
        return deptMapper.countAll();
    }
}
