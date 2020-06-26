/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelView;

import BLL.Employer;
import DAL.AppFormException;
import DAL.EmployerRepository;
import ModelGiu.EmployerTableModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;
import static sun.swing.MenuItemLayoutHelper.max;

/**
 *
 * @author DELL
 */
public class EmployerListForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form EmployerListForm
     */
    public EmployerListForm() {
        initComponents();
        loadTable();
        sort();
    }
 EmployerRepository er = new EmployerRepository();
    EmployerTableModel etm = new EmployerTableModel();
    
    public void loadTable(){
        try{
           // int siz
            List<Employer> lista = er.findAll();
           // etm.setPageNumber(10);
          // etm.withMaxPageSize(5);
            etm.setPageSize(5);
            etm.addList(lista);
            table1.setModel(etm);
            etm.fireTableDataChanged();
        }catch(AppFormException ex){
            Logger.getLogger(EmployerForm.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
     private void sort(){
     TableRowSorter<EmployerTableModel> tr;
        tr = new  TableRowSorter<EmployerTableModel>((EmployerTableModel) table1.getModel());
        table.setRowSorter(tr);
     
     
     }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        filterF = new javax.swing.JTextField();
        upB = new javax.swing.JButton();
        downB = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();

        jLabel1.setText("jLabel1");

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

        jLabel2.setText("Filter with Text:");

        filterF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterFKeyReleased(evt);
            }
        });

        upB.setText("previous");
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

        table1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(table1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(filterF, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addComponent(upB)
                .addGap(18, 18, 18)
                .addComponent(downB)
                .addGap(316, 316, 316))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(filterF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(upB)
                    .addComponent(downB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void filter(String query){
       //DefaultTableModel dtm = (DefaultTableModel)table.getModel();
        TableRowSorter<EmployerTableModel> tr;
        tr = new  TableRowSorter<EmployerTableModel>((EmployerTableModel) table1.getModel());
        table1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
        
        
    }
    private void filterFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterFKeyReleased
        // TODO add your handling code here:
           String query =filterF.getText();
           filter(query);
    }//GEN-LAST:event_filterFKeyReleased

    private void upBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upBActionPerformed
        // TODO add your handling code here:
        EmployerTableModel model = (EmployerTableModel) table1.getModel();
        model.pageUp();
        if (model.getPageOffset() == 0) {
            upB.setEnabled(false);
        }else{
            downB.setEnabled(true);
        }
    }//GEN-LAST:event_upBActionPerformed

    private void downBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downBActionPerformed
        // TODO add your handling code here
        EmployerTableModel model = (EmployerTableModel) table1.getModel();
        model.pageDown();
        // If we hit the bottom of the data, disable the down button.
        if (model.getPageOffset() == (model.getPageCount() - 1)) {
            downB.setEnabled(false);
        }else{
            upB.setEnabled(true);
        }
    }//GEN-LAST:event_downBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton downB;
    private javax.swing.JTextField filterF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    private javax.swing.JTable table1;
    private javax.swing.JButton upB;
    // End of variables declaration//GEN-END:variables
}
