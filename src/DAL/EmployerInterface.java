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
public interface EmployerInterface {
    void create (Employer e)throws AppFormException;  
 void edit (Employer e)throws AppFormException;
 void delete (Employer e)throws AppFormException;
 List <Employer> findAll() throws AppFormException;
 Employer findByID (Integer ID) throws AppFormException;
    
}
