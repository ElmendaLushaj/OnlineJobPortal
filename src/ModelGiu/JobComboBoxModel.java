/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelGiu;

import BLL.Job;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author DELL
 */
public class JobComboBoxModel extends AbstractListModel<Job>  implements ComboBoxModel<Job> {
     private List <Job> teDhenat;
    private Job selectedItem;
    
    public JobComboBoxModel(){}
    
    public JobComboBoxModel(List <Job> teDhenat){
    this.teDhenat = teDhenat;
    }
    
    public void add (List <Job> teDhenat){
    this.teDhenat = teDhenat;
    }
    
    @Override
    public int getSize(){
    return teDhenat.size();
    }
    public Job getElementAt(int index){
    return teDhenat.get(index);
    }
    public void  setSelectedItem(Object anItem){
    selectedItem = (Job)anItem;
    }
    
   

    @Override
    public Object getSelectedItem() {
        return  selectedItem; //To change body of generated methods, choose Tools | Templates.
    }
    
}
