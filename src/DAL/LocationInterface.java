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
public interface LocationInterface {
    void create (Location l)throws AppFormException;
    void edit (Location l)throws AppFormException;
    void delete (Location l)throws AppFormException;
    List<Location> findAll() throws AppFormException;
    Location findByID(Integer ID) throws AppFormException;
}
