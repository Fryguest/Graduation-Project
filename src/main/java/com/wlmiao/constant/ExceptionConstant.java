package com.wlmiao.constant;

import java.util.HashMap;

/**
 * Created by xinxin.chen on 2018.1.22.
 */
public class ExceptionConstant {

    public static final Integer XLSX_ERROR = -1000;
    public static final Integer IO_EXCEPTION = -1001;
    public static final Integer UNEXCEPT_ERROR = -1002;

    private static HashMap<Integer, String> map = new HashMap<>();
    static {
        map.put(XLSX_ERROR, "xlsx error");
        map.put(IO_EXCEPTION, "IO exception");
        map.put(UNEXCEPT_ERROR, "unexcept error");
    }

    public static String getExceptionMessage(Integer i) {
        return map.get(i);
    }

}
