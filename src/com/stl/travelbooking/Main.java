package com.stl.travelbooking;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import com.stl.travelbooking.bookingprocess.BookingSystem;
import com.stl.travelbooking.bookingprocess.CheapTravelBookingSystem;
import com.stl.travelbooking.bookingprocess.EnjoyableTourBookingSystem;
import com.stl.travelbooking.domain.BusTicket;
import com.stl.travelbooking.domain.PlaneTicket;
import com.stl.travelbooking.domain.TrainTicket;
import com.stl.travelbooking.domain.TravelClass;
import com.stl.travelbooking.domain.TravelTicket;
import com.stl.travelbooking.exceptions.InvalidTravelDurationException;

public class Main {
	
	public static void main(String[] args) throws InvalidTravelDurationException  {
		TrainTicket trainTicket = new TrainTicket();
		trainTicket.cancel();
		
		TrainTicket trainTicket2 = null ;
		try {
			trainTicket2 = new TrainTicket(222L,"banglore","chennai",new BigDecimal("89.00"),
					LocalDateTime.of(1976, 2, 27, 12, 30),LocalDateTime.of(1976, 12, 5, 5, 30)
					,TravelClass.FIRST,32,56);
			trainTicket2.upgrade();
		   trainTicket2.cancel();
		} catch (InvalidTravelDurationException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		
		
		ArrayList<String> providers = new ArrayList<>();
		providers.add("firstBusCompany");
		providers.add("secondBusCompany");
		providers.add("thirdBusCompany");
		System.out.println(providers.size());
		System.out.println(providers);
		providers.remove(1);
		System.out.println(providers.size());
		System.out.println(providers);
		BusTicket busTicket=null;
		
		busTicket = new BusTicket(223L,"banglore","chennai",new BigDecimal("89.00"),
					LocalDateTime.of(1976, 2, 27, 12, 30),LocalDateTime.of(1976, 12, 5, 5, 30)
					,providers);
		BusTicket busTicket2 = new BusTicket(224L,"mumbai","hyd",new BigDecimal("89.00"),
					LocalDateTime.of(1976, 2, 27, 12, 30),LocalDateTime.of(1976, 12, 5, 5, 30)
					,providers);
		BusTicket busTicket3 = new BusTicket(225L,"hyd","delhi",new BigDecimal("89.00"),
					LocalDateTime.of(1976, 2, 27, 12, 30),LocalDateTime.of(1976, 12, 5, 5, 30)
					,providers);
		List<TravelTicket> tickets = new ArrayList<>();
		
		tickets.add(busTicket3);
		tickets.add(busTicket2);
		tickets.add(busTicket);
		tickets.add(trainTicket2);
		
//		System.out.println(tickets.get(1));
//		for(int i=0;i<tickets.size();i++) {
//			System.out.println(tickets.get(i));
//		}
		for(TravelTicket b: tickets) {
			System.out.println(b);
		}
		
		TravelTicket foundTicket = tickets.get(2);
		System.out.println(foundTicket);
		
		if(foundTicket instanceof BusTicket) {
			System.out.println("This is a bus ticket");
			BusTicket foundBusTicket = (BusTicket)foundTicket;
			System.out.println( foundBusTicket.getPermittedProviders());
		}
		if(foundTicket instanceof TrainTicket) {
			System.out.println("This is a Train ticket");
		}
		if(foundTicket instanceof PlaneTicket) {
			System.out.println("This is a PLANE ticket");
		}
		BusTicket busTicket4 =new BusTicket(foundTicket,providers);
		
		BookingSystem bookingSystem = new CheapTravelBookingSystem();
		bookingSystem.setTravelTicket(busTicket4);
		bookingSystem.requestBooking();
		System.out.println("The booking status is "+bookingSystem.getStatus());
		
		List<Integer> integerList1 = new ArrayList<>();
		integerList1.add(1);
		integerList1.add(2);
		integerList1.add(3);
		integerList1.add(4);
		integerList1.add(5);
		List<Integer> integerList2 = List.of(1,2,3,4,5);
		for(Integer i :integerList2) {
			System.out.println(i);
		}
		System.out.println(integerList2.getClass());
		
		System.out.println(BookingSystem.getVersion());
		BookingSystem bookingSystem2 =BookingSystem.of(trainTicket); 
		
	}

}
