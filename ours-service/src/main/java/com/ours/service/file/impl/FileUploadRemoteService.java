package com.ours.service.file.impl;

import com.ours.common.util.FileUtil;
import com.ours.common.util.ImageUtil;
import com.ours.model.base.BaseSysParam;
import com.ours.service.base.IBaseSysParamService;
import com.ours.service.file.IFileUploadRemoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.UUID;

@Service
public class FileUploadRemoteService implements IFileUploadRemoteService {

    private static Logger baseLog = LoggerFactory.getLogger(FileUploadRemoteService.class);

    @Autowired
    private IBaseSysParamService baseSysParamService;

    private String imageDir;

    private String fileDir;

    /**
     * 原图地址前缀
     */
    private static final String ORIGINAL_PATH = "ori";

    public void init() {
        this.imageDir = this.baseSysParamService.findValueByKey(new BaseSysParam("IMAGE_DIR"));
        this.fileDir = this.baseSysParamService.findValueByKey(new BaseSysParam("FILE_DIR"));
    }

    @Override
    public String storeFile(byte[] fileByte, String extName) throws Exception {
        init();
        String jobName = "文件上传";
        long start = System.currentTimeMillis();
        baseLog.info(jobName + "--开始");
        InputStream inputStream = new ByteArrayInputStream(fileByte);
        String picId = UUID.randomUUID().toString().replaceAll("-", "");
        String filePath = "";
        if (ImageUtil.isImage(extName)) {
            filePath = imageDir + "/" + ORIGINAL_PATH + "/" + picId + "." + extName;
            FileUtil.InputStreamTOFile(inputStream, filePath);
        } else {
            filePath = fileDir + "/" + picId + "." + extName;
            FileUtil.InputStreamTOFile(inputStream, filePath);
        }
        long end = System.currentTimeMillis();
        baseLog.info(jobName + "--结束----耗时:" + (end - start) + "ms");
        return picId;
    }
}
