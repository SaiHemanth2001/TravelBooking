package com.stl.travelbooking.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import com.stl.travelbooking.exceptions.InvalidTravelDurationException;

public class PlaneTicket extends TravelTicket{
	
	private TravelClass travelCLass;
	private Integer seatNumber;
	private Integer stopOvers;
	
	
	public PlaneTicket() {
		super();
	}
	
	public PlaneTicket(long bookingRef, String origin, String destination, BigDecimal price,
			LocalDateTime departureTime, LocalDateTime arrivalTime, TravelClass travelCLass, Integer seatNumber,
			Integer stopOvers) throws InvalidTravelDurationException {
		super(bookingRef, origin, destination, price, departureTime, arrivalTime);
		this.travelCLass = travelCLass;
		this.seatNumber = seatNumber;
		this.stopOvers = stopOvers;
	}
	public TravelClass getTravelCLass() {
		return travelCLass;
	}
	public void setTravelCLass(TravelClass travelCLass) {
		this.travelCLass = travelCLass;
	}
	public Integer getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}
	public Integer getStopOvers() {
		return stopOvers;
	}
	public void setStopOvers(Integer stopOvers) {
		this.stopOvers = stopOvers;
	}
	
	public void upgrade() {
		
		super.setPrice(getPrice().multiply(new BigDecimal("2")));
		System.out.println("upgraded");
	}
	
	public void addStopOvers() {
		stopOvers++;
		System.out.println("you've"+stopOvers+"stopOvers");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(seatNumber, stopOvers, travelCLass);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlaneTicket other = (PlaneTicket) obj;
		return Objects.equals(seatNumber, other.seatNumber) && Objects.equals(stopOvers, other.stopOvers)
				&& Objects.equals(travelCLass, other.travelCLass);
	}

	@Override
	public String toString() {
		return "PlaneTicket [travelCLass=" + travelCLass + ", seatNumber=" + seatNumber + ", stopOvers=" + stopOvers
				+ "]";
	}
	
	

}
