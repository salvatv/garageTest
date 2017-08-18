package com.everis.alicante.becajava.implementaciones;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.everis.alicante.becajava.domain.Booking;
import com.everis.alicante.becajava.interfaces.BookingDAO;

@RunWith(MockitoJUnitRunner.class)
public class BookingDAOJPAImplTest {

	private BookingDAOJPAImpl bookingDAO;

	@Mock
	EntityManager emMock;
	
	@Mock
	EntityTransaction entityTransactionMock;
	
	@Mock
	Query query;

	@Before
	public void init() {
		this.bookingDAO = new BookingDAOJPAImpl(this.emMock);
	}

	@Test
	public void testCreate() {
		Booking booking = new Booking();
		Mockito.when(this.emMock.getTransaction()).thenReturn(this.entityTransactionMock);
		
		this.bookingDAO.create(booking);
		
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.emMock, Mockito.times(1)).persist(booking);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testReadById() {
		Booking expectedResult = new Booking();
		Mockito.when(this.emMock.find(Booking.class, 1)).thenReturn(expectedResult);

		final Booking result = this.bookingDAO.readById(1);

		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void testUpdate() {
		Booking booking = new Booking();
		Mockito.when(this.emMock.getTransaction()).thenReturn(this.entityTransactionMock);
		
		this.bookingDAO.update(booking);
		
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.emMock, Mockito.times(1)).merge(booking);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testDelete() {
		Booking booking = new Booking();
		Mockito.when(this.emMock.getTransaction()).thenReturn(this.entityTransactionMock);
		
		this.bookingDAO.delete(booking);
		
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.emMock, Mockito.times(1)).remove(booking);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testBookingDAOJPAImpl() {
		BookingDAO bookingDao = new BookingDAOJPAImpl(emMock);
		Assert.assertNotNull(bookingDao);
	}

	@Test
	public void testFindAll() {
		List<Booking> expectedResult = new ArrayList<>();
		
		Mockito.when(this.emMock.createNamedQuery("Booking.findAll")).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expectedResult);

		final List<Booking> result = this.bookingDAO.findAll();

		Assert.assertEquals(expectedResult, result);
	}

}
