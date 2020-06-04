/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelGiu;

import BLL.Location;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author DELL
 */
public class LoationComboBoxModel extends AbstractListModel<Location>  implements ComboBoxModel<Location>{
     private List <Location> teDhenat;
    private Location selectedItem;
    
    public LoationComboBoxModel(){}
    
    public LoationComboBoxModel(List <Location> teDhenat){
    this.teDhenat = teDhenat;
    }
    
    public void add (List <Location> teDhenat){
    this.teDhenat = teDhenat;
    }
    
    @Override
    public int getSize(){
    return teDhenat.size();
    }
    public Location getElementAt(int index){
    return teDhenat.get(index);
    }
    public void  setSelectedItem(Object anItem){
    selectedItem = (Location)anItem;
    }
    
   

    @Override
    public Object getSelectedItem() {
        return  selectedItem; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
