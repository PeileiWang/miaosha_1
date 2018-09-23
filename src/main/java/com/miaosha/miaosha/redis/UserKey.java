package com.miaosha.miaosha.redis;

/**
 * Created by WangPeilei
 * Time 2018/9/23 11:42
 */
public class UserKey extends BasePrefix {

    public UserKey(String prefix) {
        super(prefix);
    }

    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");
}
