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

}
