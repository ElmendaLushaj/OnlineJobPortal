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
        return  Math.min(pageSize, lista.size());
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
        int realRow = rowI+ (pageOffset * pageSize);
        Applicant a = lista.get(realRow);
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
