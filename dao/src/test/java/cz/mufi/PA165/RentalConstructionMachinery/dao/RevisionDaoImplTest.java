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
import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Revision;
import cz.mufi.PA165.RentalConstructionMachinery.enums.MachineType;
import java.util.List;
import org.junit.Assert;


/**
 *
 * @author tomas
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-dao.xml" })

public class RevisionDaoImplTest {
    
    @Autowired
    private RevisionDao revisionDao;
    

    @Autowired
    private MachineDao machineDao;
    
    Machine m;
    Revision revision;
    
   
    public RevisionDaoImplTest() {
    }

    @Transactional
    private void createEntity()
    {
        m = new Machine();
        m.setMachineType(MachineType.LORRY);

        machineDao.create(m);
        
        revision = new Revision();
        revision.setRevisionDate(java.sql.Date.valueOf("2015-7-1"));
        revision.setMachine(m);

    }
  
    
    /**
     * Test of create method, of class RevisionDaoImpl.
     */
    @Test
    @Transactional
    public void testCreate() {
    	createEntity();
 
        revisionDao.create(revision);
        Revision found = revisionDao.findById(revision.getId());
        Assert.assertEquals(revision, found);
    }

    /**
     * Test of delete method, of class RevisionDaoImpl.
     */
    @Test
    @Transactional
    public void testDelete() {
    	createEntity();

        revisionDao.create(revision);
        Revision found = revisionDao.findById(revision.getId());
        Assert.assertEquals(revision, found);
      
        revisionDao.delete(revision);
        
        found = revisionDao.findById(revision.getId());
        Assert.assertNull(found);
        Assert.assertTrue(revisionDao.findAll().isEmpty());

    }

    /**
     * Test of update method, of class RevisionDaoImpl.
     */
    @Test
    @Transactional
    public void testUpdate() {
    	createEntity();
    	 
        revisionDao.create(revision);
    	
        revision.setRevisionDate(java.sql.Date.valueOf("2000-7-1"));
        revisionDao.update(revision);
        Revision result = revisionDao.findById(revision.getId());
        Assert.assertEquals(revision, result);        
    }


    /**
     * Test of findAll method, of class RevisionDaoImpl.
     */
    @Test
    @Transactional
    public void testFindAll() {
    	createEntity();
    	
    	Machine m1 = new Machine();
        m1.setMachineType(MachineType.LORRY);

        machineDao.create(m1);
        
        Revision revision1 = new Revision();
        revision1.setRevisionDate(java.sql.Date.valueOf("2015-7-1"));
        revision1.setMachine(m1);
    	
        revisionDao.create(revision);
        revisionDao.create(revision1);
 
        List<Revision> list = revisionDao.findAll();
        Assert.assertEquals(list.size(), 2); 
    }
    
}
