/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

/**
 *
 * @author sahin
 */

import Models.UserRole;
import java.util.ArrayList;

public interface UserRoleDao {
    void addUserRole(UserRole userRole);
    
    void removeUserRole(int userId, int roleId);
    
    ArrayList<UserRole> getUserRolesByUserId(int userId);
    
  
    
}
