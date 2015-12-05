package cz.mufi.PA165.RentalConstructionMachinery.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext-service.xml"})
public class TestServiceTest {

    //@Autowired
    //private TestService service;

    @Test
    public void testIt() {
       // assert (service.smazat());
    }

}
