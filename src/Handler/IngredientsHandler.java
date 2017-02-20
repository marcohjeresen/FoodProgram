/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handler;

import Controller.IngredientsController;
import Model.Ingredients;
import Model.IngredientsGroup;
import UtilityStuff.Listeners;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author markh
 */
public class IngredientsHandler {
    
    private static IngredientsHandler ingredientsHandler;
    private IngredientsController ingredientsController;
    private Listeners listeners;
    private Language language;
    private IngredientsGroup selectedIngreGroup;
    private ArrayList<Ingredients> ingredientsList;
    private ArrayList<Ingredients> selectedIngreList;

    private IngredientsHandler() throws ClassNotFoundException, SQLException {
        this.ingredientsController = IngredientsController.getInstance();
        this.listeners = Listeners.getList();
        this.language = Language.getInstance();
        this.selectedIngreGroup = null;
        this.ingredientsList = new ArrayList<>();
        this.selectedIngreList = new ArrayList<>();
    }
    
    public static IngredientsHandler getInstance() throws ClassNotFoundException, SQLException{
        if (ingredientsHandler == null){
            ingredientsHandler = new IngredientsHandler();
        }
        return ingredientsHandler;
    }
    
    public ArrayList<IngredientsGroup> getIngredientsGroups(){
        return ingredientsController.getAllGroups(language.getLanguage());
    }
    
    public void setSelectedIngreGroup(IngredientsGroup ingredientsGroup){
        selectedIngreGroup = ingredientsGroup;
    }
    
    
    
}
