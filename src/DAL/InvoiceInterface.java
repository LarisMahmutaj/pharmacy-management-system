/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Invoice;
import java.util.List;

/**
 *
 * @author Laris
 */
public interface InvoiceInterface {

    void create(Invoice p) throws PharmacyException;

    void edit(Invoice p) throws PharmacyException;

    void delete(Invoice p) throws PharmacyException;

    List<Invoice> findAll() throws PharmacyException;

    Invoice findByID(Integer ID) throws PharmacyException;

}
