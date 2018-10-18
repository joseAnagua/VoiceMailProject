package ucb.voicemail.domain.connection.state;

import ucb.voicemail.domain.Connection;
import ucb.voicemail.domain.ConnectionState;

public class MailboxMenuState implements ConnectionState {

	@Override
	public void dial(String key, Connection connection) {
		if (key.equals("1")) {
			connection.getPresenter().displayMessageMenu();
		} else if (key.equals("2")) {
			connection.getPresenter().displayChangePasscodeMessage();
		} else if (key.equals("3")) {
			connection.getPresenter().displayChangeGreetingMessage();
		}
	}

	@Override
	public void record(String voice, Connection connection) {

	}

	@Override
	public void hangup(Connection connection) {

	}
}
