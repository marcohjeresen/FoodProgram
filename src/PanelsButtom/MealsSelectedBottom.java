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
public class MealsSelectedBottom extends javax.swing.JPanel {
    
    private Meals meal;
    private MealsHandler mealsHandler;
    private Listeners listeners;
    private Language language;
    

    /**
     * Creates new form MealsSelectedBottom
     */
    public MealsSelectedBottom(Meals meal) {
        this.meal = meal;
        try {
            mealsHandler = MealsHandler.getInstance();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MealsSelectedBottom.class.getName()).log(Level.SEVERE, null, ex);
        }
        listeners = Listeners.getList();
        language = Language.getInstance();
        initComponents();
        setSize(new Dimension(280, 60));
        setText();
    }
    
    public void setText(){
        boolean isEnglish = language.getLanguage();
        jL_name.setText(meal.getName(isEnglish));
        if (isEnglish) {
            jL_days.setText("Days: "+meal.getDaysAmount());
            jL_price.setText("Price: "+(meal.getTotalPrice() / 100)+".-");
        } else {
            jL_days.setText("Dage: "+meal.getDaysAmount());
            jL_price.setText("Pris: "+(meal.getTotalPrice() / 100)+".-");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jL_name = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jL_days = new javax.swing.JLabel();
        jL_price = new javax.swing.JLabel();

        jL_name.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jL_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_name.setText("jLabel1");

        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jL_days.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jL_days.setText("Days: 12");

        jL_price.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jL_price.setText("Price: 200.-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jL_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jL_days, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jL_price, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 41, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jL_name, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_days)
                    .addComponent(jL_price)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jL_days;
    private javax.swing.JLabel jL_name;
    private javax.swing.JLabel jL_price;
    // End of variables declaration//GEN-END:variables
}
