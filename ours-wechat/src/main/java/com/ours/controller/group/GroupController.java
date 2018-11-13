package com.ours.controller.group;

import com.ours.common.back.DataResponse;
import com.ours.common.util.EmptyUtil;
import com.ours.model.group.GroupInfo;
import com.ours.service.file.IFileUploadRemoteService;
import com.ours.service.group.IGroupInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Date;

/**
 * Created by fish on 2018/11/12.
 */
@Controller
@RequestMapping("group")
public class GroupController {

    private static Logger baseLog = LoggerFactory.getLogger(GroupController.class);

    @Autowired
    private IGroupInfoService groupInfoService;

    @Autowired
    private IFileUploadRemoteService fileUploadRemoteService;

    @RequestMapping(value = "/saveGroupInfo", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse saveGroupInfo(GroupInfo params, MultipartFile photo) {
        String url = "";
        try {
            if (EmptyUtil.isNotEmpty(photo)) {
                baseLog.info("开始圈子头像.");
                InputStream input = photo.getInputStream();
                int count = input.available();
                byte[] fileByte = new byte[count];
                input.read(fileByte);
                String fileName = photo.getOriginalFilename();
                baseLog.info("当前上传请求的file的文件名:" + fileName);
                input.read(fileByte);
                fileName = fileName.substring(fileName.lastIndexOf(".") + 1);
                String fileId = this.fileUploadRemoteService.storeFile(fileByte, fileName);
                url = fileId + "." + fileName;
                baseLog.info("结束上传文件");
                baseLog.info("上传后的文件名：" + url);
            }
            params.setGroupPhotoUrl(url);
            params.setModifyTime(new Date());
            params.setCreateTime(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(1);
        this.groupInfoService.saveGroupInfo(params);
        return new DataResponse(1000, "success");
    }


    @RequestMapping(value = "/findGroupInfo", method = RequestMethod.GET)
    @ResponseBody
    public DataResponse findGroupInfo(GroupInfo params) {
        return new DataResponse(1000, "success", this.groupInfoService.findGroupInfoList(params));
    }


}
