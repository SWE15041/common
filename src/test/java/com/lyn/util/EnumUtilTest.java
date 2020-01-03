package com.lyn.util;

import com.lyn.myEnum.Color;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

public class EnumUtilTest {

    @Test
    public void getByCode() {
        Color color = EnumUtil.getByCode(Color.class, 1);
        System.out.println("code:" + color.getCode() + "---value:" + color.getValue() + "---ordinal:" + color.ordinal());
    }

    @Test
    public void getByValue() {
        Color color = EnumUtil.getByValue(Color.class, "红色");
        System.out.println("code:" + color.getCode() + "---value:" + color.getValue() + "---ordinal:" + color.ordinal());

    }

    @Test
    public void getAll() {
        Map<Integer, String> all = EnumUtil.getAll(Color.class);
        Iterator<Map.Entry<Integer, String>> iterator = all.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            Integer key = next.getKey();
            String value = next.getValue();
            System.out.println("key:" + key + "---value:" + value);
        }
    }
}