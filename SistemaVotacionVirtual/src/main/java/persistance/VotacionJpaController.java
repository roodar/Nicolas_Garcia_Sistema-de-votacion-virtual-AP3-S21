package persistance;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import logic.Votacion;
import persistance.exceptions.NonexistentEntityException;

public class VotacionJpaController implements Serializable {

    public VotacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
      public VotacionJpaController() {
        emf = Persistence.createEntityManagerFactory("SVPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Votacion votacion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(votacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Votacion votacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            votacion = em.merge(votacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = votacion.getId_votacion();
                if (findVotacion(id) == null) {
                    throw new NonexistentEntityException("The votacion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Votacion votacion;
            try {
                votacion = em.getReference(Votacion.class, id);
                votacion.getId_votacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The votacion with id " + id + " no longer exists.", enfe);
            }
            em.remove(votacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Votacion> findVotacionEntities() {
        return findVotacionEntities(true, -1, -1);
    }

    public List<Votacion> findVotacionEntities(int maxResults, int firstResult) {
        return findVotacionEntities(false, maxResults, firstResult);
    }

    private List<Votacion> findVotacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Votacion.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Votacion findVotacion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Votacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getVotacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Votacion> rt = cq.from(Votacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
