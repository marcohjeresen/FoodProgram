/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelsView;

import Handler.AdminHandler;
import Handler.Language;
import Handler.MealsHandler;
import Handler.SystemHandler;
import Model.Meals;
import Model.UserGroup;
import Model.Users;
import PanelsButtom.AdminMealsBottom;
import PanelsButtom.UsersBottom;
import UtilityStuff.Listeners;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author markh
 */
public class AdminView extends javax.swing.JPanel implements ActionListener {
    
    private Listeners listeners;
    private AdminHandler adminHandler;
    private Language language;
    private ArrayList<Users> userList;
    private Users selectedUser;
    private MealsHandler mealsHandler;
    

    /**
     * Creates new form AdminView
     */
    public AdminView() {
        adminHandler = AdminHandler.getInstance();
        language = Language.getInstance();
        selectedUser = null;
        listeners = Listeners.getList();
        try {
            mealsHandler = MealsHandler.getInstance();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminView.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        listeners.addListener(this);
        userList = adminHandler.getAllUsers();
        setSize(new Dimension(1195, 760));
        showUsers();
        setTextLanguage();
        fillUserGroupCombobox();
    }
    
    private void showUsers(){
        UsersBottom userB;
        jP_Users.removeAll();
        for (int i = 0; i < userList.size(); i++) {
            userB = new UsersBottom(userList.get(i));
            jP_Users.add(userB);
            userB.setLocation(0, ((5*i)+(userB.getHeight() * i)));
            userB.setVisible(true);
            int count = i + 1;
            jP_Users.setPreferredSize(new Dimension(userB.getWidth(), ((5 * count) + (userB.getHeight() * count))));
        }
        jP_Users.revalidate();
        jP_Users.repaint();
    }
    
    private void showUserCreatedMeals(){
        AdminMealsBottom adminMealsBottom;
        jP_CreatetMealsUser.removeAll();
        ArrayList<Meals> userMealList = mealsHandler.getUserCreatedMeals(selectedUser);
        for (int i = 0; i < userMealList.size() ; i++) {
            adminMealsBottom = new AdminMealsBottom(userMealList.get(i));
            jP_CreatetMealsUser.add(adminMealsBottom);
            adminMealsBottom.setLocation(0, ((5*i)+(adminMealsBottom.getHeight() * i)));
            adminMealsBottom.setVisible(true);
            int count = i + 1;
            jP_CreatetMealsUser.setPreferredSize(new Dimension(adminMealsBottom.getWidth(), ((5 * count) + (adminMealsBottom.getHeight() * count))));
        }
        jP_CreatetMealsUser.revalidate();
        jP_CreatetMealsUser.repaint();
    }
    
    private void fillUserGroupCombobox(){
        jC_UserGroup.removeAllItems();
        for (UserGroup group : adminHandler.getAllUsergroups()) {
            jC_UserGroup.addItem(group.getGroupType());
        }
    }
    
    private void setTextLanguage(){
        if (language.getLanguage()) {
            jL_SelectedUsername.setText("Username");
            jL_selectedpassword.setText("Password");
            jL_selectedname.setText("Name");
            jL_UserGroup.setText("Usergroup");
            jL_Language.setText("Users Language");
            jT_LangENG.setText("English");
            jT_langDANISH.setText("Danish");
        } else {
            jL_SelectedUsername.setText("Brugernavn");
            jL_selectedpassword.setText("Adgangskode");
            jL_selectedname.setText("Navn");
            jL_UserGroup.setText("Tildelt Gruppe");
            jL_Language.setText("Brugers Sprog");
            jT_LangENG.setText("Engelsk");
            jT_langDANISH.setText("Dansk");
        }
        
    }
    
    private void showSelectedUser(){
        selectedUser = adminHandler.getSelectedUser();
        jT_SelectedUsername.setText(selectedUser.getUsername());
        jT_selectedpassword.setText(selectedUser.getPassword()+"");
        jT_selectedname.setText(selectedUser.getName());
        jT_LangENG.setSelected(selectedUser.isEnglish());
        jT_langDANISH.setSelected(!selectedUser.isEnglish());
        jC_UserGroup.setSelectedIndex(selectedUser.getUserGroup().getGroupId() - 1);
        if (selectedUser.isEnglish()) {
            jT_LangENG.setSelected(true);
            jT_LangENG.setEnabled(true);
            jT_langDANISH.setSelected(false);
            jT_langDANISH.setEnabled(false);
        } else {
            jT_LangENG.setSelected(false);
            jT_LangENG.setEnabled(false);
            jT_langDANISH.setSelected(true);
            jT_langDANISH.setEnabled(true);
        }
        showUserCreatedMeals();
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
        jPanel3 = new javax.swing.JPanel();
        jT_SelectedUsername = new javax.swing.JTextField();
        jL_SelectedUsername = new javax.swing.JLabel();
        jT_selectedpassword = new javax.swing.JTextField();
        jL_selectedpassword = new javax.swing.JLabel();
        jT_selectedname = new javax.swing.JTextField();
        jL_selectedname = new javax.swing.JLabel();
        jC_UserGroup = new javax.swing.JComboBox();
        jL_UserGroup = new javax.swing.JLabel();
        jL_Language = new javax.swing.JLabel();
        jT_LangENG = new javax.swing.JToggleButton();
        jT_langDANISH = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jP_CreatetMealsUser = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScr_Users = new javax.swing.JScrollPane();
        jP_Users = new javax.swing.JPanel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 18))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 18))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Users Information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 14))); // NOI18N

        jT_SelectedUsername.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jT_SelectedUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jL_SelectedUsername.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N

        jT_selectedpassword.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jT_selectedpassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jL_selectedpassword.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N

        jT_selectedname.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jT_selectedname.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jL_selectedname.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N

        jC_UserGroup.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N

        jL_UserGroup.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N

        jL_Language.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jL_Language.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_Language.setText("Users Language");

        jT_LangENG.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jT_LangENG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_LangENGActionPerformed(evt);
            }
        });

        jT_langDANISH.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jT_langDANISH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_langDANISHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jT_SelectedUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jL_SelectedUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jC_UserGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jL_UserGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jT_selectedname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jL_selectedname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jT_LangENG, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jT_langDANISH, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jT_selectedpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jL_selectedpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jL_Language, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jT_SelectedUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jL_SelectedUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jC_UserGroup)
                    .addComponent(jL_UserGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jL_Language, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jT_selectedpassword)
                    .addComponent(jL_selectedpassword, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jT_selectedname)
                    .addComponent(jL_selectedname, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jT_LangENG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jT_langDANISH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Createt Meals", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 14))); // NOI18N

        jScrollPane1.setBorder(null);

        javax.swing.GroupLayout jP_CreatetMealsUserLayout = new javax.swing.GroupLayout(jP_CreatetMealsUser);
        jP_CreatetMealsUser.setLayout(jP_CreatetMealsUserLayout);
        jP_CreatetMealsUserLayout.setHorizontalGroup(
            jP_CreatetMealsUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        jP_CreatetMealsUserLayout.setVerticalGroup(
            jP_CreatetMealsUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jP_CreatetMealsUser);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Favorites", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 14))); // NOI18N

        jScrollPane2.setBorder(null);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Dislike Meals", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 14))); // NOI18N

        jScrollPane3.setBorder(null);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScr_Users.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Users", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 18))); // NOI18N

        javax.swing.GroupLayout jP_UsersLayout = new javax.swing.GroupLayout(jP_Users);
        jP_Users.setLayout(jP_UsersLayout);
        jP_UsersLayout.setHorizontalGroup(
            jP_UsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jP_UsersLayout.setVerticalGroup(
            jP_UsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 682, Short.MAX_VALUE)
        );

        jScr_Users.setViewportView(jP_Users);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScr_Users, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScr_Users, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE))
                .addContainerGap())
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

    private void jT_LangENGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_LangENGActionPerformed
        jT_langDANISH.setSelected(false);
    }//GEN-LAST:event_jT_LangENGActionPerformed

    private void jT_langDANISHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_langDANISHActionPerformed
        jT_LangENG.setSelected(false);
    }//GEN-LAST:event_jT_langDANISHActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jC_UserGroup;
    private javax.swing.JLabel jL_Language;
    private javax.swing.JLabel jL_SelectedUsername;
    private javax.swing.JLabel jL_UserGroup;
    private javax.swing.JLabel jL_selectedname;
    private javax.swing.JLabel jL_selectedpassword;
    private javax.swing.JPanel jP_CreatetMealsUser;
    private javax.swing.JPanel jP_Users;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScr_Users;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToggleButton jT_LangENG;
    private javax.swing.JTextField jT_SelectedUsername;
    private javax.swing.JToggleButton jT_langDANISH;
    private javax.swing.JTextField jT_selectedname;
    private javax.swing.JTextField jT_selectedpassword;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "Admin Select User":
                showSelectedUser();
                break;
        }
    }
}
