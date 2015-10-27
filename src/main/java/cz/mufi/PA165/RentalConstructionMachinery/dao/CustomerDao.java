package cz.mufi.PA165.RentalConstructionMachinery.dao;

import java.util.List;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;

/**
 * 
 * @author zdenek
 *
 */
public interface CustomerDao {

    void create(Customer customer);

    void delete(Customer customer);

    void update(Customer customer);

    Customer findById(Long id);

    List<Customer> findAll();
}
