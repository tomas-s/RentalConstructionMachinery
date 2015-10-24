package cz.mufi.PA165.RentalConstructionMachinery.dao;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

@Repository
public class DaoTest implements InitializingBean {

    public void afterPropertiesSet() throws Exception {
        System.out.println("Dao clas DaoTest initialized.");
    }

}
