package com.btpns.training.latihan3.dao;

import com.btpns.training.latihan3.entity.RoleEntity;
import com.btpns.training.latihan3.entity.UserEntity;

import java.util.List;

public interface RoleDao {
    RoleEntity findById(int roleID);
    RoleEntity findByName (String roleName);

    void insertRole(RoleEntity roleEntity);
}
