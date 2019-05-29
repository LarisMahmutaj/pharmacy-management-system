/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Status;
import java.util.List;

/**
 *
 * @author Laris
 */
public interface StatusInterface {
    void create(Status p) throws PharmacyException;
    void edit(Status p) throws PharmacyException;
    void delete(Status p) throws PharmacyException;
    List<Status> findAll() throws PharmacyException;
    Status findByID(Integer ID) throws PharmacyException;
}
