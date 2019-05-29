/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Customer;
import java.util.List;

/**
 *
 * @author Laris
 */
public interface CustomerInterface {
    void create(Customer p) throws PharmacyException;
    void edit(Customer p) throws PharmacyException;
    void delete(Customer p) throws PharmacyException;
    List<Customer> findAll() throws PharmacyException;
    Customer findByID(Integer ID) throws PharmacyException;
}
