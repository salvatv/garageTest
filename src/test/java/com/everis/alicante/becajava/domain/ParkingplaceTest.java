package com.everis.alicante.becajava.domain;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingplaceTest {
	
	private Parkingplace parkingPlace;
	private int id = 1;
	private int parkingNumber = 1;
	private double parkingPrize = 20;
	private double parkingSize = 30;
	private byte parkingState = 0;
	private Set<Booking> bookings = new HashSet<Booking>();
	
	@Before
	public void init() {
		this.parkingPlace = new Parkingplace();
		this.parkingPlace.setIdparkingplace(id);
		this.parkingPlace.setParkingnumber(parkingNumber);
		this.parkingPlace.setParkingprize(parkingPrize);
		this.parkingPlace.setParkingsize(parkingSize);
		this.parkingPlace.setParkingstate(parkingState);
		this.parkingPlace.setBookings(bookings);
	}

	@Test
	public void testParkingplace() {
		Parkingplace parkingPlace = new Parkingplace();
		Assert.assertNotNull(parkingPlace);
	}

	@Test
	public void testGetIdparkingplace() {
		int id = this.parkingPlace.getIdparkingplace();
		Assert.assertEquals(this.id, id);
	}

	@Test
	public void testSetIdparkingplace() {
		Parkingplace parkingPlace = new Parkingplace();
		parkingPlace.setIdparkingplace(id);
		Assert.assertEquals(this.id, parkingPlace.getIdparkingplace());
	}

	@Test
	public void testGetParkingnumber() {
		int number = this.parkingPlace.getParkingnumber();
		Assert.assertEquals(this.parkingNumber, number);
	}

	@Test
	public void testSetParkingnumber() {
		Parkingplace parkingPlace = new Parkingplace();
		parkingPlace.setParkingnumber(parkingNumber);
		Assert.assertEquals(this.parkingNumber, parkingPlace.getParkingnumber());
	}

	@Test
	public void testGetParkingprize() {
		double parkingPrize = this.parkingPlace.getParkingprize();
		Assert.assertEquals(0, Double.compare(parkingPrize, parkingPlace.getParkingprize()));
	}

	@Test
	public void testSetParkingprize() {
		Parkingplace parkingPlace = new Parkingplace();
		parkingPlace.setParkingprize(parkingPrize);
		Assert.assertEquals(0, Double.compare(this.parkingPrize, parkingPlace.getParkingprize()));
	}

	@Test
	public void testGetParkingsize() {
		double parkingSize = this.parkingPlace.getParkingsize();
		Assert.assertEquals(0, Double.compare(parkingSize, parkingPlace.getParkingsize()));
	}

	@Test
	public void testSetParkingsize() {
		Parkingplace parkingPlace = new Parkingplace();
		parkingPlace.setParkingsize(parkingSize);
		Assert.assertEquals(0, Double.compare(this.parkingSize, parkingPlace.getParkingsize()));
	}

	@Test
	public void testGetParkingstate() {
		byte parkingState = this.parkingPlace.getParkingstate();
		Assert.assertEquals(this.parkingState, parkingState);
	}

	@Test
	public void testSetParkingstate() {
		Parkingplace parkingPlace = new Parkingplace();
		parkingPlace.setParkingstate(parkingState);
		Assert.assertEquals(this.parkingState, parkingPlace.getParkingstate());
	}

	@Test
	public void testGetBookings() {
		Set<Booking> bookings = this.parkingPlace.getBookings();
		Assert.assertEquals(this.bookings, bookings);
	}

	@Test
	public void testSetBookings() {
		Parkingplace parkingPlace = new Parkingplace();
		parkingPlace.setBookings(bookings);
		Assert.assertEquals(this.bookings, parkingPlace.getBookings());
	}

	@Test
	public void testAddBooking() {
		Parkingplace parkingPlace = new Parkingplace();
		Booking booking = parkingPlace.addBooking(new Booking());
		Assert.assertEquals(1, parkingPlace.getBookings().size());
		Assert.assertEquals(parkingPlace, booking.getParkingplace());
	}

	@Test
	public void testRemoveBooking() {
		Booking booking = new Booking();
		parkingPlace.addBooking(booking);
		parkingPlace.removeBooking(booking);
		Assert.assertEquals(0, parkingPlace.getBookings().size());
	}

	@Test
	public void testToString() {
		String string = "Plaza nº" + this.parkingNumber + ", precio = "+ this.parkingPrize + " , tamaño = " +this.parkingSize;
		Assert.assertEquals(this.parkingPlace.toString(), string);
	}

}
