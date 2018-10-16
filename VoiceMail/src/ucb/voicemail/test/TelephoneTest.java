package ucb.voicemail.test;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import ucb.voicemail.domain.Connection;
import ucb.voicemail.presentation.console.ConsoleTelephone;

public class TelephoneTest {
	
	private ConsoleTelephone telephone;
	private Connection connection;

	@Test
	public void deberiaMostrarTestRunning() {
		this.telephone = new ConsoleTelephone(new Scanner(System.in));
		PrintStream out = mock(PrintStream.class);
		System.setOut(out);
		this.telephone.updateInterface("TestRuning");
		verify(out).println("TestRuning");
	}

	@Test
	public void deberiaDarElValorDeFalseAMore() {
		String input = "Q";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		this.telephone = new ConsoleTelephone(new Scanner(System.in));
		connection = mock(Connection.class);
		
		this.telephone.run(connection);
	}
	
	@Test
	public void deberiaEjecutarElMetodoDialDeConnection() {		
		String input = "1";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
		
		telephone = new ConsoleTelephone(new Scanner(System.in));
		
		connection = mock(Connection.class);
		
		doNothing().when(connection).dial(isA(String.class));
	}
}
