package com.ours.common.util;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by fish on 2018/7/26.
 */
public class EmptyUtil {

    public EmptyUtil() {
    }

    public static <T> boolean isNotEmpty(Object value) {
        return NullUtil.isNotNull(value) && !isEmpty(value.toString());
    }

    public static <T> boolean isNotEmpty(List<T> lists) {
        return NullUtil.isNotNull(lists) && !lists.isEmpty();
    }

    public static <T> boolean isNotEmpty(T[] datas) {
        return NullUtil.isNotNull(datas) && datas.length > 0;
    }

    public static boolean isNotEmpty(String datas) {
        return NullUtil.isNotNull(datas)?("".equals(datas.trim())?false:!StringUtils.isBlank(datas)):false;
    }

    public static boolean isNotEmpty(Map datas) {
        return MapUtils.isNotEmpty(datas);
    }

    public static boolean isNotUndefinedChars(String value) {
        return isNotEmpty(value) && !"undefined".equals(value.trim().toLowerCase());
    }

    public static boolean isNotNullChars(String value) {
        return isNotEmpty(value) && !"null".equals(value.trim().toLowerCase());
    }

    public static boolean isNotEmptyChars(String value) {
        return isNotUndefinedChars(value) && isNotNullChars(value);
    }

    public static <T> boolean isEmpty(List<T> lists) {
        return NullUtil.isNull(lists)?true:lists.isEmpty();
    }

    public static <T> boolean isEmpty(T[] datas) {
        return NullUtil.isNull(datas)?true:datas.length == 0;
    }

    public static boolean isEmpty(String datas) {
        return NullUtil.isNull(datas)?true:("".equals(datas.trim())?true:StringUtils.isBlank(datas));
    }

    public static boolean isEmpty(Map datas) {
        return MapUtils.isEmpty(datas);
    }

    public static boolean isUndefinedChars(String value) {
        return isEmpty(value)?true:"undefined".equals(value.trim().toLowerCase());
    }

    public static boolean isNullChars(String value) {
        return isEmpty(value)?true:"null".equals(value.trim().toLowerCase());
    }

    public static boolean isEmptyChars(String value) {
        return isNullChars(value) || isUndefinedChars(value);
    }

    public static <T> boolean isEmpty(Object value) {
        return NullUtil.isNull(value)?true:isEmpty(value.toString());
    }

}
