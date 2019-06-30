/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Sales;
import java.util.List;

/**
 *
 * @author Laris
 */
public interface SalesInterface {
    void create(Sales p) throws PharmacyException;
    void edit(Sales p) throws PharmacyException;
    void delete(Sales p) throws PharmacyException;
    List<Sales> findAll() throws PharmacyException;
    Sales findByID(Integer ID) throws PharmacyException;
}
