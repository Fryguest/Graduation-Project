package com.wlmiao.constant;

import java.util.HashMap;

/**
 * Created by xinxin.chen on 2018.1.22.
 */
public class ExceptionConstant {

    public static final Integer XLSX_ERROR = -1000;
    private static HashMap<Integer, String> map = new HashMap<>();
    static {
        map.put(XLSX_ERROR, "xlsx error");
    }

    public static String getExceptionMessage(Integer i) {
        return map.get(i);
    }

}
