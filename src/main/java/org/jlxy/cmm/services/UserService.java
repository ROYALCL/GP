package org.jlxy.cmm.services;

import org.jlxy.cmm.entity.User;
import org.jlxy.cmm.utils.PageModel;

import java.util.List;

/**
 * Created by ORCHID on 2017/4/2.
 */
public interface UserService {
    /**
     * 添加用户
     *
     * @param user 待添加的用户对象
     * @return 操作是否成功，true为成功，反之则失败
     */
    boolean save(User user);

    /**
     *删除用户
     * @param user 待删除的用户对象
     * @return 操作是否成功，true为成功，反之则失败
     */
    //boolean delete(User user);

    /**
     * 删除用户
     *
     * @param id 待删除的用户对象id
     * @return 操作是否成功，true为成功，反之则失败
     */
    boolean delete(int id);

    /**
     * 更新用户
     *
     * @param user 待更新的用户对象
     * @return 操作是否成功，true为成功，反之则失败
     */
    void update(User user);

    /**
     * 查询所有用户
     * @return 所有用户集合
     */
    //List<User> selectByAll();

    /**
     * 查询所有用户
     *
     * @return 所有用户集合
     */
    List<User> selectByParamWithPage(User user, PageModel pageModel);

    /**
     * 统计所有用户数量
     * @return 返回所有用户数量统计
     */
    //int countByAll();

    /**
     * 通过用户id查询用户信息
     *
     * @param id 用户主键id
     * @return 返回用户对象User
     */
    User selectById(int id);

    /**
     * 通过用户name查询用户信息
     *
     * @param name 用户name
     * @return 返回用户对象User
     */
    User selectByName(String name);

    /**
     * 通过用户name查询用户信息
     *
     * @param email 用户name
     * @return 返回用户对象User
     */
    User selectByEmail(String email);
    /**
     * 通过用户name和password查询用户信息
     *
     * @param name     用户name
     * @param password 用户password
     * @return 返回用户对象User
     */
    User login(String name, String password);
    /**
     * 通过用户email查询用户信息
     * @param email 用户email
     * @return 返回用户对象User
     */
    //User selectByEmail(String email);
}
