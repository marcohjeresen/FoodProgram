/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelsButtom;

import Handler.Language;
import Handler.MealsHandler;
import Model.Meals;
import UtilityStuff.Listeners;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author markh
 */
public class MealsMixBottom extends javax.swing.JPanel {
    private Meals meal;
    private MealsHandler mealsHandler;
    private Listeners listeners;
    private Language language;

    /**
     * Creates new form MealsMixBottom
     */
    public MealsMixBottom(Meals meal) {
        this.meal = meal;
        try {
            mealsHandler = MealsHandler.getInstance();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MealsMixBottom.class.getName()).log(Level.SEVERE, null, ex);
        }
        listeners = Listeners.getList();
        language = Language.getInstance();
        initComponents();
        setSize(new Dimension(270, 40));
        jButton1.setText(meal.getName(language.getLanguage()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jButton1.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
