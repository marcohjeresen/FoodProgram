/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handler;

import Controller.MealsController;
import Model.Meals;
import Model.MealsGroup;
import Model.Users;
import UtilityStuff.Listeners;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author markh
 */
public class MealsHandler {

    private static MealsHandler mealsHandler;
    private Listeners listeners;
    private Language language;
    private MealsController mealsController;
    private MealsGroup selectedMealGroups;
    private ArrayList<Meals> selectedMealsList;
    private ArrayList<Meals> selectedMealsLis;
    private int foundDays;

    private MealsHandler() throws ClassNotFoundException, SQLException {
        listeners = Listeners.getList();
        language = Language.getInstance();
        selectedMealsLis = new ArrayList();
        foundDays = 0;
        selectedMealGroups = null;
        selectedMealsList = new ArrayList<>();
        mealsController = MealsController.getInstance();
    }

    public static MealsHandler getInstance() throws ClassNotFoundException, SQLException {
        if (mealsHandler == null) {
            mealsHandler = new MealsHandler();
        }
        return mealsHandler;
    }

    public ArrayList<Meals> getUserCreatedMeals(Users users) {
        return mealsController.getAllUserCreatedMeals(users);
    }

    public ArrayList<MealsGroup> getAllMealGroups() {
        return mealsController.getAllGroups();
    }

    public void setSelectedMealGroups(MealsGroup mealsGroup) {
        selectedMealGroups = mealsGroup;
    }

    public ArrayList<Meals> getMealsByGroup() {
        return mealsController.getMealsByGroup(selectedMealGroups);
    }

    public void cleanSelectedMealList() {
        selectedMealsList.removeAll(selectedMealsList);
    }

    public void addSelectedMeal(Meals meals) {
        boolean isThere = false;
        for (int i = 0; i < selectedMealsList.size(); i++) {
            if (selectedMealsList.get(i).getName(language.getLanguage()).equals(meals.getName(language.getLanguage()))) {
                isThere = true;
            }
        }
        if (!isThere) {
            selectedMealsList.add(meals);
        }
        listeners.notifyListeners("Selected Meal Added");
    }

    public ArrayList<Meals> getSelectedMealList() {
        return selectedMealsList;
    }

    public int getSelectedMealsPrice() {
        int totalPrice = 0;

        for (Meals selectedMealsList1 : selectedMealsList) {
            totalPrice = totalPrice + selectedMealsList1.getTotalPrice();

        }
        totalPrice = totalPrice / 100;

        return totalPrice;
    }

    public int getSelectedMealsDays() {
        int amountOfDays = 0;
        for (Meals selectedMealsList1 : selectedMealsList) {
            amountOfDays = amountOfDays + selectedMealsList1.getDaysAmount();
        }
        return amountOfDays;
    }
    
    public int getMaxAmountOfDays(){
        int days = 0;
        for (Meals meal : mealsController.getAllMeals()) {
            days = days + meal.getDaysAmount();
        }
        return days;
    }

    public ArrayList<Meals> FindRandomMeals(int amountOfDays) {
        ArrayList<Meals> allMealList = mealsController.getAllMeals();

        boolean isThere = false;
        foundDays = 0;
        Random ran = new Random();
        Meals meal = null;
        while (foundDays < amountOfDays) {
            int ranNumber = ran.nextInt(allMealList.size());
            meal = allMealList.get(ranNumber);
            for (Meals mealList : selectedMealsLis) {
                if (mealList.getName(language.getLanguage()).equals(meal.getName(language.getLanguage()))) {
                    isThere = true;
                    allMealList.remove(ranNumber);
                }
            }
            if (!isThere) {
                addMealToRandom(meal);
                foundDays = foundDays + meal.getDaysAmount();
                allMealList.remove(ranNumber);
            } else {
                isThere = false;
            }

        }
        listeners.notifyListeners("Random Meals Founded");
        return selectedMealsLis;
    }
    
    public int getMixFoundDays(){
        return foundDays;
    }

    public void addMealToRandom(Meals meal) {
        boolean isThere = false;
        for (int i = 0; i < selectedMealsLis.size(); i++) {
            if (selectedMealsLis.get(i).getName(language.getLanguage()).equals(meal.getName(language.getLanguage()))) {
                isThere = true;
            }
        }
        if (!isThere) {
            selectedMealsLis.add(meal);
        }
    }

    public ArrayList<Meals> getFoundMeals() {
        return selectedMealsLis;
    }
    
    
    
    public void deleteMixMeals(){
        selectedMealsLis = new ArrayList<>();
        listeners.notifyListeners("Remove Mix Meals");
    }

}
