package com.ours.service.file.impl;

import com.ours.common.util.FileUtil;
import com.ours.common.util.ImageUtil;
import com.ours.model.base.BaseSysParam;
import com.ours.service.base.IBaseSysParamService;
import com.ours.service.file.IFileUploadRemoteService;
import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.coobird.thumbnailator.Thumbnails.Builder;

import java.io.*;
import java.util.UUID;

@Service
public class FileUploadRemoteServiceImpl implements IFileUploadRemoteService {

    private static Logger baseLog = LoggerFactory.getLogger(FileUploadRemoteServiceImpl.class);

    @Autowired
    private IBaseSysParamService baseSysParamService;

    private String imageDir;

    private String fileDir;

    private Float minScale;

    private Float minQuality;

    private Integer smallWidth;

    private Integer smallHeight;

    private Integer photoWidth;

    private Integer photoHeight;

    /**
     * 原图地址前缀
     */
    private static final String ORIGINAL_PATH = "ori";

    /**
     * 压缩图地址前缀
     */
    private static final String MIN_PATH = "min";

    /**
     * 缩略图地址前缀
     */
    private static final String SMALL_PATH = "small";

    /**
     * 头像地址前缀
     */
    private static final String PHOTO_PATH = "photo";

    public void init() {
        BaseSysParam params = new BaseSysParam();
        params.setParamKey("IMAGE_DIR");
        this.imageDir = this.baseSysParamService.findValueByKey(params);
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
