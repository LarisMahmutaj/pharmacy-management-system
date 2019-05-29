/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Customer;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Laris
 */
public class CustomerRepository extends EntMngClass implements CustomerInterface {

    @Override
    public void create(Customer p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Customer p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Customer p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Customer> findAll() throws PharmacyException {
        try {
            return em.createNamedQuery("Customer.findAll").getResultList();
        } catch (Exception e) {
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Customer findByID(Integer ID) throws PharmacyException {
        try {
            Query q = em.createQuery("Select p from Customer p where p.id=:id");
            q.setParameter("id", ID);
            return (Customer) q.getSingleResult();
        } catch (Exception e) {
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }
}
