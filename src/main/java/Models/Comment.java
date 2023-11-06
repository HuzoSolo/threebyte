/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.PreparedStatement;
import java.sql.Timestamp;

/**
 *
 * @author sahin
 */
public class Comment {
    
    private int id;

    private int userId;

    private int topicId;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private int upVotes;

    private int downVotes;
    
    private String content;

    //constructor method with setters

    public Comment(int id1, int topicId1, int userId1, String content1, int par2) {
       //boş constructor
    }

    public Comment(int id, int topicId, int userId, String content, Object object, Object object0, int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public int getUserId(){
        return userId;
    }

    public int getTopicId(){
        return topicId;
    } 
    
    public String getContent(){
        return content;
    }

    public Timestamp getCreatedAt(){
        return createdAt;
    }

    public Timestamp getUpdatedAt(){
        return updatedAt;
    }

    public int getupVotes(){
        return upVotes;
    }

    public int getdownVotes(){
        return downVotes;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setContent(String content){
        this.content = content;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public void setTopicId(int topicId){
        this.topicId = topicId;
    }

    public void setCreatedAt(Timestamp createdAt){
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt){
        this.updatedAt = updatedAt;
    }

    public void setupVotes(int upVotes){
        this.upVotes = upVotes;
    }

    public void setdownVotes(int downVotes){
        this.downVotes = downVotes;
    }

    public PreparedStatement prepareStatement(String insertSql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
