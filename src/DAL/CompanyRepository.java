/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Company;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author DELL
 */
public class CompanyRepository  extends EntMngClass{
         public List <Company>findAll() throws AppFormException{
        try{
        return em.createNamedQuery("Company.findAll").getResultList();
        }catch (Exception ex){
            throw new AppFormException("Msg \n"+ex.getMessage());
        
        }
    
    }
    
    public Company findByID(Integer ID) throws AppFormException{
          try {
            Query query = em.createQuery("SELECT p FROM Company p WHERE p.ID = :abc");
            query.setParameter("abc", ID);
            return (Company) query.getSingleResult();
        } catch (Exception e) {
            throw new AppFormException("Msg! \n" + e.getMessage());
        }
    }
}
