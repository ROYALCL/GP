package org.jlxy.cmm.utils;

import org.jlxy.cmm.BaseJunitTest;
import org.junit.Test;

/**
 * Created by ORCHID on 2017/4/2.
 */
public class MethodNameTest extends BaseJunitTest {
    @Test
    public void nameTest1() {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function: " + new MethodName().getMethodName() + " exec successful! ");
    }

    @Test
    public void nameTest2() {
        logger.info(new MethodName().getMethodName());
        logger.info(this.getClass().getSimpleName());
    }
}