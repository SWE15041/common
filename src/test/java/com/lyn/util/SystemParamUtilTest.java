package com.lyn.util;

import org.junit.Test;

public class SystemParamUtilTest {

    @Test
    public void getSystemParam() {
        SystemParamUtil.init();
        String hello = SystemParamUtil.getParam("hello", String.class);
        System.out.println("sysParam hello=" + hello);
    }
}