/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SessionAndCookie;

import java.time.Instant;
import java.util.ArrayList;

/**
 *
 * @author muhuz
 */
public class UseBeanSession {

    long currentTimeMillis;

    int id;
    String name;
    String role;
    ArrayList<String> Sessions = new ArrayList<String>();
    
    public UseBeanSession() {
        
        Instant now = Instant.now();
        currentTimeMillis = now.toEpochMilli();

    }

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

    public void setId(int id) {
        this.id = id;
    }
    
    public void setRole(String role) {
        this.role = role;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public void addToSessions(String session) {
        this.Sessions.add(session);
        
    }
    
    public long showAge(){
        return currentTimeMillis;
    }

}
