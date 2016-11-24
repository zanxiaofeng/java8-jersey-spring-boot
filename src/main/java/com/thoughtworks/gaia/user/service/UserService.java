package com.thoughtworks.gaia.user.service;

import com.exmertec.yaz.query.EqualQuery;
import com.google.common.base.Strings;
import com.thoughtworks.gaia.common.Loggable;
import com.thoughtworks.gaia.common.exception.BadRequestException;
import com.thoughtworks.gaia.user.UserMapper;
import com.thoughtworks.gaia.user.dao.UserDao;
import com.thoughtworks.gaia.user.entity.User;
import com.thoughtworks.gaia.user.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UserService implements Loggable {
    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserDao userDao;

    public User createUser(String userId, String password) {
        if (Strings.isNullOrEmpty(userId)){
            throw new BadRequestException();
        }

        if (userDao.where(new EqualQuery("userId", userId)).count() > 0){
            throw new BadRequestException();
        }

        UserModel userModel = new UserModel();
        userModel.setUserId(userId);
        userModel.setPassword(password);
        userDao.save(userModel);

        return mapper.map(userModel, User.class);
    }
}
