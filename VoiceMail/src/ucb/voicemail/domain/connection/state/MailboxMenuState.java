package ucb.voicemail.domain.connection.state;

import ucb.voicemail.domain.Connection;
import ucb.voicemail.domain.ConnectionState;

public class MailboxMenuState implements ConnectionState {

	@Override
	public void dial(String key, Connection connection) {
		if (key.equals("1"))
	    {
			connection.setState(new MessageMenuState());
			connection.displayMessageMenu();
			//connection.notifyToAll(MESSAGE_MENU_TEXT);
	    }
	    else if (key.equals("2"))
	    {
	    	connection.setState(new ChangePasscodeState());
	        connection.displayChangePasscodeMessage();
	    	//connection.notifyToAll("Enter new passcode followed by the # key");
	    }
	    else if (key.equals("3"))
	    {
	    	connection.setState(new ChangeGreentingState());
	        connection.displayChangeGreetingMessage();
	    	//connection.notifyToAll("Record your greeting, then press the # key");
	    }
	}

	@Override
	public void record(String voice, Connection connection) {

	}

	@Override
	public void hangup(Connection connection) {

	}
}
