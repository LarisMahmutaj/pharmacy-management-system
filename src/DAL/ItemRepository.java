/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Invoice;
import BLL.Item;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Laris
 */
public class ItemRepository extends EntMngClass implements ItemInterface {

    @Override
    public void create(Item p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Item p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Item p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Item> findAll() throws PharmacyException {
        try {
            return em.createNamedQuery("Item.findAll").getResultList();
        } catch (Exception e) {
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Item findByID(Integer ID) throws PharmacyException {
        try {
            Query q = em.createQuery("Select p from Item p where p.id=:id");
            q.setParameter("id", ID);
            return (Item) q.getSingleResult();
        } catch (Exception e) {
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }
    
    @Override
    public List<Item> findByInvoiceID(Invoice invoiceID) throws PharmacyException{
        try{
            Query q = em.createQuery("SELECT i FROM Item i WHERE i.invoiceID = :InvoiceID");
            q.setParameter("InvoiceID", invoiceID);
            return (List<Item>)q.getResultList();
        }catch(Exception e){
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }
}
