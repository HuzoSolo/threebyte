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

public class UserDaoImp implements UserDao {

   
    @Override
    public void addUser(User user) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
           
            String sql = "INSERT INTO users(id, username, email, password, profilePicture, `rank`, createdAt, updatedAt, reputation, lastLogin) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, 123);
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getProfilePicture());
            ps.setString(6, user.getRank().name());
            java.sql.Timestamp now = new java.sql.Timestamp(new java.util.Date().getTime());
            ps.setTimestamp(7, now);
            ps.setTimestamp(8, now);
            ps.setFloat(9, user.getReputation());
            ps.setTimestamp(10, user.getLastLogin());
            
            ps.executeUpdate();
            
        } catch (Exception e){ System.out.println(e);}

    }

    @Override
    public User getUser(int id) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String username = rs.getString("username"); // 'username' sütunu için
        
                String email = rs.getString("email");  
        
                String password_md5 = rs.getString("password"); // 'password' sütunu için
              
                String profilePicture = rs.getString("profilePicture");
                
                String rank_str = rs.getString("rank");
                
                User.Rank rank = rank_str != null ? User.Rank.valueOf(rank_str) : User.Rank.BIT;
                java.sql.Timestamp createdAt = rs.getTimestamp("createdAt") != null ? rs.getTimestamp("createdAt") : new java.sql.Timestamp(new java.util.Date().getTime());
                java.sql.Timestamp updatedAt = rs.getTimestamp("updatedAt") != null ? rs.getTimestamp("updatedAt") : new java.sql.Timestamp(new java.util.Date().getTime());
                Float reputation = rs.getObject("reputation") != null ? rs.getFloat("reputation") : 0.0f;
                java.sql.Timestamp lastLogin = rs.getTimestamp("lastLogin") != null ? rs.getTimestamp("lastLogin") : new java.sql.Timestamp(new java.util.Date().getTime());
            
                
                User gettedUser = new User(username,email,password_md5);
                gettedUser.setCreatedAt(createdAt);
                gettedUser.setLastLogin(lastLogin);
                gettedUser.setProfilePicture(profilePicture);
                gettedUser.setRank(rank);
                gettedUser.setUpdatedAt(updatedAt);
                gettedUser.setReputation(reputation);
                
                return gettedUser;
            }
        } catch (Exception e){ System.out.println(e);} 
        finally {
            // Bağlantıyı kapat
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e){ System.out.println(e);}
        }

        return null;
    }

    @Override
    public void updateUser(User user) {
        Connection con = null;
        try {
             Class.forName("com.mysql.jdbc.Driver");
            // Veritabanına bağlan
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            
            // SQL sorgusu
            String sql = "UPDATE users SET username=?, email=?, password=? WHERE id=?";
            
            // Prepared statement oluştur
            PreparedStatement ps = con.prepareStatement(sql);
            
            // Parametreleri yerine yerleştir
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getId());
            
            // SQL sorgusunu çalıştır
            ps.executeUpdate();
            
        } catch (Exception e){ System.out.println(e);} 
        finally {
            // Bağlantıyı kapat
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e){ System.out.println(e);}
        }
    }
    

    @Override
    public void deleteUser(int id) {
        Connection con = null;
        try {
            // Veritabanına bağlan
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            
            // SQL sorgusu
            String sql = "DELETE FROM users WHERE id=?";
            
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
