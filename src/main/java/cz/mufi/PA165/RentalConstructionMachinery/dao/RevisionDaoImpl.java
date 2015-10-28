package cz.mufi.PA165.RentalConstructionMachinery.dao;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Revision;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static org.hibernate.criterion.Projections.id;
import org.springframework.stereotype.Repository;


@Repository
public class RevisionDaoImpl implements RevisionDao {
    
    @PersistenceContext
    public EntityManager em;

    
    public void create(Revision revision) {
        System.out.println("CREATE");

        // em.getTransaction().begin();
        em.persist(revision);
        // em.getTransaction().commit();

        System.out.println("CREATE DONE");

        //System.out.println(em);
    }

    public void delete(Revision revision) {
        em.remove(revision);
    }

    public Revision update(Revision revision) {
        return em.merge(revision);
    }

    public Revision findById(Long id) {
        return em.find(Revision.class, id);
    }

    public List<Revision> findAll() {
        return em.createQuery("SELECT a FROM Revision a", Revision.class).getResultList();
    }

  
        
    }

