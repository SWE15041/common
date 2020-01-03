package com.lyn.constant;

import com.lyn.myEnum.Enumeration;

public enum Color implements Enumeration<Integer, String> {
    //
    RED(1, "红色"), BLUE(2, "蓝色"), GREEN(3, "绿色");

    private String value;
    private Integer code;

    Color(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getValue() {
        return this.value;
    }

}
