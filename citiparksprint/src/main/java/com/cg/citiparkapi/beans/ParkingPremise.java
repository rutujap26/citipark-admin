package com.cg.citiparkapi.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "parkingpremises")
public class ParkingPremise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long parkingPremiseId;
	
	@NotBlank(message = "Parking Premise Name Required")
	private String parkingPremiseName;
	private int numberOfParkingFloors;
	
	@NotBlank(message = "Parking Premise Identifier Required")
	@Column(unique = true, updatable = false, length = 3)
	private String premiseIdentifier;
	
	@OneToOne (targetEntity = Address.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="address_id")
	private Address premiseAddress;
	
	public ParkingPremise() {
	}

	

	public ParkingPremise(String parkingPremiseName, int numberOfParkingFloors, Address premiseAddress, String premiseIdentifier) {
		super();
		this.parkingPremiseName = parkingPremiseName;
		this.numberOfParkingFloors = numberOfParkingFloors;
		this.premiseAddress = premiseAddress;
		this.premiseIdentifier = premiseIdentifier;
	}



	public long getParkingPremiseId() {
		return parkingPremiseId;
	}

	public void setParkingPremiseId(long parkingPremiseId) {
		this.parkingPremiseId = parkingPremiseId;
	}

	public String getParkingPremiseName() {
		return parkingPremiseName;
	}

	public void setParkingPremiseName(String parkingPremiseName) {
		this.parkingPremiseName = parkingPremiseName;
	}

	public int getNumberOfParkingFloors() {
		return numberOfParkingFloors;
	}

	public void setNumberOfParkingFloors(int numberOfParkingFloors) {
		this.numberOfParkingFloors = numberOfParkingFloors;
	}

	public Address getPremiseAddress() {
		return premiseAddress;
	}

	public void setPremiseAddress(Address premiseAddress) {
		this.premiseAddress = premiseAddress;
	}



	public String getPremiseIdentifier() {
		return premiseIdentifier;
	}



	public void setPremiseIdentifier(String premiseIdentifier) {
		this.premiseIdentifier = premiseIdentifier;
	}



	@Override
	public String toString() {
		return "ParkingPremise [parkingPremiseId=" + parkingPremiseId + ", parkingPremiseName=" + parkingPremiseName
				+ ", numberOfParkingFloors=" + numberOfParkingFloors + ", premiseAddress=" + premiseAddress
				+ ", premiseIdentifier=" + premiseIdentifier + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numberOfParkingFloors;
		result = prime * result + (int) (parkingPremiseId ^ (parkingPremiseId >>> 32));
		result = prime * result + ((parkingPremiseName == null) ? 0 : parkingPremiseName.hashCode());
		result = prime * result + ((premiseAddress == null) ? 0 : premiseAddress.hashCode());
		result = prime * result + ((premiseIdentifier == null) ? 0 : premiseIdentifier.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParkingPremise other = (ParkingPremise) obj;
		if (numberOfParkingFloors != other.numberOfParkingFloors)
			return false;
		if (parkingPremiseId != other.parkingPremiseId)
			return false;
		if (parkingPremiseName == null) {
			if (other.parkingPremiseName != null)
				return false;
		} else if (!parkingPremiseName.equals(other.parkingPremiseName))
			return false;
		if (premiseAddress == null) {
			if (other.premiseAddress != null)
				return false;
		} else if (!premiseAddress.equals(other.premiseAddress))
			return false;
		if (premiseIdentifier == null) {
			if (other.premiseIdentifier != null)
				return false;
		} else if (!premiseIdentifier.equals(other.premiseIdentifier))
			return false;
		return true;
	}



	
	
	
}
