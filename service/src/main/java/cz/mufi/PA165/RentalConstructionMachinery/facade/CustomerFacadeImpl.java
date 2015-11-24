package cz.mufi.PA165.RentalConstructionMachinery.facade;

import org.springframework.stereotype.Component;
import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;
import cz.mufi.PA165.RentalConstructionMachinery.dao.CustomerDao;
import javax.transaction.Transactional;
import org.dozer.DozerBeanMapper;
import org.dozer.inject.Inject;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

//@Component
@Service
@Transactional
public class CustomerFacadeImpl implements CustomerFacade {
//airoportserviceimpl
    
    @Inject
    private CustomerDao customerDao;
    
    @Inject
    private DozerBeanMapper dozerBeanMapper;
    
    @Override
    public void createNewCustomer(CustomerDTO customerDTO){

          dozerBeanMapper = new DozerBeanMapper();
          Customer customer = dozerBeanMapper.map(customerDTO, Customer.class); //uspesne nakopiruje
          System.out.println("nakopiroval som: "+customer);
          customerDao.create(customer); //tuto to zhavaruje moze to byt kvoli tomu ze rentHistoryDTO sa nezhoduje s rentHistory

          
    }

    @Override
    public void deleteCustomer(CustomerDTO customer) {
        throw new NotImplementedException();
    }

    @Override
    public void updateCustomer(CustomerDTO customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getAllCustomers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
