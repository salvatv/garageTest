package com.everis.alicante.becajava.domain;


import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BookingTest {
	
	private Booking booking;
	private Date date = new Date();
	private Client expectedClient = new Client();
	private Parkingplace pkng = new Parkingplace();
	private Vehicle vehicle = new Vehicle();
	private int id = 1;
	
	@Before
	public void init() {
		this.booking = new Booking();
		this.booking.setBookingdate(date);
		this.booking.setIdbooking(id);
		this.booking.setClient(expectedClient);
		this.booking.setParkingplace(pkng);
		this.booking.setVehicle(vehicle);
	}

	@Test
	public void testBooking() {
		Booking booking = new Booking();
		Assert.assertNotNull(booking);
	}

	@Test
	public void testGetIdbooking() {
		int id = this.booking.getIdbooking();
		Assert.assertEquals(this.id, id);
	}

	@Test
	public void testSetIdbooking() {
		Booking booking = new Booking();
		booking.setIdbooking(this.id);
		Assert.assertEquals(this.id, booking.getIdbooking());
	}

	@Test
	public void testGetBookingdate() {
		Date date = this.booking.getBookingdate();
		Assert.assertEquals(this.date, date);
	}

	@Test
	public void testSetBookingdate() {
		Booking booking = new Booking();
		booking.setBookingdate(this.date);
		Assert.assertEquals(this.booking.getBookingdate(), booking.getBookingdate());
	}

	@Test
	public void testGetClient() {
		Client client = this.booking.getClient();
		Assert.assertEquals(this.expectedClient, client);
	}

	@Test
	public void testSetClient() {
		Booking booking = new Booking();
		booking.setClient(this.expectedClient);
		Assert.assertEquals(this.expectedClient, booking.getClient());
	}

	@Test
	public void testGetParkingplace() {
		Parkingplace pkng = this.booking.getParkingplace();
		Assert.assertEquals(this.pkng, pkng);
	}

	@Test
	public void testSetParkingplace() {
		Booking booking = new Booking();
		booking.setParkingplace(this.pkng);
		Assert.assertEquals(this.pkng, booking.getParkingplace());
	}

	@Test
	public void testGetVehicle() {
		Vehicle vehicle = this.booking.getVehicle();
		Assert.assertEquals(this.vehicle, vehicle);
	}

	@Test
	public void testSetVehicle() {
		Booking booking = new Booking();
		booking.setVehicle(this.vehicle);
		Assert.assertEquals(this.vehicle, booking.getVehicle());
	}

	@Test
	public void testToString() {
		String string = "Booking [idbooking=" + this.booking.getIdbooking() + ", bookingdate=" + this.booking.getBookingdate() + ", client=" + this.booking.getClient()
				+ ", parkingplace=" + this.booking.getParkingplace() + ", vehicle=" + this.booking.getVehicle() + "]";
		Assert.assertEquals(this.booking.toString(), string);
	}

}
