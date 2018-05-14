package com.wlmiao.util;

import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;

/**
 * Created by xinxin.chen on 2018.2.26.
 */
public class WebFileUtil {

    public static void downloadFile(HttpServletResponse response, String content, String fileName) {
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        try {
            OutputStream out = response.getOutputStream();
            out.write(content.getBytes());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void downloadFileFromDisk(HttpServletResponse response, String filepath, String filename) {
        filename = filename.replaceAll(",", "-");
        if (StringUtils.hasText(filepath)) {
            File file = new File(filepath);
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName=" + filename);
            try {
                FileInputStream inputStream = new FileInputStream(file);
                OutputStream out = response.getOutputStream();
                byte buffer[] = new byte[1024];
                int len = 0;
                while ((len = inputStream.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
                inputStream.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void downloadZipFile(HttpServletResponse response, List<JSONObject> fileList, String fileName) {
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName + ".zip");
        try {
            ZipOutputStream out = new ZipOutputStream(response.getOutputStream());
            for (JSONObject file : fileList) {
                out.putNextEntry(new ZipEntry(file.getString("title")));
                out.write(file.getString("content").getBytes());
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
