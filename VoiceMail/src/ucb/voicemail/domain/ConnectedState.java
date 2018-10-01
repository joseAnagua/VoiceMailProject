package ucb.voicemail.domain;

public class ConnectedState implements ConnectionState {

	@Override
	public void dial(String key, Connection connection) {
		if (key.equals("#"))
		{
			Mailbox currentMailbox = connection.findMailboxByAccumulatedKeys();
			if (currentMailbox != null)
			{
				connection.setState(new RecordingState());
				connection.notifyToAll(currentMailbox.getGreeting());
			}
			else
				connection.notifyToAll("Incorrect mailbox number. Try again!");
			connection.setAccumulatedKeys("");
		}
		else
			connection.addAccumulatedKeys(key);
	}

	@Override
	public void record(String voice, Connection connection) {
		
	}

	@Override
	public void hangup(Connection connection) {

	}

}
