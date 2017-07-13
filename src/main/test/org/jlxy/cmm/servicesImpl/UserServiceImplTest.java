package org.jlxy.cmm.servicesImpl;

import org.jlxy.cmm.BaseJunitTest;
import org.jlxy.cmm.entity.Role;
import org.jlxy.cmm.entity.User;
import org.jlxy.cmm.services.RoleService;
import org.jlxy.cmm.services.UserService;
import org.jlxy.cmm.utils.BOOLEAN;
import org.jlxy.cmm.utils.PageModel;
import org.jlxy.cmm.utils.SEX;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by ORCHID on 2017/4/2.
 */
public class UserServiceImplTest extends BaseJunitTest {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Test
    public void save() throws Exception {
        User user = new User(roleService.selectById(1),"test2", "000000", "ttest1", SEX.MALE.getValue(), "11111@163.com", "false", new Date());
        if (userService.save(user)) {
            logger.info("TRUE");
        } else {
            logger.info("FALSE");
        }
    }

    @Test
    public void delete() throws Exception {
        if (userService.delete(userService.selectByName("test2").getId())) {
            logger.info("TRUE");
        } else {
            logger.info("FALSE");
        }
    }

    @Test
    public void update() throws Exception {
        User user = new User(roleService.selectById(2),"test2", "000000", "ttest1", SEX.FEMALE.getKey(), "0000@163.com", "false", new Date());
        userService.update(user);

    }

    @Test
    public void selectByParamWithPage() throws Exception {
        int pageIndex=2;
        User user=new User();
        user.setUsed(BOOLEAN.FALSE.getValue());
        PageModel pageModel = new PageModel();
        pageModel.setPageIndex(pageIndex);
        List<User> users = userService.selectByParamWithPage(user, pageModel);
        for(User user1:users){
            logger.info(user1.toString());
        }
        System.out.println(pageModel.getPageIndex());
        System.out.println(pageModel.getPageSize());
        System.out.println(pageModel.getRecordCount());
        System.out.println(pageModel.getTotalSize());
    }

    @Test
    public void selectById() throws Exception {
        User user = userService.selectById(userService.selectByName("test").getId());
        logger.info(user.toString());
    }

    @Test
    public void login() throws Exception {
        User user = userService.login(userService.selectByName("test1").getName(), "000000");
        logger.info(user.toString());
    }

}