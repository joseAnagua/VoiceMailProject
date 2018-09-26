package ucb.voicemail.domain;

public class MessageMenuState implements ConnectionState {

	@Override
	public void dial(String key, Connection connection) {
		connection.messageMenu(key);
	}

	@Override
	public void record(String voice, Connection connection) {

	}

	@Override
	public void hangup(Connection connection) {

	}

}
