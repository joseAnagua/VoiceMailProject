package ucb.voicemail.domain;

public class MailboxMenuState implements ConnectionState {

	@Override
	public void dial(String key, Connection connection) {
		connection.mailboxMenu(key);
	}

	@Override
	public void record(String voice, Connection connection) {

	}

	@Override
	public void hangup(Connection connection) {

	}

}
