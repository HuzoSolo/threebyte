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
import java.util.ArrayList;

public interface TopicDao {

    void addTopic(Topic topic);

    Topic getTopic(int id);
    ArrayList<Models.Topic> getAllTopics();

    boolean updateTopicTitle(Topic topic);
    
    boolean updateTopicContent(Topic topic);

    void deleteTopic(int id);
}
