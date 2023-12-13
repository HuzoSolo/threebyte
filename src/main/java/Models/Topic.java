package Models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author artun
 */

import java.sql.Timestamp;


public class Topic{

    private int id;

    private String title;

    private String content;

    private int userId;

    private int categoryId;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private boolean isLocked;

    private boolean isPinned;
    
    private boolean checkTitle;
    private boolean checkContent;
    //constructor method with setters

    public Topic() {
       //boş constructor
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent(){
        return content;
    }

    public int getUserId(){
        return userId;
    }

    public int getCategoryId(){
        return categoryId;
    }   

    public Timestamp getCreatedAt(){
        return createdAt;
    }

    public Timestamp getUpdatedAt(){
        return updatedAt;
    }

    public boolean getLocked(){
        return isLocked;
    }

    public boolean getPinned(){
        return isPinned;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setTitle(String title){
         if(title != null && !title.equals("")){
            title = title.replace("<","&lt;");
            this.title = title.replace(">", "&gt;");
            this.checkTitle = true;
        }
        else{
            this.checkTitle = false;
        }
    }

    public void setContent(String content){
        if(content != null && !content.equals("")){
            content = content.replace("<","&lt;");
            this.content = content.replace(">", "&gt;");
            
            this.checkContent = true;
        }
        else{
            this.checkContent = false;
        }
        
    }
    public boolean getCheckTitle(){
        return this.checkTitle;
    }
    public boolean getCheckContent(){
        return this.checkContent;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public void setCategoryId(int categoryId){
        this.categoryId = categoryId;
    }

    public void setCreatedAt(Timestamp createdAt){
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt){
        this.updatedAt = updatedAt;
    }

    public void setLocked(boolean isLocked){
        this.isLocked = isLocked;
    }

    public void setPinned(boolean isPinned){
        this.isPinned = isPinned;
    }


}
