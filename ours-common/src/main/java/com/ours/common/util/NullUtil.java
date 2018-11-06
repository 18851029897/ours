package com.ours.common.util;

/**
 * Created by fish on 2018/7/26.
 */
public class NullUtil {

    public NullUtil() {
    }

    public static boolean isNotNull(Object obj) {
        return null != obj;
    }

    public static boolean isNull(Object obj) {
        return null == obj;
    }

}
