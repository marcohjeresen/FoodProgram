/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handler;

import Controller.AdminController;
import Model.UserGroup;
import Model.Users;
import java.util.ArrayList;

/**
 *
 * @author markh
 */
public class AdminHandler {
    
    private static AdminHandler adminHandler;
    private AdminController adminController;
    private boolean adminLogon;
    private Users selectedUser;
    
    
    private AdminHandler(){
        adminController = AdminController.getInstance();
        adminLogon = false;
        selectedUser = null;
    }
    
    public static AdminHandler getInstance(){
        if (adminHandler == null) {
            adminHandler = new AdminHandler();
        }
        return adminHandler;
    }
    
    public void adminLogout(){
        adminLogon = false;
    }
    
    public void checkAdminLogon(Users users){
        if (users.getUserGroup().getGroupId() == 1) {
            adminLogon = true;
        } else {
            adminLogon = false;
        }
    }
    
    public ArrayList<UserGroup> getAllUsergroups(){
        return adminController.getAllUserGroup();
    }
    
    public ArrayList<Users> getAllUsers(){
        return adminController.getAllUsers();
    }

    public boolean isAdminLogon() {
        return adminLogon;
    }
    
    public void setSelectedUser(Users users){
        selectedUser = users;
    }
    
    public Users getSelectedUser(){
        return selectedUser;
    }
    
}
