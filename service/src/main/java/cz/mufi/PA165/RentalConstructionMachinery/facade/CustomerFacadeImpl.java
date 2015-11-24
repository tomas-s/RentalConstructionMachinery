package cz.mufi.PA165.RentalConstructionMachinery.facade;

import cz.mufi.PA165.RentalConstructionMachinery.dao.CustomerDao;
import cz.mufi.PA165.RentalConstructionMachinery.dao.CustomerDaoImpl;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;
import org.springframework.stereotype.Component;
import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import javax.transaction.Transactional;
import org.dozer.DozerBeanMapper;
import org.dozer.inject.Inject;

@Component
public class CustomerFacadeImpl implements CustomerFacade {

    @Inject
    private CustomerDao customerDao;    //!!!tu je chyba lebo nenainicializuje CustomerDao a potom nepozna a odkazuje sa na obiekt null skuste si tu dat break point a pochopite
    
    @Inject
    private DozerBeanMapper dozerBeanMapper;
    
    
    @Override
    public void createNewCustomer(CustomerDTO customerDTO){

          dozerBeanMapper = new DozerBeanMapper();  
          Customer customer = dozerBeanMapper.map(customerDTO, Customer.class); //uspesne nakopiruje
          System.out.println("nakopiroval som: "+customer);
          //customerDao = new CustomerDaoImpl();
          customerDao.create(customer);
    }

    @Override
    public void deleteCustomer(CustomerDTO customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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