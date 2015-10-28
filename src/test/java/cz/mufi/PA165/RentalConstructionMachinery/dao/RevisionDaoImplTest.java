/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mufi.PA165.RentalConstructionMachinery.dao;

import javax.transaction.Transactional;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Revision;
import java.util.List;
//import java.sql.Date;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.PersistenceUnit;


/**
 *
 * @author tomas
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-main.xml" })

public class RevisionDaoImplTest {
    
    @Autowired
    private RevisionDao revisionDao;
    
   
    public RevisionDaoImplTest() {
    }

    /**
     * Test of create method, of class RevisionDaoImpl.
     */
    @Test
    @Transactional
    public void testCreate() {
        Revision revision = new Revision();
        revision.setRevisionDate(java.sql.Date.valueOf("2015-7-1"));
        
        

        revisionDao.create(revision);

        System.out.println("dao: " + revision);
        Revision found = revisionDao.findById(revision.getId());
        System.out.println("dao: " + found);
        
    }

    /**
     * Test of delete method, of class RevisionDaoImpl.
     */
    @Test
    @Transactional
    public void testDelete() {
   
        Revision revision1 = new Revision();
        revision1.setRevisionDate(java.sql.Date.valueOf("2015-7-1"));
        
        Revision revision2 = new Revision();
        revision2.setRevisionDate(java.sql.Date.valueOf("1999-1-5"));
        
        revisionDao.create(revision1);
        revisionDao.create(revision2);
      
        
       
        revisionDao.delete(revision1);
        //revisionDao.delete(revision2);
        
        List<Revision> list = revisionDao.findAll();
        System.out.println("size"+list.size());

    }

    /**
     * Test of update method, of class RevisionDaoImpl.
     */
    @Test
    public void testUpdate() {
    }

    /**
     * Test of findById method, of class RevisionDaoImpl.
     * blbne tu ze nepreda datovy typ long
     */
    @Test
    public void testFindById() {
        System.out.println("test: testFindById ");
        Revision revision = new Revision();
        long cislo =5;
        revision.setId(cislo);
        revision.setRevisionDate(java.sql.Date.valueOf("2009-11-23"));
        
        System.out.println("revizia: "+revision);
        
        //tu je chyba nepozna cislo
        Revision result = revisionDao.findById(revision.getId());
        System.out.println("vysledok: "+result);
    }

    /**
     * Test of findAll method, of class RevisionDaoImpl.
     * funguje potom spravit assert 
     */
    @Test
    @Transactional
    public void testFindAll() {
        Revision revision1 = new Revision();
        revision1.setRevisionDate(java.sql.Date.valueOf("2015-7-1"));
        
        Revision revision2 = new Revision();
        revision2.setRevisionDate(java.sql.Date.valueOf("1999-1-5"));
        
        revisionDao.create(revision1);
        revisionDao.create(revision2);
        
        
        List<Revision> list = revisionDao.findAll();
        System.out.println("list:  "+list);
        
        
        
    }
    
}
