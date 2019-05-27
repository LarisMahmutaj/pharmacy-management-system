/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Medicine;
import java.util.List;

/**
 *
 * @author Laris
 */
public interface MedicineInterface {
       void create(Medicine p) throws PharmacyException;
    void edit(Medicine p) throws PharmacyException;
    void delete(Medicine p) throws PharmacyException;
    List<Medicine> findAll() throws PharmacyException;
    Medicine findByID(Integer ID) throws PharmacyException;
}
