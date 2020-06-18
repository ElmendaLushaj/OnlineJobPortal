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
     protected int pageSize;
    protected int pageOffset;
    
       public int getPageOffset() {
    return pageOffset;
  }
      public int getPageCount() {
    return (int) Math.ceil((double) lista.size() / pageSize);
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
     return Math.min(pageSize, lista.size());
     }
     public ApplicationDetails getApplicationDetails(int i){
     return lista.get(i);
     }
     @Override
     public int getColumnCount(){
     return kolonat.length;}
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int realRow = rowIndex+ (pageOffset * pageSize);
        ApplicationDetails ad = lista.get(realRow);
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
