package ucb.voicemail.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import ucb.voicemail.domain.Connection;
import ucb.voicemail.domain.ArrayMailboxRepository;

public class ConnectionTest {
	private Connection connection;
	private ArrayMailboxRepository mailsystem;
	
	@Before
	public void init(){
		this.mailsystem = mock(ArrayMailboxRepository.class);
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
	
}
