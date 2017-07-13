package org.jlxy.cmm.servicesImpl;

import org.jlxy.cmm.entity.User;
import org.jlxy.cmm.mapper.UserMapper;
import org.jlxy.cmm.services.UserService;
import org.jlxy.cmm.utils.MethodName;
import org.jlxy.cmm.utils.PageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ORCHID on 2017/4/2.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 添加用户
     *
     * @param user 待添加的用户对象
     * @return 操作是否成功，true为成功，反之则失败
     */
    public boolean save(User user) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
                if (userMapper.save(user) > 0) {
                    return true;
                } else {
                    return false;
                }
    }

    /**
     * 删除用户
     *
     * @param id 待删除的用户对象id
     * @return 操作是否成功，true为成功，反之则失败
     */
    public boolean delete(int id) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        if (userMapper.delete(id) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 更新用户
     *
     * @param user 待更新的用户对象
     * @return 操作是否成功，true为成功，反之则失败
     */
    public void update(User user) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");

            userMapper.update(user);
         }

    /**
     * 查询所有用户
     *
     * @param user
     * @param pageModel
     * @return 所有用户集合
     */
    public List<User> selectByParamWithPage(User user, PageModel pageModel) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        Map<String, Object> map = new HashMap();
        int recordCount;
        if(user!=null){
            map.put("user", user);
            recordCount = userMapper.count(map);
        }else {
            recordCount = userMapper.countAll();
        }
        pageModel.setRecordCount(recordCount);
        logger.info("分" + recordCount + "页");
        if (recordCount > 0) {
            map.put("pageModel", pageModel);
        }
        return userMapper.selectByParamWithPage(map);
    }

    /**
     * 通过用户id查询用户信息
     *
     * @param id 用户主键id
     * @return 返回用户对象User
     */
    public User selectById(int id) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        return userMapper.selectById(id);
    }

    /**
     * 通过用户name查询用户信息
     *
     * @param name 用户name
     * @return 返回用户对象User
     */
    public User selectByName(String name) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        return userMapper.selectByName(name);
    }

    /**
     * 通过用户name查询用户信息
     *
     * @param email 用户name
     * @return 返回用户对象User
     */
    public User selectByEmail(String email) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        return userMapper.selectByEmail(email);
    }

    /**
     * 通过用户name和password查询用户信息
     *
     * @param name     用户name
     * @param password 用户password
     * @return 返回用户对象User
     */
    public User login(String name, String password) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        return userMapper.selectByLogin(name, password);
    }
}
