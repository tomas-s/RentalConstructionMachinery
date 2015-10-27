package cz.mufi.PA165.RentalConstructionMachinery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cz.mufi.PA165.RentalConstructionMachinery.dao.CustomerDao;

/**
 * Hello world!
 *
 */
public class App {

    @Autowired
    private CustomerDao customerDao;

    public static void main(String[] args) {
        System.out.println("Hello World!");

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext-main.xml" });

        System.out.println("Hello World 2!");
    }
}
