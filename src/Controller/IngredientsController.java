/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.Ingredients;
import Model.IngredientsGroup;
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
public class IngredientsController {

    private static IngredientsController ingredientsController;
    private Database db;
    private Listeners listeners;
    private Ingredients ingredients;
    private IngredientsGroup ingredientsGroup;

    private IngredientsController() throws ClassNotFoundException, SQLException {
        db = new Database();
        listeners = Listeners.getList();
        ingredients = null;
        ingredientsGroup = null;
    }

    public static IngredientsController getInstance() throws ClassNotFoundException, SQLException {
        if (ingredientsController == null) {
            ingredientsController = new IngredientsController();
        }
        return ingredientsController;
    }

    public ArrayList<IngredientsGroup> getAllGroups(boolean englishLang) {
        ArrayList<IngredientsGroup> allGroupList = new ArrayList<>();
        try {
            ResultSet rs = db.query("call getallingredientsgroups("+englishLang+")");
            while (rs.next()) {
                ingredientsGroup = new IngredientsGroup(rs.getInt("igr_id"), rs.getString("igr_danishtype"), rs.getString("igr_englishtype"));
                allGroupList.add(ingredientsGroup);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngredientsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allGroupList;
    }

}
