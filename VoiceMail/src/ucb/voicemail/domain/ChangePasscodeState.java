package ucb.voicemail.domain;

public class ChangePasscodeState implements ConnectionState {
	
	@Override
	public void dial(String key, Connection connection) {
		if (key.equals("#"))
		{
			Mailbox currentMailbox = connection.getCurrentMailbox();
			currentMailbox.setPasscode(connection.getAccumulatedKeys());
			connection.setState(new MailboxMenuState());
			connection.notifyToAll(MAILBOX_MENU_TEXT);
			connection.setAccumulatedKeys("");
		}
		else
			connection.addAccumulatedKeys(key);
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
}
