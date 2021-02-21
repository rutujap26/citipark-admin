package com.cg.citiparkapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.citiparkapi.beans.ParkingFloor;

public interface ParkingFloorRepository extends JpaRepository<ParkingFloor, Integer> {

}
