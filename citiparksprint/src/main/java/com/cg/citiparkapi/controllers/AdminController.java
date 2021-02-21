package com.cg.citiparkapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.citiparkapi.beans.ParkingFloor;
import com.cg.citiparkapi.beans.ParkingPremise;
import com.cg.citiparkapi.services.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	
	@PostMapping("/api/parkingPremise/create")
	public ResponseEntity<?> addParkingPremise(@Valid @RequestBody ParkingPremise parkingPremise) {
		ParkingPremise premise = adminService.createParkingPremise(parkingPremise);
		return new ResponseEntity<ParkingPremise>(premise, HttpStatus.OK);
	}
	
	@GetMapping("/api/parkingPremise/getByIdentifier/{premiseIdentifier}")
	public ResponseEntity<?> getParkingPremiseByIdentifier(@PathVariable String premiseIdentifier) {
		ParkingPremise premise = adminService.readParkingPremiseByIdentifier(premiseIdentifier.toUpperCase());
		return new ResponseEntity<ParkingPremise>(premise, HttpStatus.OK);
	}
	
	@GetMapping("/api/parkingPremise/{parkingPremiseName}")
	public ResponseEntity<?> getParkingPremisesByPremiseName(@PathVariable String parkingPremiseName) {
		List<ParkingPremise> premise = adminService.readParkingPremiseByName(parkingPremiseName);
		return new ResponseEntity<List<ParkingPremise>>(premise, HttpStatus.OK);
	}
	
	@GetMapping("/api/parkingPremise/all")
	public List<ParkingPremise> getAllParkingPremises(){
		return adminService.readAllParkingPremises();
	}
	
	@PutMapping("/api/parkingPremise/update")
	public ParkingPremise updateParkingPremise(@RequestBody ParkingPremise parkingPremise) {
		return adminService.updateParkingPremise(parkingPremise);
	}

	@DeleteMapping("/api/parkingPremise/delete/{premiseIdentifier}")
	public ResponseEntity<?> removeParkingPremise(@PathVariable String premiseIdentifier) {
		boolean status = adminService.deleteParkingPremise(premiseIdentifier);
		if(status)
			return new ResponseEntity<String>("Parking Premise with Id: "+premiseIdentifier+" deleted", HttpStatus.OK);
		return new ResponseEntity<String>("Failed", HttpStatus.OK);
	}
	
	
	//Parking Floor
	
	
	@PostMapping("floor/api/create")
	public ResponseEntity<?> createParkingFloor(@RequestBody ParkingFloor floor){
		ParkingFloor parkingFloor = adminService.createParkingFloor(floor);
		return new ResponseEntity<ParkingFloor>(parkingFloor, HttpStatus.CREATED);
	}
	
	@GetMapping("/floor/api/fetchallfloors")
	public Iterable<ParkingFloor> fetchingAlleParkingFloor(){
		return  adminService.fetchingAlleParkingFloor();
	}
	
	@GetMapping("/floor/api/fetchfloorbyid")
	public ResponseEntity<?> fetchParkingFloorById(@RequestParam(value = "parkingFloorId") int parkingFloorId){
		ParkingFloor parkingFloor = adminService.fetchParkingFloorById(parkingFloorId);
		if (parkingFloor == null) 
			return new ResponseEntity<String>("Data is not present for requested parkingFloorId", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ParkingFloor>(parkingFloor, HttpStatus.OK);
	}

	@PutMapping("/floor/api/updatebyid/{parkingFloorId}")
	public ResponseEntity<ParkingFloor> updateParkingFloorById(@PathVariable int parkingFloorId, @RequestBody ParkingFloor floor){
		ParkingFloor parkingFloor = adminService.updateParkingFloorById(parkingFloorId, floor);
		return new ResponseEntity<ParkingFloor>(parkingFloor, HttpStatus.OK);
	}

	@DeleteMapping("/floor/api/delete/{parkingFloorId}")
	public ResponseEntity<?> deleteParkingFloorById(@PathVariable int parkingFloorId){
		String message = adminService.deleteParkingFloorById(parkingFloorId);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
