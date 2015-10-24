package cz.mufi.PA165.RentalConstructionMachinery;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // ApplicationContext context = new FileSystemXmlApplicationContext
        // ("C:/Users/ZARA/workspace/HelloSpring/src/Beans.xml");

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext-main.xml" });
        System.out.println(context);

        System.out.println("Hello World 2!");
    }
}
