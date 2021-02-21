package com.cg.citiparkapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.citiparkapi.beans.ParkingFloor;
import com.cg.citiparkapi.beans.ParkingPremise;

@Service
public interface AdminService {
	
	/**
	 * Parking Premise
	 */

	public ParkingPremise createParkingPremise(ParkingPremise parkingPremise);
	
	public List<ParkingPremise> readParkingPremiseByName(String premiseName);
	
	public List<ParkingPremise> readAllParkingPremises();
	
	public ParkingPremise updateParkingPremise(ParkingPremise parkingPremise);

	public ParkingPremise readParkingPremiseByIdentifier(String premiseIdentifier);
	
	public boolean deleteParkingPremise(String premiseIdentifier);
	
	/**
	 * Parking Floor
	 */
	
	ParkingFloor createParkingFloor(ParkingFloor floor);

	Iterable<ParkingFloor> fetchingAlleParkingFloor();

	ParkingFloor fetchParkingFloorById(int parkingFloorId);

	String deleteParkingFloorById(int parkingFloorId);

	ParkingFloor updateParkingFloorById(int parkingFloorId, ParkingFloor floor);
}
