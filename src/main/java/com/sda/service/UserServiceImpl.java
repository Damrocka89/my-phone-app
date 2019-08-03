package com.sda.service;

import com.sda.dao.UserDao;
import com.sda.dao.UserDaoImpl;
import com.sda.model.User;

import static com.sda.mapper.UserMapper.mapToUser;
import static com.sda.mapper.UserMapper.mapToUserEntity;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public void saveUser(User user) {
        userDao.saveUser(mapToUserEntity(user));
    }


    @Override
    public User getUser(String login) {
        return login == null ?  null : mapToUser(userDao.findUser(login).orElse(null));
    }


}
