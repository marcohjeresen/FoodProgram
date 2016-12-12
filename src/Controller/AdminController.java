/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.UserGroup;
import Model.Users;
import com.sun.corba.se.impl.orbutil.ORBConstants;
import com.sun.xml.internal.ws.encoding.soap.SOAPConstants;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author markh
 */
public class AdminController {

    private static AdminController adminController;
    private Database db;

    private AdminController() throws ClassNotFoundException, SQLException {
        db = new Database();
    }

    public static AdminController getInstance() {
        if (adminController == null) {
            try {
                adminController = new AdminController();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return adminController;
    }

    public ArrayList<UserGroup> getAllUserGroup() {
        ArrayList<UserGroup> groupList = new ArrayList<>();
        try {
            ResultSet rs = db.query("call getallusergroups();");
            while (rs.next()){
                UserGroup group = new UserGroup(rs.getInt("ugr_id"), rs.getString("ugr_type"));
                groupList.add(group);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return groupList;
    }
    
    public ArrayList<Users> getAllUsers(){
        ArrayList<Users> userList = new ArrayList<>();
        try {
            ResultSet rs = db.query("call getallusers();");
            while (rs.next()){
                UserGroup group = new UserGroup(rs.getInt("ugr_id"), rs.getString("ugr_type"));
                Users user = new Users(rs.getInt("use_id"), rs.getString("use_username"), rs.getInt("use_password"), rs.getString("use_name"), group, rs.getBoolean("use_languageenglish"));
                userList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userList;
    }
}
