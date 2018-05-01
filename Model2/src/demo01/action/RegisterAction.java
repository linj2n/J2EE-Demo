package demo01.action;

import demo01.dao.impl.UserDAO;
import demo01.model.User;

public class RegisterAction {
    public static void registerUser(User user) {
        new UserDAO().add(user);
    }
}
