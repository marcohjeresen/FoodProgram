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
public class IngredientsGroup {
    
    private int groupId;
    private String danishName;
    private String englishName;

    public IngredientsGroup(int groupId, String danishName, String englishName) {
        this.groupId = groupId;
        this.danishName = danishName;
        this.englishName = englishName;
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

    public void setDanishName(String danishName) {
        this.danishName = danishName;
    }


    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }
    
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

  
    
}
