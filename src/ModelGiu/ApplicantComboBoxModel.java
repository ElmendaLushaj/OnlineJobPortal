/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelGiu;

import BLL.Applicant;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author DELL
 */
public class ApplicantComboBoxModel extends AbstractListModel<Applicant>  implements ComboBoxModel<Applicant> {
    
    private List <Applicant> teDhenat;
    private Applicant selectedItem;
    
    public ApplicantComboBoxModel(){}
    
    public ApplicantComboBoxModel(List <Applicant> teDhenat){
    this.teDhenat = teDhenat;
    }
    
    public void add (List <Applicant> teDhenat){
    this.teDhenat = teDhenat;
    }
    
    @Override
    public int getSize(){
    return teDhenat.size();
    }
    public Applicant getElementAt(int index){
    return teDhenat.get(index);
    }
    public void  setSelectedItem(Object anItem){
    selectedItem = (Applicant)anItem;
    }
    
   

    @Override
    public Object getSelectedItem() {
        return  selectedItem; //To change body of generated methods, choose Tools | Templates.
    }
    
}
    

