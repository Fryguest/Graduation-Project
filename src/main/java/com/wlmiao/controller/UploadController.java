package com.wlmiao.controller;

import com.alibaba.fastjson.JSONObject;
import com.wlmiao.util.FileUpload;
import com.wlmiao.util.UUIDUtils;
import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${upload.path}")
    private String uploadPath;

    /**
     * 上传文件
     *
     * @param file 文件路径
     * @return json 状态和存放路径
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String upload(@RequestHeader(value = "uploadid") String uploadid, @RequestParam("file") MultipartFile file) {
        JSONObject result = new JSONObject();
        String filename = FileUpload.fileUp(file, uploadPath + File.separatorChar + uploadid, UUIDUtils.getUUID());
        logger.info("original file {} upload to {} filename {} ", file.getOriginalFilename(),
            uploadPath + File.separatorChar + uploadid, filename);
        result.put("originalname", file.getOriginalFilename());
        if (null != filename) {
            result.put("filename", uploadPath + File.separatorChar + uploadid + File.separatorChar + filename);
            result.put("status", 1);
        } else {
            logger.error("filename {} upload failed", file.getOriginalFilename());
            result.put("status", 0);
        }
        return result.toJSONString();
    }
}
