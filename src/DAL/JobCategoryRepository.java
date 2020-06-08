/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.JobCategory;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author DELL
 */
public class JobCategoryRepository extends EntMngClass{
         public List <JobCategory> findAll() throws AppFormException{
        try{
        return em.createNamedQuery("JobCategory.findAll").getResultList();
        }catch (Exception ex){
            throw new AppFormException("Msg \n"+ex.getMessage());
        
        }
    
    }
    
    public JobCategory findByID(Integer ID) throws AppFormException{
         try {
            Query query = em.createQuery("SELECT p FROM Perdoruesi p WHERE p.ID = :abc");
            query.setParameter("abc", ID);
            return (JobCategory) query.getSingleResult();
        } catch (Exception e) {
            throw new AppFormException("Msg! \n" + e.getMessage());
        }
    }
}
