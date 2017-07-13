package org.jlxy.cmm.controller;

import org.apache.commons.io.FileUtils;
import org.jlxy.cmm.entity.Document;
import org.jlxy.cmm.entity.User;
import org.jlxy.cmm.services.DocumentService;
import org.jlxy.cmm.utils.MethodName;
import org.jlxy.cmm.utils.PageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.List;

import static org.jlxy.cmm.utils.CmConstants.USER_SESSION;

/**
 * Created by ORCHID on 2017/4/3.
 */
@Controller
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/document/selectDocument")
    public String selectDocument(
            Model model, Integer pageIndex,
            @ModelAttribute Document document) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        PageModel pageModel = new PageModel();
        if (pageIndex != null) {
            pageModel.setPageIndex(pageIndex);
        }
        /** 查询用户信息     */
        List<Document> documents = documentService.selectByParamWithPage(document, pageModel);
        model.addAttribute("documents", documents);
        model.addAttribute("pageModel", pageModel);
        return "document/document";
    }

    /**
     * 处理添加请求
     *
     * @param flag     标记， 1表示跳转到上传页面，2表示执行上传操作
     * @param document 要添加的公告对象
     * @param mv
     */
    @RequestMapping(value = "/document/addDocument")
    public ModelAndView addDocument(
            String flag,
            @ModelAttribute Document document,
            ModelAndView mv,
            HttpSession session) throws Exception {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        if (flag.equals("1")) {
            mv.setViewName("document/showAddDocument");
        } else {
            // 上传文件路径
            String path = session.getServletContext().getRealPath("/upload");
           logger.info(path);
            // 上传文件名
            String fileName = document.getFile().getOriginalFilename();
            // 将上传文件保存到一个目标文件当中
            document.getFile().transferTo(new File(path + File.separator + fileName));
            // 插入数据库
            // 设置fileName
            document.setFileName(fileName);
            // 设置关联的User对象
            User user = (User) session.getAttribute(USER_SESSION);
            document.setUser(user);
            document.setCreateTime(new Date());
            // 插入数据库
            documentService.save(document);
            // 返回
            mv.setViewName("redirect:/document/selectDocument");
        }
        // 返回
        return mv;
    }

    /**
     * 处理删除文档请求
     *
     * @param ids 需要删除的id字符串
     * @param mv
     */
    @RequestMapping(value = "/document/removeDocument")
    public ModelAndView removeDocument(String ids, ModelAndView mv) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        // 分解id字符串
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            // 根据id删除文档
            documentService.delete(Integer.parseInt(id));
        }
        // 设置客户端跳转到查询请求
        mv.setViewName("redirect:/document/selectDocument");
        // 返回ModelAndView
        return mv;
    }

    /**
     * 处理修改文档请求
     *
     * @param flag     标记， 1表示跳转到修改页面，2表示执行修改操作
     * @param document 要修改文档的对象
     * @param mv
     */
    @RequestMapping(value = "/document/updateDocument")
    public ModelAndView updateDocument(
            String flag,
            @ModelAttribute Document document,
            ModelAndView mv) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        if (flag.equals("1")) {
            // 根据id查询文档
            Document target = documentService.selectById(document.getId());
            // 设置Model数据
            mv.addObject("document", target);
            // 设置跳转到修改页面
            mv.setViewName("document/showUpdateDocument");
        } else {
            // 执行修改操作
            documentService.update(document);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/document/selectDocument");
        }
        // 返回
        return mv;
    }

    @RequestMapping(value = "/document/downLoad")
    public ResponseEntity<byte[]> downLoad(
            Integer id,
            HttpSession session) throws Exception {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        // 根据id查询文档
        String fileName = documentService.selectById(id).getFileName();
        // 上传文件路径
        String path = session.getServletContext().getRealPath("/upload/");
        // 获得要下载文件的File对象
        File file = new File(path + File.separator + fileName);
        // 创建springframework的HttpHeaders对象
        HttpHeaders headers = new HttpHeaders();
        // 下载显示的文件名，解决中文名称乱码问题
        String downloadFielName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
        // 通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFielName);
        // application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 201 HttpStatus.CREATED
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
}