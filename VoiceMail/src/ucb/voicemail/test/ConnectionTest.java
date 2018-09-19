package ucb.voicemail.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import ucb.voicemail.domain.Connection;
import ucb.voicemail.domain.MailSystem;

public class ConnectionTest {
	private Connection connection;
	private MailSystem mailsystem;
	
	@Before
	public void init(){
		this.mailsystem = mock(MailSystem.class);
		this.connection = new Connection(this.mailsystem);
	}
	
	@Test
	public void deberiaLlamarAlMetodoConnect() {
		this.connection.dial("key to test");
	}
	
}
