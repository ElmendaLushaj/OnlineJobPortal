/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Job;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface JobInterface {
     void create(Job j)throws AppFormException;
    void edit(Job j)throws AppFormException;
    void delete(Job j)throws AppFormException;
    List<Job>findAll()throws AppFormException;
    Job findByID(Integer ID)throws AppFormException;
}
