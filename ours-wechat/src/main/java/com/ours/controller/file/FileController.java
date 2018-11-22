package com.ours.controller.file;

import com.ours.common.back.DataResponse;
import com.ours.common.util.EmptyUtil;
import com.ours.service.file.IFileUploadRemoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by fish on 2018/11/22.
 */

@Controller
@RequestMapping("file")
public class FileController {

    private static Logger baseLog = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private IFileUploadRemoteService fileUploadRemoteService;

    /**
     * 上传文件
     *
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse upload(MultipartFile file) throws Exception {
        String fileUrl = "";
        if (EmptyUtil.isNotEmpty(file)) {
            baseLog.info("开始上传文件.");
            InputStream input = file.getInputStream();
            int count = input.available();
            byte[] fileByte = new byte[count];
            input.read(fileByte);
            String fileName = file.getOriginalFilename();
            baseLog.info("当前上传请求的file的文件名:" + fileName);
            input.read(fileByte);
            fileName = fileName.substring(fileName.lastIndexOf(".") + 1);
            String fileId = this.fileUploadRemoteService.storeFile(fileByte, fileName);
            fileUrl = fileId + "." + fileName;
            baseLog.info("结束上传文件");
            baseLog.info("上传后的文件名：" + fileUrl);
        }
        return new DataResponse(1000, "success", fileUrl);
    }


}
