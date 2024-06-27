/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dal.DBContext;
import java.sql.*;
import java.util.ArrayList;
import model.Users;

/**
 *
 * @author Admin
 */
public class UserDao extends DBContext {

    public UserDao() {
        connectDB();
    }
    Connection cnn;// Kết nối DB
    PreparedStatement stm; // Thực hiện các câu lệnh sql
    ResultSet rs; // lưu kết quả truy vấn

    private void connectDB() {
        cnn = connection;
        if (cnn != null) {
            System.out.println("Connect success");
        } else {
            System.out.println("Not success");
        }
    }

    public boolean checkUser(String name, String password) {
        try {
            String strsql = "select * from Users where name=? and pass = ?";
            stm = cnn.prepareStatement(strsql);
            stm.setString(1, name);
            stm.setString(2, password);
            rs = stm.executeQuery();
            while (rs.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(" checkUser:" + e.getMessage());
        }
        return false;
    }

    // check account tồn tại hay chưa
    public boolean checkAccountExistedByEmail(String email) {
        try {
            String sql = "SELECT * FROM Users WHERE  email = ?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, email);
            rs = stm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public void addUser(String name, String pass, String email) {

        String sql = "INSERT INTO Users VALUES(?,?,?)";
        try {
            stm = cnn.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, pass);
            stm.setString(3, email);

            stm.execute();
        } catch (Exception e) {
        }
    }

    public boolean checkAccountExistedByName(String name) {
        try {
            String sql = "SELECT * FROM Users WHERE name = ? ";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, name);
            rs = stm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public String getEmail(String name) {
        try {
            String strsql = "SELECT email FROM Users WHERE name = ?";
            stm = cnn.prepareStatement(strsql);
            stm.setString(1, name);

            rs = stm.executeQuery();
            while (rs.next()) {

                return rs.getString("email");
            }

        } catch (Exception e) {
            System.out.println(" checkUser:" + e.getMessage());
        }
        return "";
    }

    public void insertRS(String name, String correctAnswers, String made) {

        String sql = "INSERT INTO result VALUES(?,?,?)";
        try {
            stm = cnn.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, correctAnswers);
            stm.setString(3, made);
            
            stm.execute();
        } catch (Exception e) {
        }
    }

    public ArrayList<Users> getResultByName(String name) {
        ArrayList<Users> userList = new ArrayList<>();

        try {
            String strsql = "SELECT Users.name, Users.email, result.ketqua, result.de "
                    + "FROM Users "
                    + "LEFT JOIN result ON Users.name = result.name "
                    + "WHERE Users.name = ?"
                    + " order by ketqua desc ";
            stm = cnn.prepareStatement(strsql);
            stm.setString(1, name);
            rs = stm.executeQuery();

            while (rs.next()) {
                Users user = new Users();
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setKetqua(rs.getString("ketqua"));
                user.setDe(rs.getString("de"));
                userList.add(user);
            }
        } catch (Exception e) {
            System.out.println("getResultByName: " + e.getMessage());
        }

        return userList;
    }

    public void deleteUser(String name) {
        try {
            String strsql = "delete from Users where name = ?";

            stm = cnn.prepareStatement(strsql);

            stm.setString(1, name);

            rs = stm.executeQuery();
            while (rs.next()) {

            }

        } catch (Exception e) {
            System.out.println(" checkUser:" + e.getMessage());
        }

    }

    public void deteteResult(String name) {
         try {
            String strsql = "delete from Result where name = ?";

            stm = cnn.prepareStatement(strsql);

            stm.setString(1, name);

            rs = stm.executeQuery();
            while (rs.next()) {

            }

        } catch (Exception e) {
            System.out.println(" checkUser:" + e.getMessage());
        }
    }

}
