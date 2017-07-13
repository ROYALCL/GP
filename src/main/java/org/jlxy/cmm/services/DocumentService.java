package org.jlxy.cmm.services;

import org.jlxy.cmm.entity.Document;
import org.jlxy.cmm.utils.PageModel;

import java.util.List;

/**
 * Created by ORCHID on 2017/4/2.
 */
public interface DocumentService {
    /**
     * 添加文档
     *
     * @param document 文件对象
     */
    boolean save(Document document);

    /**
     * 根据id删除文档
     *
     * @param id
     */
    boolean delete(int id);

    /**
     * 修改文档
     *
     * @param document 公告对象
     */
    void update(Document document);

    /**
     * 根据id查询文档
     *
     * @param id
     * @return 文档对象
     */
    Document selectById(int id);

    /**
     * 获得所有文档
     *
     * @return Document对象的List集合
     */
    List<Document> selectByAll();

    List<Document> selectByParamWithPage(Document document, PageModel pageModel);

    /**
     * 获得所有文档总数
     *
     * @return Document对象的数量统计
     */
    int countByAll();
}
