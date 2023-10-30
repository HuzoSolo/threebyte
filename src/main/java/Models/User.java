/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author artun
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

// create rank enum




public class User{
    
    public enum Rank {
    BIT,
    BYTE,
    KILOBYTE,
    MEGABYTE,
    GIGABYTE
    }
    
   
    private int id;
  
    private String username;

    private String email;

    private String password;
    
    private String profilePicture;

    private Rank rank;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private float reputation;

    private Timestamp lastLogin;


    public User(int id, String username, String email, String password) {
        setId(id);
        setUsername(username);
        setEmail(email);
        setPassword(password);
        
    }
    
    private String md5(String passwordToHash) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getProfilePicture() {
        return profilePicture;
    }
    public Rank getRank() {
        return rank;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
    public float getReputation() {
        return reputation;
    }
    public Timestamp getLastLogin() {
        return lastLogin;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = md5(password);
    }
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
    public void setRank(Rank rank) {
        this.rank = rank;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
    public void setReputation(float reputation) {
        this.reputation = reputation;
    }
    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }
    
}