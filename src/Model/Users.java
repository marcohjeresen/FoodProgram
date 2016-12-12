/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author markh
 */
public class Users {
    
    private int Id;
    private String username;
    private int password;
    private String name;
    private UserGroup userGroup;
    private boolean english;

    public Users(int Id, String username, int password, String name, UserGroup userGroup, boolean english) {
        this.Id = Id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.userGroup = userGroup;
        this.english = english;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public boolean isEnglish() {
        return english;
    }

    public void setEnglish(boolean english) {
        this.english = english;
    }
    
    
    
}
