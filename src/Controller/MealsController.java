/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.Meals;
import Model.MealsGroup;
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
public class MealsController {

    private static MealsController mealsController;
    private Database db;
    private Listeners listeners;
    private Meals meals;
    private ArrayList<Meals> mealList;

    private MealsController() throws ClassNotFoundException, SQLException {
        db = new Database();
        listeners = Listeners.getList();
        meals = null;
        mealList = new ArrayList<>();
    }

    public static MealsController getInstance() throws ClassNotFoundException, SQLException {
        if (mealsController == null) {
            mealsController = new MealsController();
        }
        return mealsController;
    }

    public ArrayList<Meals> getAllUserCreatedMeals(Users user) {
        ArrayList<Meals> usersMealList = new ArrayList<>();
        try {
            ResultSet rs = db.query("call getalluserscreatetmeals(" + user.getId() + ");");
            while (rs.next()) {
                MealsGroup group = new MealsGroup(rs.getInt("mgr_id"), rs.getString("mgr_englishtype"), rs.getString("mgr_danishtype"));
                Meals m = new Meals(rs.getInt("mea_number"), rs.getString("mea_englishname"), rs.getString("mea_danishname"), group, rs.getInt("mea_amountdays"), rs.getInt("mea_totalprice"), user);
                usersMealList.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MealsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usersMealList;
    }

    public ArrayList<Meals> getMealsByGroup(MealsGroup group) {
        ArrayList<Meals> MealByGroupList = new ArrayList<>();
        try {
            ResultSet rs = db.query("call getmealbygroup(" + group.getGroupId() + ");");
            while (rs.next()) {
                Meals m = new Meals(rs.getInt("mea_number"), rs.getString("mea_englishname"), rs.getString("mea_danishname"), group, rs.getInt("mea_amountdays"), rs.getInt("mea_totalprice"), null);
                MealByGroupList.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MealsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return MealByGroupList;
    }

    public ArrayList<MealsGroup> getAllGroups() {
        ArrayList<MealsGroup> allGroupList = new ArrayList<>();
        try {
            ResultSet rs = db.query("call getAllMealGroups();");
            while (rs.next()) {
                MealsGroup group = new MealsGroup(rs.getInt("mgr_id"), rs.getString("mgr_englishtype"), rs.getString("mgr_danishtype"));
                allGroupList.add(group);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MealsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allGroupList;
    }

    public ArrayList<Meals> getAllMeals() {
        ArrayList<Meals> allMealList = new ArrayList<>();
        try {
            ResultSet rs = db.query("call getallmeals();");
            while (rs.next()) {
                Meals m = new Meals(rs.getInt("mea_number"), rs.getString("mea_englishname"), rs.getString("mea_danishname"), null, rs.getInt("mea_amountdays"), rs.getInt("mea_totalprice"), null);
                allMealList.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MealsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allMealList;
    }

}
