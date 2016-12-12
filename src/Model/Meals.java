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
public class Meals {
    
    private int Number;
    private String englishName;
    private String danishName;
    private MealsGroup mealsGroup;
    private int daysAmount;
    private int totalPrice;
    private Users users;

    public Meals(int Number, String englishName, String danishName, MealsGroup mealsGroup, int daysAmount, int totalPrice, Users users) {
        this.Number = Number;
        this.englishName = englishName;
        this.danishName = danishName;
        this.mealsGroup = mealsGroup;
        this.daysAmount = daysAmount;
        this.totalPrice = totalPrice;
        this.users = users;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public String getName(boolean english) {
        if (english) {
            if (!englishName.equals("")) {
                return englishName;
            }else{
                return danishName;
            }
        }else {
            if (!danishName.equals("")) {
                return danishName;
            }else{
                return englishName;
            }
            
        }
        
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public void setDanishName(String danishName) {
        this.danishName = danishName;
    }

    public MealsGroup getMealsGroup() {
        return mealsGroup;
    }

    public void setMealsGroup(MealsGroup mealsGroup) {
        this.mealsGroup = mealsGroup;
    }

    public int getDaysAmount() {
        return daysAmount;
    }

    public void setDaysAmount(int daysAmount) {
        this.daysAmount = daysAmount;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    
    
}
