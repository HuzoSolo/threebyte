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
import java.sql.*;
import java.util.ArrayList;

public class TopicDaoImp implements TopicDao {

    @Override
    public void addTopic(Topic topic) {
       if(topic.getCheckContent() && topic.getCheckTitle()){
           
       
       Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            String sql = "INSERT INTO topics ( category_id, user_id, title, content, is_pinned, is_locked) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, topic.getCategoryId());
            ps.setInt(2, topic.getUserId());
            ps.setString(3, topic.getTitle());
            ps.setString(4, topic.getContent());
            ps.setBoolean(5, topic.getPinned());
            ps.setBoolean(6, topic.getLocked());
            
            ps.executeUpdate();

        } catch (Exception e){ System.out.println(e);}
        finally {
            // Bağlantıyı kapat
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e){ System.out.println(e);}
        }
        }else{
           System.out.println("CONTENT VEYA TITLE HATALI GIRILDI");
       }

    }

    @Override
    public Topic getTopic(int id) {
        
        Topic topic = null;

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            String sql = "SELECT * FROM topics WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                topic = new Topic();
                topic.setId(rs.getInt("id"));
                topic.setCategoryId(rs.getInt("category_id"));
                topic.setUserId(rs.getInt("user_id"));
                topic.setTitle(rs.getString("title"));
                topic.setContent(rs.getString("content"));
                topic.setCreatedAt(rs.getTimestamp("createdAt"));
                topic.setUpdatedAt(rs.getTimestamp("updatedAt"));
                topic.setLocked(rs.getBoolean("is_locked"));
                topic.setPinned(rs.getBoolean("is_pinned"));
            }

        } catch (Exception e){ System.out.println(e);}
        finally {
            // Bağlantıyı kapat
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e){ System.out.println(e);}
        }

        return topic;
    }
    
    @Override
    public ArrayList<Models.Topic> getAllTopics() {
        
        Topic topic = null;
        ArrayList<Models.Topic> all_topics = new ArrayList();
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            String sql = "SELECT * FROM topics";
            PreparedStatement ps = con.prepareStatement(sql);
            

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                topic = new Topic();
                topic.setId(rs.getInt("id"));
                topic.setCategoryId(rs.getInt("category_id"));
                topic.setUserId(rs.getInt("user_id"));
                topic.setTitle(rs.getString("title"));
                topic.setContent(rs.getString("content"));
                topic.setCreatedAt(rs.getTimestamp("createdAt"));
                topic.setUpdatedAt(rs.getTimestamp("updatedAt"));
                topic.setLocked(rs.getBoolean("is_locked"));
                topic.setPinned(rs.getBoolean("is_pinned"));
                all_topics.add(topic);
            }

        } catch (Exception e){ System.out.println(e);}
        finally {
            // Bağlantıyı kapat
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e){ System.out.println(e);}
        }

        return all_topics;
    }

    @Override
    public boolean updateTopicTitle(Topic topic) {
        if(topic.getCheckContent() && topic.getCheckTitle()){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            String sql = "UPDATE topics SET title = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, topic.getTitle());
            ps.setInt(2, topic.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception e){ System.out.println(e); return false;}
        finally {
            // Bağlantıyı kapat
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e){ System.out.println(e);}
        }
        }else{
            System.out.println("CONTENT VEYA TITLE HATALI GIRILDI");
            return false;
        }
    }
    
    @Override
    public boolean updateTopicContent(Topic topic) {
         if(topic.getCheckContent() && topic.getCheckTitle()){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            String sql = "UPDATE topics SET content = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, topic.getContent());
            ps.setInt(2, topic.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception e){ System.out.println(e); return false;}
        finally {
            // Bağlantıyı kapat
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e){ System.out.println(e);}
        }
         }else{
            System.out.println("CONTENT VEYA TITLE HATALI GIRILDI");
            return false;
        }
    }

    @Override
    public void deleteTopic(int id) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            String sql = "DELETE FROM topics WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e){ System.out.println(e);}
        finally {
            // Bağlantıyı kapat
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e){ System.out.println(e);}
        }
    }

}
