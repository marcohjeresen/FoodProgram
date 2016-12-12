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
public class IngredientsToMeals {
    
    private Ingredients ingredients;
    private Meals meals;
    private int ingredientsAmount;
    private int price;

    public IngredientsToMeals(Ingredients ingredients, Meals meals, int ingredientsAmount, int price) {
        this.ingredients = ingredients;
        this.meals = meals;
        this.ingredientsAmount = ingredientsAmount;
        this.price = price;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public Meals getMeals() {
        return meals;
    }

    public void setMeals(Meals meals) {
        this.meals = meals;
    }

    public int getIngredientsAmount() {
        return ingredientsAmount;
    }

    public void setIngredientsAmount(int ingredientsAmount) {
        this.ingredientsAmount = ingredientsAmount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    
}
