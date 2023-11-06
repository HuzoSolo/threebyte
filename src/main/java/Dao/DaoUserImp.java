/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author artun
 */
import Models.User;
import java.sql.*;

public class DaoUserImp implements UserDao {


    @Override
    public void addUser(User user) {
        Connection con = null;
        try {
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            String sql = "INSERT INTO Users(id, username, email, password) VALUES(?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }

    }

    @Override
    public User getUser(int id) {
        try {
            Connection con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            String sql = "SELECT * FROM Users WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            if (rs.next()) {
                User user = new User();
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateUser(User user) {
        Connection con = null;
        try {
            // Veritabanına bağlan
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            
            // SQL sorgusu
            String sql = "UPDATE Users SET username=?, email=?, password=? WHERE id=?";
            
            // Prepared statement oluştur
            PreparedStatement ps = con.prepareStatement(sql);
            
            // Parametreleri yerine yerleştir
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getId());
            
            // SQL sorgusunu çalıştır
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Bağlantıyı kapat
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    

    @Override
    public void deleteUser(int id) {
        Connection con = null;
        try {
            // Veritabanına bağlan
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            
            // SQL sorgusu
            String sql = "DELETE FROM Users WHERE id=?";
            
            // Prepared statement oluştur
            PreparedStatement ps = con.prepareStatement(sql);
            
            // Parametreleri yerine yerleştir
            ps.setInt(1, id);
            
            // SQL sorgusunu çalıştır
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Bağlantıyı kapat
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
     
    }

}
