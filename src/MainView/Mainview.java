/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainView;

import PanelsView.LogonView;
import PanelsView.CardLayoutView;
import PanelsView.NewUserView;
import UtilityStuff.Listeners;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author markh
 */
public class Mainview extends javax.swing.JFrame implements ActionListener {

    private Listeners listeners;
    private LogonView logonView;

    /**
     * Creates new form Mainview
     */
    public Mainview() {
        listeners = Listeners.getList();
        logonView = new LogonView();
        initComponents();
        listeners.addListener(this);
        setSize(new Dimension(1400, 800));
        jP_Logon.add(logonView);
        logonView.setLocation((this.getWidth() - logonView.getWidth()) / 2, (this.getHeight() - logonView.getHeight() - 50) / 2);
    }

    private void newUser() {
        jP_Logon.removeAll();
        NewUserView newUser = new NewUserView();
        jP_Logon.add(newUser);
        newUser.setLocation((this.getWidth() - newUser.getWidth()) / 2, (this.getHeight() - newUser.getHeight() - 50) / 2);
        this.repaint();
        this.revalidate();
    }

    private void Logon() {

        jP_Logon.removeAll();
        CardLayoutView plan = new CardLayoutView();
        jP_Logon.add(plan);
        this.repaint();
        this.revalidate();
    }

    private void Logout() {
        jP_Logon.removeAll();
        logonView = new LogonView();
        jP_Logon.add(logonView);
        logonView.setLocation((this.getWidth() - logonView.getWidth()) / 2, (this.getHeight() - logonView.getHeight() - 50) / 2);
        this.repaint();
        this.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jP_Logon = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jP_LogonLayout = new javax.swing.GroupLayout(jP_Logon);
        jP_Logon.setLayout(jP_LogonLayout);
        jP_LogonLayout.setHorizontalGroup(
            jP_LogonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1400, Short.MAX_VALUE)
        );
        jP_LogonLayout.setVerticalGroup(
            jP_LogonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jP_Logon, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mainview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mainview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mainview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mainview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mainview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jP_Logon;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "Logon succseed":
                Logon();
                break;
            case "Create new user":
                newUser();
                break;
            case "User Created":
                Logon();
                break;
            case "Logout":
                Logout();
                break;
        }
    }
}