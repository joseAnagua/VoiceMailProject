package ucb.voicemail.domain;

public class ConnectedState implements ConnectionState {

	@Override
	public void dial(String key, Connection connection) {
		connection.connect(key);
	}

	@Override
	public void record(String voice, Connection connection) {
		
	}

	@Override
	public void hangup(Connection connection) {

	}

}
