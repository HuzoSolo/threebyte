/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author sahin
 */

import Models.UserRole;
import java.sql.*;
import java.util.ArrayList;


public class UserRoleDaoImpl implements UserRoleDao {
    

    @Override
    public void addUserRole(UserRole userRole) {
        // Kullanıcıya rol eklemek için SQL sorgusu oluşturun ve çalıştırın.
        String sql = "INSERT INTO user_roles (user_id, role_id) VALUES (?, ?)";
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            System.out.println("addUserRole Connection açıldı");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userRole.getUserId());
            ps.setInt(2, userRole.getRoleId());
            ps.executeUpdate();
        } catch (Exception e){ System.out.println(e);}
        finally {
            // Bağlantıyı kapat
            try {
                if (con != null) {
                    con.close();
                    System.out.println("addUserRole Connection Kapandı");
                }
            } catch (Exception e){ System.out.println(e);}
        }
    }

    @Override
    public void removeUserRole(int userId, int roleId) {
        // Kullanıcıdan rolü kaldırmak için SQL sorgusu oluşturun ve çalıştırın.
        String sql = "DELETE FROM user_roles WHERE user_id = ? AND role_id = ?";
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            System.out.println("removeUserRole Connection açıldı");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, roleId);
            ps.executeUpdate();
        } catch (Exception e){ System.out.println(e);}
        finally {
            // Bağlantıyı kapat
            try {
                if (con != null) {
                    con.close();
                    System.out.println("removeUserRole Connection Kapandı");
                }
            } catch (Exception e){ System.out.println(e);}
        }
    }

   

    @Override
    public ArrayList<UserRole> getUserRolesByUserId(int userId) {
        ArrayList<UserRole> userRoles = new ArrayList();
        // Belirli bir rolün sahip olduğu kullanıcıları getirmek için SQL sorgusu oluşturun ve çalıştırın.
        String sql = "SELECT * FROM user_roles WHERE user_id = ?";
       Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            System.out.println("getUserRolesByUserId Connection açıldı");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int roleId = rs.getInt("role_id");
                UserRole userRole = new UserRole(userId, roleId);
                userRoles.add(userRole);
                    
            }
            
        } catch (Exception e){ System.out.println(e);}
        finally {
            // Bağlantıyı kapat
            try {
                if (con != null) {
                    con.close();
                    System.out.println("getUserRolesByUserId Connection Kapandı");
                }
            } catch (Exception e){ System.out.println(e);}
        }
        return userRoles;
    }
}
