package com.lyn.myEnum;

/**
 * 基础枚举 用于定义常用的接口
 *
 * @param <T,K>
 */
public interface Enumeration<T, K> {
    /**
     * 获取枚举的值
     *
     * @return
     */
    T getCode();

    K getValue();

}
