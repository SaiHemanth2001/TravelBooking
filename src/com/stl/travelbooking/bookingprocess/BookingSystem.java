package com.stl.travelbooking.bookingprocess;

import com.stl.travelbooking.domain.TravelTicket;

public interface BookingSystem {
	
	public void setTravelTicket (TravelTicket ticket);
    public void requestBooking();
    public boolean getStatus();
    public boolean cancel();
    
    public static String getVersion () {
    	return "Version1";
    }
    public static BookingSystem of(TravelTicket ticket) {
    	BookingSystem bookingSystem = new CheapTravelBookingSystem();
    	bookingSystem.setTravelTicket(ticket);
    	return bookingSystem;
    }

}
