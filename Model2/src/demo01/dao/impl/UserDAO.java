package demo01.dao.impl;
import demo01.dao.IUserDAO;
import demo01.model.User;
import demo01.util.SQLUtil;
import java.sql.*;

public class UserDAO implements IUserDAO {

    @Override
    public  User find(String userEmail, String userPwd) {
        User result = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rSet = null;
        try {
            String sql = "select * from user_ where user_email = ? and user_password = ?";
            conn = SQLUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userEmail);
            pstmt.setString(2, userPwd);
            rSet = pstmt.executeQuery();

            if (rSet.next()) {
//                System.out.println("found!");
                result = new User();
                result.setId(rSet.getInt(1));
                result.setName(rSet.getString(2));
                result.setPassword(rSet.getString(3));
                result.setEmail(rSet.getString(4));
            }
            rSet.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public User find(String userEmail) {
        User result = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rSet = null;
        try {
            String sql = "select * from user_ where user_email = ?";
            conn = SQLUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userEmail);
            rSet = pstmt.executeQuery();

            if (rSet.next()) {
                result = new User();
                result.setId(rSet.getInt(1));
                result.setName(rSet.getString(2));
                result.setPassword(rSet.getString(3));
                result.setEmail(rSet.getString(4));
            }
            rSet.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void add(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // user_id, user_name, user_password, user_email
            String sql = "insert into user_ values(null,?,?,?)";
            conn = SQLUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getEmail());

            pstmt.execute();

            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean isExist(String email) {
        return !(find(email) == null);
    }

    public static void main(String[] args) {

        Timestamp currTime = new Timestamp(System.currentTimeMillis());
        User newUser = new User();
        newUser.setName(currTime.toString());
        newUser.setPassword(currTime.toString());
        newUser.setEmail(currTime.toString() + "@xxx.com");


        new UserDAO().add(newUser);

        //        User user = new UserDAO().find("zhangsan", "123456");
        User user = new UserDAO().find("zhangsan@gmail.com");
        if (user != null) System.out.println("[userId: " + user.getId() + "], [userName:  " + user.getName() + "], [userPwd: " + user.getPassword() + "], [userEmail: " + user.getEmail() + "]. ");
        else System.out.println("fail.");
    }
}

