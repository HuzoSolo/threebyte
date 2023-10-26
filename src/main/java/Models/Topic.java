package Models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author artun
 */
import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "topics")
public class Topic{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)// title is required
    private String title;

    @Column(nullable = false) // content is required
    private String content;

    @Column(nullable = false) // user id is required and unique
    private int userId;

    @Column(nullable = false, unique = true)
    private int categoryId;

    @Column(nullable = false)
    private Timestamp createdAt;

    @Column(nullable = false)
    private Timestamp updatedAt;

    @Column(nullable = false)
    private boolean isClosed;

    @Column(nullable = false)
    private boolean isPinned;

    //constructor method with setters

    public Topic(int id, String title, String content, int userId, int categoryId, Timestamp createdAt, Timestamp updatedAt, boolean isClosed, boolean isPinned) {
        setId(id);
        setTitle(title);
        setContent(content);
        setUserId(userId);
        setCategoryId(categoryId);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        setClosed(isClosed);
        setPinned(isPinned);
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

    public boolean getClosed(){
        return isClosed;
    }

    public boolean getPinned(){
        return isPinned;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setContent(String content){
        this.content = content;
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

    public void setClosed(boolean isClosed){
        this.isClosed = isClosed;
    }

    public void setPinned(boolean isPinned){
        this.isPinned = isPinned;
    }


}
