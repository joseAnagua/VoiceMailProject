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

	/*@Test
	public void deberiaDarElValorDeFalseAMore() {
		String input = "Q";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		this.telephone = new Telephone(new Scanner(System.in));
		this.connection = mock(Connection.class);
		this.telephone.run(connection);
	}*/
	
	/*public void deberiaEjecutarElMetodoDialDeConnection() {		
		String input = "1";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
		
		telephone = new Telephone(new Scanner(System.in));
		
		connection = mock(Connection.class);
		
		doNothing().when(connection).dial(isA(String.class));
	}*/
}
