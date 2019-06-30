/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Invoice;
import BLL.Sales;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Laris
 */
public class SalesRepository extends EntMngClass implements SalesInterface {

    @Override
    public void create(Sales p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Sales p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Sales p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Sales> findAll() throws PharmacyException {
        try {
            return em.createNamedQuery("Sales.findAll").getResultList();
        } catch (Exception e) {
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Sales findByID(Integer SalesID) throws PharmacyException {
        try {
            Query q = em.createQuery("SELECT p FROM Sales p WHERE p.statusID = :SalesID");
            q.setParameter("SalesID", SalesID);
            return (Sales) q.getSingleResult();
        } catch (Exception e) {
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }
    
    public Sales findByInvoiceId(Invoice invoiceId)throws PharmacyException{
        try{
            Query q = em.createQuery("SELECT s FROM Sales s WHERE s.invoiceID = :invoiceId");
            q.setParameter("invoiceId", invoiceId);
            return (Sales)q.getSingleResult();
        }catch(Exception e){
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }
}
