/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Employer;
import java.util.List;

/**
 *
 * @author DELL
 */
public class EmployerRepository extends EntMngClass implements EmployerInterface , Comparable<Employer>{
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
    throw new UnsupportedOperationException("Not supported yet.");
    }
    public int compareTo(Employer e){
    
    }
}
