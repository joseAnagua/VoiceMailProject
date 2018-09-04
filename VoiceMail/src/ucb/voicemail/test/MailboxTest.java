package ucb.voicemail.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

import ucb.voicemail.domain.Mailbox;
import ucb.voicemail.domain.Message;
import ucb.voicemail.domain.MessageQueue;

public class MailboxTest {
	Mailbox mailbox;
	String passcode;
	String greeting;
	Message mockedMessage;
	MessageQueue mockedMessageQueue;
	
	@Before
	public void init() {
		this.passcode = "1";
		this.greeting = "Saludos";
		this.mailbox = new Mailbox(this.passcode, this.greeting);
		this.mockedMessage = mock(Message.class);
		this.mockedMessageQueue = mock(MessageQueue.class);
	}
	
	@Test
	public void deberiaDevolverPasscodeTrue() {
		assertTrue(this.mailbox.checkPasscode("1"));
	}

}
