package org.jlxy.cmm.servicesImpl;

import org.jlxy.cmm.BaseJunitTest;
import org.jlxy.cmm.entity.Document;
import org.jlxy.cmm.services.DocumentService;
import org.jlxy.cmm.services.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by ORCHID on 2017/4/3.
 */
public class DocumentServiceImplTest extends BaseJunitTest {
    @Autowired
    private DocumentService documentService;

    @Autowired
    private UserService userService;

    @Test
    public void save() throws Exception {
        Document document = new Document(userService.selectById(1), "iodsfsoid", "ksdjhkjsd", "ldkjflks", new Date());
        if (documentService.save(document)) {
            logger.info("TRUE");
        } else {
            logger.info("FALSE");
        }
    }

    @Test
    public void delete() throws Exception {
        if (documentService.delete(1)) {
            logger.info("TRUE");
        } else {
            logger.info("FALSE");
        }
    }

    @Test
    public void update() throws Exception {
        Document document = new Document(userService.selectById(1), "update", "ksdjhkjsd", "ldkjflks", new Date());
    }

    @Test
    public void selectById() throws Exception {
        logger.info(documentService.selectById(1).toString());
    }

    @Test
    public void selectByAll() throws Exception {
        List<Document> documents = documentService.selectByAll();
        for (Document document : documents) {
            logger.info(document.toString());
        }
    }

    @Test
    public void countByAll() throws Exception {
        System.out.println(documentService.countByAll());
    }

}