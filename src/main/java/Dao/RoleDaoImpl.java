/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author sahin
 */
import Models.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class RoleDaoImpl implements RoleDao {
     Connection con;

    public RoleDaoImpl() {
       
    }

   
    public void addRole(Role role) {
        String insertSql = "INSERT INTO roles (role_name) VALUES (?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(insertSql)) {
            preparedStatement.setString(1, role.getRoleName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    public void updateRole(Role role) {
        String updateSql = "UPDATE roles SET role_name = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(updateSql)) {
            preparedStatement.setString(1, role.getRoleName());
            preparedStatement.setInt(2, role.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    public void deleteRole(int roleId) {
        String deleteSql = "DELETE FROM roles WHERE id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(deleteSql)) {
            preparedStatement.setInt(1, roleId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    public List<Role> getAllRole() {
        List<Role> roles = new ArrayList<>();
        String selectSql = "SELECT * FROM roles";
        try (PreparedStatement preparedStatement = con.prepareStatement(selectSql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String roleName = resultSet.getString("role_name");
                Role role = new Role(id, roleName);
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    public  Role getRoleId(int roleId) {
        Role role = null;
        String selectSql = "SELECT * FROM roles WHERE id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(selectSql)) {
            preparedStatement.setInt(1, roleId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String roleName = resultSet.getString("role_name");
                    role = new Role(id, roleName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public void addRole(javax.management.relation.Role role) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateRole(javax.management.relation.Role role) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
