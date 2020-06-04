/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelGiu;

import BLL.Employer;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author DELL
 */
public class EmployerComboBoxModel extends AbstractListModel<Employer> implements ComboBoxModel<Employer> {
     private List <Employer> teDhenat;
    private Employer selectedItem;
    
    public EmployerComboBoxModel(){
    }
    
    public EmployerComboBoxModel(List <Employer> teDhenat){
    this.teDhenat = teDhenat;
    }
    
    public void add (List <Employer> teDhenat){
    this.teDhenat = teDhenat;
    }
    @Override
    public int getSize(){
    return teDhenat.size();
    }
    public Employer getElementAt(int index){
    return teDhenat.get(index);
    }
    public void  setSelectedItem(Object anItem){
    selectedItem = (Employer)anItem;
    }
    
   

    @Override
    public Object getSelectedItem() {
        return  selectedItem; //To change body of generated methods, choose Tools | Templates.
    }
    
}
