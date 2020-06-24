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
    String [] kolonat = {"Employer_Id" , "Name" , "Contact", "Email" , "Picture Path"};
    protected int pageSize;
    protected int pageOffset;
    
    public EmployerTableModel(){}
     public int getPageOffset() {
    return pageOffset;
  }
      public int getPageCount() {
    return (int) Math.ceil((double) list.size() / pageSize);
  }
      
      
   public void setPageSize(int s ) {
       
   
 
    int oldPageSize = pageSize;
    pageSize = s;
    pageOffset = (oldPageSize * pageOffset) / pageSize;
    fireTableDataChanged();
}
    
      /*if (pageSize < oldPageSize) { fireTableRowsDeleted(pageSize,
      oldPageSize - 1); } else { fireTableRowsInserted(oldPageSize,
      pageSize - 1); }
     */


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
        return Math.min(5, list.size());
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
      
        int realRow = rowI + (pageOffset * pageSize);
        Employer e = list.get(realRow);
        switch (columnI) {
            case 0:
                return e.getEmployerID();
            case 1:
                return e.getEName();
            case 2:
                return e.getEContact();
            case 3:
                return e.getEEmail();
            case 4:
                return e.getImg();
            default:
                return null;

        
    

    
        }
    }
}

