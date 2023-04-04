package com.stl.travelbooking.bookingprocess;

import com.stl.travelbooking.domain.TravelTicket;

public class CheapTravelBookingSystem implements BookingSystem {

	@Override
	public void setTravelTicket(TravelTicket ticket) {
		// TODO Auto-generated method stub
		System.out.println("CheapTravel recieved the ticket"+ticket);

	}

	@Override
	public void requestBooking() {
		// TODO Auto-generated method stub
		System.out.println("CheapTravel recieved the booking request");

	}

	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancel() {
		// TODO Auto-generated method stub
		return false;
	}

}
