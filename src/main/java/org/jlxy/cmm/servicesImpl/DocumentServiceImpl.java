package org.jlxy.cmm.servicesImpl;

import org.jlxy.cmm.entity.Document;
import org.jlxy.cmm.mapper.DocumentMapper;
import org.jlxy.cmm.services.DocumentService;
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
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentMapper documentMapper;

    /**
     * 添加文档
     *
     * @param document 文件对象
     */
    public boolean save(Document document) {
        if (documentMapper.save(document) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据id删除文档
     *
     * @param id
     */
    public boolean delete(int id) {
        if (documentMapper.delete(id) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改文档
     *
     * @param document 公告对象
     */
    public void update(Document document) {
        documentMapper.update(document);
    }

    /**
     * 根据id查询文档
     *
     * @param id
     * @return 文档对象
     */
    public Document selectById(int id) {
        return documentMapper.selectById(id);
    }

    /**
     * 获得所有文档
     *
     * @return Document对象的List集合
     */
    public List<Document> selectByAll() {
        return documentMapper.selectAll();
    }

    public List<Document> selectByParamWithPage(Document document, PageModel pageModel) {
        /** 当前需要分页的总数据条数  */
        Map<String, Object> map = new HashMap();
        map.put("document", document);
        int recordCount = documentMapper.count(map);
        pageModel.setRecordCount(recordCount);

        if (recordCount > 0) {
            /** 开始分页查询数据：查询第几页的数据 */
            map.put("pageModel", pageModel);
        }
        return documentMapper.selectByParamWithPage(map);
    }

    /**
     * 获得所有文档总数
     *
     * @return Document对象的数量统计
     */
    public int countByAll() {
        return documentMapper.countAll();
    }
}
