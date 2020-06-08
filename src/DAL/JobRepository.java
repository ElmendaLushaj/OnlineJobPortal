/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Job;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author DELL
 */
public class JobRepository  extends EntMngClass implements JobInterface{
     public void create(Job j) throws AppFormException {
        try {
            em.getTransaction().begin();
            em.persist(j);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new AppFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Job j) throws AppFormException {
        try {
            em.getTransaction().begin();
            em.merge(j);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new AppFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Job j) throws AppFormException {
          try {
            em.getTransaction().begin();
            em.remove(j);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new AppFormException("Msg \n" + e.getMessage());
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Job> findAll() throws AppFormException {
        try {
            return em.createNamedQuery("Job.findAll").getResultList();

        } catch (Exception e) {
            throw new AppFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public Job findByID(Integer ID) throws AppFormException {
              try {
            Query query = em.createQuery("SELECT p FROM Job p WHERE p.ID = :abc");
            query.setParameter("abc", ID);
            return (Job) query.getSingleResult();
        } catch (Exception e) {
            throw new AppFormException("Msg! \n" + e.getMessage());
        } //To change body of generated methods, choose Tools | Templates.
    }

    
}
