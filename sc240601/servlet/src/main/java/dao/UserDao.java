package dao;

import pojo.User;

import java.util.List;

public interface UserDao {
    int reg(User user);

    User login(String phone,String password);

    List<User> show();

    int deleteUser(Integer id);

    int updateUser(User user);
}
