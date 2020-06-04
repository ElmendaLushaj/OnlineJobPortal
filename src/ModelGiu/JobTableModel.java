/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelGiu;

import BLL.Job;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DELL
 */
public class JobTableModel extends AbstractTableModel{
    
    List <Job> listaa;
    String [] kolonat = {"Job ID","Job Title","Job Description","Category Id","Location Id", "Company Id","Job type","Job salary","Posting Date"};
    
   public JobTableModel(){
    }
    public JobTableModel(List<Job> listaa){
    this.listaa= listaa;
    }
    
    public void addList(List<Job>listaa){
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
     public Job getJob(int i){
     return listaa.get(i);
     }
     @Override
     public int getColumnCount(){
     return kolonat.length;}
     
     
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    Job j=listaa.get(rowIndex);
    switch(columnIndex){
        case 0:
            return j.getJobID();
          case 1:  
            return j.getJobTitle();
        case 2:
            return j.getJobDescription();
        case 3:
            return j.getCategoryID();
        case 4:
            return j.getLocationID(); 
        case 5:
            return j.getCompanyID();
        case 6:
            return j.getJobType();
        case 7:
            return j.getJobSalary();
        case 8:
            return j.getPostingDate();
      
            
        default:
            return null;
    }
    }
}
