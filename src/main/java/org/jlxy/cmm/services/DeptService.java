package org.jlxy.cmm.services;

import org.jlxy.cmm.entity.Dept;
import org.jlxy.cmm.utils.PageModel;

import java.util.List;

/**
 * Created by ORCHID on 2017/4/2.
 */
public interface DeptService {
    /**
     * 保存文件
     *
     * @param dept 待保存文件
     * @return 操作成功为true，反之则为false
     */
    boolean save(Dept dept);

    /**
     * 根据id删除部门
     *
     * @param id
     **/
    boolean delete(int id);

    /**
     * 修改部门
     *
     * @param dept 部门对象
     */
    void update(Dept dept);

    /**
     * 根据id查询部门
     *
     * @param id
     * @return 部门对象
     */
    Dept selectById(int id);

    Dept selectByParentId(int id);

    List<Dept> selectByParamWithPage(Dept dept, PageModel pageModel);

    /**
     * 获得所有部门
     *
     * @return Dept对象的List集合
     */
    List<Dept> selectByAll();

    /**
     * 统计所有部门数量
     *
     * @return 返回查询数量
     */
    int countByAll();
}
