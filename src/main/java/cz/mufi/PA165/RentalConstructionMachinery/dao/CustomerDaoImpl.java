package cz.mufi.PA165.RentalConstructionMachinery.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;

/**
 * 
 * @author zdenek
 *
 */
@Repository
public class CustomerDaoImpl extends DaoGenericImpl<Customer> implements CustomerDao {

    @PersistenceContext
    private EntityManager em;

    public void create(Customer customer) {
        // TODO Auto-generated method stub

        System.out.println("CREATE");

        // em.getTransaction().begin();
        em.persist(customer);
        // em.getTransaction().commit();

        System.out.println("CREATE DONE");

        System.out.println(em);
    }

    public void delete(Customer customer) {
        // TODO Auto-generated method stub

    }

    public void update(Customer customer) {
        // TODO Auto-generated method stub

    }

    public Customer findById(Long id) {
        return em.find(Customer.class, id);
    }

    public List<Customer> findAll() {
        return null;
    }
}
