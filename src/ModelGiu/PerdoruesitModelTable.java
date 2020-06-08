/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelGiu;

import BLL.Perdoruesi;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DELL
 */
public class PerdoruesitModelTable extends AbstractTableModel{
    List<Perdoruesi> listaa;
    String [] kolonat = {"Role ID:" , "Username:" , "Password:"};
    
    public PerdoruesitModelTable(){
    }
    public PerdoruesitModelTable(List<Perdoruesi> listaa){
    this.listaa= listaa;
    }
    
    public void addList(List<Perdoruesi>listaa){
    this.listaa = listaa;
    }
    
    @Override
    public String getColumnName(int col){
    return kolonat[col];
    }
   
    public void remove(int row){
        listaa.remove(row);
        
    }
     @Override
     public int getRowCount(){
     return listaa.size();
     }
     public Perdoruesi getPerdoruesi(int i){
     return listaa.get(i);
     }
     @Override
     public int getColumnCount(){
     return kolonat.length;}
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Perdoruesi p = listaa.get(rowIndex);
        switch(columnIndex){
            case 0:
                return p.getId();
            case 1:
                return p.getUsername();
            case 2:
                return p.getPassword();
            case 3:
                return p.getRoliID();
            default:
                return null;
        }
    }
    
}
