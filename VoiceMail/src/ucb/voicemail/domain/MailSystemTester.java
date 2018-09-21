package ucb.voicemail.domain;
import java.util.Scanner;
import ucb.voicemail.domain.Window;
/**
   This program tests the mail system. A single phone
   communicates with the program through System.in/System.out.
*/
public class MailSystemTester
{
   public static void main(String[] args)
   {
	  Window w = new Window(new MainMenu());
      MailSystem system = new MailSystem(MAILBOX_COUNT);
      Scanner console = new Scanner(System.in);
      Telephone p = new Telephone(console);
      Connection c = new Connection(system);
      c.addUserInterface(p);
      c.addUserInterface(w);
      c.start(); // REINICIAR LA CONEXCION PARA QUE APAREZCA " Enter mailbox number followed by #"
      w.run(c);
      p.run(c);
   }

   private static final int MAILBOX_COUNT = 20;
}
