/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Invoice;
import BLL.Item;
import java.util.List;

/**
 *
 * @author Laris
 */
public interface ItemInterface {

    void create(Item p) throws PharmacyException;

    void edit(Item p) throws PharmacyException;

    void delete(Item p) throws PharmacyException;

    List<Item> findAll() throws PharmacyException;

    Item findByID(Integer ID) throws PharmacyException;
    
    List<Item> findByInvoiceID(Invoice ID) throws PharmacyException;
}
