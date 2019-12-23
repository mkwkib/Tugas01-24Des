package com.btpns.training.latihan3.service;

import com.btpns.training.latihan3.dao.UserDao;
import com.btpns.training.latihan3.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {
   @Autowired
   private UserDao userDao;

    @Override
    public UserEntity findById(int userID) {
        return userDao.findById(userID);
    }

    @Override
    public UserEntity findByName(String userName) {
        return userDao.findByName(userName);
    }

    @Override
    public void insertUser(UserEntity userEntity) {
        userDao.insertUser(userEntity);
    }

    @Override
    public List<UserEntity> findByRoleId(int roleId) {
        return userDao.findByRoleId(roleId);
    }
}
