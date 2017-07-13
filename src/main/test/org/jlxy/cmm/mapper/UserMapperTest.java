package org.jlxy.cmm.mapper;

import org.jlxy.cmm.BaseJunitTest;
import org.jlxy.cmm.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ORCHID on 2017/4/2.
 */
public class UserMapperTest extends BaseJunitTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void selectByParamWithPage() throws Exception {
        User user = new User();
        //user.setUsed(false);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user", user);
        List<User> users = userMapper.selectByParamWithPage(map);
        for (User user1 : users) {
            logger.info(user1.toString());
        }
    }

}