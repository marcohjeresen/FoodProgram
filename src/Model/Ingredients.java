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
public class Ingredients {
    
    private int Number;
    private String englishName;
    private String danishName;
    private IngredientsGroup ingredientsGroup;
    private int price;

    public Ingredients(int Number, String englishName, String danishName, IngredientsGroup ingredientsGroup, int price) {
        this.Number = Number;
        this.englishName = englishName;
        this.danishName = danishName;
        this.ingredientsGroup = ingredientsGroup;
        this.price = price;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public String getName(boolean english) {
        if (english) {
            return englishName;
        } else {
            return danishName;
        }
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }


    public void setDanishName(String danishName) {
        this.danishName = danishName;
    }

    public IngredientsGroup getIngredientsGroup() {
        return ingredientsGroup;
    }

    public void setIngredientsGroup(IngredientsGroup ingredientsGroup) {
        this.ingredientsGroup = ingredientsGroup;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    
    
    
}
