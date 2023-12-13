/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author sahin
 */
public class Role {
    private int id;
    private String roleName;
    private boolean checkRoleName;
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }
    public boolean getCheckRoleName(){
        return checkRoleName;
    }
    public void setRoleName(String roleName) {
        if (roleName != null || !roleName.equals("")){
            this.roleName = roleName;
            checkRoleName = true;
        }
        else{
            checkRoleName = false;
        }
    }
}
