/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

/**
 *
 * @author sahin
 */
import Models.Comment;

public interface CommentDao {
    
    void addTopic(Comment comment);

    Comment getComment(int id);

    void updateComment(Comment comment);

    void deleteComment(int id);
    
}
