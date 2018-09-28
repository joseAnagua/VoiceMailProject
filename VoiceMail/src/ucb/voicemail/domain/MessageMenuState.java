package ucb.voicemail.domain;

public class MessageMenuState implements ConnectionState {

	@Override
	public void dial(String key, Connection connection) {
		  if (key.equals("1"))
	      {
	         String output = "";
	         Message m = connection.getCurrentMailbox().getCurrentMessage();
	         if (m == null) output += "No messages." + "\n";
	         else output += m.getText() + "\n";
	         output += MESSAGE_MENU_TEXT;
	         //phone.speak(output);
	         connection.notifyToAll(output);
	      }
	      else if (key.equals("2"))
	      {
	         connection.getCurrentMailbox().saveCurrentMessage();
	         connection.notifyToAll(MESSAGE_MENU_TEXT);
	      }
	      else if (key.equals("3"))
	      {
	         connection.getCurrentMailbox().removeCurrentMessage();
	         connection.notifyToAll(MESSAGE_MENU_TEXT);
	      }
	      else if (key.equals("4"))
	      {
	    	 connection.setState(new MailboxMenuState());
	         connection.notifyToAll(MAILBOX_MENU_TEXT);
	      }
	}

	@Override
	public void record(String voice, Connection connection) {

	}

	@Override
	public void hangup(Connection connection) {

	}

	private static final String MAILBOX_MENU_TEXT = 
	         "Enter 1 to listen to your messages\n"
	         + "Enter 2 to change your passcode\n"
	         + "Enter 3 to change your greeting";
	
	private static final String MESSAGE_MENU_TEXT = 
	         "Enter 1 to listen to the current message\n"
	         + "Enter 2 to save the current message\n"
	         + "Enter 3 to delete the current message\n"
	         + "Enter 4 to return to the main menu";
}
