/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SessionAndCookie;

import java.time.Instant;
<<<<<<< Updated upstream
import java.util.ArrayList;
=======
import Models.User;
import java.sql.Timestamp;
>>>>>>> Stashed changes

/**
 *
 * @author muhuz
 */
public class UseBeanSession {

<<<<<<< Updated upstream
=======
    User newUser = new User("", "", "");

    private int id;

    private String username;

    private String email;

    private String password;

    private String profilePicture;

    private User.Rank rank;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private float reputation;

    private Timestamp lastLogin;

>>>>>>> Stashed changes
    long currentTimeMillis;

    int id;
    String name;
    String role;
    ArrayList<String> Sessions = new ArrayList<String>();
    
    public UseBeanSession() {

        Instant now = Instant.now();
        currentTimeMillis = now.toEpochMilli();

    }

<<<<<<< Updated upstream
    public int getId() {
        return id;
    }
    
    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getSessions() {
        return Sessions;
    }
=======
    //getter and setter methods
    public int getId() {
        return id;
    }
>>>>>>> Stashed changes

    public void setId(int id) {
        this.id = id;
    }
<<<<<<< Updated upstream
    
    public void setRole(String role) {
        this.role = role;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public void addToSessions(String session) {
        this.Sessions.add(session);
        
=======

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public User.Rank getRank() {
        return rank;
    }

    public void setRank(User.Rank rank) {
        this.rank = rank;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public float getReputation() {
        return reputation;
    }

    public void setReputation(float reputation) {
        this.reputation = reputation;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    //end of getter and setters
    public User getUser() {
        return this.newUser;
>>>>>>> Stashed changes
    }

    public long showAge() {
        return currentTimeMillis;
    }

}
