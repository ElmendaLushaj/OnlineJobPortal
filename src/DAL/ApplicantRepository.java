/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Applicant;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author DELL
 */
public class ApplicantRepository extends EntMngClass implements ApplicantInterface {
    @Override
    public void create (Applicant a)throws AppFormException{
         try{
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
       
    }
    catch(Exception ex){
    throw new AppFormException("Msg \n"+ex.getMessage());
    }
   
    }
    
    @Override
    public void delete(Applicant a)throws AppFormException{
         try{
     em.getTransaction().begin();
     em.remove(a);
     em.getTransaction().commit();
    }catch(Exception ex){
    throw new AppFormException("Msg \n"+ex.getMessage());
    }
    
    }
    
     @Override
    public void edit(Applicant a)throws AppFormException{
    try{
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
       
    } catch(Exception ex){
    throw new AppFormException("Msg \n"+ex.getMessage());
    }
}
     public List <Applicant>findAll() throws AppFormException{
        try{
        return em.createNamedQuery("Applicant.findAll").getResultList();
        }catch (Exception ex){
            throw new AppFormException("Msg \n"+ex.getMessage());
        
        }
    
    }
    
    public Applicant findByID(Integer ID) throws AppFormException{
   try {
            Query query = em.createQuery("SELECT p FROM Applicant p WHERE p.ID = :abc");
            query.setParameter("abc", ID);
            return (Applicant) query.getSingleResult();
        } catch (Exception e) {
            throw new AppFormException("Msg! \n" + e.getMessage());
        }
    }
    }

