package com.wlmiao.exception;

import com.wlmiao.constant.ExceptionConstant;
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

}
