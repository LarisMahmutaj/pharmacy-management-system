/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import BLL.POS;
import BLL.Stock;
import java.util.List;

/**
 *
 * @author Agon
 */
public interface POSInterface {
//    void create(Status p) throws PharmacyException;
//    void edit(Status p) throws PharmacyException;
    void delete(POS s) throws PharmacyException;
    List<POS> findAll() throws PharmacyException;
    Stock findByID(Integer ID) throws PharmacyException;
    List<POS> findByName(String name) throws PharmacyException;
}
