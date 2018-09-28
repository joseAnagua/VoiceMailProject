package ucb.voicemail.domain;
import java.util.Scanner;
import ucb.voicemail.domain.Window;
/**
   This program tests the mail system. A single phone
   communicates with the program through System.in/System.out.
*/
public class MailSystemTester
{
	
	public static int x = 5;
	
	public static int h1() {
		return x = 4;
	}
	
   public static void main(String[] args)
   {
	  Window w = new Window(new MainMenu());
      MailSystem system = new MailSystem(MAILBOX_COUNT);
      Scanner console = new Scanner(System.in);
      ConsoleTelephone p = new ConsoleTelephone(console);
      Connection c = new Connection(system);
      c.addTelephone(p);
      c.addTelephone(w);
      c.start(); // REINICIAR LA CONEXCION PARA QUE APAREZCA " Enter mailbox number followed by #"
      w.run(c);
      p.run(c);
   }

   private static final int MAILBOX_COUNT = 20;
}
