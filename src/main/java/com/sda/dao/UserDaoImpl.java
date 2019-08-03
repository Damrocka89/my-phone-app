package com.sda.dao;

import com.sda.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    private static List<UserEntity> users = loadMockUser();

    @Override
    public void saveUser(UserEntity user) {
        users.add(user);
    }

    @Override
    public Optional<UserEntity> findUser(String login) {
        return users.stream().filter(
                u -> login.equals(u.getLogin())
        ).findFirst();
    }

    private static List<UserEntity> loadMockUser() {
        List<UserEntity> result = new ArrayList<>();
        result.add(new UserEntity("romantyk", "haslo", "Roman", "Romantyczny", "roman.romantyczny@gmail.com"));
        return result;
    }
}
