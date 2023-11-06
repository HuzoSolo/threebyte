/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author sahin
 */


import Models.Comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoImpl implements CommentDao {
    private Connection con;

    public CommentDaoImpl() {

    }

    
    public void addComment(Comment comment) {
       
        String insertSql = "INSERT INTO comments (topic_id, user_id, content) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(insertSql)) {
            preparedStatement.setInt(1, comment.getTopicId());
            preparedStatement.setInt(2, comment.getUserId());
            preparedStatement.setString(3, comment.getContent());
            preparedStatement.executeUpdate();
            System.out.println("Yorum eklendi.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Yorum eklenirken bir hata oluştu.");
        }
    }

   
    public List<Comment> getCommentsByTopic(int topicId) {
        List<Comment> comments = new ArrayList<>();
        // Belirli bir konuya ait yorumları getirmek için SQL sorgusu oluşturun ve çalıştırın.
        String selectSql = "SELECT * FROM comments WHERE topic_id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(selectSql)) {
            preparedStatement.setInt(1, topicId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int userId = resultSet.getInt("user_id");
                    String content = resultSet.getString("content");
                    // Diğer alanları almak ve Comment nesnesini oluşturmak için buraya eklemeler yapabilirsiniz.
                    Comment comment = new Comment(id, topicId, userId, content, null, null, 0, 0);
                    comments.add(comment);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    // Diğer metotlar burada yer alır...

    @Override
    public void addTopic(Comment comment) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Comment getComment(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateComment(Comment comment) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteComment(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

