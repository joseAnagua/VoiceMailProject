package ucb.voicemail.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ucb.voicemail.domain.MailSystem;


public class MailSystemTest {

	MailSystem mailSystem;
	int mailBoxcount;
	
	@Before
	public void init() {
		this.mailBoxcount = 10;
		this.mailSystem = new MailSystem(this.mailBoxcount);
	}
	
	@Test
	public void deberiaHaberCreadoMailboxes() {
		assertEquals(10, this.mailSystem.getLengthMailbox());
	}
	
	@Test
	public void deberiaDevolverNullPorMailboxInvalido() {
		assertEquals(null, this.mailSystem.findMailbox("23"));
	}
	
	@Test
	public void deberiaDevolverDiferenteDeNullPorMailboxValido() {
<<<<<<< HEAD
		assertNotNull(mailSystem.findMailbox("8"));
=======
		assertNotEquals(null, this.mailSystem.findMailbox("8"));
>>>>>>> connection_test
	}
	
	@Test
	public void deberiaDevolverPasscodeDeMailboxTrue() {
		assertTrue(this.mailSystem.findMailbox("8").checkPasscode("8"));
	}
	
	@Test 
	public void deberiaDevolverPasscodeDeMailboxFalse() {
		assertFalse(this.mailSystem.findMailbox("8").checkPasscode("9"));
	}
	
	@Test
	public void deberiaDevolverIgualGrettindDelMailbox() {
		assertEquals("You have reached mailbox [8]. \nPlease leave a message now.", this.mailSystem.findMailbox("8").getGreeting());
	}
	
	@Test
	public void deberiaDevolverNoIgualElGrettingDelMailbox() {
		assertNotEquals("You have reached mailbox [9]. \nPlease leave a message now.", this.mailSystem.findMailbox("8").getGreeting());
	}		
}




