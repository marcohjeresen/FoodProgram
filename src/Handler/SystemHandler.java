/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handler;

import Controller.SystemController;
import Model.UserGroup;
import Model.Users;
import java.sql.SQLException;

/**
 *
 * @author markh
 */
public class SystemHandler {
    
    private static SystemHandler systemHandler;
    private SystemController systemController;
    private AdminHandler adminHandler;
    private Users users;
    private Language language;

    private SystemHandler() throws ClassNotFoundException, SQLException {
        systemController = SystemController.getInstance();
        adminHandler = AdminHandler.getInstance();
        language = Language.getInstance();
    }
    
    public static SystemHandler getInstance() throws ClassNotFoundException, SQLException{
        if (systemHandler == null) {
            systemHandler = new SystemHandler();
        }
        return systemHandler;
    }
    
    public boolean logon(String username, int password){
        boolean logon = systemController.logon(username, password);
        if (logon) {
            language.setLanguage(systemController.getUser().isEnglish());
            users = systemController.getUser();
            
        }
        adminHandler.checkAdminLogon(users);
        return logon;
    }
    
    public void logout(){
        language.setLanguage(true);
        systemController.logoutUser();
        adminHandler.adminLogout();
    }
    
    public boolean createUser(String username, int password, String name, boolean languageenglish){
        boolean create = systemController.createNewUser(username, password, name, languageenglish);
        if (create) {
            language.setLanguage(systemController.getUser().isEnglish());
            users = systemController.getUser();
        }
        return create;
    }
    
    public boolean checkusername(String username){
        return systemController.checkUsername(username);
    }
    
    
    
    
    
}
