/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelGiu;

import BLL.Location;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DELL
 */
public class LocationTableModel extends AbstractTableModel{
    List<Location> listaa;
    String [] kolonat = {"Location Id:" , "Location Name:" , "Employer Id:"};
    
    public LocationTableModel(){
    }
    public LocationTableModel(List<Location> listaa){
    this.listaa= listaa;
    }
    
    public void addList(List<Location>listaa){
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
     public Location getLocation(int i){
     return listaa.get(i);
     }
     @Override
     public int getColumnCount(){
     return kolonat.length;}
     
   
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Location l = listaa.get(rowIndex);
        switch(columnIndex){
            case 0:
                return l.getLocationID();
            case 1:
                return l.getLocationName();
            case 2:
                return l.getEmployerID();
            default:
                return null;
        }
    }
    
}
