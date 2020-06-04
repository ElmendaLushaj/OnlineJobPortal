/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelGiu;

import BLL.ApplicationDetails;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DELL
 */ 
public class ApplicationDetailsTableModel extends AbstractTableModel{
    
    List <ApplicationDetails> lista;
    String [] kolonat = {"Application_ID" , "Job_Id" , "Applicant_ID"};
    
    public ApplicationDetailsTableModel(){}
    
    public ApplicationDetailsTableModel(List <ApplicationDetails> lista){
     this.lista=lista;
    }
    
    public void addList(List <ApplicationDetails> lista){
    this.lista=lista;
    }
    
     
    @Override
    public String getColumnName(int col){
    return kolonat[col];
    }
   
    public void remove(int row){
        lista.remove(row);
        
    }
     @Override
     public int getRowCount(){
     return lista.size();
     }
     public ApplicationDetails getApplicationDetails(int i){
     return lista.get(i);
     }
     @Override
     public int getColumnCount(){
     return kolonat.length;}
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ApplicationDetails ad = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return ad.getApplicationID();
            case 1:
                return ad.getJobID();
            case 2:
                return ad.getApplicantID();
            default:
                return null;
        }
    }
    
}
