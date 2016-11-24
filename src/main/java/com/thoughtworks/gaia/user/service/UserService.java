package com.thoughtworks.gaia.user.service;

import com.thoughtworks.gaia.common.Loggable;
import com.thoughtworks.gaia.user.UserMapper;
import com.thoughtworks.gaia.user.dao.UserDao;
import com.thoughtworks.gaia.user.entity.User;
import com.thoughtworks.gaia.user.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UserService implements Loggable {
    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserDao userDao;
}
