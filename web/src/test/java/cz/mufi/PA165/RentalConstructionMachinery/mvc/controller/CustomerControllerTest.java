package cz.mufi.PA165.RentalConstructionMachinery.mvc.controller;

import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.facade.CustomerFacade;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Matej Jakimov on 13.12.15.
 */
@WebAppConfiguration
public class CustomerControllerTest {

    @Mock
    private CustomerFacade customerFacade;

    @InjectMocks
    private CustomerController customerController;

    private MockMvc mvc;

    private CustomerDTO customerDTO;

    @Before
    public void init() {
        customerDTO = new CustomerDTO();
        customerDTO.setId(666l);
        customerDTO.setUsername("test");
        customerDTO.setFirstName("first");
        customerDTO.setLastName("last");
        customerDTO.setPassword("");
        customerDTO.setRole("ROLE_TEST");
        customerDTO.setPhoneNumber("666");

        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void testIndex() throws Exception {
        List<CustomerDTO> customers = new ArrayList<>();
        customers.add(customerDTO);

        when(customerFacade.getAllCustomers()).thenReturn(customers);

        mvc.perform(get("/customer")).andExpect(status().isOk())
                .andExpect(model().attributeExists("customers"))
                .andExpect(model().attribute("customers", customers));
    }

    @Test
    public void testDelete() throws Exception {
        when(customerFacade.findById(666l)).thenReturn(customerDTO);
        mvc.perform(post("/customer/delete/666")).andExpect(status().is3xxRedirection());
        verify(customerFacade).deleteCustomer(customerDTO);
    }

    @Test
    public void testDeleteFail() throws Exception {
        when(customerFacade.findById(666l)).thenReturn(null);
        mvc.perform(post("/customer/delete/666")).andExpect(status().is3xxRedirection());
        verify(customerFacade, never()).deleteCustomer(customerDTO);
    }


    @Test
    public void testDetail() throws Exception {
        when(customerFacade.findById(666l)).thenReturn(customerDTO);
        mvc.perform(get("/customer/detail/666")).andExpect(status().isOk())
                .andExpect(model().attributeExists("customer"))
                .andExpect(model().attribute("customer", customerDTO));
    }

    @Test
    public void testDetailFail() throws Exception {
        when(customerFacade.findById(666l)).thenReturn(null);
        mvc.perform(get("/customer/detail/666")).andExpect(status().is3xxRedirection());
    }

    @Test
    public void testEdit() throws Exception {
        when(customerFacade.findById(666l)).thenReturn(customerDTO);
        mvc.perform(get("/customer/edit/666")).andExpect(status().isOk())
                .andExpect(model().attributeExists("customer"))
                .andExpect(model().attribute("customer", customerDTO))
                .andExpect(forwardedUrl("customer/edit"));
    }

    @Test
    public void testEditPost() throws Exception {
        when(customerFacade.findById(666l)).thenReturn(customerDTO);
        mvc.perform(post("/customer/edit")
                .param("id", "666")
                .param("firstName", customerDTO.getFirstName())
                .param("lastName", customerDTO.getLastName())
                .param("phoneNumber", customerDTO.getPhoneNumber())
        )
                .andExpect(status().is3xxRedirection());
        verify(customerFacade).updateCustomer(customerDTO);
    }

    @Test
    public void testEditFailed() throws Exception {
        when(customerFacade.findById(666l)).thenReturn(null);
        mvc.perform(get("/customer/edit/666")).andExpect(status().is3xxRedirection());
    }

    @Test
    public void testEditPostFailed() throws Exception {
        when(customerFacade.findById(666l)).thenReturn(null);
        mvc.perform(post("/customer/edit")
                        .param("id", "666")
                        .param("firstName", customerDTO.getFirstName())
                        .param("lastName", customerDTO.getLastName())
                        .param("phoneNumber", customerDTO.getPhoneNumber())
        )
                .andExpect(status().is3xxRedirection());
        verify(customerFacade, never()).updateCustomer(customerDTO);
    }


}
