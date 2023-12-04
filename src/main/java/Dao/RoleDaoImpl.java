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
import java.sql.*;

public class RoleDaoImpl implements RoleDao {

    @Override
    public void addRole(Role role) {
        if (role.getCheckRoleName()) {
            String sql = "INSERT INTO roles (role_name) VALUES (?)";
            Connection con = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");

                con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, role.getRoleName());
                ps.executeUpdate();
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
        } else {
            System.out.println("ROL ADI HATASI");
        }
    }

    @Override
    public boolean updateRole(Role role) {
        if (role.getCheckRoleName()) {
            String sql = "UPDATE roles SET role_name = ? WHERE id = ?";
            Connection con = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");

                con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, role.getRoleName());
                ps.setInt(2, role.getId());
                ps.executeUpdate();
                return true;
            } catch (Exception e) {
                System.out.println(e);
                return false;
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
        } else {
            System.out.println("ROL ADI HATASI");
            return false;
        }
    }

    @Override
    public void deleteRole(int roleId) {
        String sql = "DELETE FROM roles WHERE id = ?";
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, roleId);
            ps.executeUpdate();
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

    @Override
    public Role getRole(int roleId) {
        Role role = null;
        String sql = "SELECT * FROM roles WHERE id = ?";
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, roleId);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String roleName = resultSet.getString("role_name");
                    Role gettedRole = new Role();
                    gettedRole.setRoleName(roleName);
                    gettedRole.setId(id);
                    return gettedRole;
                }
            }
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
        return role;
    }
}
