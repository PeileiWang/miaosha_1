package com.miaosha.miaosha.redis;

/**
 * Created by WangPeilei
 * Time 2018/9/23 11:42
 */
public class OrderKey extends BasePrefix {
    public OrderKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}
