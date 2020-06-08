/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Perdoruesi;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface PerdoruesiInteerface {
    
    void create(Perdoruesi p) throws AppFormException;
    void edit(Perdoruesi p) throws AppFormException;
    void delete(Perdoruesi p) throws AppFormException;
    List<Perdoruesi> findAll() throws AppFormException;
    Perdoruesi findByID(Integer ID) throws AppFormException;
    Perdoruesi loginByUsernameAndPassword(String u, String p) throws AppFormException;
}
