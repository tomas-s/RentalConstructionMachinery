/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mufi.PA165.RentalConstructionMachinery.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Revision;
import cz.mufi.PA165.RentalConstructionMachinery.enums.MachineType;

/**
 *
 * @author tomas
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-dao.xml" })
@Transactional
public class RevisionDaoImplTest {

    @Autowired
    private RevisionDao revisionDao;

    @Autowired
    private MachineDao machineDao;

    private Machine m;
    private Revision revision;

    public RevisionDaoImplTest() {
    }

    @Before
    public void createEntity() {
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
    public void testCreate() {
        revisionDao.create(revision);
        Revision found = revisionDao.findById(revision.getId());
        Assert.assertEquals(revision, found);
    }

    /**
     * Test of delete method, of class RevisionDaoImpl.
     */
    @Test
    public void testDelete() {

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
    public void testUpdate() {
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
    public void testFindAll() {

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

    @Test
    public void testGetRevisionsBetween() {
        Machine m1 = new Machine();
        m1.setMachineType(MachineType.LORRY);

        machineDao.create(m1);

        Revision revision1 = new Revision();
        revision1.setRevisionDate((java.sql.Date.valueOf("2015-7-1")));
        revision1.setMachine(m1);

        revisionDao.create(revision1);
        List<Revision> list;
        Date from = (java.sql.Date.valueOf("2000-7-1"));
        Date to = (java.sql.Date.valueOf("2015-7-1"));

        list = revisionDao.getRevisionsBetween(from, to);
        assertEquals(list.size(), 1);

    }

    @Test
    public void testGetRevisionsForMachineBetween() {

        Machine machine = machineDao.create(m);

        Revision revision1 = new Revision();
        revision1.setRevisionDate((java.sql.Date.valueOf("2013-7-1")));
        revision1.setMachine(m);

        revisionDao.create(revision1);
        List<Revision> list;
        Date from = (java.sql.Date.valueOf("2000-7-1"));
        Date to = (java.sql.Date.valueOf("2015-7-1"));

        list = revisionDao.getRevisionsForMachineBetween(machine, from, to);
        assertEquals(list.size(), 1);

    }

    @Test
    public void testGetRevisionsForMachineIsNotBetween() {

        Machine machine = machineDao.create(m);

        Revision revision1 = new Revision();
        revision1.setRevisionDate((java.sql.Date.valueOf("1999-7-1")));
        revision1.setMachine(m);

        revisionDao.create(revision1);
        List<Revision> list;
        Date from = (java.sql.Date.valueOf("2000-7-1"));
        Date to = (java.sql.Date.valueOf("2015-7-1"));

        list = revisionDao.getRevisionsForMachineBetween(machine, from, to);
        assertEquals(list.size(), 0);

    }

    @Test
    public void revisionExists() {
        Machine machine = machineDao.create(m);

        Revision revision1 = new Revision();
        revision1.setRevisionDate((java.sql.Date.valueOf("2013-7-1")));
        revision1.setMachine(m);

        revisionDao.create(revision1);
        Date from = (java.sql.Date.valueOf("2000-7-1"));
        Date to = (java.sql.Date.valueOf("2015-7-1"));

        assertEquals(true, revisionDao.revisionExists(machine, from, to));

    }

}
