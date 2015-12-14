package cz.mufi.PA165.RentalConstructionMachinery.facade;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;
import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerTypeDTO;
import cz.mufi.PA165.RentalConstructionMachinery.service.BeanMappingService;
import cz.mufi.PA165.RentalConstructionMachinery.service.CustomerService;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Matej Jakimov on 14.12.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/mainApplicationContext.xml"})
@Transactional
public class LoginFacadeImplTest {

    @Mock
    private CustomerService customerService;

    @Mock
    private BeanMappingService mapperService;

    @InjectMocks
    private LoginFacadeImpl loginFacade;

    @Before
    public void initMocks()
    {
        MockitoAnnotations.initMocks(this);
    }

    private static CustomerDTO getCustomer() {
        CustomerDTO c = new CustomerDTO();
        c.setFirstName("A");
        c.setLastName("B");
        c.setPhoneNumber("0");
        c.setCustomerType(CustomerTypeDTO.LEGAL);

        return c;
    }

    @Test
    public void testLoadUserByUsername() {
        Customer customer = new Customer();
        CustomerDTO customerDTO = getCustomer();

        when(customerService.getCustomerByUsername("username")).thenReturn(customer);
        when(mapperService.map(customer, CustomerDTO.class)).thenReturn(customerDTO);
        UserDetails ret = loginFacade.loadUserByUsername("username");
        Assert.assertEquals(ret, customerDTO);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void testLoadUserByUsernameFail() {
        Customer customer = new Customer();
        CustomerDTO customerDTO = getCustomer();

        when(customerService.getCustomerByUsername("username")).thenReturn(null);
        UserDetails ret = loginFacade.loadUserByUsername("username");
    }
}
