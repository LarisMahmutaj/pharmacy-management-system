/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Classification;
import java.util.List;

/**
 *
 * @author Laris
 */
public interface ClassificationInterface {
       void create(Classification p) throws PharmacyException;
    void edit(Classification p) throws PharmacyException;
    void delete(Classification p) throws PharmacyException;
    List<Classification> findAll() throws PharmacyException;
    Classification findByID(Integer ID) throws PharmacyException;
}
