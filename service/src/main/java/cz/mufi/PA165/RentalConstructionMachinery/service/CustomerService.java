package cz.mufi.PA165.RentalConstructionMachinery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.mufi.PA165.RentalConstructionMachinery.dao.CustomerDao;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;
}
