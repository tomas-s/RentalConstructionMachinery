package cz.mufi.PA165.RentalConstructionMachinery.facade;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Rent;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Revision;
import cz.mufi.PA165.RentalConstructionMachinery.dto.*;
import cz.mufi.PA165.RentalConstructionMachinery.enums.CustomerType;
import cz.mufi.PA165.RentalConstructionMachinery.enums.MachineType;
import cz.mufi.PA165.RentalConstructionMachinery.service.BeanMappingService;
import cz.mufi.PA165.RentalConstructionMachinery.service.RentService;
import cz.mufi.PA165.RentalConstructionMachinery.service.RentServiceImpl;
import cz.mufi.PA165.RentalConstructionMachinery.service.RevisionService;
import org.dozer.DozerBeanMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by jakac on 26.11.15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext-service.xml"})
@Transactional
public class RevisionFacadeTest {

    @Mock
    private RevisionService revisionService;

    @Mock
    private BeanMappingService mapperService;

    /**
     * Nedari se pouzit najednou Spring DI a Mockito DI
     */
    @InjectMocks
    private RevisionFacadeImpl revisionFacade;

    @Before
    public void initMocks()
    {
        MockitoAnnotations.initMocks(this);
    }

    private static MachineDTO getMachineDTO() {
        MachineDTO m = new MachineDTO();
        return m;
    }

    private static RevisionCreateDTO getCreateRevisionDTO() {
        RevisionCreateDTO r = new RevisionCreateDTO();

        r.setMachine(getMachineDTO());
        r.setRevisionDate(Calendar.getInstance().getTime());

        return r;
    }

    private static RevisionDTO getRevisionDTO() {
        RevisionDTO r = new RevisionDTO();

        r.setMachine(getMachineDTO());
        r.setRevisionDate(Calendar.getInstance().getTime());

        return r;
    }

    private static Revision getRevision() {
        Revision r = new Revision();

        Machine m = new Machine();
        m.setId((long) 123);
        m.setMachineType(MachineType.CRANE);

        r.setMachine(m);
        r.setId((long) 123);
        r.setRevisionDate(Calendar.getInstance().getTime());

        return r;
    }

    @Test
    public void testCreate()
    {
        Revision r = getRevision();
        RevisionCreateDTO rc = getCreateRevisionDTO();

        when(mapperService.map(rc, Revision.class)).thenReturn(r);
        when(revisionService.createRevision(r)).thenReturn(r);
        revisionFacade.createRevision(rc);
        verify(revisionService).createRevision(r);
    }

    @Test
    public void testDelete()
    {
        Revision r = getRevision();

        long id = 123;

        when(revisionService.findRevisionById(id)).thenReturn(r);
        revisionFacade.deleteRevision(id);
        verify(revisionService).deleteRevision(r);
    }

    @Test
    public void testGetRevisionsBetween() {
        Date d = Calendar.getInstance().getTime();

        List<Revision> list = new ArrayList<>();
        List<RevisionDTO> list2 = new ArrayList<>();

        when(revisionService.getRevisionsBetween(d, d)).thenReturn(list);
        when(mapperService.map(list, RevisionDTO.class)).thenReturn(list2);
        Assert.assertEquals(revisionFacade.getRevisionsBetween(d, d), list2);
        verify(mapperService).map(list, RevisionDTO.class);
        verify(revisionService).getRevisionsBetween(d, d);
    }
}
