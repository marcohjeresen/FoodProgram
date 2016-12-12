/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handler;

/**
 *
 * @author markh
 */
public class Language {
    
    private static Language language;
    
    private boolean english;

    private Language() {
        english = true;
    }
    
    public static Language getInstance(){
        if (language == null) {
            language = new Language();
        }
        return language;
    }
    
    public void setLanguage(boolean choosenLanguage){
        if (choosenLanguage) {
            english = true;
        } else {
            english = false;
        }
    }
    
    public boolean getLanguage(){
        return english;
    }
    
    
}
