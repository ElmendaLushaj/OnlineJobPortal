/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Employer;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author DELL
 */
public class EmployerRepository extends EntMngClass implements EmployerInterface {
     @Override
    public void create(Employer e)throws AppFormException{
    try{
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
       
    }
    catch(Exception ex){
    throw new AppFormException("Msg \n"+ex.getMessage());
    }
    
    }
    @Override
    public void edit(Employer e)throws AppFormException{
    try{
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
       
    }
    catch(Exception ex){
    throw new AppFormException("Msg \n"+ex.getMessage());
    }
    
    }
    @Override
    
    public void delete(Employer e)throws AppFormException{
    try{
     em.getTransaction().begin();
     em.remove(e);
     em.getTransaction().commit();
    }catch(Exception ex){
    throw new AppFormException("Msg \n"+ex.getMessage());
    }
    }
    
    public List <Employer>findAll() throws AppFormException{
        try{
        return em.createNamedQuery("Employer.findAll").getResultList();
        }catch (Exception ex){
            throw new AppFormException("Msg \n"+ex.getMessage());
        
        }
    
    }
    
    public Employer findByID(Integer ID) throws AppFormException{
        try {
            Query query = em.createQuery("SELECT p FROM Employer p WHERE p.ID = :abc");
            query.setParameter("abc", ID);
            return (Employer) query.getSingleResult();
        } catch (Exception e) {
            throw new AppFormException("Msg! \n" + e.getMessage());
        }
    }
  /*  public int compareTo(Employer e){
    
    }*/
}
