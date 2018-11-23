package com.ours.service.file;


/**
 * Created by fish on 2018/11/12.
 */
public interface IFileUploadRemoteService {

    /**
     * 保存文件(包括图片和文件)
     *
     * @param fileByte
     * @param extName
     * @return 图片ID路径
     * @throws Exception
     */
    String storeFile(byte[] fileByte, String extName) throws Exception;

}
