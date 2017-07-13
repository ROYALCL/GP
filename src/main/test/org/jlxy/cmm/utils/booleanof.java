package org.jlxy.cmm.utils;

import org.jlxy.cmm.BaseJunitTest;
import org.jlxy.cmm.entity.User;
import org.junit.Test;

/**
 * Created by ORCHID on 2017/4/4.
 */
public class booleanof extends BaseJunitTest {
    @Test
    public void testboolean(){
        boolean x=true;
        String y="true";
        if(Boolean.parseBoolean(BOOLEAN.TRUE.getKey())){
            logger.info("TRUE");
        }
        logger.info(BOOLEAN.TRUE.getKey());
        logger.info(new User().toString());
    }
}
