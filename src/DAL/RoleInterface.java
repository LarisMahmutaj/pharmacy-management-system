/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Role;
import java.util.List;

/**
 *
 * @author Laris
 */
public interface RoleInterface {
       void create(Role p) throws PharmacyException;
    void edit(Role p) throws PharmacyException;
    void delete(Role p) throws PharmacyException;
    List<Role> findAll() throws PharmacyException;
    Role findByID(Integer ID) throws PharmacyException;
}
