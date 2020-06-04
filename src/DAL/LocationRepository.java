/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Location;
import java.util.List;

/**
 *
 * @author DELL
 */
public class LocationRepository extends EntMngClass implements LocationInterface {
     public void create (Location l)throws AppFormException{
     try{
     em.getTransaction().begin();
     em.persist(l);
     em.getTransaction().commit();
     
     }
     catch(Exception e){
            throw new AppFormException("Msg \n" + e.getMessage());
        }
     
     }
       public void delete (Location l)throws AppFormException{
     try{
     em.getTransaction().begin();
     em.remove(l);
     em.getTransaction().commit();
     
     }
     catch(Exception e){
            throw new AppFormException("Msg \n" + e.getMessage());
        }
     
     }
         public void edit (Location l)throws AppFormException{
     try{
     em.getTransaction().begin();
     em.merge(l);
     em.getTransaction().commit();
     
     }
     catch(Exception e){
            throw new AppFormException("Msg \n" + e.getMessage());
        }
     
     }
           @Override
    public List<Location> findAll() throws AppFormException {
        try{
            return em.createNamedQuery("Location.findAll").getResultList();
        }catch(Exception e){
            throw new AppFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public Location findByID(Integer ID) throws AppFormException {
        throw new UnsupportedOperationException("Not supported yet. Ne javet ne vijim"); //To change body of generated methods, choose Tools | Templates.
    }
    
}
