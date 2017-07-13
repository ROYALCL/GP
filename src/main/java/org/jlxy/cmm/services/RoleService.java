package org.jlxy.cmm.services;

import org.jlxy.cmm.entity.Role;
import org.jlxy.cmm.utils.PageModel;

import java.util.List;

/**
 * Created by ORCHID on 2017/4/2.
 */
public interface RoleService {
    /**
     * 保存文件
     *
     * @param role 待保存文件
     * @return 操作成功为true，反之则为false
     */
    boolean save(Role role);

    /**
     * 根据id删除部门
     *
     * @param id
     **/
    boolean delete(int id);

    /**
     * 修改部门
     *
     * @param role 部门对象
     */
    void update(Role role);

    /**
     * 根据id查询部门
     *
     * @param id
     * @return 部门对象
     */
    Role selectById(int id);

    List<Role> selectByParamWithPage(Role role, PageModel pageModel);

    /**
     * 获得所有部门
     *
     * @return Role对象的List集合
     */
    List<Role> selectByAll();

    /**
     * 统计所有部门数量
     *
     * @return 返回查询数量
     */
    int countByAll();
}
