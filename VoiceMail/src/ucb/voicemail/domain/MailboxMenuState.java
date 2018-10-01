package ucb.voicemail.domain;

public class MailboxMenuState implements ConnectionState {

	@Override
	public void dial(String key, Connection connection) {
		if (key.equals("1"))
	    {
			connection.setState(new MessageMenuState());
			connection.notifyToAll(MESSAGE_MENU_TEXT);
	    }
	    else if (key.equals("2"))
	    {
	    	connection.setState(new ChangePasscodeState());
	        connection.notifyToAll("Enter new passcode followed by the # key");
	    }
	    else if (key.equals("3"))
	    {
	    	connection.setState(new ChangeGreentingState());
	        connection.notifyToAll("Record your greeting, then press the # key");
	    }
	}

	@Override
	public void record(String voice, Connection connection) {

	}

	@Override
	public void hangup(Connection connection) {

	}

	private static final String MESSAGE_MENU_TEXT = 
		       "Enter 1 to listen to the current message\n"
		       + "Enter 2 to save the current message\n"
		       + "Enter 3 to delete the current message\n"
		       + "Enter 4 to return to the main menu";
	
}
