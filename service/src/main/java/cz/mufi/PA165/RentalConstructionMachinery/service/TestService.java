package cz.mufi.PA165.RentalConstructionMachinery.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class TestService implements InitializingBean {

    public void afterPropertiesSet() throws Exception {
        System.out.println("Service clas TestService initialized.");
    }

    public boolean smazat()
    {
        return true;
    }

}
