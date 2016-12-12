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
import javax.swing.plaf.DimensionUIResource;

/**
 *
 * @author markh
 */
public class MealsBottom extends javax.swing.JPanel {
    
    private Meals meals;
    private Listeners listeners;
    private MealsHandler mealsHandler;
    private Language language;

    /**
     * Creates new form MealsBottom
     */
    public MealsBottom(Meals meals) {
        this.meals = meals;
        listeners = Listeners.getList();
        try {
            mealsHandler = MealsHandler.getInstance();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MealsBottom.class.getName()).log(Level.SEVERE, null, ex);
        }
        language = Language.getInstance();
        initComponents();
        setSize(new Dimension(290, 40));
        jButton1.setText(meals.getName(language.getLanguage()));
    }
    
    public void addMeal(){
        mealsHandler.addSelectedMeal(meals);
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
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       addMeal();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
