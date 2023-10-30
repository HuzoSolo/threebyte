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
    User getUser(int id);
    void updateUser(User user);
    void deleteUser(int id);
}
