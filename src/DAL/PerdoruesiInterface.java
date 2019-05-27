/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Perdoruesi;
import java.util.List;

/**
 *
 * @author Laris
 */
public interface PerdoruesiInterface {
       void create(Perdoruesi p) throws PharmacyException;
    void edit(Perdoruesi p) throws PharmacyException;
    void delete(Perdoruesi p) throws PharmacyException;
    List<Perdoruesi> findAll() throws PharmacyException;
    Perdoruesi findByID(Integer ID) throws PharmacyException;
    Perdoruesi loginByUsernameAndPassword(String u,String p) throws PharmacyException;
}
