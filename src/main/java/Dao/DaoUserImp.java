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

    private final String url = "jdbc:mysql://db-threebyte.cmgxydh1ctvr.eu-central-1.rds.amazonaws.com";
    private final String user = "root";
    private final String password = "1q2w3e4r";

    @Override
    public void addUser(User user) {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourDatabase", "username", "password");
            String sql = "INSERT INTO Users(id, username, email, password) VALUES(?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public User getUser(int id) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM Users WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"));
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
            con = DriverManager.getConnection("jdbc:mysql://threebyte.cmgxydh1ctvr.eu-central-1.rds.amazonaws.com", "username", "password");
            
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
            con = DriverManager.getConnection("jdbc:mysql://threebyte.cmgxydh1ctvr.eu-central-1.rds.amazonaws.com", "username", "password");
            
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
