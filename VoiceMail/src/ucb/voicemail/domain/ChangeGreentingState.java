package ucb.voicemail.domain;

public class ChangeGreentingState implements ConnectionState {

	@Override
	public void dial(String key, Connection connection) {
		if (key.equals("#"))
	    {
			MailboxRepository mailboxRepository = connection.getMailboxRepository();
			Mailbox currentMailbox = connection.getCurrentMailbox();
	        mailboxRepository.setGreeting(connection.getCurrentRecording(), currentMailbox.getExt());
			connection.setCurrentRecording("");
	        connection.setState(new MailboxMenuState());
	        connection.notifyToAll(MAILBOX_MENU_TEXT);
	    }
	}

	@Override
	public void record(String voice, Connection connection) {
		connection.currentRecord(voice);
	}

	@Override
	public void hangup(Connection connection) {

	}

	private static final String MAILBOX_MENU_TEXT = 
	         "Enter 1 to listen to your messages\n"
	         + "Enter 2 to change your passcode\n"
	         + "Enter 3 to change your greeting";
}
