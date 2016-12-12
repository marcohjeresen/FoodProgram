/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.UserGroup;
import Model.Users;
import UtilityStuff.Listeners;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author markh
 */
public class SystemController {

    private static SystemController systemController;
    private Database db;
    private Users user;
    private Listeners listeners;

    private SystemController() throws ClassNotFoundException, SQLException {
        db = new Database();
        listeners = Listeners.getList();
    }

    public static SystemController getInstance() throws ClassNotFoundException, SQLException {
        if (systemController == null) {
            systemController = new SystemController();
        }
        return systemController;
    }

    public Users getUser() {
        return user;
    }
    
    public void logoutUser(){
        user = null;
    }
    
    

    public Boolean logon(String username, int password) {
        try {
            ResultSet rs = db.query("Call logon('" + username + "'," + password + ");");
            while (rs.next()) {
                UserGroup ug = new UserGroup(rs.getInt("ugr_id"), rs.getString("ugr_type"));
                user = new Users(rs.getInt("use_id"), rs.getString("use_username"), rs.getInt("use_password"), rs.getString("use_name"), ug, rs.getBoolean("use_languageenglish"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SystemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user != null;
    }

    public Boolean createNewUser(String username, int password, String name, boolean languageenglish) {
        int userId = 0;
        UserGroup group = getFreeUserGroups();
        try {
            db.ændre("Call createnewuser('" + username + "'," + password + ",'" + name + "'," + group.getGroupId() + "," + languageenglish + ");");
            ResultSet rs = db.query("call getlatestuserid()");
            while (rs.next()){
                userId = rs.getInt("userid");
            }
            user = new Users(userId, username, password, name, group, languageenglish);
        } catch (SQLException ex) {
            Logger.getLogger(SystemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user != null;
    }

    public UserGroup getFreeUserGroups() {
        UserGroup group = null;
        try {
            ResultSet rs = db.query("call getusergroupnoadmin();");
            while (rs.next()) {
                group = new UserGroup(rs.getInt("ugr_id"), rs.getString("ugr_type"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SystemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return group;
    }
    
    public boolean checkUsername(String username){
        boolean usernameIsFree = true;
        try{
            ResultSet rs = db.query("call checkusername('"+username+"');");
            while (rs.next()){
                String usernameIsThere = rs.getString("use_username");
                usernameIsFree = false;
            }
        } catch (SQLException ex) {
            usernameIsFree = true;
        }
        return usernameIsFree;
    }

}
