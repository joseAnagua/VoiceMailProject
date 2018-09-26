package ucb.voicemail.domain;

public class ChangePasscodeState implements ConnectionState {

	@Override
	public void dial(String key, Connection connection) {
		connection.changePasscode(key);
	}

	@Override
	public void record(String voice, Connection connection) {

	}

	@Override
	public void hangup(Connection connection) {

	}

}
