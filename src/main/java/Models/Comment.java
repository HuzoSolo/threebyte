/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

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
    private boolean checkContent;
    //getters and setters
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getTopicId() {
        return topicId;
    }

    public String getContent() {
        return content;
    }
    public boolean getCheckContent(){
        return this.checkContent;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public int getupVotes() {
        return upVotes;
    }

    public int getdownVotes() {
        return downVotes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        if (content != null && !content.equals("")){
            content = content.replace("<","&lt;");
            this.content = content.replace(">", "&gt;");
            this.checkContent =  true;
        }
        else{
            this.checkContent =  false;
        }
        
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setupVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    public void setdownVotes(int downVotes) {
        this.downVotes = downVotes;
    }

}
