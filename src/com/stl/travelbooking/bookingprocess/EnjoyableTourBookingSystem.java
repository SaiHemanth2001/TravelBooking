package com.stl.travelbooking.bookingprocess;

import com.stl.travelbooking.domain.TravelTicket;

public class EnjoyableTourBookingSystem implements BookingSystem {

	@Override
	public void setTravelTicket(TravelTicket ticket) {
		// TODO Auto-generated method stub
		System.out.println("EnjoyableTours have recieved Ticket"+ ticket);
	}

	@Override
	public void requestBooking() {
		// TODO Auto-generated method stub
		System.out.println("EnjoyableTours have recieved booking request");

	}

	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		System.out.println("EnjoyableTours is provding the status");
		return false;
	}

	@Override
	public boolean cancel() {
		// TODO Auto-generated method stub
		return false;
	}

}
