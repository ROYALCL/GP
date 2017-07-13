package org.jlxy.cmm.servicesImpl;

import org.jlxy.cmm.entity.Notice;
import org.jlxy.cmm.mapper.NoticeMapper;
import org.jlxy.cmm.services.NoticeService;
import org.jlxy.cmm.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ORCHID on 2017/4/2.
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 添加公告
     *
     * @param notice 公告对象
     */
    public boolean save(Notice notice) {
        if (noticeMapper.save(notice) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据id删除公告
     *
     * @param id
     */
    public boolean delete(int id) {
        if (noticeMapper.delete(id) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改公告
     *
     * @param notice 公告对象
     */
    public void update(Notice notice) {
        noticeMapper.update(notice);
    }

    /**
     * 根据id查询公告
     *
     * @param id
     * @return 公告对象
     */
    public Notice selectById(int id) {
        return noticeMapper.select(id);
    }

    /**
     * 获得所有公告
     *
     * @return Notice对象的List集合
     */
    public List<Notice> selectByAll() {
        return noticeMapper.selectAll();
    }

    /**
     * 获得所有公告
     *
     * @param notice
     * @param pageModel
     * @return Notice对象的List集合
     */
    public List<Notice> selectByParamWithPage(Notice notice, PageModel pageModel) {
        /** 当前需要分页的总数据条数  */
        Map<String, Object> map = new HashMap();
        map.put("notice", notice);
        int recordCount = noticeMapper.count(map);
        pageModel.setRecordCount(recordCount);

        if (recordCount > 0) {
            /** 开始分页查询数据：查询第几页的数据 */
            map.put("pageModel", pageModel);
        }

        return noticeMapper.selectByParamWithPage(map);
    }

    /**
     * 获得所有公告总数
     *
     * @return Notice对象的数量统计
     */
    public int countByAll() {
        return noticeMapper.countAll();
    }
}
