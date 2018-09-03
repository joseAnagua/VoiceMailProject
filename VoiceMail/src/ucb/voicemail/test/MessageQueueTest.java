package ucb.voicemail.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import ucb.voicemail.domain.Message;
import ucb.voicemail.domain.MessageQueue;

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

}
