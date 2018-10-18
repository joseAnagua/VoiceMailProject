package ucb.voicemail.domain.connection.state;

import ucb.voicemail.domain.Connection;
import ucb.voicemail.domain.ConnectionState;
import ucb.voicemail.domain.MailboxRepository;

public class ChangeGreentingState implements ConnectionState {

	@Override
	public void dial(String key, Connection connection) {
		if (key.equals("#"))
	    {
			MailboxRepository mailboxRepository = connection.getMailboxRepository();
			String currentMailboxId = connection.getCurrentMailboxId();
	        mailboxRepository.setGreeting(connection.getCurrentRecording(), currentMailboxId);
			connection.setCurrentRecording("");
	        connection.setState(new MailboxMenuState());
	        connection.displayMailboxMenu();
	        //connection.notifyToAll(MAILBOX_MENU_TEXT);
	    }
	}

	@Override
	public void record(String voice, Connection connection) {
		connection.currentRecord(voice);
	}

	@Override
	public void hangup(Connection connection) {

	}
}
