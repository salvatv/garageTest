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
import com.everis.alicante.becajava.domain.Client;
import com.everis.alicante.becajava.domain.Parkingplace;
import com.everis.alicante.becajava.interfaces.BookingDAO;
import com.everis.alicante.becajava.interfaces.ParkingPlaceDAO;

@RunWith(MockitoJUnitRunner.class)
public class ParkingPlaceDAOJPAImplTest {
	
	private ParkingPlaceDAOJPAImpl parkingDAO;
	
	@Mock
	EntityManager emMock;
	
	@Mock
	EntityTransaction entityTransactionMock;
	
	@Mock
	Query query;

	@Before
	public void init() {
		this.parkingDAO = new ParkingPlaceDAOJPAImpl(this.emMock);
	}

	@Test
	public void testCreate() {
		Parkingplace parkingPlace = new Parkingplace();
		Mockito.when(this.emMock.getTransaction()).thenReturn(this.entityTransactionMock);
		
		this.parkingDAO.create(parkingPlace);
		
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.emMock, Mockito.times(1)).persist(parkingPlace);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testReadById() {
		Parkingplace expectedResult = new Parkingplace();
		Mockito.when(this.emMock.find(Parkingplace.class, 1)).thenReturn(expectedResult);

		final Parkingplace result = this.parkingDAO.readById(1);

		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void testUpdate() {
		Parkingplace parkingPlace = new Parkingplace();
		Mockito.when(this.emMock.getTransaction()).thenReturn(this.entityTransactionMock);
		
		this.parkingDAO.update(parkingPlace);
		
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.emMock, Mockito.times(1)).merge(parkingPlace);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testDelete() {
		Parkingplace parkingPlace = new Parkingplace();
		Mockito.when(this.emMock.getTransaction()).thenReturn(this.entityTransactionMock);
		
		this.parkingDAO.delete(parkingPlace);
		
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.emMock, Mockito.times(1)).remove(parkingPlace);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testParkingPlaceDAOJPAImpl() {
		ParkingPlaceDAO parkingDAO = new ParkingPlaceDAOJPAImpl(emMock);
		Assert.assertNotNull(parkingDAO);
	}

	@Test
	public void testFindAll() {
		List<Parkingplace> expectedResult = new ArrayList<>();
		
		Mockito.when(this.emMock.createNamedQuery("Parkingplace.findAll")).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expectedResult);

		final List<Parkingplace> result = this.parkingDAO.findAll();

		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void testFindFreeParkingPlace() {
		Parkingplace parkingPlace = new Parkingplace();
		parkingPlace.setParkingstate((byte) 0);
		List<Parkingplace> places = new ArrayList<>();
		places.add(parkingPlace);
		Query queryMock = Mockito.mock(Query.class);
		Mockito.when(this.emMock.createNativeQuery(Mockito.anyString())).thenReturn(queryMock);
		Mockito.when(queryMock.getResultList()).thenReturn(places);
		
		final List<Parkingplace> result = this.parkingDAO.findFreeParkingPlace();
		
		Assert.assertEquals(0, result.get(0).getParkingstate());
	}

	@Test
	public void testFindFreeParkingPlaces() {

		List<Parkingplace> places = new ArrayList<>();
		Query queryMock = Mockito.mock(Query.class);
		Mockito.when(this.emMock.createNamedQuery("Parkingplace.findFreePlaces")).thenReturn(queryMock);
		Mockito.when(queryMock.getResultList()).thenReturn(places);
		
		final List<Parkingplace> result = this.parkingDAO.findFreeParkingPlaces();
		
		Assert.assertEquals(places, result);
	}

}
