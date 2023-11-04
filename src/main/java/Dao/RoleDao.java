/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Models.Comment;
import java.util.List;
import javax.management.relation.Role;

/**
 *
 * @author sahin
 */
public interface RoleDao{
    void addRole(Role role);
    
    void updateRole(Role role);
    
    void deleteRole(int roleId);
    
    List<Role> getAllRoles();
    
    Role getRoleById(int roleId);
    
}
