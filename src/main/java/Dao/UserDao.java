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

public interface UserDao {
    void addUser(User user);
    User getUserbyId(int id);
    User getUserbyName(String username);
   
    boolean updatePassword(int id, String oldPassword, String newPassword);
    boolean updateEmail(int id, String newEmail);
    boolean updateProfilPicture(int id, String newProfilPicture);
    boolean updateRank(int id, User.Rank rank);
    void deleteUser(int id);
}
