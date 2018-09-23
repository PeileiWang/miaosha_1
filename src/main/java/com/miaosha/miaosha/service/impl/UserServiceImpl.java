package com.miaosha.miaosha.service.impl;

import com.miaosha.miaosha.dao.UserDao;
import com.miaosha.miaosha.domain.User;
import com.miaosha.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by WangPeilei
 * Time 2018/9/22 19:01
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }
}
