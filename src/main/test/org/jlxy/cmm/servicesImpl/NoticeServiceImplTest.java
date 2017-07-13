package org.jlxy.cmm.servicesImpl;

import org.jlxy.cmm.BaseJunitTest;
import org.jlxy.cmm.entity.Notice;
import org.jlxy.cmm.services.NoticeService;
import org.jlxy.cmm.services.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by ORCHID on 2017/4/2.
 */
public class NoticeServiceImplTest extends BaseJunitTest {
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private UserService userService;

    @Test
    public void save() throws Exception {
        Notice notice = new Notice(userService.selectByName("test"), "test1", "skdjfhskjdfh", new Date());
        if (noticeService.save(notice)) {
            logger.info("TRUE");
        } else {
            logger.info("FALSE");
        }
    }

    @Test
    public void delete() throws Exception {
        if (noticeService.delete(1)) {
            logger.info("TRUE");
        } else {
            logger.info("FALSE");
        }
    }

    @Test
    public void update() throws Exception {
        Notice notice = new Notice(userService.selectByName("test"), "testupdate", "skdjfhskjdfh", new Date());
        noticeService.update(notice);
    }

    @Test
    public void selectById() throws Exception {
        Notice notice = noticeService.selectById(2);
        if (notice != null) {
            logger.info(notice.toString());
        }
    }

    @Test
    public void selectByAll() throws Exception {
        List<Notice> notices = noticeService.selectByAll();
        for (Notice notice : notices) {
            logger.info(notice.toString());
        }
    }

    @Test
    public void selectByParamWithPage() throws Exception {
    }

    @Test
    public void countByAll() throws Exception {
        System.out.println(noticeService.countByAll());
    }

}