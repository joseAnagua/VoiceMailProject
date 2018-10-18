package ucb.voicemail.domain.connection.state;

import ucb.voicemail.domain.Connection;
import ucb.voicemail.domain.ConnectionState;
import ucb.voicemail.domain.Mailbox;
import ucb.voicemail.domain.MessageRepository;

public class RecordingState implements ConnectionState {
	
	@Override
	public void dial(String key, Connection connection) {
		if (key.equals("#"))
	    {
			Mailbox currentMailbox = connection.getMailboxRepository().findMailbox(connection.getCurrentMailboxId());
			if (currentMailbox.checkPasscode(connection.getAccumulatedKeys()))
	        {
				connection.setState(new MailboxMenuState());
	            connection.displayMailboxMenu();
				//connection.notifyToAll(MAILBOX_MENU_TEXT);
	        }
	        else {
	        	connection.displaypPasscodeMessageError();
	        	//connection.notifyToAll("Incorrect passcode. Try again!");
	        }
	        connection.setAccumulatedKeys("");
	   }
	   else
		   connection.addAccumulatedKeys(key);
	}

	@Override
	public void record(String voice, Connection connection) {
		connection.currentRecord(voice);
	}

	@Override
	public void hangup(Connection connection) {
		MessageRepository messageRepository = connection.getMessageRepository();
		messageRepository.addMessage(connection.getCurrentRecording(), connection.getCurrentMailboxId());
	}
}
