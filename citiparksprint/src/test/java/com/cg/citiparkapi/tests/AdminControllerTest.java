package com.cg.citiparkapi.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.citiparkapi.CitiparkapiApplication;
import com.cg.citiparkapi.beans.Address;
import com.cg.citiparkapi.beans.ParkingPremise;
import com.cg.citiparkapi.services.AdminService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CitiparkapiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AdminControllerTest {

	private Address address;
	private ParkingPremise premise;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@MockBean
	private AdminService adminService;
	
	@LocalServerPort
	private int port;
	
	private String getUrl() {
		return "http://localhost:"+port;
	}
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		address = new Address("pune", "maharashtra", "411006");
		premise = new ParkingPremise("pre1", 4, address, "P1");
	}
	
	@Test
	public void testAddParkingPremise() {
		ResponseEntity<ParkingPremise> postResponse = restTemplate.postForEntity(getUrl()+"/api/parkingPremise/create", premise, ParkingPremise.class);
		assertEquals(HttpStatus.OK, postResponse.getStatusCode());
	}
	
	@Test
	public void testGetParkingPremiseByIdentifier() {
		ResponseEntity<ParkingPremise> postResponse1 = restTemplate.getForEntity(getUrl()+"/api/parkingPremise/getByIdentifier/P1", ParkingPremise.class);
		assertEquals(HttpStatus.OK ,postResponse1.getStatusCode());
	}
	
	@Test
	public void testGetParkingPremiseByIdentifierForInvalidId() {
		ResponseEntity<ParkingPremise> postResponse2 = restTemplate.getForEntity(getUrl()+"/api/parkingPremise/getByIdentifier/pp", ParkingPremise.class);
		assertNotNull(postResponse2);
		assertNotNull(postResponse2.badRequest());
	}
	
	
}
