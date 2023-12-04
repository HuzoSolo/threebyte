/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Models.Role;



/**
 *
 * @author sahin
 */
public interface RoleDao {
    
    public void addRole(Role role);
    
    public boolean updateRole(Role role);
    
    public void deleteRole(int roleId);

    public Role getRole(int roleId);
    
}
