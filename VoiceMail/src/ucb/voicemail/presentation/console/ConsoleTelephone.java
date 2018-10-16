package ucb.voicemail.presentation.console;
import java.util.Scanner;

import ucb.voicemail.domain.Connection;
import ucb.voicemail.domain.Telephone;

/**
   A telephone that takes simulated keystrokes and voice input
   from the user and simulates spoken text.
*/
public class ConsoleTelephone implements Telephone
{
   /**
      Construct phone object.
      @param aScanner that reads text from a character-input stream
   */
   public ConsoleTelephone(Scanner aScanner)
   {
      scanner = aScanner;
   }

   /**
      Speak a message to System.out.
      @param output the text that will be "spoken"
   */
   public void speak(String output)
   {
      System.out.println(output);
   }
   //==============================================
   public void updateInterface(String output)
   {
      System.out.println(output);
   }
   //==============================================
   /**
      Loops reading user input and passes the input to the
      Connection object's methods dial, record or hangup.
      @param c the connection that connects this phone to the
      voice mail system
   */
   public void run(Connection c)
   {
      boolean more = true;
      while (more)
      {
         String input = scanner.nextLine();
         if (input == null) return;
         if (input.equalsIgnoreCase(HANGUP))
            c.hangup();
         else if (input.equalsIgnoreCase(QUIT))
            more = false;
         else if (input.length() == 1
            && OPTIONS_ALPHA_NUMERIC.indexOf(input) >= 0)
            c.dial(input);
         else
            c.record(input);
         
      }
  }

   	private Scanner scanner;
   	private static final String HANGUP = "H";
	private static final String QUIT = "Q";
	private static final String OPTIONS_ALPHA_NUMERIC= "1234567890#";
}
