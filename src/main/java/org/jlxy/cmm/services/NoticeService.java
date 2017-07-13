package org.jlxy.cmm.services;

import org.jlxy.cmm.entity.Notice;
import org.jlxy.cmm.utils.PageModel;

import java.util.List;

/**
 * Created by ORCHID on 2017/4/2.
 */
public interface NoticeService {
    /**
     * 添加公告
     *
     * @param notice 公告对象
     */
    boolean save(Notice notice);

    /**
     * 根据id删除公告
     *
     * @param id
     */
    boolean delete(int id);

    /**
     * 修改公告
     *
     * @param notice 公告对象
     */
    void update(Notice notice);

    /**
     * 根据id查询公告
     *
     * @param id
     * @return 公告对象
     */
    Notice selectById(int id);

    /**
     * 获得所有公告
     *
     * @return Notice对象的List集合
     */
    List<Notice> selectByAll();

    /**
     * 获得所有公告
     *
     * @return Notice对象的List集合
     */
    List<Notice> selectByParamWithPage(Notice notice, PageModel pageModel);

    /**
     * 获得所有公告总数
     *
     * @return Notice对象的数量统计
     */
    int countByAll();
}
