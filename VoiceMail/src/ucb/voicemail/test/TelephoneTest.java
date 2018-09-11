package ucb.voicemail.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import com.sun.corba.se.pept.transport.Connection;

import ucb.voicemail.domain.Telephone;

public class TelephoneTest {
	
	private Telephone telephone;
	private Connection connection;

	@Test
	public void deberiaMostrarTestRunning() {
		this.telephone = new Telephone(new Scanner(System.in));
		PrintStream out = mock(PrintStream.class);
		System.setOut(out);
		this.telephone.updateInterface("TestRunning");
		verify(out).println("TestRuning");
	}

}
