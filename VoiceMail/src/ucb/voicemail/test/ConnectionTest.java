package ucb.voicemail.test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import ucb.voicemail.domain.Connection;
import ucb.voicemail.domain.ConnectionState;
import ucb.voicemail.domain.Mailbox;
import ucb.voicemail.domain.MailboxRepository;
import ucb.voicemail.domain.Telephone;
import ucb.voicemail.repository.mailbox.ArrayMailboxRepository;

public class ConnectionTest {
	private Connection connection;
	private MailboxRepository mailsystem;

	@Before
	public void init() {
		this.mailsystem = mock(MailboxRepository.class);
		this.connection = new Connection(this.mailsystem, null);
	}

	@Test
	public void deberiaLlamarAlMetodoConnect() {
		this.connection.dial("key to test");
	}

	@Test
	public void deberiaConcatenarElTextoACurrentRecording() {
		this.connection.record("texto");
	}

	@Test
	public void noDeberiaAgregarMensajeACurrentMailbox() {
		this.connection.hangup();
	}

	@Test
	public void deberiaGuardarGrabacion() {
		this.connection.currentRecord("Guardar");
		assertEquals("Guardar", connection.getCurrentRecording());
	}

	@Test
	public void deberiaCambiarEstado() {
		ConnectionState state = mock(ConnectionState.class);
		this.connection.setState(state);
		assertEquals(state, this.connection.getState());
	}
	
	@Test
	public void deberiaCambiarTeclasAcumuladas() {
		this.connection.setAccumulatedKeys("Test");
		assertEquals("Test", this.connection.getAccumulatedKeys());
	}
	
	@Test
	public void deberiaGrabarMensajeActual() {
		this.connection.setCurrentRecording("Test");
		//assertEquals("Test", this.connection.getAccumulatedKeys());
		assertEquals("Test", this.connection.getCurrentRecording());
	}
	
	@Test
	public void deberiaRetornarElMailboxId() {
		when(mailsystem.findMailbox(anyString())).thenReturn(new Mailbox("1", "", ""));
		//connection.findMailboxByAccumulatedKeys();
		assertEquals("1", connection.getCurrentMailboxId());
	}
	
	@Test
	public void deberiaRetonarRepositorios() {
		assertEquals(mailsystem, connection.getMailboxRepository());
		assertEquals(null, connection.getMessageRepository());
	}
	
	@Test
	public void deberiaNotificarTelefono() {
		Telephone telephone = mock(Telephone.class);
		connection.addTelephone(telephone);
		//connection.notifyToAll("Hola");
		verify(telephone).updateInterface(any(String.class));
	}
	
	@Test
	public void deberiaEliminarTelefono() {
		Telephone t1 = mock(Telephone.class);
		Telephone t2 = mock(Telephone.class);
		connection.addTelephone(t1);
		connection.addTelephone(t2);
		connection.deleteTelephone(t1);
		//connection.notifyToAll("Hola");
		verify(t1, never()).updateInterface(any(String.class));
		verify(t2).updateInterface(any(String.class));
	}
	
	@Test
	public void deberiaIniciarConnection() {
		connection.start();
		assertEquals("", connection.getAccumulatedKeys());
		assertEquals("", connection.getCurrentRecording());
	}
}
