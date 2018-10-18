package ucb.voicemail.domain.connection.state;

import ucb.voicemail.domain.Connection;
import ucb.voicemail.domain.ConnectionState;
import ucb.voicemail.domain.MailboxRepository;

public class ChangePasscodeState implements ConnectionState {

	@Override
	public void dial(String key, Connection connection) {
		if (key.equals("#")) {
			MailboxRepository mailboxRepository = connection.getMailboxRepository();
			String currentMailboxId = connection.getCurrentMailboxId();
			mailboxRepository.setPasscode(connection.getAccumulatedKeys(), currentMailboxId);
			connection.setState(new MailboxMenuState());
			connection.getPresenter().displayMailboxMenu();
			connection.setAccumulatedKeys("");
		} else
			connection.addAccumulatedKeys(key);
	}

	@Override
	public void record(String voice, Connection connection) {

	}

	@Override
	public void hangup(Connection connection) {

	}
}
