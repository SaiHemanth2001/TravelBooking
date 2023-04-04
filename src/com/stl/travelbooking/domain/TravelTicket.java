package com.stl.travelbooking.domain;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

import com.stl.travelbooking.exceptions.InvalidTravelDurationException;

public abstract class TravelTicket {
	
	private long bookingRef;
	private String origin;
	private String destination;
	private BigDecimal price;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	
	public TravelTicket() {}
	
	public TravelTicket(long bookingRef, String origin, String destination, BigDecimal price,
			LocalDateTime departureTime, LocalDateTime arrivalTime) throws InvalidTravelDurationException {
		if(Duration.between(departureTime, arrivalTime).toSeconds()<0) {
			throw new InvalidTravelDurationException("can't arrive before departure");
		}
		this.bookingRef = bookingRef;
		this.origin = origin;
		this.destination = destination;
		this.price = price;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	public long getBookingRef() {
		return bookingRef;
	}

	protected void setBookingRef(long bookingRef) {
		this.bookingRef = bookingRef;
	}

	public String getOrigin() {
		return origin;
	}

	protected void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	protected void setDestination(String destination) {
		this.destination = destination;
	}

	public BigDecimal getPrice() {
		return price;
	}

	protected void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	protected void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	protected void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public void reschedule() {
		System.out.println("rescheduling ticket");
	}
	
	public void cancel() {
		System.out.println("cancelling ticket");
	}

	@Override
	public String toString() {
		return "TravelTicket [bookingRef=" + bookingRef + ", origin=" + origin + ", destination=" + destination
				+ ", price=" + price + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrivalTime, bookingRef, departureTime, destination, origin, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TravelTicket other = (TravelTicket) obj;
		return Objects.equals(arrivalTime, other.arrivalTime) && bookingRef == other.bookingRef
				&& Objects.equals(departureTime, other.departureTime) && Objects.equals(destination, other.destination)
				&& Objects.equals(origin, other.origin) && Objects.equals(price, other.price);
	}
	
	
	

}
