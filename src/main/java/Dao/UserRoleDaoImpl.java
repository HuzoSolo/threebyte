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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRoleDaoImpl implements UserRoleDao {
    private Connection con;

    public UserRoleDaoImpl() {
     
    }

    @Override
    public void addUserRole(UserRole userRole) {
        // Kullanıcıya rol eklemek için SQL sorgusu oluşturun ve çalıştırın.
        String insertSql = "INSERT INTO user_roles (user_id, role_id) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(insertSql)) {
            preparedStatement.setInt(1, userRole.getUserId());
            preparedStatement.setInt(2, userRole.getRoleId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserRole(int userId, int roleId) {
        // Kullanıcıdan rolü kaldırmak için SQL sorgusu oluşturun ve çalıştırın.
        String deleteSql = "DELETE FROM user_roles WHERE user_id = ? AND role_id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(deleteSql)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, roleId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UserRole> getUserRolesByUserId(int userId) {
        List<UserRole> userRoles = new ArrayList<>();
        // Belirli bir kullanıcının rollerini getirmek için SQL sorgusu oluşturun ve çalıştırın.
        String selectSql = "SELECT * FROM user_roles WHERE user_id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(selectSql)) {
            preparedStatement.setInt(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int roleId = resultSet.getInt("role_id");
                    UserRole userRole = new UserRole(userId, roleId);
                    userRoles.add(userRole);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userRoles;
    }

    @Override
    public List<UserRole> getUserRolesByRoleId(int roleId) {
        List<UserRole> userRoles = new ArrayList<>();
        // Belirli bir rolün sahip olduğu kullanıcıları getirmek için SQL sorgusu oluşturun ve çalıştırın.
        String selectSql = "SELECT * FROM user_roles WHERE role_id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(selectSql)) {
            preparedStatement.setInt(1, roleId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int userId = resultSet.getInt("user_id");
                    UserRole userRole = new UserRole(userId, roleId);
                    userRoles.add(userRole);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userRoles;
    }
}
