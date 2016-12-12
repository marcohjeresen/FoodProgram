/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelsView;

import Handler.SystemHandler;
import UtilityStuff.Listeners;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author markh
 */
public class NewUserView extends javax.swing.JPanel {

    private SystemHandler systemHandler;
    private Listeners listeners;
    private String username;
    private boolean usernameOk;
    private int password;
    private boolean passwordOk;
    private String name;
    private boolean nameOk;

    /**
     * Creates new form NewUserView
     */
    public NewUserView() {
        listeners = Listeners.getList();
        try {
            systemHandler = SystemHandler.getInstance();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NewUserView.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        setSize(new Dimension(390, 350));
    }

    private void checkUsername() {
        if (systemHandler.checkusername(jT_username.getText())) {
            jL_username_available.setText("Username is free");
            jL_username_available.setForeground(Color.black);
            username = jT_username.getText();
            usernameOk = true;
        } else {
            jL_username_available.setText("occupied Username");
            jL_username_available.setForeground(Color.red);
            usernameOk = false;
        }
        unlockCreateUser();
    }

    private void checkPassword() {
        try {
            password = Integer.parseInt(jT_password.getText());
            passwordOk = true;
            jT_password.setForeground(Color.black);
        } catch (NumberFormatException ex) {
            passwordOk = false;
            jT_password.setForeground(Color.red);
        }
        unlockCreateUser();
    }

    private void checkName() {
        if (!jT_name.getText().equals("")) {
            nameOk = true;
            name = jT_name.getText();
        } else {
            nameOk = false;
        }
        unlockCreateUser();
    }

    private void unlockCreateUser() {
        if (usernameOk) {
            if (passwordOk) {
                if (nameOk) {
                    if (jT_english.isSelected()) {
                        jB_end.setEnabled(true);
                    } else if (jT_danish.isSelected()) {
                        jB_end.setEnabled(true);
                    } else {
                        jB_end.setEnabled(false);
                    }
                } else {
                    jB_end.setEnabled(false);
                }
            } else {
                jB_end.setEnabled(false);
            }
        } else {
            jB_end.setEnabled(false);
        }
    }

    private void createUser() {
        if (jT_english.isSelected()) {
            systemHandler.createUser(username, password, name, true);
            listeners.notifyListeners("User Created");
        } else if (jT_danish.isSelected()) {
            systemHandler.createUser(username, password, name, false);
            listeners.notifyListeners("User Created");
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

        jT_username = new javax.swing.JTextField();
        jL_username_available = new javax.swing.JLabel();
        jT_password = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jT_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jB_end = new javax.swing.JButton();
        jT_english = new javax.swing.JToggleButton();
        jT_danish = new javax.swing.JToggleButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Create new user for free", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jT_username.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jT_username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jT_username.setText("Username");
        jT_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jT_usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jT_usernameFocusLost(evt);
            }
        });

        jL_username_available.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jL_username_available.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_username_available.setText("Only lettering");

        jT_password.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jT_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jT_password.setText("Password");
        jT_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jT_passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jT_passwordFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Only numbers");

        jT_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jT_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jT_name.setText("Name");
        jT_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jT_nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jT_nameFocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Language");

        jB_end.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jB_end.setText("Confirmed");
        jB_end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_endActionPerformed(evt);
            }
        });

        jT_english.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jT_english.setText("ENG");
        jT_english.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_englishActionPerformed(evt);
            }
        });

        jT_danish.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jT_danish.setText("Danish");
        jT_danish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_danishActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jT_username, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jL_username_available, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jT_english, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jT_danish, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                            .addComponent(jB_end, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jT_name, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jT_password, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jT_username, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jL_username_available, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jT_password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jT_name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jT_english, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jT_danish, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jB_end, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jT_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jT_usernameFocusLost
        if (jT_username.getText().equals("")) {
            jT_username.setText("Username");
        } else {
            checkUsername();
        }
    }//GEN-LAST:event_jT_usernameFocusLost

    private void jT_englishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_englishActionPerformed
        jT_danish.setSelected(false);
        unlockCreateUser();
    }//GEN-LAST:event_jT_englishActionPerformed

    private void jT_danishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_danishActionPerformed
        jT_english.setSelected(false);
        unlockCreateUser();
    }//GEN-LAST:event_jT_danishActionPerformed

    private void jT_passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jT_passwordFocusLost
        if (jT_password.getText().equals("")) {
            jT_password.setText("Password");
        } else {
            checkPassword();
        }

    }//GEN-LAST:event_jT_passwordFocusLost

    private void jT_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jT_nameFocusLost
        if (jT_name.getText().equals("")) {
            jT_name.setText("Name");
        } else {
            checkName();
        }

    }//GEN-LAST:event_jT_nameFocusLost

    private void jB_endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_endActionPerformed
        createUser();
    }//GEN-LAST:event_jB_endActionPerformed

    private void jT_usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jT_usernameFocusGained
        if (jT_username.getText().equals("Username")) {
            jT_username.setText("");
        }
    }//GEN-LAST:event_jT_usernameFocusGained

    private void jT_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jT_passwordFocusGained
        if (jT_password.getText().equals("Password")) {
            jT_password.setText("");
        }
    }//GEN-LAST:event_jT_passwordFocusGained

    private void jT_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jT_nameFocusGained
        if (jT_name.getText().equals("Name")) {
            jT_name.setText("");
        }
    }//GEN-LAST:event_jT_nameFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_end;
    private javax.swing.JLabel jL_username_available;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JToggleButton jT_danish;
    private javax.swing.JToggleButton jT_english;
    private javax.swing.JTextField jT_name;
    private javax.swing.JTextField jT_password;
    private javax.swing.JTextField jT_username;
    // End of variables declaration//GEN-END:variables
}