package com.freedev.dailyquest.users;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


// This file is where the DB queries are implemented
// Convert to Functional Programming
public class UsersDAO {
    
    public UsersDAO(){};
    // CREATE METHOD
    public static boolean addOneToDB(User user) throws SQLException {
        Connection connection = connectToDB();
        PreparedStatement prst = null;
        Boolean result = null;
        try {
            if(connection != null) {
                String query = "INSERT INTO users_tbl(user_email, user_name, user_password, user_address, user_contact) VALUES(?,?,?,?,?)";
                prst = connection.prepareStatement(query);
                prst.setString(1, user.getUserEmail());
                prst.setString(2, user.getUserName());
                prst.setString(3, encryptPassword(user.getUserPassword()));
                prst.setString(4, user.getUserAddress());
                prst.setString(5, user.getUserPhoneNumber());
                
               
                result = prst.execute();
                System.out.println("Record saved in database");
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
    // GET ONE RECORD METHOD
    public static User fetchOneToDB(String email, String password) throws SQLException{
        Connection conn = connectToDB();
        PreparedStatement prst = null;
        try {
            String query = "SELECT * FROM users_tbl WHERE user_email = '"+email+"' && user_password = '"+encryptPassword(password)+"'";
            prst = conn.prepareStatement(query);
            ResultSet rs = prst.executeQuery();
            User LoggedUser = new User();
            if(rs.next()){
                LoggedUser.setUserID(rs.getInt("user_id"));
                LoggedUser.setUserEmail(rs.getString("user_email"));
                LoggedUser.setUserName(rs.getString("user_name"));
                LoggedUser.setUserAddress(rs.getString("user_address"));
                LoggedUser.setUserPhoneNumber(rs.getString("user_contact"));
                LoggedUser.setUserStatus(rs.getString("user_status"));
            }
            return LoggedUser;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User getOneUserFromDB(Object object) throws Exception {
        User user = null;
        Connection conn = connectToDB();
        String sql = "SELECT * FROM users_tbl WHERE user_id = '"+object+"'";
        try {
            PreparedStatement prst = conn.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();

            if(rs.next()){
                user = new User();
                user.setUserID(rs.getInt("user_id"));
                user.setUserEmail(rs.getString("user_email"));
                user.setUserName(rs.getString("user_name"));
                user.setUserAddress(rs.getString("user_address"));
                user.setUserPhoneNumber(rs.getString("user_contact"));
                user.setUserPassword(rs.getString("user_password"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static boolean editUser(User user) throws Exception {
        boolean result = false;
        Connection conn = connectToDB();
        String sql = "UPDATE users_tbl SET user_email = ?, user_name = ?, user_address = ?, user_contact = ?, user_password = ?, updatedAt = ? WHERE user_email = '"+user.getUserEmail()+"'";
        try {
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setString(1, user.getUserEmail());
            prst.setString(2, user.getUserName());
            prst.setString(3, user.getUserAddress());
            prst.setString(4, user.getUserPhoneNumber());
            prst.setString(5, encryptPassword(user.getUserPassword()));
            prst.setDate(6, Date.valueOf(LocalDate.now()));
            result = prst.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public static boolean editUserWithHidden(User user, String hidden) throws Exception {
        boolean result = false;
        Connection conn = connectToDB();
        String sql = "UPDATE users_tbl SET user_email = ?, user_name = ?, user_address = ?, user_contact = ?, user_password = ?, updatedAt = ? WHERE user_email = '"+user.getUserEmail()+"'";
        try {
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setString(1, user.getUserEmail());
            prst.setString(2, user.getUserName());
            prst.setString(3, user.getUserAddress());
            prst.setString(4, user.getUserPhoneNumber());
            prst.setString(5, hidden);
            prst.setDate(6, Date.valueOf(LocalDate.now()));
            result = prst.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
    
    public static Connection connectToDB() throws SQLException{
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/dailyquestdb?useTimezone=true&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");
           conn = DriverManager.getConnection(url, "root", "password123");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    private static String encryptPassword(String plainPass) throws NoSuchAlgorithmException {
        String hashed_pass = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(plainPass.getBytes(StandardCharsets.UTF_8));
            StringBuilder build = new StringBuilder();
            
            for(int i = 0; i < hash.length; i++){
                build.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
            }

            hashed_pass = build.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hashed_pass;
    }
   
    public static List<User> getAllUsers() throws Exception {
        List<User> users = null;
        Connection conn = connectToDB();
        String sql = "SELECT * From users_tbl";
        try {
            users = new ArrayList<>();
            PreparedStatement prst = conn.prepareStatement(sql);            
            ResultSet rs = prst.executeQuery();

            while(rs.next()){
                User user = new User();

                user.setUserID(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserEmail(rs.getString("user_email"));
                user.setUserAddress(rs.getString("user_address"));
                user.setUserPhoneNumber(rs.getString("user_contact"));
                users.add(user);
            };
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return users;
    }
}
