package com.lyn.util;

import java.math.BigDecimal;

public class StringUtil {
    public static <T> T cast(String value, Class<T> requiredType) {
        if (Validator.isNull(value)) {
            return null;
        }
        if (Integer.class.isAssignableFrom(requiredType)) {
            return (T) Integer.valueOf(value);
        } else if (Long.class.isAssignableFrom(requiredType)) {
            return (T) Long.valueOf(value);
        } else if (Short.class.isAssignableFrom(requiredType)) {
            return (T) Short.valueOf(value);
        } else if (Double.class.isAssignableFrom(requiredType)) {
            return (T) Double.valueOf(value);
        } else if (Boolean.class.isAssignableFrom(requiredType)) {
            return (T) Boolean.valueOf(value);
        } else if (Float.class.isAssignableFrom(requiredType)) {
            return (T) Float.valueOf(value);
        } else if (BigDecimal.class.isAssignableFrom(requiredType)) {
            return (T) BigDecimal.valueOf(cast(value, Double.class));
        }
        return requiredType.cast(value);
    }

    public static boolean isNotBlank(String str) {
        return !StringUtil.isBlank(str);
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
}
