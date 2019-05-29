/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Stock;
import java.util.List;

/**
 *
 * @author Laris
 */
public interface StockInterface {
    void create(Stock p) throws PharmacyException;
    void edit(Stock p) throws PharmacyException;
    void delete(Stock p) throws PharmacyException;
    List<Stock> findAll() throws PharmacyException;
    Stock findByID(Integer ID) throws PharmacyException;
}
