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
           
            String sql = "INSERT INTO users( username, email, password, profilePicture, `rank`, reputation) VALUES( ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getProfilePicture());
            ps.setString(5, user.getRank().name());
            
            ps.setFloat(6, user.getReputation());
            
            
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
    public User getUserbyId(int id) {
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
    public User getUserbyName(String userName) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt("id");
                
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
                gettedUser.setId(id);
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
                    System.out.println("connection KAPANDI!");
                }
            } catch (Exception e){ System.out.println(e);}
            finally {
                System.out.println("OKOKOKOKOK");
            }
        }

        return null;
    }

   
    
    @Override
    public boolean updatePassword(int id, String oldPassword, String newPassword){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Veritabanına bağlan
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            String selectSql = "SELECT password FROM users WHERE id = ?";
            // SQL sorgusu
            String sql = "UPDATE users SET password=?, updatedAt=? WHERE id=?";
            
            Hash h = new Hash();
            // Prepared statement oluştur
            PreparedStatement ps = con.prepareStatement(selectSql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String realOldPassword = rs.getString("password");
                String md5OldPassword = h.md5(oldPassword);
                if(md5OldPassword.equals(realOldPassword)){
                    
                    PreparedStatement ps2 = con.prepareStatement(sql);
                    ps2.setString(1, h.md5(newPassword));
                    java.sql.Timestamp now = new java.sql.Timestamp(new java.util.Date().getTime());
                    ps2.setTimestamp(2, now);
                    ps2.setInt(3, id);
                    ps2.executeUpdate();
                    return true;
                }
            }
            
            
            return false;
        } catch (Exception e){ System.out.println(e); return false;} 
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
    public boolean updateEmail(int id, String newEmail){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Veritabanına bağlan
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            
            // SQL sorgusu
            String sql = "UPDATE users SET email=?, updatedAt=? WHERE id=?";
            
            
            // Prepared statement oluştur
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, newEmail);
            java.sql.Timestamp now = new java.sql.Timestamp(new java.util.Date().getTime());
            ps.setTimestamp(2, now);
            ps.setInt(3, id);
            
            ps.executeQuery();

            return true;
        } catch (Exception e){ System.out.println(e); return false;} 
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
    public boolean updateProfilPicture(int id, String newProfilPicture){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Veritabanına bağlan
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            
            // SQL sorgusu
            String sql = "UPDATE users SET profilPicture=?, updatedAt=? WHERE id=?";
            
            
            // Prepared statement oluştur
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, newProfilPicture);
            java.sql.Timestamp now = new java.sql.Timestamp(new java.util.Date().getTime());
            ps.setTimestamp(2, now);
            ps.setInt(3, id);
            ps.executeQuery();
            return true;
            
        } catch (Exception e){ System.out.println(e);return false;} 
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
    public boolean updateRank(int id, Models.User.Rank newRank){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Veritabanına bağlan
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            
            // SQL sorgusu
            String sql = "UPDATE users SET `rank`=?, updatedAt=? WHERE id=?";
            
            
            // Prepared statement oluştur
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, newRank.name());
            java.sql.Timestamp now = new java.sql.Timestamp(new java.util.Date().getTime());
            ps.setTimestamp(2, now);
            ps.setInt(3, id);
            ps.executeQuery();

            return true;
        } catch (Exception e){ System.out.println(e);return false;} 
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
            Class.forName("com.mysql.jdbc.Driver");
            // Veritabanına bağlan
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            
            // SQL sorgusu
            String sql = "DELETE FROM users WHERE id=?";
            
            // Prepared statement oluştur
            PreparedStatement ps = con.prepareStatement(sql);
            
            // Parametreleri yerine yerleştir
            ps.setInt(1, id);
            
            // SQL sorgusunu çalıştır
            ps.executeQuery();
            
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // Bağlantıyı kapat
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
     
    }

}
