package demo01.dao;

import demo01.model.User;
public interface IUserDAO {

    // 根据用户名、用户密码查找用户
    User find(String userName, String userPwd);

    // 根据用户名查找用户
    User find(String userName);

    // 增加一个用户
    void add(User user) ;
}

