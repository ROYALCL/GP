package org.jlxy.cmm.servicesImpl;

import org.jlxy.cmm.entity.Role;
import org.jlxy.cmm.entity.User;
import org.jlxy.cmm.mapper.RoleMapper;
import org.jlxy.cmm.mapper.UserMapper;
import org.jlxy.cmm.services.RoleService;
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
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 保存文件
     *
     * @param role 待保存文件
     * @return 操作成功为true，反之则为false
     */
    public boolean save(Role role) {
        if (roleMapper.save(role) > 1) {
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
        List<User> users = userMapper.selectByRole(id);
        if (users.size() > 0) {
            return false;
        } else {
            if (roleMapper.countByParent(id) > 0) {
                if (roleMapper.delete(id) > 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    /**
     * 修改部门
     *
     * @param role 部门对象
     */
    public void update(Role role) {
        roleMapper.update(role);
    }

    /**
     * 根据id查询部门
     *
     * @param id
     * @return 部门对象
     */
    public Role selectById(int id) {
        return roleMapper.selectById(id);
    }

    public List<Role> selectByParamWithPage(Role role, PageModel pageModel) {
        /** 当前需要分页的总数据条数  */
        Map<String, Object> map = new HashMap();
        map.put("role", role);
        int recordCount = roleMapper.count(map);
        pageModel.setRecordCount(recordCount);

        if (recordCount > 0) {
            /** 开始分页查询数据：查询第几页的数据 */
            map.put("pageModel", pageModel);
        }
        return roleMapper.selectByParamWithPage(map);
    }

    /**
     * 获得所有部门
     *
     * @return Dept对象的List集合
     */
    public List<Role> selectByAll() {
        return roleMapper.selectAll();
    }

    /**
     * 统计所有部门数量
     *
     * @return 返回查询数量
     */
    public int countByAll() {
        return roleMapper.countAll();
    }
}
