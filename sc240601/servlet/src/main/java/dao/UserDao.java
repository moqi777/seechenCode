package dao;

import pojo.User;

public interface UserDao {
    public int reg(User user);
    public User login(String phone,String password);
}
