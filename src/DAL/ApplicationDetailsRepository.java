/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.ApplicationDetails;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ApplicationDetailsRepository extends EntMngClass implements ApplicationDetailsInterface {

    public void create(ApplicationDetails ad) throws AppFormException {
        try {
            em.getTransaction().begin();
            em.persist(ad);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw new AppFormException("Message /n" + e.getMessage());

        }

    }

    public void edit(ApplicationDetails ad) throws AppFormException {
        try {
            em.getTransaction().begin();
            em.merge(ad);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw new AppFormException("Message" + e.getMessage());
        }

    }
    public void delete (ApplicationDetails ad)throws AppFormException{
    try{
    em.getTransaction().begin();
    em.remove(ad);
    em.getTransaction().commit();
    
    
    }catch(Exception e){
    throw new AppFormException("Message"+e.getMessage());
    
    }
    
    
    }
    
    public List <ApplicationDetails> findAll()throws AppFormException{
    
    try{
    return em.createNamedQuery("ApplicationDetails.findAll").getResultList();
            }
    catch(Exception e){
    throw new AppFormException("Message"+e.getMessage());
    }
    
    
    
    }
    
    public ApplicationDetails findByID(Integer ID)throws AppFormException{
    throw new UnsupportedOperationException("Hala se jena bo");
    }
    
}
