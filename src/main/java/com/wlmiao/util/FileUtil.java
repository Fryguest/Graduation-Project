package com.wlmiao.util;

import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;

/**
 * Created by xinxin.chen on 2018.1.10.
 */
public class FileUtil {

    public static List<String> readFileByline(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        List<String> result = new ArrayList<>();
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            if (!StringUtils.isEmpty(line.trim())) {
                result.add(line.trim());
            }
        }
        br.close();
        fr.close();
        return result;
    }

    public static String readFile(String filePath) throws IOException {
        return readFile(new File(filePath));
    }

    public static String readFile(File file) throws IOException {
        StringBuffer sb = new StringBuffer();
        FileInputStream inputStream = new FileInputStream(file);
        byte buffer[] = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) > 0) {
            sb.append(new String(buffer, 0, len));
        }
        inputStream.close();
        return sb.toString();

    }

    public static String cancatPath(Object prePath, Object sufPath) {
        return formatPath(prePath.toString() + File.separator + sufPath.toString());
    }

    public static String formatPath(String originPath) {
        String path = originPath.replace("\\", "/");
        while (path.contains("//")) {
            path = path.replace("//", "/");
        }
        return path;
    }

    public static boolean copyFile(String srcFileName, String destFileName, boolean overlay, boolean removeOrigin)
        throws IOException {
        File srcFile = new File(srcFileName);

        if (!srcFile.exists() || !srcFile.isFile()) {
            return false;
        }

        File destFile = new File(destFileName);

        if (!createFile(destFile, overlay)) {
            return false;
        }

        InputStream in = new FileInputStream(srcFile);
        OutputStream out = new FileOutputStream(destFile);
        Integer byteread;
        byte[] buffer = new byte[1024];
        while ((byteread = in.read(buffer)) != -1) {
            out.write(buffer, 0, byteread);
        }
        out.close();
        in.close();

        if (removeOrigin) {
            srcFile.delete();
        }
        return true;

    }

    public static boolean copyDirectory(String srcDirName, String destDirName, boolean overlay, boolean removeOrigin)
        throws IOException {

        File srcDir = new File(srcDirName);
        if (!srcDir.exists() || !srcDir.isDirectory()) {
            return false;
        }

        File destDir = new File(destDirName);
        if (destDir.exists()) {
            if (overlay) {
                destDir.delete();
            } else {
                return true;
            }
        } else if (!destDir.mkdirs()) {
            return false;
        }

        boolean flag = true;
        File[] files = srcDir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                flag = copyFile(files[i].getAbsolutePath(), cancatPath(destDirName, files[i].getName()),
                    overlay, removeOrigin);
            } else if (files[i].isDirectory()) {
                flag = copyDirectory(files[i].getAbsolutePath(), cancatPath(destDirName, files[i].getName()),
                    overlay, removeOrigin);
            }
            if (!flag) {
                destDir.delete();
                return false;
            }
        }
        if (removeOrigin) {
            srcDir.delete();
        }
        return true;
    }


    public static boolean createFile(String path, boolean overlay) throws IOException {
        File file = new File(path);
        return createFile(file, overlay);
    }

    public static boolean createFile(File file, boolean overlay) throws IOException {
        if (file.exists()) {
            if (overlay) {
                file.delete();
            } else {
                return false;
            }
        }

        if (!file.getParentFile().exists()) {
            if (!file.getParentFile().mkdirs()) {
                return false;
            }
        }

        file.createNewFile();
        return true;
    }

    public static boolean writeFile(String path, List<String> contentList, Boolean append) throws IOException {
        File file = new File(path);
        return writeFile(file, contentList, append);
    }

    public static boolean writeFile(File file, List<String> contentList, Boolean append) throws IOException {
        FileOutputStream output = new FileOutputStream(file, append);
        StringBuffer sb = new StringBuffer();
        for (String content : contentList) {
            sb.append(content + "\n");
        }
        output.write(sb.toString().getBytes());
        output.close();
        return true;
    }

    public static JSONObject readJSON(String path) throws IOException {
        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        String s = readFile(file);
        if (StringUtils.isEmpty(s)) {
            return null;
        }
        return JSONObject.parseObject(s);
    }
}
