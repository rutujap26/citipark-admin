package com.cg.citiparkapi.exceptions;

import com.cg.citiparkapi.beans.ParkingFloor;

public class ParkingFloorCustomException {

	public static void validateFloor(ParkingFloor floor) {
		if (floor.getFloorNumber() == null || floor.getFloorNumber().isEmpty()) {
			throw new IllegalArgumentException("please provide valid FloorNumber");
		}
	}
}
