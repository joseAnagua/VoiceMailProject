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
		assertEquals(null, this.mailSystem.findMailbox("8"));
	}
	
	@Test
	public void deberiaDevolverPasscodeDeMailboxTrue() {
		assertTrue(this.mailSystem.findMailbox("8").checkPasscode("8"));
	}
}




