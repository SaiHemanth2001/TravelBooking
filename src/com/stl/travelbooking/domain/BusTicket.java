package com.stl.travelbooking.domain;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import com.stl.travelbooking.exceptions.InvalidTravelDurationException;

public class BusTicket extends TravelTicket{
	
	private ArrayList<String> permittedProviders;
	
	public BusTicket() {
		super();
	}

	public BusTicket(long bookingRef, String origin, String destination, BigDecimal price, LocalDateTime departureTime,
			LocalDateTime arrivalTime, ArrayList<String> permittedProviders) throws InvalidTravelDurationException {
		super(bookingRef, origin, destination, price, departureTime, arrivalTime);
		this.permittedProviders = permittedProviders;
	}
	
	public BusTicket(TravelTicket t , ArrayList<String> permittedProviders) throws InvalidTravelDurationException {
		super(t.getBookingRef(),t.getOrigin(),t.getDestination(),t.getPrice(),t.getDepartureTime(),t.getArrivalTime());
		this.permittedProviders = permittedProviders;
	}

	public ArrayList<String> getPermittedProviders() {
		return permittedProviders;
	}

	public void setPermittedProviders(ArrayList<String> permittedProviders) {
		this.permittedProviders = permittedProviders;
	}

	@Override
	public void cancel() {
		Duration d = Duration.between(LocalDateTime.now(), getDepartureTime());
		Long days =d.toDays();
		if (days>30) {
		super.cancel();
		}
		else {
			System.out.println("can't be cancelled");
		}
		
	}

	

	@Override
	public String toString() {
		return "BusTicket [toString()=" +super.toString() + "permittedProviders=" +permittedProviders +   "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(permittedProviders);
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
		BusTicket other = (BusTicket) obj;
		return Objects.equals(permittedProviders, other.permittedProviders);
	}

	

}
