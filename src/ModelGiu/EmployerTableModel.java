/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelGiu;

import BLL.Employer;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DELL
 */
public class EmployerTableModel extends AbstractTableModel{
    List<Employer>list;
    String [] kolonat = {"Employer_Id" , "Name" , "Contact", "Email"};
    
    public EmployerTableModel(){}
    
    public EmployerTableModel(List <Employer> list){
    this.list = list;
    }
    
    public void addList (List<Employer>list){
    this.list = list;
    }
    @Override
    public String getColumnName(int col){
        return kolonat[col];
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }
    
    public void remove(int row){
        list.remove(row);
    }
    public Employer getEmployer(int index){
    return list.get(index);
    }
    
    public int getColumnCount(){
    return kolonat.length;
    
    }
    
    public Object getValueAt(int rowI, int columnI) {
        Employer e = list.get(rowI);
        switch (columnI) {
            case 0:
                return e.getEmployerID();
            case 1:
                return e.getEName();
            case 2:
                return e.getEContact();
            case 3:
                return e.getEEmail();
            default:
                return null;

        }
    }
}
