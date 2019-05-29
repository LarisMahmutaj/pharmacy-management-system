/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Supplier;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Laris
 */
public class SupplierRepository extends EntMngClass implements SupplierInterface {

    @Override
    public void create(Supplier p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Supplier p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Supplier p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Supplier> findAll() throws PharmacyException {
        try {
            return em.createNamedQuery("Supplier.findAll").getResultList();
        } catch (Exception e) {
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Supplier findByID(Integer ID) throws PharmacyException {
        try {
            Query q = em.createQuery("Select p from Supplier p where p.id=:id");
            q.setParameter("id", ID);
            return (Supplier) q.getSingleResult();
        } catch (Exception e) {
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }
}
