/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Supplier;
import java.util.List;

/**
 *
 * @author Laris
 */
public interface SupplierInterface {
    void create(Supplier p) throws PharmacyException;
    void edit(Supplier p) throws PharmacyException;
    void delete(Supplier p) throws PharmacyException;
    List<Supplier> findAll() throws PharmacyException;
    Supplier findByID(Integer ID) throws PharmacyException;
}
