package com.cg.citiparkapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.cg.citiparkapi.beans.ParkingPremise;

public interface ParkingPremiseRepository extends JpaRepository<ParkingPremise, Long> {

	@Query(value ="SELECT pp FROM ParkingPremise pp WHERE pp.parkingPremiseName=:premiseName")
	List<ParkingPremise> findByParkingPremiseName(@Param("premiseName") String premiseName);
	
	@Query(value = "SELECT pp FROM ParkingPremise pp WHERE pp.premiseIdentifier=:premiseIdentifier")
	ParkingPremise findbyPremiseIdentifier(@Param("premiseIdentifier") String parkingPremiseIdentifier);
}

