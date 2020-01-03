package com.lyn.util;

import com.lyn.myEnum.Enumeration;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class EnumUtil {

    /**
     * 零和非零开头的数字：^(0|[1-9][0-9]*)$
     */
    public static final String POSITIVE_INTEGER_REGEX = "^(0|[1-9][0-9]*)$";

    /**
     * 通过code获取枚举实例
     *
     * @param enumClazz
     * @param code
     * @param <E>
     * @return
     */
    public static <E extends Enumeration> E getByCode(Class<E> enumClazz, Integer code) {
        if (enumClazz == null || !enumClazz.isEnum()) {
            return null;
        }
        E[] enumConstants = enumClazz.getEnumConstants();
        for (E enumConstant : enumConstants) {
            if (enumConstant.getCode().equals(code)) {
                return enumConstant;
            }
        }
        return null;
    }

    /**
     * 根据value值获取枚举对象
     *
     * @param enumClazz
     * @param value
     * @param <E>
     * @return
     */
    public static <E extends Enumeration> E getByValue(Class<E> enumClazz, String value) {
        if (enumClazz == null || !enumClazz.isEnum() || value == null || "".equals(value)) {
            return null;
        }
        E[] enumConstants = enumClazz.getEnumConstants();
        for (E enumConstant : enumConstants) {
            if (enumConstant.getValue().equals(value)) {
                return enumConstant;
            }
        }
        return null;
    }

    /**
     * 获取所有的枚举实例
     *
     * @param enumClazz
     * @param <E>
     * @return Map<code                                                                                                                               ,                                                                                                                               value>
     */
    public static <E extends Enumeration> Map<Integer, String> getAll(Class<E> enumClazz) {
        if (enumClazz == null || !enumClazz.isEnum()) {
            return null;
        }
        Map<Integer, String> targetMap = new HashMap<>();
        E[] enumConstants = enumClazz.getEnumConstants();
        for (E enumConstant : enumConstants) {
            boolean matches = isMatches(String.valueOf(enumConstant.getCode()), POSITIVE_INTEGER_REGEX);
            if (!matches) {
                break;
            }
            Integer code = Integer.valueOf(String.valueOf(enumConstant.getCode()));
            String value = String.valueOf(enumConstant.getValue());
            targetMap.put(code, value);
        }
        return targetMap;
    }

    public static boolean isDigit(String value) {
        int length = value.length();
        for (int i = 0; i < length - 1; i++) {
            if (!Character.isDigit(value.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMatches(String value, String regex) {
        return Pattern.compile(regex).matcher(value).matches();
    }

}
