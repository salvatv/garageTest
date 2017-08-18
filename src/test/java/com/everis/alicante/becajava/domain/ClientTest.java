package com.everis.alicante.becajava.domain;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClientTest {
	
	private Client client;
	private int id = 1;
	private String telephone = "965456655";
	private String name = "pepe";
	private String surname = "lopez";
	private String nif = "74354652l";
	private Set<Booking> bookings = new HashSet<Booking>();
	private Set<Vehicle> vehicles = new HashSet<Vehicle>();
	
	@Before
	public void init() {
		this.client = new Client();
		this.client.setIdclient(id);
		this.client.setName(name);
		this.client.setNif(nif);
		this.client.setSurname(surname);
		this.client.setBookings(bookings);
		this.client.setTelephone(telephone);
		this.client.setVehicles(vehicles);
	}

	@Test
	public void testClient() {
		Client client = new Client();
		Assert.assertNotNull(client);
	}

	@Test
	public void testGetIdclient() {
		int id = this.client.getIdclient();
		Assert.assertEquals(this.id, id);
	}

	@Test
	public void testSetIdclient() {
		Client client = new Client();
		client.setIdclient(id);
		Assert.assertEquals(this.id, client.getIdclient());
	}

	@Test
	public void testGetName() {
		String name = this.client.getName();
		Assert.assertEquals(this.name, name);
	}

	@Test
	public void testSetName() {
		Client client = new Client();
		client.setName(name);
		Assert.assertEquals(this.name, client.getName());
	}

	@Test
	public void testGetNif() {
		String nif = this.client.getNif();
		Assert.assertEquals(this.nif, nif);
	}

	@Test
	public void testSetNif() {
		Client client = new Client();
		client.setNif(nif);
		Assert.assertEquals(this.nif, client.getNif());
	}

	@Test
	public void testGetSurname() {
		String surname = this.client.getSurname();
		Assert.assertEquals(this.surname, surname);
	}

	@Test
	public void testSetSurname() {
		Client client = new Client();
		client.setSurname(surname);
		Assert.assertEquals(this.surname, client.getSurname());
	}

	@Test
	public void testGetTelephone() {
		String telephone = this.client.getTelephone();
		Assert.assertEquals(this.telephone, telephone);
	}

	@Test
	public void testSetTelephone() {
		Client client = new Client();
		client.setTelephone(telephone);
		Assert.assertEquals(this.telephone, client.getTelephone());
	}

	@Test
	public void testGetBookings() {
		Set<Booking> bookings = this.client.getBookings();
		Assert.assertEquals(this.bookings, bookings);
	}

	@Test
	public void testSetBookings() {
		Client client = new Client();
		client.setBookings(bookings);
		Assert.assertEquals(this.bookings, client.getBookings());
	}

	@Test
	public void testAddBooking() {
		Client client = new Client();
		Booking booking =  client.addBooking(new Booking());
		Assert.assertEquals(1, client.getBookings().size());
		Assert.assertEquals(client, booking.getClient());
	}

	@Test
	public void testRemoveBooking() {
		Booking booking = new Booking();
		client.addBooking(booking);
		client.removeBooking(booking);
		Assert.assertEquals(0, client.getBookings().size());
	}

	@Test
	public void testGetVehicles() {
		Set<Vehicle> vehicles = this.client.getVehicles();
		Assert.assertEquals(this.vehicles, vehicles);
	}

	@Test
	public void testSetVehicles() {
		Client client = new Client();
		client.setVehicles(vehicles);
		Assert.assertEquals(this.vehicles, client.getVehicles());
	}

	@Test
	public void testAddVehicle() {
		Client client = new Client();
		Vehicle vehicle = client.addVehicle(new Vehicle());
		Assert.assertEquals(1, client.getVehicles().size());
		Assert.assertEquals(client, vehicle.getClient());
	}

	@Test
	public void testRemoveVehicle() {
		Vehicle vehicle = new Vehicle();
		client.addVehicle(vehicle);
		client.removeVehicle(vehicle);
		Assert.assertEquals(0, client.getVehicles().size());
	}

}
