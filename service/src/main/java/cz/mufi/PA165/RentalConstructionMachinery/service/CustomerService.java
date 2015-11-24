package cz.mufi.PA165.RentalConstructionMachinery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.mufi.PA165.RentalConstructionMachinery.dao.CustomerDao;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void createCustomer(Customer customer) {
        customerDao.create(customer);
    }

    public void deleteCustomer(Customer customer) {
        customerDao.delete(customer);
    }

    public Customer findCustomerById(long id) {
        return customerDao.findById(id);
    }
}
