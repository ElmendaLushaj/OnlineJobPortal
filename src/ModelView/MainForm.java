/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelView;

import BLL.ApplicationDetails;

/**
 *
 * @author DELL
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        buttonPane = new javax.swing.JDesktopPane();
        employerButton = new javax.swing.JButton();
        locationB = new javax.swing.JButton();
        applicantB = new javax.swing.JButton();
        catogoryMenu = new javax.swing.JButton();
        jobB = new javax.swing.JButton();
        applicationB = new javax.swing.JButton();
        companyB = new javax.swing.JButton();
        desktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        menuTable = new javax.swing.JMenu();
        employerMenu = new javax.swing.JMenuItem();
        applicantMenu = new javax.swing.JMenuItem();
        productMenu = new javax.swing.JMenu();
        categoryMenu = new javax.swing.JMenu();
        jobMenu = new javax.swing.JMenuItem();
        companyMenu = new javax.swing.JMenu();
        locationMenu = new javax.swing.JMenu();
        applicationMenu = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        employerButton.setText("Employer");
        employerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employerButtonActionPerformed(evt);
            }
        });

        locationB.setText("Location");
        locationB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationBActionPerformed(evt);
            }
        });

        applicantB.setText("Applicant");
        applicantB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applicantBActionPerformed(evt);
            }
        });

        catogoryMenu.setText("JCategory");

        jobB.setText("Jobs");
        jobB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobBActionPerformed(evt);
            }
        });

        applicationB.setText("Applications");
        applicationB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applicationBActionPerformed(evt);
            }
        });

        companyB.setText("Company");

        javax.swing.GroupLayout buttonPaneLayout = new javax.swing.GroupLayout(buttonPane);
        buttonPane.setLayout(buttonPaneLayout);
        buttonPaneLayout.setHorizontalGroup(
            buttonPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(companyB)
                .addGap(163, 163, 163)
                .addComponent(catogoryMenu)
                .addGap(158, 158, 158)
                .addComponent(jobB)
                .addGap(230, 230, 230))
            .addGroup(buttonPaneLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(employerButton)
                .addGap(140, 140, 140)
                .addComponent(locationB)
                .addGap(139, 139, 139)
                .addComponent(applicantB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addComponent(applicationB)
                .addGap(107, 107, 107))
        );
        buttonPaneLayout.setVerticalGroup(
            buttonPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPaneLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(buttonPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employerButton)
                    .addComponent(locationB)
                    .addComponent(applicantB)
                    .addComponent(applicationB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(buttonPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(catogoryMenu)
                    .addComponent(companyB)
                    .addComponent(jobB))
                .addGap(31, 31, 31))
        );
        buttonPane.setLayer(employerButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        buttonPane.setLayer(locationB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        buttonPane.setLayer(applicantB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        buttonPane.setLayer(catogoryMenu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        buttonPane.setLayer(jobB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        buttonPane.setLayer(applicationB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        buttonPane.setLayer(companyB, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        menuTable.setText("Users");

        employerMenu.setText("Employer's");
        employerMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employerMenuActionPerformed(evt);
            }
        });
        menuTable.add(employerMenu);

        applicantMenu.setText("Applicants");
        applicantMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applicantMenuActionPerformed(evt);
            }
        });
        menuTable.add(applicantMenu);

        jMenuBar1.add(menuTable);

        productMenu.setText("Product");

        categoryMenu.setText("Job Category");

        jobMenu.setText("Job");
        categoryMenu.add(jobMenu);

        productMenu.add(categoryMenu);

        jMenuBar1.add(productMenu);

        companyMenu.setText("Companies");
        jMenuBar1.add(companyMenu);

        locationMenu.setText("Locations");
        jMenuBar1.add(locationMenu);

        applicationMenu.setText("Applications");
        jMenuBar1.add(applicationMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonPane)
            .addComponent(desktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void employerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employerButtonActionPerformed
        // TODO add your handling code here:
        EmployerForm ef = new EmployerForm();
        desktopPane.add(ef);
        ef.show();
    }//GEN-LAST:event_employerButtonActionPerformed

    private void applicantMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applicantMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_applicantMenuActionPerformed

    private void locationBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationBActionPerformed
        // TODO add your handling code here:
        LocationForm lf = new LocationForm();
        desktopPane.add(lf);
        lf.show();
    }//GEN-LAST:event_locationBActionPerformed

    private void employerMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employerMenuActionPerformed
        // TODO add your handling code here:
          EmployerForm ef = new EmployerForm();
        desktopPane.add(ef);
        ef.show();
                 
    }//GEN-LAST:event_employerMenuActionPerformed

    private void applicantBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applicantBActionPerformed
        // TODO add your handling code here:
         ApplicantForm af = new ApplicantForm();
        desktopPane.add(af);
        af.show();
    }//GEN-LAST:event_applicantBActionPerformed

    private void applicationBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applicationBActionPerformed
        // TODO add your handling code here:
        ApplicationDetailsForm ad = new ApplicationDetailsForm();
        desktopPane.add(ad);
        ad.show();
    }//GEN-LAST:event_applicationBActionPerformed

    private void jobBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobBActionPerformed
        // TODO add your handling code here:
        JobForm jf = new JobForm ();
        desktopPane.add(jf);
        jf.show();
    }//GEN-LAST:event_jobBActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applicantB;
    private javax.swing.JMenuItem applicantMenu;
    private javax.swing.JButton applicationB;
    private javax.swing.JMenu applicationMenu;
    private javax.swing.JDesktopPane buttonPane;
    private javax.swing.JMenu categoryMenu;
    private javax.swing.JButton catogoryMenu;
    private javax.swing.JButton companyB;
    private javax.swing.JMenu companyMenu;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JButton employerButton;
    private javax.swing.JMenuItem employerMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JButton jobB;
    private javax.swing.JMenuItem jobMenu;
    private javax.swing.JButton locationB;
    private javax.swing.JMenu locationMenu;
    private javax.swing.JMenu menuTable;
    private javax.swing.JMenu productMenu;
    // End of variables declaration//GEN-END:variables
}