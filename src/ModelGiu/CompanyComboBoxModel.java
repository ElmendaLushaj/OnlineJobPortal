/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelGiu;

import BLL.Company;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author DELL
 */
public class CompanyComboBoxModel extends AbstractListModel<Company>  implements ComboBoxModel<Company>{
      private List <Company> teDhenat;
    private Company selectedItem;
    
    public CompanyComboBoxModel(){}
    
    public CompanyComboBoxModel(List <Company> teDhenat){
    this.teDhenat = teDhenat;
    }
    
    public void add (List <Company> teDhenat){
    this.teDhenat = teDhenat;
    }
    
    @Override
    public int getSize(){
    return teDhenat.size();
    }
    public Company getElementAt(int index){
    return teDhenat.get(index);
    }
    public void  setSelectedItem(Object anItem){
    selectedItem = (Company)anItem;
    }
    
   

    @Override
    public Object getSelectedItem() {
        return  selectedItem; //To change body of generated methods, choose Tools | Templates.
    }
    
}
