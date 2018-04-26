package demo01.action;
import demo01.model.User;
import demo01.dao.impl.UserDAO;
public class LoginAction {
    public static User loginUser(String userName, String userPwd) {
        User user = new UserDAO().find(userName, userPwd);
        return user;
    }
}
