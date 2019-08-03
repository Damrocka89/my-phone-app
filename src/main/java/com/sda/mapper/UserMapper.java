package com.sda.mapper;

import com.sda.entity.UserEntity;
import com.sda.model.User;

public class UserMapper {
    private UserMapper() {
    }

    public static User mapToUser(UserEntity userEntity){
        if(userEntity == null){
            return null;
        }
        return new User(userEntity.getLogin(), userEntity.getPassword(), userEntity.getName(),userEntity.getSurname(), userEntity.getEmail());
    }

    public static UserEntity mapToUserEntity(User user){
        return new UserEntity(user.getLogin(), user.getPassword(), user.getName(),user.getSurname(), user.getEmail());
    }
}
