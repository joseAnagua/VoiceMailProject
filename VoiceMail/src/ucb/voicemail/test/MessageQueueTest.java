package ucb.voicemail.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import ucb.voicemail.domain.Message;
import ucb.voicemail.repository.message.MessageQueue;

public class MessageQueueTest {
	
	MessageQueue messages;
	Message mockedMessage;

	@Before
	public void init() {
		mockedMessage = mock(Message.class);
		messages = new MessageQueue();
	}
	
	@Test
	public void deberiaRetornar0ConSize() {
		assertEquals(0, messages.size());
	}
	
	@Test
	public void deberiaRetornarNumeroConSize() {
		this.messages.add(this.mockedMessage);
		this.messages.add(this.mockedMessage);
		assertEquals(mockedMessage, messages.remove());
	}
	
	@Test
	public void deberiaRetornarMensajeQueSeElimina() {
		this.messages.add(this.mockedMessage);
		this.messages.add(this.mockedMessage);
		assertEquals(this.mockedMessage, this.messages.remove());
	}
	
	@Test
	public void deberiaGuardarUnNuevoMensajeConAdd() {
		this.messages.add(this.mockedMessage);
		assertEquals(this.mockedMessage, this.messages.peek());
	}

	@Test
	public void deberiaRetornarVacioConPeek() {
		assertNull(this.messages.peek());
	}
	
}
