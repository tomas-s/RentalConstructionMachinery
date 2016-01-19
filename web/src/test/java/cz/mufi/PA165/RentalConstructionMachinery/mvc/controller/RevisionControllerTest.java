/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mufi.PA165.RentalConstructionMachinery.mvc.controller;

import cz.mufi.PA165.RentalConstructionMachinery.dto.RevisionDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.MachineDTO;
import cz.mufi.PA165.RentalConstructionMachinery.facade.RevisionFacade;
import java.util.Date;
import static javax.swing.UIManager.get;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;





import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
/**
 *
 * @author tomas
 */
@WebAppConfiguration
public class RevisionControllerTest {
    
    @Mock
    private RevisionFacade revisionFacade;

    @InjectMocks
    private RevisionController revisionController;

    private MockMvc mvc;

    private RevisionDTO revisionDTO;
    
    private MachineDTO machineDTO;
    
@Before
    public void init() {
        machineDTO = new MachineDTO();
        revisionDTO = new RevisionDTO();
        long id = 52;
        revisionDTO.setId(id);
                revisionDTO.setMachine(machineDTO);
        revisionDTO.setRevisionDate(new Date(195,1,3));
    
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(revisionController).build();
    }
//    netusim preco chce stal pretitpovat pri volani get...
//    @Test
//    public void testIndex() throws Exception {
//        List<RevisionDTO> revisions = new ArrayList<>();
//        revisions.add(revisionDTO);
//
//        when(revisionFacade.getAllRevisions()).thenReturn(revisions);
//
//        mvc.perform(get("/revision")).andExpect(status().isOk())
//                .andExpect(model().attributeExists("customers"))
//                .andExpect(model().attribute("customers", revisions));
//    }
//    
    
    @Test
    public void testDelete() throws Exception {
        when(revisionFacade.findById(52l)).thenReturn(revisionDTO);
        mvc.perform(post("/revision/delete/52")).andExpect(status().is3xxRedirection());
        verify(revisionFacade).deleteRevision(revisionDTO.getId());
    }
    
    
    @Test
    public void testDeleteFail() throws Exception {
        when(revisionFacade.findById(52l)).thenReturn(null);
        mvc.perform(post("/revision/delete/52")).andExpect(status().is3xxRedirection());
        verify(revisionFacade, never()).deleteRevision(revisionDTO.getId());
    }

    @Test
    public void testInit() {
    }

    @Test
    public void testList() {
    }

    @Test
    public void testFindedRevision() throws Exception {
    }

    @Test
    public void testFindRevision() {
    }

    @Test
    public void testListUser() {
    }

    @Test
    public void testGreetingForm() {
    }

    @Test
    public void testGreetingSubmit() {
    }

    @Test
    public void testDetail() {
    }

    
    
    
    
}
