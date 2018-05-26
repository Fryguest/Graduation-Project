package com.wlmiao.util;

import com.alibaba.fastjson.JSONObject;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;


public class WebFileUtil {

    public static void downloadFile(HttpServletResponse response, String content, String fileName) throws IOException {
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        OutputStream out = response.getOutputStream();
        out.write(content.getBytes());
        out.close();
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

    public static void downloadZipFile(HttpServletResponse response, List<JSONObject> fileList, String fileName)
        throws IOException {
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName + ".zip"
        );
        ZipOutputStream out = new ZipOutputStream(response.getOutputStream());
        for (JSONObject file : fileList) {
            out.putNextEntry(new ZipEntry(file.getString("title")));
            out.write(file.getString("content").getBytes());
        }
        out.close();
    }

    public static void downloadZipFileByXssfWorkbookList(HttpServletResponse response,
        List<Map<String, XSSFWorkbook>> fileList, String fileName) {
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName + ".zip");
        try {
            ZipOutputStream out = new ZipOutputStream(response.getOutputStream());
            for (Map<String, XSSFWorkbook> map : fileList) {
                for (Map.Entry<String, XSSFWorkbook> entry : map.entrySet()) {
                    String title = entry.getKey();
                    XSSFWorkbook xssfWorkbook = entry.getValue();
                    out.putNextEntry(new ZipEntry(title));
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    xssfWorkbook.write(bos);
                    bos.writeTo(out);
                    out.closeEntry();
                }
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void downloadXlsxFileByWorkbook(HttpServletResponse response, XSSFWorkbook xssfWorkbook,
        String fileName)
        throws IOException {
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);

        OutputStream out = response.getOutputStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        xssfWorkbook.write(bos);
        bos.writeTo(out);
        out.close();
    }

}
