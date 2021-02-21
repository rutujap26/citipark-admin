package com.cg.citiparkapi.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.citiparkapi.beans.Address;
import com.cg.citiparkapi.beans.ParkingPremise;
import com.cg.citiparkapi.exceptions.DuplicateParkingPremiseException;
import com.cg.citiparkapi.exceptions.NoSuchParkingPremiseException;
import com.cg.citiparkapi.repository.ParkingPremiseRepository;
import com.cg.citiparkapi.services.AdminService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {

	@Autowired
	AdminService adminService;
	
	@MockBean
	ParkingPremiseRepository parkingPremiseRepository;
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testForParkingPremise() {
		Address address = new Address("pune", "MH", "411006");
		ParkingPremise parkingPremise = new ParkingPremise("pre1", 2, address, "P1");
		when(parkingPremiseRepository.save(parkingPremise)).thenReturn(parkingPremise);
		assertEquals(parkingPremise, adminService.createParkingPremise(parkingPremise));
	}
	
	@Test
	public void testForDuplicateParkingPremise() {
		Address address = new Address("pune", "MH", "411006");
		ParkingPremise premise = new ParkingPremise("pre1", 2, address, "P1");
		when(parkingPremiseRepository.save(premise)).thenThrow(DuplicateParkingPremiseException.class);
	}
	
	@Test
	public void testForValidParkingPremiseIdentifier() {
		Address address = new Address("pune", "MH", "411006");
		ParkingPremise premise = new ParkingPremise("pre2", 3, address, "P1");
		when(parkingPremiseRepository.findbyPremiseIdentifier("P1")).thenReturn(new ParkingPremise("pre2", 3, address, "P1"));
		assertEquals(premise, adminService.readParkingPremiseByIdentifier("P1"));
	}
	
	@Test
	public void testForInvalidParkingPremiseIdentifier() {
		when(parkingPremiseRepository.findbyPremiseIdentifier("P1")).thenThrow(NoSuchParkingPremiseException.class);
	}
	
	@Test
	public void testForValidParkingPremiseName() {
		Address address = new Address("pune", "MH", "411006");
		when(parkingPremiseRepository.findByParkingPremiseName("pre1")).thenReturn(Stream.of(new ParkingPremise("pre1", 1, address, "P2"), new ParkingPremise("pre1", 5, address, "P3")).collect(Collectors.toList()));
		assertEquals(2, adminService.readParkingPremiseByName("pre1").size());
	}
	
	@Test
	public void testForInvalidParkingPremiseName() {
		when(parkingPremiseRepository.findByParkingPremiseName("pre1")).thenThrow(NoSuchParkingPremiseException.class);
	}
	
	@Test
	public void testForGetAllParkingPremises() {
		Address address = new Address("pune", "MH", "411006");
		when(parkingPremiseRepository.findAll()).thenReturn(Stream.of(new ParkingPremise("pre1", 2, address, "P1"), new ParkingPremise("pre2", 4, address, "P2")).collect(Collectors.toList()));
		assertEquals(2, adminService.readAllParkingPremises().size());
	}
	
}
