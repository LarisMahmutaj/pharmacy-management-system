/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Orders;
import BLL.Supplier;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Laris
 */
public class OrderRepository extends EntMngClass implements OrderInterface {

    @Override
    public void create(Orders p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Orders p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Orders p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Orders> findAll() throws PharmacyException {
        try {
            return em.createNamedQuery("Orders.findAll").getResultList();
        } catch (Exception e) {
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Orders findByID(Integer ID) throws PharmacyException {
        try {
            Query q = em.createQuery("SELECT p FROM Orders p WHERE p.id=:id");
            q.setParameter("id", ID);
            return (Orders) q.getSingleResult();
        } catch (Exception e) {
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }
    
    public List<Orders> findBySupplierID(Supplier supplierID) throws PharmacyException{
        try{
            Query q = em.createQuery("SELECT o FROM Orders o WHERE o.supplierID = :supplierID");
            q.setParameter("supplierID", supplierID);
            return q.getResultList();
        }catch(Exception e){
            throw new PharmacyException("Msg! \n" + e.getMessage()); 
        }
    }
}
