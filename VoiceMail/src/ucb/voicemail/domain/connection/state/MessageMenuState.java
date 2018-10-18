package ucb.voicemail.domain.connection.state;

import ucb.voicemail.domain.Connection;
import ucb.voicemail.domain.ConnectionState;
import ucb.voicemail.domain.Message;
import ucb.voicemail.domain.MessageRepository;

public class MessageMenuState implements ConnectionState {

	@Override
	public void dial(String key, Connection connection) {
		MessageRepository messageRepository = connection.getMessageRepository();
		if (key.equals("1")) {
			String output = "";
			Message message = messageRepository.getCurrentMessage(connection.getCurrentMailboxId());
			connection.displayCurrentMessage(message);
			/*if (message == null)
				output += "No messages." + "\n";
			else
				output += message.getText() + "\n";
			output += MESSAGE_MENU_TEXT;
			connection.notifyToAll(output);*/
		} else if (key.equals("2")) {
			messageRepository.saveCurrentMessage(connection.getCurrentMailboxId());
			connection.displayMessageMenu();
			//connection.notifyToAll(MESSAGE_MENU_TEXT);
		} else if (key.equals("3")) {
			messageRepository.removeCurrentMessage(connection.getCurrentMailboxId());
			connection.displayMessageMenu();
			//connection.notifyToAll(MESSAGE_MENU_TEXT);
		} else if (key.equals("4")) {
			connection.setState(new MailboxMenuState());
			connection.displayMailboxMenu();
			//connection.notifyToAll(MAILBOX_MENU_TEXT);
		}
	}

	@Override
	public void record(String voice, Connection connection) {

	}

	@Override
	public void hangup(Connection connection) {

	}
}
