/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelGiu;

import BLL.Roli;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author DELL
 */
public class RoliComboBoxModel extends AbstractListModel<Roli>  implements ComboBoxModel<Roli>{
         private List <Roli> teDhenat;
    private Roli selectedItem;
    
    public RoliComboBoxModel(){}
    
    public RoliComboBoxModel(List <Roli> teDhenat){
    this.teDhenat = teDhenat;
    }
    
    public void add (List <Roli> teDhenat){
    this.teDhenat = teDhenat;
    }
    
    @Override
    public int getSize(){
    return teDhenat.size();
    }
    public Roli getElementAt(int index){
    return teDhenat.get(index);
    }
    public void  setSelectedItem(Object anItem){
    selectedItem = (Roli)anItem;
    }
    
   

    @Override
    public Object getSelectedItem() {
        return  selectedItem; //To change body of generated methods, choose Tools | Templates.
    }
}
