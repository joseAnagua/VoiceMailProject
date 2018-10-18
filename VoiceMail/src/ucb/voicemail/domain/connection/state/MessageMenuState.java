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
			Message message = messageRepository.getCurrentMessage(connection.getCurrentMailboxId());
			connection.getPresenter().displayCurrentMessage(message);
		} else if (key.equals("2")) {
			messageRepository.saveCurrentMessage(connection.getCurrentMailboxId());
			connection.getPresenter().displayMessageMenu();
		} else if (key.equals("3")) {
			messageRepository.removeCurrentMessage(connection.getCurrentMailboxId());
			connection.getPresenter().displayMessageMenu();
		} else if (key.equals("4")) {
			connection.getPresenter().displayMailboxMenu();
		}
	}

	@Override
	public void record(String voice, Connection connection) {

	}

	@Override
	public void hangup(Connection connection) {

	}
}
