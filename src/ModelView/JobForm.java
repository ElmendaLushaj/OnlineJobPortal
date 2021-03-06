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
import ModelGiu.ApplicantTableModel;
import ModelGiu.CompanyComboBoxModel;
import ModelGiu.JobCategoryComboBoxModel;
import ModelGiu.JobTableModel;
import ModelGiu.LoationComboBoxModel;
import java.awt.Color;
import java.util.List;
import java.util.Locale.Category;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;

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
        sort();
         Color c = new Color(204 , 204 , 255);
        panel.setBackground(c);
        
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
            jtm.setPageSize(5);
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
        mistake = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        filterF = new javax.swing.JTextField();
        upB = new javax.swing.JButton();
        downB = new javax.swing.JButton();
        filterCBM = new javax.swing.JComboBox();

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
        typeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                typeFieldKeyReleased(evt);
            }
        });

        titleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleFieldActionPerformed(evt);
            }
        });
        titleField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                titleFieldKeyReleased(evt);
            }
        });

        salaryField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryFieldActionPerformed(evt);
            }
        });
        salaryField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                salaryFieldKeyReleased(evt);
            }
        });

        descriptionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionFieldActionPerformed(evt);
            }
        });
        descriptionField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descriptionFieldKeyReleased(evt);
            }
        });

        categorycbm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        categorycbm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                categorycbmKeyReleased(evt);
            }
        });

        locationcbm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        locationcbm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                locationcbmKeyReleased(evt);
            }
        });

        companycbm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        companycbm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                companycbmKeyReleased(evt);
            }
        });

        dateChooser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dateChooserKeyReleased(evt);
            }
        });

        jLabel10.setText("Filter by Text:");

        filterF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterFKeyReleased(evt);
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

        filterCBM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Filter by positions", "W", "M" }));
        filterCBM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterCBMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveB)
                            .addComponent(cancelB))
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(jLabel5)))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(companycbm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelLayout.createSequentialGroup()
                                    .addComponent(locationcbm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(48, 48, 48)
                                    .addComponent(jLabel9))
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(salaryField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typeField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(upB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(downB)
                        .addGap(151, 151, 151)
                        .addComponent(filterCBM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jLabel10)
                        .addGap(37, 37, 37)
                        .addComponent(filterF, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 65, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(descriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(deleteB))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(486, 486, 486)
                .addComponent(mistake, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 393, Short.MAX_VALUE))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(categorycbm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelB)
                            .addComponent(jLabel6)
                            .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(companycbm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(salaryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(typeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteB)
                            .addComponent(jLabel3)
                            .addComponent(descriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addGap(17, 17, 17)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(categorycbm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(upB)
                    .addComponent(jLabel10)
                    .addComponent(filterF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(downB)
                    .addComponent(filterCBM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mistake, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBActionPerformed
        // TODO add your handling code here:
        try{
            if(titleField.getText().trim().isEmpty()   || descriptionField.getText().trim().isEmpty() || 
                typeField.getText().trim().isEmpty()
                || categorycbm.getSelectedIndex() == 0  || locationcbm.getSelectedIndex() == 0  || companycbm.getSelectedIndex() == 0 || salaryField.getText().trim().isEmpty()
                    || dateChooser.getDate() == null) {
            mistake.setText("All of the fields shoul be filled");
        }
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
private void filter(String query){
       //DefaultTableModel dtm = (DefaultTableModel)table.getModel();
        TableRowSorter<JobTableModel> tr;
        tr = new  TableRowSorter<JobTableModel>((JobTableModel) table.getModel());
        table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
        
        
    }

  private void filterCBM(String query){
    TableRowSorter<JobTableModel> tr;
        tr = new  TableRowSorter<JobTableModel>((JobTableModel) table.getModel());
        
        table.setRowSorter(tr);
        if(query !="Filter by positions"){
        tr.setRowFilter(RowFilter.regexFilter(query));
        }
     }
    
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

    private void titleFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_titleFieldKeyReleased
mistake.setText(" ");        // TODO add your handling code here:
    }//GEN-LAST:event_titleFieldKeyReleased

    private void descriptionFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descriptionFieldKeyReleased
mistake.setText(" ");        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionFieldKeyReleased

    private void categorycbmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_categorycbmKeyReleased
mistake.setText(" ");        // TODO add your handling code here:
    }//GEN-LAST:event_categorycbmKeyReleased

    private void locationcbmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_locationcbmKeyReleased
mistake.setText(" ");        // TODO add your handling code here:
    }//GEN-LAST:event_locationcbmKeyReleased

    private void companycbmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_companycbmKeyReleased
mistake.setText(" ");        // TODO add your handling code here:
    }//GEN-LAST:event_companycbmKeyReleased

    private void typeFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_typeFieldKeyReleased
mistake.setText(" ");        // TODO add your handling code here:
    }//GEN-LAST:event_typeFieldKeyReleased

    private void salaryFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salaryFieldKeyReleased
mistake.setText(" ");        // TODO add your handling code here:
    }//GEN-LAST:event_salaryFieldKeyReleased

    private void dateChooserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateChooserKeyReleased
mistake.setText(" ");        // TODO add your handling code here:
    }//GEN-LAST:event_dateChooserKeyReleased

    private void filterFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterFKeyReleased
        // TODO add your handling code here:
        String query =filterF.getText();
        filter(query);
    }//GEN-LAST:event_filterFKeyReleased

    private void upBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upBActionPerformed
        // TODO add your handling code here:
         JobTableModel model = (JobTableModel) table.getModel();
        model.pageUp();
         if (model.getPageOffset() == 0) {
          upB.setEnabled(false);
        }else{
        downB.setEnabled(true);}
    }//GEN-LAST:event_upBActionPerformed

    private void downBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downBActionPerformed
        // TODO add your handling code here:
           JobTableModel model = (JobTableModel) table.getModel();
        model.pageDown();
           // If we hit the bottom of the data, disable the down button.
        if (model.getPageOffset() == (model.getPageCount() - 1)) {
          downB.setEnabled(false);
        }else{
        upB.setEnabled(true);
      }
    }//GEN-LAST:event_downBActionPerformed

    private void filterCBMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterCBMActionPerformed
        // TODO add your handling code here:
         String query = filterCBM.getSelectedItem().toString();
        filterCBM(query);
    }//GEN-LAST:event_filterCBMActionPerformed
 private void sort(){
     TableRowSorter<JobTableModel> tr;
        tr = new  TableRowSorter<JobTableModel>((JobTableModel) table.getModel());
        table.setRowSorter(tr);
     
     
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelB;
    private javax.swing.JComboBox categorycbm;
    private javax.swing.JComboBox companycbm;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JButton deleteB;
    private javax.swing.JTextField descriptionField;
    private javax.swing.JButton downB;
    private javax.swing.JComboBox filterCBM;
    private javax.swing.JTextField filterF;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel mistake;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField salaryField;
    private javax.swing.JButton saveB;
    private javax.swing.JTable table;
    private javax.swing.JTextField titleField;
    private javax.swing.JTextField typeField;
    private javax.swing.JButton upB;
    // End of variables declaration//GEN-END:variables
}
