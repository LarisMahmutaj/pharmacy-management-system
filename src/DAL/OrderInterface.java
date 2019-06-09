/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Orders;
import java.util.List;

/**
 *
 * @author Laris
 */
public interface OrderInterface {
       void create(Orders p) throws PharmacyException;
    void edit(Orders p) throws PharmacyException;
    void delete(Orders p) throws PharmacyException;
    List<Orders> findAll() throws PharmacyException;
    Orders findByID(Integer ID) throws PharmacyException;
}
