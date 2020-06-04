/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.JobCategory;
import java.util.List;

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
    throw new UnsupportedOperationException("Not supported yet.");
    }
}
