package ucb.voicemail.domain;

public class RecordingState implements ConnectionState {

	@Override
	public void dial(String key, Connection connection) {
		connection.login(key);
	}

	@Override
	public void record(String voice, Connection connection) {
		connection.currentRecord(voice);
	}

	@Override
	public void hangup(Connection connection) {
		connection.addMessageCurrent();
	}

}
