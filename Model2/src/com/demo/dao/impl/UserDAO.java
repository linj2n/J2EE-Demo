package com.demo.dao.impl;

import com.demo.dao.IUserDAO;
import com.demo.domain.User;
import com.demo.util.SQLUtil;


import java.sql.*;

public class UserDAO implements IUserDAO {
    @Override
    public User find(String userName, String userPwd) {
        User result = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rSet = null;
        try {
            String sql = "select * from user_ where user_name = ? and user_password = ?";
            conn = SQLUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            pstmt.setString(2, userPwd);
            rSet = pstmt.executeQuery();

            if (rSet.next()) {
                result = new User();
                result.setId(rSet.getInt(1));
                result.setPassword(userPwd);
                result.setName(userName);
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
    public User find(String userName) {
        User result = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rSet = null;
        try {
            String sql = "select * from user_ where user_name = ?";
            conn = SQLUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            rSet = pstmt.executeQuery();

            if (rSet.next()) {
                result = new User();
                result.setId(rSet.getInt(1));
                result.setPassword(rSet.getString(3));
                result.setName(userName);
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
    public static void main(String[] args) {


        Timestamp currTime = new Timestamp(System.currentTimeMillis());
        User newUser = new User();
        newUser.setName(currTime.toString());
        newUser.setPassword(currTime.toString());
        newUser.setEmail(currTime.toString() + "@xxx.com");


        new UserDAO().add(newUser);

        //        User user = new UserDAO().find("zhangsan", "123456");
        User user = new UserDAO().find(currTime.toString());
        if (user != null) System.out.println("[userId: " + user.getId() + "], [userName:  " + user.getName() + "], [userPwd: " + user.getPassword() + "], [userEamil: " + user.getEmail() + "]. ");
        else System.out.println("fail.");


    }
}
