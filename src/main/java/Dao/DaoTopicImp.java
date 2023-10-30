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

public class DaoTopicImp implements TopicDao {

    @Override
    public void addTopic(Topic topic) {

        Connection con = null;
        try {
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            String sql = "INSERT INTO Users(id, category_id, user_id, title, content, createdAt, updatedAt, is_pinned, is_locked) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, topic.getId());
            ps.setString(4, topic.getTitle());
            ps.setString(5, topic.getContent());
            ps.setInt(3, topic.getUserId());
            ps.setInt(2, topic.getCategoryId());
            ps.setTimestamp(6, topic.getCreatedAt());
            ps.setTimestamp(7, topic.getUpdatedAt());
            ps.setBoolean(9, topic.getLocked());
            ps.setBoolean(8, topic.getPinned());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Topic getTopic(int id) {
        Connection con = null;
        Topic topic = null;

        try {
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            String sql = "SELECT * FROM Users WHERE id = ?";
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

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return topic;
    }

    @Override
    public void updateTopic(Topic topic) {
        Connection con = null;

        try {
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            String sql = "UPDATE Users SET category_id = ?, user_id = ?, title = ?, content = ?, createdAt = ?, updatedAt = ?, is_pinned = ?, is_locked = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, topic.getCategoryId());
            ps.setInt(2, topic.getUserId());
            ps.setString(3, topic.getTitle());
            ps.setString(4, topic.getContent());
            ps.setTimestamp(5, topic.getCreatedAt());
            ps.setTimestamp(6, topic.getUpdatedAt());
            ps.setBoolean(7, topic.getPinned());
            ps.setBoolean(8, topic.getLocked());
            ps.setInt(9, topic.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTopic(int id) {
        Connection con = null;

        try {
            con = DriverManager.getConnection(sqlConfig.url, sqlConfig.user, sqlConfig.password);
            String sql = "DELETE FROM Users WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
