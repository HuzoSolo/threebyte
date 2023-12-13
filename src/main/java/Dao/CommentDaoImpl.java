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
import java.sql.*;
import java.util.ArrayList;

public class CommentDaoImpl implements CommentDao {

    @Override
    public void addComment(Comment comment) {
        if(comment.getCheckContent()){

        String sql = "INSERT INTO comments (topic_id, user_id, content) VALUES (?, ?, ?)";
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, comment.getTopicId());
            ps.setInt(2, comment.getUserId());
            ps.setString(3, comment.getContent());
            ps.executeUpdate();
            System.out.println("Yorum eklendi.");
            
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // Bağlantıyı kapat
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        }
        else {
          System.out.println("CONTENT HATALI GELDI");
        }
    }

    @Override
    public Comment getComment(int id) {
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            String sql = "SELECT * FROM comments WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int topic_id = rs.getInt("topic_id");
                int user_id = rs.getInt("user_id");
                int upvotes = rs.getInt("upvotes");
                int downvotes = rs.getInt("downvotes");
                String content = (rs.getString("content") != null && !rs.getString("content").isEmpty()) ? rs.getString("content") : null;
                java.sql.Timestamp createdAt = rs.getTimestamp("createdAt") != null ? rs.getTimestamp("createdAt") : new java.sql.Timestamp(new java.util.Date().getTime());
                java.sql.Timestamp updatedAt = rs.getTimestamp("updatedAt") != null ? rs.getTimestamp("updatedAt") : new java.sql.Timestamp(new java.util.Date().getTime());
                Comment returnedComment = new Comment();
                returnedComment.setContent(content);
                returnedComment.setTopicId(topic_id);
                returnedComment.setUserId(user_id);
                returnedComment.setupVotes(upvotes);
                returnedComment.setdownVotes(downvotes);
                returnedComment.setCreatedAt(createdAt);
                returnedComment.setUpdatedAt(updatedAt);
                return returnedComment;
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return null;
    }
    
    @Override
    public ArrayList<Models.Comment> getAllCommentsByTopicId(int topicId){
        ArrayList<Models.Comment> comments = new ArrayList();
        Connection con = null;
         try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            String sql = "SELECT * FROM comments WHERE topic_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, topicId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Comment newComment = new Comment();
                newComment.setId(rs.getInt("id"));
                newComment.setTopicId(rs.getInt("topic_id"));
                newComment.setUserId(rs.getInt("user_id"));
                newComment.setContent(rs.getString("content"));
                newComment.setCreatedAt(rs.getTimestamp("createdAt"));
                newComment.setUpdatedAt(rs.getTimestamp("updatedAt"));
                newComment.setupVotes(rs.getInt("upvotes"));
                newComment.setdownVotes(rs.getInt("downvotes"));
                comments.add(newComment);
            }
         }catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
         return comments;
    }

    @Override
    public boolean updateComment(Comment comment) {
        if(comment.getCheckContent()){
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            String sql = "UPDATE comments SET content = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, comment.getContent());

            ps.setInt(2, comment.getId());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        }
        else{
            System.out.println("CONTENT HATASI");
            return false;
        }
    }

    @Override
    public void deleteComment(int id) {
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            String sql = "DELETE FROM comments WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
