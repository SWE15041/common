package com.lyn.util;

import com.lyn.string.StringPool;

public class Validator {
    public static boolean isNull(String s) {
        if (s == null) {
            return true;
        }

        s = s.trim();

        if ((s.equals(StringPool.NULL)) || (s.equals(StringPool.BLANK))) {
            return true;
        }

        return false;
    }
}
