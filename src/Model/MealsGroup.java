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
public class MealsGroup {

    private int groupId;
    private String groupEnglishType;
    private String groupDanishType;

    public MealsGroup(int groupId, String groupEnglish, String groupDanish) {
        this.groupId = groupId;
        this.groupEnglishType = groupEnglish;
        this.groupDanishType = groupDanish;
    }

    public String getGroupDanishType() {
        return groupDanishType;
    }

    public void setGroupDanishType(String groupDanishType) {
        this.groupDanishType = groupDanishType;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupEnglishType() {
        return groupEnglishType;
    }

    public void setGroupEnglishType(String groupEnglishType) {
        this.groupEnglishType = groupEnglishType;
    }

}
