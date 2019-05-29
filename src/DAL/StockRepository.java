/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Stock;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Laris
 */
public class StockRepository extends EntMngClass implements StockInterface {

    @Override
    public void create(Stock p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Stock p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Stock p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Stock> findAll() throws PharmacyException {
        try {
            return em.createNamedQuery("Stock.findAll").getResultList();
        } catch (Exception e) {
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Stock findByID(Integer ID) throws PharmacyException {
        try {
            Query q = em.createQuery("Select p from Stock p where p.id=:id");
            q.setParameter("id", ID);
            return (Stock) q.getSingleResult();
        } catch (Exception e) {
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }
}
