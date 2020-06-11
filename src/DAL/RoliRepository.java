/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Roli;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author DELL
 */
public class RoliRepository extends EntMngClass{
    public List<Roli> findAll() throws AppFormException {
        try {
            return em.createNamedQuery("Roli.findAll").getResultList();
        } catch (Exception e) {
            throw new AppFormException("Msg! \n" + e.getMessage());
        }
    }
     public Roli findByID(Integer ID) throws AppFormException {
        try {
            Query query = em.createQuery("SELECT p FROM Roli p WHERE p.ID = :abc");
            query.setParameter("abc", ID);
            return (Roli) query.getSingleResult();
        } catch (Exception e) {
            throw new AppFormException("Msg! \n" + e.getMessage());
        }
    }
    
}
