package cz.mufi.PA165.RentalConstructionMachinery.service;

import cz.mufi.PA165.RentalConstructionMachinery.dao.RevisionDao;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Revision;
import cz.mufi.PA165.RentalConstructionMachinery.enums.MachineType;
import cz.mufi.PA165.RentalConstructionMachinery.exceptions.ServiceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by jakac on 26.11.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/mainApplicationContext.xml"})
@Transactional
public class RevisionServiceTest {

    @Mock
    private RentServiceImpl rentService;

    @Mock
    private RevisionDao revisionDao;

    /**
     * Nedari se pouzit najednou Spring DI a Mockito DI
     */
    @InjectMocks
    private RevisionServiceImpl revisionService;

    @Before
    public void initMocks()
    {
        MockitoAnnotations.initMocks(this);
    }

    private static Machine getMachine() {
        Machine m = new Machine();
        m.setMachineType(MachineType.DIGGER);
        return m;
    }

    private static Revision getRevision() {
        Revision r = new Revision();
        r.setMachine(getMachine());
        r.setRevisionDate(java.sql.Date.valueOf("2000-7-1"));
        return r;
    }

    @Test
    public void testCreate()
    {
        Revision r = getRevision();
        when(rentService.hasConflict(any(Machine.class), any(Date.class))).thenReturn(false);
        when(revisionDao.create(any(Revision.class))).thenReturn(r);

        Assert.assertEquals(revisionService.createRevision(r), r);
    }

    @Test(expected = ServiceException.class)
    public void testConflict()
    {
        Revision r = getRevision();
        when(rentService.hasConflict(any(Machine.class), any(Date.class))).thenReturn(true);
        when(revisionDao.create(any(Revision.class))).thenReturn(r);

        revisionService.createRevision(r);
    }


}
