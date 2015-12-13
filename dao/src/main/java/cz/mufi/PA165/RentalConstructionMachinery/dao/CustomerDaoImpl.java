package cz.mufi.PA165.RentalConstructionMachinery.dao;

import org.springframework.stereotype.Repository;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author zdenek
 *
 */
@Repository
public class CustomerDaoImpl extends DaoGenericImpl<Customer> implements CustomerDao {

    public Customer getCustomerByUsername(String username) {
        return em.createQuery("SELECT r FROM Customer r WHERE " +
                    " r.username = ?1", Customer.class)
                    .setParameter(1, username).getSingleResult();
    }
}
