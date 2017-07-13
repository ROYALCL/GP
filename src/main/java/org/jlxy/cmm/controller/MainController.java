package org.jlxy.cmm.controller;

import org.jlxy.cmm.utils.MethodName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ORCHID on 2017/4/3.
 */
@Controller
public class MainController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/{formName}")
    public String loginForm(@PathVariable String formName) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        logger.info("controller: " + formName);
        // 动态跳转页面
        return formName;
    }
}
