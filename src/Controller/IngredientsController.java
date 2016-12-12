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
import java.sql.SQLException;
import java.util.ArrayList;

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
    private ArrayList<Ingredients> ingredientsList;
    private ArrayList<IngredientsGroup> ingredientsGroupList;

    private IngredientsController() throws ClassNotFoundException, SQLException {
        db = new Database();
        listeners = Listeners.getList();
        ingredientsList = new ArrayList<>();
        ingredientsGroupList = new ArrayList<>();
    }
    
    public static IngredientsController getInstance() throws ClassNotFoundException, SQLException{
        if (ingredientsController == null) {
            ingredientsController = new IngredientsController();
        }
        return ingredientsController;
    }
    
    
    public void getAllIngredients(){
        
    }
    
    
}
