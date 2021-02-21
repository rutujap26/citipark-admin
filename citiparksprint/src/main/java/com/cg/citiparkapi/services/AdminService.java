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

	/**
	 * Create Parking Premise using provided parking premise.
	 * Throws exception for duplicate parking premise entry.
	 * @param parkingPremise
	 * @return parking premise
	 */
	public ParkingPremise createParkingPremise(ParkingPremise parkingPremise);
	
	/**
	 * Read parking premises by parking premise name.
	 * Throws exception for premise name not available in database.
	 * @param premiseName
	 * @return list of parking premises
	 */
	public List<ParkingPremise> readParkingPremiseByName(String premiseName);
	
	/**
	 * Read all parking premises available in database.
	 * @return list of all parking premises
	 */
	public List<ParkingPremise> readAllParkingPremises();
	
	/**
	 * Update parking premise in the database with provided paraking premise
	 * @param parkingPremise
	 * @return updated parking premise
	 */
	public ParkingPremise updateParkingPremise(ParkingPremise parkingPremise);

	/**
	 * Read parking premise by using premise identifier.
	 * Throws exception for identifier not present in database.
	 * @param premiseIdentifier
	 * @return Parking premise of given premise identifier
	 */
	public ParkingPremise readParkingPremiseByIdentifier(String premiseIdentifier);
	
	/**
	 * Delete parking premise by using premise identifier.
	 * @param premiseIdentifier
	 * @return true if deleted successfully.
	 */
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
