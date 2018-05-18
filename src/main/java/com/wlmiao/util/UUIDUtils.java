package com.wlmiao.util;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;

public class UUIDUtils {

    private static final TimeBasedGenerator timeBasedGenerator = Generators
        .timeBasedGenerator(EthernetAddress.fromInterface());

    /**
     * 获取UUID
     *
     * @return UUID字符串
     */
    public static String getUUID() {
        return timeBasedGenerator.generate().toString();
    }

}
