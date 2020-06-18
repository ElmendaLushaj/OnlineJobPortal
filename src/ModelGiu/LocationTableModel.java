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
 
    protected int pageSize;

  protected int pageOffset;
  
  
      public int getPageOffset() {
    return pageOffset;
  }
      public int getPageCount() {
    return (int) Math.ceil((double) listaa.size() / pageSize);
  }
   public void setPageSize(int s) {
    if (s == pageSize) {
      return;
    }
    int oldPageSize = pageSize;
    pageSize = s;
    pageOffset = (oldPageSize * pageOffset) / pageSize;
    fireTableDataChanged();
    /*
     * if (pageSize < oldPageSize) { fireTableRowsDeleted(pageSize,
     * oldPageSize - 1); } else { fireTableRowsInserted(oldPageSize,
     * pageSize - 1); }
     */
  }
  public void pageDown() {
    if (pageOffset < getPageCount() - 1) {
      pageOffset++;
      fireTableDataChanged();
    }
  }

  // Update the page offset and fire a data changed (all rows).
  public void pageUp() {
    if (pageOffset > 0) {
      pageOffset--;
      fireTableDataChanged();
    }
  }
    public LocationTableModel(){
    }
    public LocationTableModel(List<Location> listaa){
    this.listaa= listaa;
    }
    
    public void addList(List<Location>listaa){
    this.listaa = listaa;
    }
    
    //@Override
    public String getColumnName(int col){
    return kolonat[col];
    }
   
    public void remove(int row){
        listaa.remove(row);
        
    }
     @Override
     public int getRowCount(){
     return Math.min(pageSize, listaa.size());
     }
     public Location getLocation(int i){
     return listaa.get(i);
     }
     @Override
     public int getColumnCount(){
     return kolonat.length;}
     
   
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int realRow = rowIndex + (pageOffset * pageSize);
        Location l = listaa.get(realRow);
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
