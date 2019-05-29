/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Status;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Laris
 */
public class StatusRepository extends EntMngClass implements StatusInterface {

    @Override
    public void create(Status p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Status p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Status p) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Status> findAll() throws PharmacyException {
        try {
            return em.createNamedQuery("Status.findAll").getResultList();
        } catch (Exception e) {
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Status findByID(Integer ID) throws PharmacyException {
        try {
            Query q = em.createQuery("Select p from Status p where p.id=:id");
            q.setParameter("id", ID);
            return (Status) q.getSingleResult();
        } catch (Exception e) {
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }
}
