package com.everis.alicante.becajava.domain;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VehicleTest {
	
	private Vehicle vehicle;
	private int id = 1;
	private String vehicleModel = "car";
	private String vehiclePlate = "8765";
	private Set<Booking> bookings = new HashSet<Booking>();
	private Client client = new Client();
	
	@Before
	public void init() {
		this.vehicle = new Vehicle();
		this.vehicle.setIdvehicle(id);
		this.vehicle.setBookings(bookings);
		this.vehicle.setClient(client);
		this.vehicle.setVehiclemodel(vehicleModel);
		this.vehicle.setVehicleplate(vehiclePlate);
	}
	

	@Test
	public void testVehicle() {
		Vehicle vehicle = new Vehicle();
		Assert.assertNotNull(vehicle);
	}

	@Test
	public void testGetIdvehicle() {
		int id = this.vehicle.getIdvehicle();
		Assert.assertEquals(this.id, id);
	}

	@Test
	public void testSetIdvehicle() {
		Vehicle vehicle = new Vehicle();
		vehicle.setIdvehicle(id);
		Assert.assertEquals(this.id, vehicle.getIdvehicle());
	}

	@Test
	public void testGetVehiclemodel() {
		String vehicleModel = this.vehicle.getVehiclemodel();
		Assert.assertEquals(this.vehicleModel, vehicleModel);
	}

	@Test
	public void testSetVehiclemodel() {
		Vehicle vehicle = new Vehicle();
		vehicle.setVehiclemodel(vehicleModel);
		Assert.assertEquals(this.vehicleModel, vehicle.getVehiclemodel());
	}

	@Test
	public void testGetVehicleplate() {
		String vehiclePlate = this.vehicle.getVehicleplate();
		Assert.assertEquals(this.vehiclePlate, vehiclePlate);
	}

	@Test
	public void testSetVehicleplate() {
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleplate(vehiclePlate);
		Assert.assertEquals(this.vehiclePlate, vehicle.getVehicleplate());
	}

	@Test
	public void testGetBookings() {
		Set<Booking> bookings = this.vehicle.getBookings();
		Assert.assertEquals(this.bookings, bookings);
	}

	@Test
	public void testSetBookings() {
		Vehicle vehicle = new Vehicle();
		vehicle.setBookings(bookings);
		Assert.assertEquals(this.bookings, vehicle.getBookings());
	}

	@Test
	public void testAddBooking() {
		Vehicle vehicle = new Vehicle();
		Booking booking =  vehicle.addBooking(new Booking());
		Assert.assertEquals(1, vehicle.getBookings().size());
		Assert.assertEquals(vehicle, booking.getVehicle());
	}

	@Test
	public void testRemoveBooking() {
		Booking booking = new Booking();
		vehicle.addBooking(booking);
		vehicle.removeBooking(booking);
		Assert.assertEquals(0, vehicle.getBookings().size());
	}

	@Test
	public void testGetClient() {
		Client client = this.vehicle.getClient();
		Assert.assertEquals(this.client, client);
	}

	@Test
	public void testSetClient() {
		Vehicle vehicle = new Vehicle();
		vehicle.setClient(client);
		Assert.assertEquals(this.client, vehicle.getClient());
	}

}
