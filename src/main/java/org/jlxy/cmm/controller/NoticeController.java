package org.jlxy.cmm.controller;

import org.jlxy.cmm.entity.Notice;
import org.jlxy.cmm.entity.User;
import org.jlxy.cmm.services.NoticeService;
import org.jlxy.cmm.utils.MethodName;
import org.jlxy.cmm.utils.PageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

import static org.jlxy.cmm.utils.CmConstants.USER_SESSION;

/**
 * Created by ORCHID on 2017/4/3.
 */
@Controller
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/notice/selectNotice")
    public String selectNotice(Model model, Integer pageIndex,
                               @ModelAttribute Notice notice) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        PageModel pageModel = new PageModel();
        if (pageIndex != null) {
            pageModel.setPageIndex(pageIndex);
        }
        /** 查询用户信息     */
        List<Notice> notices = noticeService.selectByParamWithPage(notice, pageModel);
        model.addAttribute("notices", notices);
        model.addAttribute("pageModel", pageModel);
        return "notice/notice";

    }

    /**
     * 处理添加请求
     *
     * @param id    要显示的公告id
     * @param model
     */
    @RequestMapping(value = "/notice/previewNotice")
    public String previewNotice(
            Integer id, Model model) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        Notice notice = noticeService.selectById(id);

        model.addAttribute("notice", notice);
        // 返回
        return "notice/previewNotice";
    }

    /**
     * 处理删除公告请求
     *
     * @param ids 需要删除的id字符串
     * @param mv
     */
    @RequestMapping(value = "/notice/removeNotice")
    public ModelAndView removeNotice(String ids, ModelAndView mv) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        // 分解id字符串
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            // 根据id删除公告
            noticeService.delete(Integer.parseInt(id));
        }
        // 设置客户端跳转到查询请求
        mv.setViewName("redirect:/notice/selectNotice");
        // 返回ModelAndView
        return mv;
    }

    /**
     * 处理添加请求
     *
     * @param flag   标记， 1表示跳转到添加页面，2表示执行添加操作
     * @param notice 要添加的公告对象
     * @param mv
     */
    @RequestMapping(value = "/notice/addNotice")
    public ModelAndView addNotice(
            String flag,
            @ModelAttribute Notice notice,
            ModelAndView mv,
            HttpSession session) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        if (flag.equals("1")) {
            mv.setViewName("notice/showAddNotice");
        } else {
            notice.setUser((User) session.getAttribute(USER_SESSION));
            notice.setCreateTime(new Date());
            noticeService.save(notice);
            mv.setViewName("redirect:/notice/selectNotice");
        }
        // 返回
        return mv;
    }

    /**
     * 处理添加请求
     *
     * @param flag   标记， 1表示跳转到修改页面，2表示执行修改操作
     * @param notice 要添加的公告对象
     * @param mv
     */
    @RequestMapping(value = "/notice/updateNotice")
    public ModelAndView updateNotice(
            String flag,
            @ModelAttribute Notice notice,
            ModelAndView mv,
            HttpSession session) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        if (flag.equals("1")) {
            Notice target = noticeService.selectById(notice.getId());
            mv.addObject("notice", target);
            mv.setViewName("notice/showUpdateNotice");
        } else {
            noticeService.update(notice);
            mv.setViewName("redirect:/notice/selectNotice");
        }
        // 返回
        return mv;
    }

}
