package com.btpns.training.latihan3.dao;

import com.btpns.training.latihan3.entity.UserEntity;

import java.util.List;

public interface UserDao {
    UserEntity findById(int userID);
    UserEntity findByName (String userName);
    List<UserEntity> findByRoleId (int roleId);
    void insertUser(UserEntity userEntity);
}
