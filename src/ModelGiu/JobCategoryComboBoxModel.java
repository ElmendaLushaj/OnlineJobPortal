/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelGiu;

import BLL.JobCategory;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author DELL
 */
public class JobCategoryComboBoxModel extends AbstractListModel<JobCategory>  implements ComboBoxModel<JobCategory> {
       private List <JobCategory> teDhenat;
    private JobCategory selectedItem;
    
    public JobCategoryComboBoxModel(){}
    
    public JobCategoryComboBoxModel(List <JobCategory> teDhenat){
    this.teDhenat = teDhenat;
    }
    
    public void add (List <JobCategory> teDhenat){
    this.teDhenat = teDhenat;
    }
    
    @Override
    public int getSize(){
    return teDhenat.size();
    }
    public JobCategory getElementAt(int index){
    return teDhenat.get(index);
    }
    public void  setSelectedItem(Object anItem){
    selectedItem = (JobCategory)anItem;
    }
    
   

    @Override
    public Object getSelectedItem() {
        return  selectedItem; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
