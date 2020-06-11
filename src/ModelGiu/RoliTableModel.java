/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelGiu;

import BLL.Roli;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DELL
 */
public class RoliTableModel extends  AbstractTableModel {
     List<Roli> listaa;
    String [] kolonat = {"ID:" , "Emertimi:" };
    
    public RoliTableModel(){
    }
    public RoliTableModel(List<Roli> listaa){
    this.listaa= listaa;
    }
    
    public void addList(List<Roli>listaa){
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
     public Roli getRoli(int i){
     return listaa.get(i);
     }
     @Override
     public int getColumnCount(){
     return kolonat.length;}
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Roli p = listaa.get(rowIndex);
        switch(columnIndex){
            case 0:
                return p.getId();
            case 1:
                return p.getEmertimi();
            
            default:
                return null;
        }
    }
}
