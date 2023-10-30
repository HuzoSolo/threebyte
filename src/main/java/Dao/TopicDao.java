/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author artun
 */
import Models.Topic;

public interface TopicDao {

    void addTopic(Topic topic);

    Topic getTopic(int id);

    void updateTopic(Topic topic);

    void deleteTopic(int id);
}
