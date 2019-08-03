package com.sda.dao;

import com.sda.entity.UserEntity;

import java.util.Optional;

public interface UserDao {
    void saveUser(UserEntity user);

    Optional<UserEntity> findUser(String login);
}
