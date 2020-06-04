/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Applicant;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface ApplicantInterface {
   void create (Applicant e) throws AppFormException;
   void delete (Applicant e) throws AppFormException;
   void edit (Applicant e) throws AppFormException;
   
   List <Applicant> findAll() throws AppFormException;
   Applicant findByID (Integer ID ) throws AppFormException;
   
    
}
