package demo01.validator;
import demo01.dao.impl.UserDAO;
import demo01.form.RegisterForm;

import java.util.ArrayList;
import java.util.List;

public class RegisterValidator {
    public List<String> validate(RegisterForm registerForm) {
        List<String> errors = new ArrayList<String>();
        if (new UserDAO().isExist(registerForm.getUserEmail())) {
            errors.add("邮箱已被使用，直接登录？");
        }
        if (!registerForm.getUserPassword1().equals(registerForm.getUserPassword2())) {
            errors.add("两次输入的密码不一样！");
        }
        return errors;
    }
}
