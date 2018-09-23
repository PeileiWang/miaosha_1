package com.miaosha.miaosha.redis;

/**
 * Created by WangPeilei
 * Time 2018/9/23 11:38
 */
public interface KeyPrefix {

    int expireSeconds();

    String getPrefix();
}
