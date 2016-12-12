/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelsView;

import Handler.Language;
import Handler.MealsHandler;
import Model.Meals;
import Model.MealsGroup;
import PanelsButtom.MealsBottom;
import PanelsButtom.MealsMixBottom;
import PanelsButtom.MealsSelectedBottom;
import PanelsButtom.MealsTypeBottom;
import UtilityStuff.Listeners;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author markh
 */
public class MealsPlanView extends javax.swing.JPanel implements ActionListener {

    private MealsHandler mealsHandler;
    private Language language;
    private Listeners listeners;


    /**
     * Creates new form MealsPlanView
     */
    public MealsPlanView() {
        try {
            mealsHandler = MealsHandler.getInstance();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MealsPlanView.class.getName()).log(Level.SEVERE, null, ex);
        }
        listeners = Listeners.getList();
        language = Language.getInstance();
        initComponents();
        listeners.addListener(this);
        setSize(new Dimension(1195, 760));
        jSlider1.setMaximum(mealsHandler.getMaxAmountOfDays() -1);
        showAllGroups();
        setMixMealsText();
    }
    
    public void setMixMealsText(){
        int days = jSlider1.getValue();
        if (language.getLanguage()) {
            jB_MixMeals.setText("Mix For "+days+" Days");
            jB_deleteMix.setText("Remove Mixed Meals");
        }else{
            jB_MixMeals.setText("Mix Til "+days+" Dage");
            jB_deleteMix.setText("Fjern Alle");
        }
    }

    public void showAllGroups() {
        MealsTypeBottom typeB;
        ArrayList<MealsGroup> groupList = mealsHandler.getAllMealGroups();
        jP_typesOfMeals.removeAll();
        for (int i = 0; i < groupList.size(); i++) {
            typeB = new MealsTypeBottom(groupList.get(i));
            jP_typesOfMeals.add(typeB);
            typeB.setLocation(0, ((5 * i) + (typeB.getHeight() * i)));
            typeB.setVisible(true);
            int count = i + 1;
            jP_typesOfMeals.setPreferredSize(new Dimension(typeB.getWidth(), ((5 * count) + (typeB.getHeight() * count))));
        }
        jP_typesOfMeals.revalidate();
        jP_typesOfMeals.repaint();
    }

    public void showMealsByGroup() {
        MealsBottom mealsB;
        ArrayList<Meals> mealsList = mealsHandler.getMealsByGroup();
        jP_Meals.removeAll();
        for (int i = 0; i < mealsList.size(); i++) {
            mealsB = new MealsBottom(mealsList.get(i));
            jP_Meals.add(mealsB);
            mealsB.setLocation(5, ((5 * i) + (mealsB.getHeight() * i)));
            mealsB.setVisible(true);
            int count = i + 1;
            jP_Meals.setPreferredSize(new Dimension(mealsB.getWidth(), ((5 * count) + (mealsB.getHeight() * count))));
        }
        jP_Meals.revalidate();
        jP_Meals.repaint();
    }

    public void showSelectedMeals() {
        MealsSelectedBottom msb;
        ArrayList<Meals> selectedMealList = mealsHandler.getSelectedMealList();
        jP_SelectedMeals.removeAll();
        for (int i = 0; i < selectedMealList.size(); i++) {
            msb = new MealsSelectedBottom(selectedMealList.get(i));
            jP_SelectedMeals.add(msb);
            msb.setLocation(0, ((5 * i) + (msb.getHeight() * i)));
            msb.setVisible(true);
            int count = i + 1;
            jP_SelectedMeals.setPreferredSize(new Dimension(msb.getWidth() , ((5 * count) + (msb.getHeight() * count))));
        }
        if (language.getLanguage()) {
            jL_TotalPrice.setText("Total Price: "+mealsHandler.getSelectedMealsPrice());
            jL_AmountOfDays.setText("Total Amount Of Days: " + mealsHandler.getSelectedMealsDays());
        } else{
            jL_TotalPrice.setText("Total Pris: "+mealsHandler.getSelectedMealsPrice());
            jL_AmountOfDays.setText("Total Antal Dage: " + mealsHandler.getSelectedMealsDays());
        }
        jP_SelectedMeals.revalidate();
        jP_SelectedMeals.repaint();
    }
    
    public void showMixedMeals(){
        MealsMixBottom mb;
        ArrayList<Meals> mixMealList = mealsHandler.FindRandomMeals(jSlider1.getValue() - 1);
        jP_MixAList.removeAll();
        for (int i = 0; i < mixMealList.size(); i++) {
            mb = new MealsMixBottom(mixMealList.get(i));
            jP_MixAList.add(mb);
            mb.setLocation(5, ((5 * i) + (mb.getHeight() * i)));
            mb.setVisible(true);
            int count = i + 1;
            jP_MixAList.setPreferredSize(new Dimension(mb.getWidth(), ((5 * count) + (mb.getHeight() * count))));
        }
        jSlider1.setMaximum(jSlider1.getMaximum() - mealsHandler.getMixFoundDays() -1);
        
        jP_MixAList.revalidate();
        jP_MixAList.repaint();
    }
    
    private void addRandomMeals(){
        for (Meals meal : mealsHandler.getFoundMeals()) {
            mealsHandler.addSelectedMeal(meal);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jP_typesOfMeals = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jP_Meals = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jL_AmountOfDays = new javax.swing.JLabel();
        jL_TotalPrice = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jP_SelectedMeals = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jB_MixMeals = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jP_MixAList = new javax.swing.JPanel();
        jB_addRandomToSelected = new javax.swing.JButton();
        jB_deleteMix = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Plan Meals", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 18))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Type Of Meals", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 14))); // NOI18N

        jScrollPane4.setBorder(null);

        javax.swing.GroupLayout jP_typesOfMealsLayout = new javax.swing.GroupLayout(jP_typesOfMeals);
        jP_typesOfMeals.setLayout(jP_typesOfMealsLayout);
        jP_typesOfMealsLayout.setHorizontalGroup(
            jP_typesOfMealsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        jP_typesOfMealsLayout.setVerticalGroup(
            jP_typesOfMealsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(jP_typesOfMeals);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Meals", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Search For Meals");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jButton3.setText("Search");
        jButton3.setEnabled(false);

        jScrollPane2.setBorder(null);

        jP_Meals.setPreferredSize(new java.awt.Dimension(290, 55));

        javax.swing.GroupLayout jP_MealsLayout = new javax.swing.GroupLayout(jP_Meals);
        jP_Meals.setLayout(jP_MealsLayout);
        jP_MealsLayout.setHorizontalGroup(
            jP_MealsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        jP_MealsLayout.setVerticalGroup(
            jP_MealsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jP_Meals);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Selected Meals", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 14))); // NOI18N

        jButton4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jButton4.setText("End Planning");
        jButton4.setEnabled(false);

        jL_AmountOfDays.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N

        jL_TotalPrice.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N

        jScrollPane3.setBorder(null);

        javax.swing.GroupLayout jP_SelectedMealsLayout = new javax.swing.GroupLayout(jP_SelectedMeals);
        jP_SelectedMeals.setLayout(jP_SelectedMealsLayout);
        jP_SelectedMealsLayout.setHorizontalGroup(
            jP_SelectedMealsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jP_SelectedMealsLayout.setVerticalGroup(
            jP_SelectedMealsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jP_SelectedMeals);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jL_AmountOfDays, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jL_TotalPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jL_TotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jL_AmountOfDays, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Mix A List", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 14))); // NOI18N
        jPanel8.setPreferredSize(new java.awt.Dimension(297, 730));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chose Amount Of Days");
        jLabel1.setToolTipText("Chose Amount Of Days");

        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jB_MixMeals.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jB_MixMeals.setText("Mix");
        jB_MixMeals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_MixMealsActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);

        javax.swing.GroupLayout jP_MixAListLayout = new javax.swing.GroupLayout(jP_MixAList);
        jP_MixAList.setLayout(jP_MixAListLayout);
        jP_MixAListLayout.setHorizontalGroup(
            jP_MixAListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 287, Short.MAX_VALUE)
        );
        jP_MixAListLayout.setVerticalGroup(
            jP_MixAListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jP_MixAList);

        jB_addRandomToSelected.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jB_addRandomToSelected.setText("Add To Selected Meals");
        jB_addRandomToSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_addRandomToSelectedActionPerformed(evt);
            }
        });

        jB_deleteMix.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jB_deleteMix.setText("jButton1");
        jB_deleteMix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_deleteMixActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jB_addRandomToSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jB_MixMeals, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jB_deleteMix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jB_MixMeals, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addComponent(jB_addRandomToSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jB_deleteMix, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        setMixMealsText();
        if (jSlider1.getValue() != 0) {
            jB_MixMeals.setEnabled(true);
        }else{
            jB_MixMeals.setEnabled(false);
        }
    }//GEN-LAST:event_jSlider1StateChanged

    private void jB_MixMealsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_MixMealsActionPerformed
        showMixedMeals();
    }//GEN-LAST:event_jB_MixMealsActionPerformed

    private void jB_deleteMixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_deleteMixActionPerformed
        mealsHandler.deleteMixMeals();
        showMixedMeals();
    }//GEN-LAST:event_jB_deleteMixActionPerformed

    private void jB_addRandomToSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_addRandomToSelectedActionPerformed
        addRandomMeals();
    }//GEN-LAST:event_jB_addRandomToSelectedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_MixMeals;
    private javax.swing.JButton jB_addRandomToSelected;
    private javax.swing.JButton jB_deleteMix;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jL_AmountOfDays;
    private javax.swing.JLabel jL_TotalPrice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jP_Meals;
    private javax.swing.JPanel jP_MixAList;
    private javax.swing.JPanel jP_SelectedMeals;
    private javax.swing.JPanel jP_typesOfMeals;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "MealGroup Selected":
                showMealsByGroup();
                break;
            case "Selected Meal Added":
                showSelectedMeals();
                break;
            case "Remove Mix Meals":
                jSlider1.setMaximum(mealsHandler.getMaxAmountOfDays());
                jSlider1.setMinimum(0);
                jSlider1.setValue(0);
            default:
        }
    }
}
