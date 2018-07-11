package com.xinyonghang.supplychain.controller;

import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class FileController {

    @Value("${image.upload.path}")
    private String basePath;

    /**
     * 普通页面的上传图片
     * @param file 上传图片
     * @return 上传结果
     * @throws Exception 异常
     */
    @RequestMapping(value = {"/upload"}, method = {RequestMethod.POST})
    @ResponseBody
    public Result upload(@RequestParam("file") MultipartFile file) throws Exception {
        String fileName = System.currentTimeMillis() + file.getOriginalFilename();
        File tempFile = new File(basePath + fileName);
        // 如果目录不存在就先创建目录
        if (!tempFile.getParentFile().exists()) {
                tempFile.getParentFile().mkdirs();
        }
        if (!file.isEmpty()) {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(tempFile));
            out.write(file.getBytes());
            out.flush();
            out.close();
        }
        return ResultGenerator.genSuccessResult();
    }

    /**
     * Ckeditor 上传图片  需要会掉ck的callback方法
     * @param file 图片文件
     * @param req 请求
     * @param response  响应
     * @throws Exception 异常
     */
    @RequestMapping(value = {"/uploadCkeditor"}, method = {RequestMethod.POST})
    @ResponseBody
    public void uploadCkeditor(@RequestParam("file") MultipartFile file, HttpServletRequest req, HttpServletResponse response) throws Exception {
        String fileName = System.currentTimeMillis() + file.getOriginalFilename();
        File tempFile = new File(basePath + fileName);
        // 如果目录不存在就先创建目录
        if (!tempFile.getParentFile().exists()) {
                tempFile.getParentFile().mkdirs();
        }
        if (!file.isEmpty()) {
            // 保存图片到服务器
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(tempFile));
            out.write(file.getBytes());
            out.flush();
            out.close();

            // CKedtior回显
            OutputStream outputStream = response.getOutputStream();
            String rootURL = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
            // 返回"图像"选项卡并显示图片 request.getContextPath()为web项目名
            String callback = req.getParameter("CKEditorFuncNum");
            byte[] b;
            b = ("<script type=\"text/javascript\">" + "window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + rootURL + "/getImage?imagePath=" + fileName + "','')" + "</script>").getBytes("utf-8");
            outputStream.write(b, 0, b.length);
            outputStream.flush();

        }
    }


    @ResponseBody
    @RequestMapping(value = "/getImage", produces = "application/json;charset=utf-8")
    public void getImage(@RequestParam String imagePath, HttpServletResponse response) {
        FileInputStream fis = null;
        OutputStream os = null;
        try {
            // 获取请求参数
            File file = new File(basePath + imagePath);
            if (file.exists()) {
                fis = new FileInputStream(file);
                os = response.getOutputStream();

                byte[] buf = new byte[1024 * 100];
                int position;
                while ((position = fis.read(buf)) != -1) {
                    os.write(buf, 0, position);
                }
                os.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
