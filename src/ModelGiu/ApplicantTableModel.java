/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelGiu;

import BLL.Applicant;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DELL
 */
public class ApplicantTableModel  extends AbstractTableModel{
    List <Applicant> lista;
    String [] kolonat = {"Applicant_ID" , "Name" , "Gender" , "Email" , "Contact" , "PS"};
    
    public ApplicantTableModel(){}
    
    public ApplicantTableModel(List <Applicant> lista){
    this.lista = lista;
    }
    
    public void addList(List <Applicant> lista){
    this.lista = lista;
    }
    
     @Override
    public String getColumnName(int col){
        return kolonat[col];
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }
    
    public void remove(int row){
        lista.remove(row);
    }
    public Applicant getApplicant(int index){
    return lista.get(index);
    }
    
    public int getColumnCount(){
    return kolonat.length;
    
    }
     public Object getValueAt(int rowI, int columnI) {
        Applicant a = lista.get(rowI);
        switch (columnI) {
            case 0:
                return a.getApplicantID();
                  case 1:
                return a.getAName();
            case 2:
                return a.getGender();
            case 3:
                return a.getAEmail();
               
            case 4:
                return a.getAContact();
                  case 5:
                return a.getProfessionalSummary();
            default:
                return null;

        }
    }
    
}
