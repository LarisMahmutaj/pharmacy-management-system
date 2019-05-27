/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Role;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Laris
 */
public class RoleRepository extends EntMngClass implements RoleInterface {

    @Override
    public void create(Role p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Role p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Role p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Role> findAll() throws PharmacyException {
        try {
            return em.createNamedQuery("Role.findAll").getResultList();
        } catch (Exception e) {
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Role findByID(Integer ID) throws PharmacyException {
        try {
            Query q = em.createQuery("Select p from Role p where p.id=:id");
            q.setParameter("id", ID);
            return (Role) q.getSingleResult();
        } catch (Exception e) {
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Role loginByUsernameAndPassword(String u, String p) throws PharmacyException {
        try {
            Query q = em.createQuery("Select u from Role u where u.userName=:un AND u.password=:psw");
            q.setParameter("un", u);
            q.setParameter("psw", p);
            return (Role) q.getSingleResult();
        } catch (Exception e) {
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }

}
