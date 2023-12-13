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
import java.util.ArrayList;

public interface CommentDao {

    void addComment(Comment comment);

    Comment getComment(int id);

    boolean updateComment(Comment comment);

    void deleteComment(int id);

    ArrayList<Models.Comment> getAllCommentsByTopicId(int topic_id);

}
