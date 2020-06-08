/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelView;

import BLL.Company;
import BLL.Job;
import BLL.JobCategory;
import BLL.Location;
import DAL.AppFormException;
import DAL.CompanyRepository;
import DAL.JobCategoryRepository;
import DAL.JobRepository;
import DAL.LocationRepository;
import ModelGiu.CompanyComboBoxModel;
import ModelGiu.JobCategoryComboBoxModel;
import ModelGiu.JobTableModel;
import ModelGiu.LoationComboBoxModel;
import java.util.List;
import java.util.Locale.Category;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author DELL
 */
public class JobForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form JobForm
     */
    public JobForm() {
        initComponents();
        loadTable();
        tabelaSelectedIndexChange();
        loadComboBox();
    }
    JobRepository jr = new JobRepository();
    JobTableModel jtm = new JobTableModel();
    LocationRepository lr = new LocationRepository();
    LoationComboBoxModel lcbm = new LoationComboBoxModel();
    JobCategoryRepository jcr = new JobCategoryRepository();
    JobCategoryComboBoxModel jccbm = new JobCategoryComboBoxModel();
    CompanyRepository cr = new CompanyRepository();
    CompanyComboBoxModel ccbm = new CompanyComboBoxModel();
     
    
    
    public void loadTable(){
      try{
            List<Job> lista = jr.findAll();
            jtm.addList(lista);
            table.setModel(jtm);
            jtm.fireTableDataChanged();
        }catch(AppFormException ex){
            Logger.getLogger(EmployerForm.class.getName()).log(Level.SEVERE,null,ex);
        }
    
    }
     private void tabelaSelectedIndexChange(){
          final ListSelectionModel rowSM = table.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()){
                    return;
                }
                
                ListSelectionModel rowSM = (ListSelectionModel) e.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if(selectedIndex > -1){
                    Job j = jtm.getJob(selectedIndex);
                     titleField.setText(j.getJobTitle());
                    descriptionField.setText(j.getJobDescription());
                    typeField.setText(j.getJobType());
                   // float nr= (flo j.getJobSalary();
                    salaryField.setText(Float.toString((float) j.getJobSalary()));
                  
                   jccbm.setSelectedItem(j.getCategoryID());
                    categorycbm.repaint();
                    lcbm.setSelectedItem(j.getLocationID());
                    locationcbm.repaint();
                    ccbm.setSelectedItem(j.getCompanyID());
                    companycbm.repaint();
                    dateChooser.setDate(j.getPostingDate());
                }
            }
        });
    }
       public void loadComboBox(){
        try{
            List <Location> list = lr.findAll();
            lcbm.add(list);
            locationcbm.setModel(lcbm);
            locationcbm.repaint();
            List <Company> lista = cr.findAll();
            ccbm.add(lista);
            companycbm.setModel(ccbm);
            companycbm.repaint();
           List <JobCategory> listaa = jcr.findAll();
            jccbm.add(listaa);
            categorycbm.setModel(jccbm);
            categorycbm.repaint();
            
      
            
          
        }catch(AppFormException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
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

        panel = new javax.swing.JPanel();
        saveB = new javax.swing.JButton();
        cancelB = new javax.swing.JButton();
        deleteB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        typeField = new javax.swing.JTextField();
        titleField = new javax.swing.JTextField();
        salaryField = new javax.swing.JTextField();
        descriptionField = new javax.swing.JTextField();
        categorycbm = new javax.swing.JComboBox();
        locationcbm = new javax.swing.JComboBox();
        companycbm = new javax.swing.JComboBox();
        dateChooser = new com.toedter.calendar.JDateChooser();

        saveB.setText("Save");
        saveB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBActionPerformed(evt);
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

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table);

        jLabel1.setText("Job ID:");

        jLabel2.setText("Job Title");

        jLabel3.setText("Job Description");

        jLabel4.setText("Category ID");

        jLabel5.setText("Location ID:");

        jLabel6.setText("Company ID:");

        jLabel7.setText("Job Type");

        jLabel8.setText("Job Salary:");

        jLabel9.setText("Posting Date:");

        idField.setEnabled(false);
        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });

        typeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeFieldActionPerformed(evt);
            }
        });

        titleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleFieldActionPerformed(evt);
            }
        });

        salaryField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryFieldActionPerformed(evt);
            }
        });

        descriptionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionFieldActionPerformed(evt);
            }
        });

        categorycbm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        locationcbm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        companycbm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveB)
                            .addComponent(cancelB)
                            .addComponent(deleteB))
                        .addGap(25, 25, 25)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabel5)))
                                .addGap(18, 18, 18)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(companycbm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(locationcbm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(categorycbm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(100, 100, 100)
                                        .addComponent(jLabel8))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(descriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(72, 72, 72)
                                        .addComponent(jLabel7)))
                                .addGap(18, 18, 18)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(typeField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(salaryField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(saveB)
                        .addComponent(jLabel1)
                        .addComponent(jLabel5)
                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(locationcbm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelB)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(companycbm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteB)
                    .addComponent(jLabel3)
                    .addComponent(descriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(typeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(categorycbm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(salaryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBActionPerformed
        // TODO add your handling code here:
        try{
            int row = table.getSelectedRow();
            if(row == -1){
            Job  j = new Job();
             j.setJobType(typeField.getText());
            j.setJobDescription(descriptionField.getText());
            j.setJobSalary(Float.parseFloat(salaryField.getText()));
            j.setJobTitle(titleField.getText());
            j.setCategoryID((JobCategory)jccbm.getSelectedItem());
            j.setCompanyID((Company)ccbm.getSelectedItem());
            j.setLocationID((Location)lcbm.getSelectedItem());
            j.setPostingDate(dateChooser.getDate());
            jr.create(j);
            }
            else{
            Job  j = new Job();
            j.setJobTitle(titleField.getText());
            j.setJobDescription(descriptionField.getText());
            j.setJobSalary(Float.parseFloat(salaryField.getText()));
            j.setCategoryID((JobCategory)jccbm.getSelectedItem());
            j.setCompanyID((Company)ccbm.getSelectedItem());
            j.setLocationID((Location)lcbm.getSelectedItem());
            j.setPostingDate(dateChooser.getDate());
             j.setJobType(typeField.getText());
            jr.edit(j);
            }
            clear();
            loadTable();
        }catch(AppFormException af){
            JOptionPane.showMessageDialog(this , "This data Exists");
        }
    }//GEN-LAST:event_saveBActionPerformed

    
    public void clear(){
    // idField.setText("");
        table.clearSelection();
     typeField.setText("");
     descriptionField.setText("");
     salaryField.setText("");
     titleField.setText("");
       companycbm.setSelectedIndex(-1);
        companycbm.repaint();
         locationcbm.setSelectedIndex(-1);
        locationcbm.repaint();
        categorycbm.setSelectedIndex(-1);
        categorycbm.repaint();
        dateChooser.setDate(null);
    
    }
    private void deleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBActionPerformed
        // TODO add your handling code here:
                         int row = table.getSelectedRow();
        if(row != -1){
        Object [] opsions = {"Yes" , "No"};
        int i = JOptionPane.showOptionDialog(this, "Do you want to delete this Job from list?", "Deletion", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, opsions, opsions[1]);
        if(i == 0){
        Job j =jtm.getJob(row);
        try{
        jr.delete(j);
        }catch(AppFormException apf){
        JOptionPane.showMessageDialog(this,apf.getMessage());}
                
        clear();
        loadTable();
        }
        }
        else {
         JOptionPane.showMessageDialog(this, "You dind't chose anything to delete");}
    }//GEN-LAST:event_deleteBActionPerformed

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    private void typeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeFieldActionPerformed

    private void titleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleFieldActionPerformed

    private void salaryFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salaryFieldActionPerformed

    private void descriptionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionFieldActionPerformed

    private void cancelBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_cancelBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelB;
    private javax.swing.JComboBox categorycbm;
    private javax.swing.JComboBox companycbm;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JButton deleteB;
    private javax.swing.JTextField descriptionField;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox locationcbm;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField salaryField;
    private javax.swing.JButton saveB;
    private javax.swing.JTable table;
    private javax.swing.JTextField titleField;
    private javax.swing.JTextField typeField;
    // End of variables declaration//GEN-END:variables
}
