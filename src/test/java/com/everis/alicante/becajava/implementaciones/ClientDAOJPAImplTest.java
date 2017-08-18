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
import com.everis.alicante.becajava.interfaces.BookingDAO;
import com.everis.alicante.becajava.interfaces.ClientDAO;

@RunWith(MockitoJUnitRunner.class)
public class ClientDAOJPAImplTest {

	private ClientDAOJPAImpl clientDAO;

	@Mock
	EntityManager emMock;

	@Mock
	EntityTransaction entityTransactionMock;

	@Mock
	Query query;

	@Before
	public void init() {
		this.clientDAO = new ClientDAOJPAImpl(this.emMock);
	}

	@Test
	public void testCreate() {
		Client client = new Client();
		Mockito.when(this.emMock.getTransaction()).thenReturn(this.entityTransactionMock);

		this.clientDAO.create(client);

		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.emMock, Mockito.times(1)).persist(client);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testReadById() {
		Client expectedResult = new Client();
		Mockito.when(this.emMock.find(Client.class, 1)).thenReturn(expectedResult);

		final Client result = this.clientDAO.readById(1);

		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void testUpdate() {
		Client client = new Client();
		Mockito.when(this.emMock.getTransaction()).thenReturn(this.entityTransactionMock);

		this.clientDAO.update(client);

		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.emMock, Mockito.times(1)).merge(client);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testDelete() {
		Client client = new Client();
		Mockito.when(this.emMock.getTransaction()).thenReturn(this.entityTransactionMock);

		this.clientDAO.delete(client);

		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.emMock, Mockito.times(1)).remove(client);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testClientDAOJPAImpl() {
		ClientDAO clientDAO = new ClientDAOJPAImpl(emMock);
		Assert.assertNotNull(clientDAO);
	}

	@Test
	public void testFindAll() {
		List<Client> expectedResult = new ArrayList<>();

		Mockito.when(this.emMock.createNamedQuery("Client.findAll")).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expectedResult);

		final List<Client> result = this.clientDAO.findAll();

		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void testFindImporteByClient() {
		Client client = new Client();
		client.setName("pepe");
		Query queryMock = Mockito.mock(Query.class);
		Mockito.when(this.emMock.createNativeQuery(Mockito.anyString())).thenReturn(queryMock);
		Mockito.when(queryMock.getSingleResult()).thenReturn(2d);
		
		query.setParameter(1, client.getName());
		
		final double result = this.clientDAO.findImporteByClient(client);
		
		Assert.assertEquals(2d, result, 0);
		Mockito.verify(queryMock, Mockito.times(1)).setParameter(1, "pepe");
		
	}

}
