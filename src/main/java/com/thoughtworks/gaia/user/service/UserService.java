package com.thoughtworks.gaia.user.service;

import com.exmertec.yaz.query.EqualQuery;
import com.google.common.base.Strings;
import com.thoughtworks.gaia.common.Loggable;
import com.thoughtworks.gaia.common.exception.BadRequestException;
import com.thoughtworks.gaia.common.exception.ErrorCode;
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
            throw new BadRequestException(ErrorCode.USER_EMPTY_USER_ID);
        }

        if (userDao.where(new EqualQuery("userId", userId)).count() > 0){
            throw new BadRequestException(ErrorCode.USER_EXISTS_USER_ID);
        }

        UserModel userModel = new UserModel();
        userModel.setUserId(userId);
        userModel.setPassword(password);
        userDao.save(userModel);

        return mapper.map(userModel, User.class);
    }

    public User updateUser(User user){
        if (null == user.getId() || user.getId() <= 0) {
            throw new BadRequestException(ErrorCode.USER_EMPTY_USER_ID);
        }

        if (null != user.getPhone() && user.getPhone().length() != 11) {
            throw new BadRequestException(ErrorCode.USER_INVALID_PHONE);
        }

        UserModel userModel = new UserModel();
        userModel.setId(user.getId());
        userModel.setSex(user.getSex());
        userModel.setSchool(user.getSchool());
        userModel.setGrade(user.getGrade());
        userModel.setPhone(user.getPhone());
        userModel.setAge(user.getAge());
        userModel.setRealname(user.getRealname());

        userDao.update(userModel);
        return mapper.map(userModel, User.class);
    }
}
