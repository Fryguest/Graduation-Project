package com.wlmiao.exception;

import com.alibaba.fastjson.JSONObject;
import com.wlmiao.constant.ExceptionConstant;
import com.wlmiao.util.WebFileUtil;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import lombok.Data;

@Data
public class EduSysException extends Exception {

    private static final long serialVersionUID = 4969678483949772157L;

    private Integer code;

    private String msg;

    public EduSysException(Integer code) {
        super();
        this.code = code;
        this.msg = ExceptionConstant.getExceptionMessage(code);
    }

    public EduSysException(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public void returnException(HttpServletResponse response) throws IOException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("msg", msg);
        WebFileUtil.downloadFile(response, jsonObject.toString(), "error");
    }
}
