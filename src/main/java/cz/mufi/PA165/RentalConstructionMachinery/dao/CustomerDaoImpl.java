package cz.mufi.PA165.RentalConstructionMachinery.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;

/**
 * 
 * @author zdenek
 *
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

    // @PersistenceContext
    // private EntityManager em;

    public void create(Customer customer) {
        // TODO Auto-generated method stub

        System.out.println("CREATE");
    }

    public void delete(Customer customer) {
        // TODO Auto-generated method stub

    }

    public void update(Customer customer) {
        // TODO Auto-generated method stub

    }

    public List<Customer> findAll() {
        // TODO Auto-generated method stub
        return null;
    }
}
