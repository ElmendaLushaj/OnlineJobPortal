/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelView;

import BLL.Perdoruesi;
import BLL.Roli;
import DAL.AppFormException;
import DAL.PerdoruesiRepository;
import DAL.RoliRepository;
import ModelGiu.PerdoruesitModelTable;
import ModelGiu.RoliComboBoxModel;
import ModelGiu.RoliTableModel;
import java.awt.PopupMenu;
import java.awt.print.Pageable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class PerdoruesitForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form PerdoruesitForm
     */
    public PerdoruesitForm() {
        initComponents();
        loadTable();
        tabelaSelectedIndexChange();
        loadComboBox();
       // addRowToTable();
    }
    PerdoruesiRepository pr = new PerdoruesiRepository();
    PerdoruesitModelTable ptm = new PerdoruesitModelTable();
  //  public PerdoruesitForm(Perdoruesi p) throws AppFormException{
    //  pr.create(p);
    //  loadTable();
      
    //}
    
    
   // Pageable paging = PageRequest.of(pageNo, pageSize);
 
    // Page<Perdoruesit> pagedResult = PerdoruesitRepository.findAll(paging); 
    
    public void loadTable(){
     try{
            List<Perdoruesi> lista = pr.findAll();
            ptm.setPageSize(5);
            ptm.addList(lista);
            perdoruesitTable.setModel(ptm);
            ptm.fireTableDataChanged();
        }catch(AppFormException ex){
            Logger.getLogger(EmployerForm.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    private void tabelaSelectedIndexChange(){
        final ListSelectionModel rowSM = perdoruesitTable.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()){
                    return;
                }
                
                ListSelectionModel rowSM = (ListSelectionModel) e.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if(selectedIndex > -1){
                    Perdoruesi p = ptm.getPerdoruesi(selectedIndex);
                    
                    idField.setText(p.getId().toString());
                    usernameField.setText(p.getUsername());
                   
                    passwordField.setText(p.getPassword());
                    rcbm.setSelectedItem(p.getRoliID());
                    comboBox.repaint();
                    
                }
            }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        saveB = new javax.swing.JButton();
        personalCBM = new javax.swing.JComboBox();
        paneli = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        perdoruesitTable = new javax.swing.JTable();
        idField = new javax.swing.JTextField();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        saveButton = new javax.swing.JButton();
        comboBox = new javax.swing.JComboBox();
        cancelB = new javax.swing.JButton();
        deleteB = new javax.swing.JButton();
        upB = new javax.swing.JButton();
        downB = new javax.swing.JButton();

        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table3);

        saveB.setText("jButton1");
        saveB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBActionPerformed(evt);
            }
        });

        personalCBM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));

        perdoruesitTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(perdoruesitTable);

        idField.setEnabled(false);

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        comboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });

        cancelB.setText("Cancel");
        cancelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBActionPerformed(evt);
            }
        });

        deleteB.setText("Delete");
        deleteB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBActionPerformed(evt);
            }
        });

        upB.setText("Previous");
        upB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upBActionPerformed(evt);
            }
        });

        downB.setText("Next");
        downB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneliLayout = new javax.swing.GroupLayout(paneli);
        paneli.setLayout(paneliLayout);
        paneliLayout.setHorizontalGroup(
            paneliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneliLayout.createSequentialGroup()
                .addGroup(paneliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneliLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(paneliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(paneliLayout.createSequentialGroup()
                                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(paneliLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(saveButton)
                        .addGap(66, 66, 66)
                        .addComponent(cancelB)
                        .addGap(59, 59, 59)
                        .addComponent(deleteB))
                    .addGroup(paneliLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(upB)
                        .addGap(36, 36, 36)
                        .addComponent(downB)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        paneliLayout.setVerticalGroup(
            paneliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneliLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(paneliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(paneliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelB)
                    .addComponent(deleteB))
                .addGap(51, 51, 51)
                .addGroup(paneliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(upB)
                    .addComponent(downB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(242, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_saveBActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
         try{   int row = perdoruesitTable.getSelectedRow();
            if(row == -1){
             Perdoruesi  p = new Perdoruesi();
            p.setUsername(usernameField.getText());
            p.setPassword(new String (passwordField.getPassword()));
          //  int idd = Integer.parseInt(idField1.getText());
           // p.setId(idd);
            p.setRoliID((Roli)rcbm.getSelectedItem());
            pr.create(p);
            }
            else{
             Perdoruesi  p = new Perdoruesi();
            p.setUsername(usernameField.getText());
            p.setPassword(new String (passwordField.getPassword()));
          //  int idd = Integer.parseInt(idField1.getText());
           // p.setId(idd);
          //  p.setRoliID((Roli)comboBox.getSelectedItem());
              p.setRoliID((Roli)rcbm.getSelectedItem());
            pr.edit(p);
            }
            clear();
            loadTable();
      }catch(AppFormException af){
            JOptionPane.showMessageDialog(this , "This data Exists");
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_cancelBActionPerformed

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxActionPerformed

    private void deleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBActionPerformed
        // TODO add your handling code here:
        int row = perdoruesitTable.getSelectedRow();
        if(row != -1){
        Object [] opsions = {"Yes" , "No"};
        int i = JOptionPane.showOptionDialog(this, "Do you want to delete this User?", "Deletion", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, opsions, opsions[1]);
        if(i == 0){
        Perdoruesi p =ptm.getPerdoruesi(row);
        try{
        pr.delete(p);
        }catch(AppFormException apf){
        JOptionPane.showMessageDialog(this,apf.getMessage());}
                
        clear();
        loadTable();
        }
        }
        else {
         JOptionPane.showMessageDialog(this, "You dind't chose anything to delete");}
    }//GEN-LAST:event_deleteBActionPerformed

    private void upBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upBActionPerformed
        // TODO add your handling code here:
         PerdoruesitModelTable model = (PerdoruesitModelTable) perdoruesitTable.getModel();
        model.pageUp();
         if (model.getPageOffset() == 0) {
          upB.setEnabled(false);
        }else{
        downB.setEnabled(true);
      }
    }//GEN-LAST:event_upBActionPerformed

    private void downBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downBActionPerformed
        // TODO add your handling code here:
             PerdoruesitModelTable model = (PerdoruesitModelTable) perdoruesitTable.getModel();
        model.pageDown();
           // If we hit the bottom of the data, disable the down button.
        if (model.getPageOffset() == (model.getPageCount() - 1)) {
          downB.setEnabled(false);
        }else{
        upB.setEnabled(true);
      }
    }//GEN-LAST:event_downBActionPerformed
public void clear(){
     perdoruesitTable.clearSelection();
     idField.setText("");
     usernameField.setText("");
      comboBox.setSelectedIndex(-1);
        comboBox.repaint();
     //genderField.setText("");
    passwordField.setText("");
    
    }
    RoliRepository rp = new RoliRepository();
    RoliComboBoxModel rcbm = new RoliComboBoxModel();
    //Roli r = new Roli();
   // RoliTableModel rtm = new RoliTableModel();
    
       public void loadComboBox(){
        try{
             List <Roli> listaa = rp.findAll();
            rcbm.add(listaa);
            comboBox.setModel(rcbm);
            comboBox.repaint();
        }catch(AppFormException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
  /* public static void addRowToTable(Object [] o){
   
   DefaultTableModel model = (DefaultTableModel)table.getModel();
   model.addRow(o);
   }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelB;
    private javax.swing.JComboBox comboBox;
    private javax.swing.JButton deleteB;
    private javax.swing.JButton downB;
    private javax.swing.JTextField idField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel paneli;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTable perdoruesitTable;
    private javax.swing.JComboBox personalCBM;
    private javax.swing.JButton saveB;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable table3;
    private javax.swing.JButton upB;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
