package com.everis.alicante.becajava.implementaciones;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.everis.alicante.becajava.domain.Booking;
import com.everis.alicante.becajava.domain.Vehicle;
import com.everis.alicante.becajava.interfaces.BookingDAO;
import com.everis.alicante.becajava.interfaces.VehicleDAO;

@RunWith(MockitoJUnitRunner.class)
public class VehicleDAOJPAImplTest {
	
	private VehicleDAOJPAImpl vehicleDAO;

	@Mock
	EntityManager emMock;
	
	@Mock
	EntityTransaction entityTransactionMock;
	
	@Mock
	Query query;
	
	@Before
	public void init() {
		this.vehicleDAO = new VehicleDAOJPAImpl(this.emMock);
	}

	@Test
	public void testCreate() {
		Vehicle vehicle = new Vehicle();
		Mockito.when(this.emMock.getTransaction()).thenReturn(this.entityTransactionMock);
		
		this.vehicleDAO.create(vehicle);
		
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.emMock, Mockito.times(1)).persist(vehicle);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testReadById() {
		Vehicle vehicle = new Vehicle();
		Mockito.when(this.emMock.find(Vehicle.class, 1)).thenReturn(vehicle);

		final Vehicle result = this.vehicleDAO.readById(1);

		Assert.assertEquals(vehicle, result);
	}

	@Test
	public void testUpdate() {
		Vehicle vehicle = new Vehicle();
		Mockito.when(this.emMock.getTransaction()).thenReturn(this.entityTransactionMock);
		
		this.vehicleDAO.update(vehicle);
		
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.emMock, Mockito.times(1)).merge(vehicle);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testDelete() {
		Vehicle vehicle = new Vehicle();
		Mockito.when(this.emMock.getTransaction()).thenReturn(this.entityTransactionMock);
		
		this.vehicleDAO.delete(vehicle);
		
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.emMock, Mockito.times(1)).remove(vehicle);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testBookingDAOJPAImpl() {
		VehicleDAO vehicleDAO = new VehicleDAOJPAImpl(emMock);
		Assert.assertNotNull(vehicleDAO);
	}

	@Test
	public void testFindAll() {
		List<Vehicle> expectedResult = new ArrayList<>();
		
		Mockito.when(this.emMock.createNamedQuery("Vehicle.findAll")).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expectedResult);

		final List<Vehicle> result = this.vehicleDAO.findAll();

		Assert.assertEquals(expectedResult, result);
	}

}
