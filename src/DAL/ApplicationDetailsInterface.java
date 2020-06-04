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
public interface ApplicationDetailsInterface {
    void create (ApplicationDetails ad) throws AppFormException;
    void edit (ApplicationDetails ad) throws AppFormException;
    void delete (ApplicationDetails ad) throws AppFormException;
    List <ApplicationDetails> findAll() throws AppFormException;
    ApplicationDetails findByID(Integer ID) throws AppFormException;
    
}
