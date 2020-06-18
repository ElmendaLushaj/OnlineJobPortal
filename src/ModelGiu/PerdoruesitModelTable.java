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
    String [] kolonat = {"ID:" , "Username:" , "Password:", "Rol ID:"};
    
     protected int pageSize;

  protected int pageOffset;
    
    public PerdoruesitModelTable(){
    }
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
     return Math.min(pageSize, listaa.size());
     }
     public Perdoruesi getPerdoruesi(int i){
     return listaa.get(i);
     }
     @Override
     public int getColumnCount(){
     return kolonat.length;}
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         int realRow = rowIndex + (pageOffset * pageSize);
        Perdoruesi p = listaa.get(realRow);
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
