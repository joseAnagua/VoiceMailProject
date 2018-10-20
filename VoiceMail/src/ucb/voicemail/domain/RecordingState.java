package ucb.voicemail.domain;

public class RecordingState implements ConnectionState {

	@Override
	public void dial(String key, Connection connection) {
		if (key.equals("#")) {
			Mailbox currentMailbox = connection.getMailboxRepository().findMailbox(connection.getCurrentMailboxId());
			if (currentMailbox.checkPasscode(connection.getAccumulatedKeys())) {
				connection.setState(new MailboxMenuState());
				connection.notifyToAll(MAILBOX_MENU_TEXT);
			} else
				connection.notifyToAll("Incorrect mailbox number. Try again!");
			connection.setAccumulatedKeys("");
		} else
			connection.addAccumulatedKeys(key);
	}

	@Override
	public void record(String voice, Connection connection) {
		connection.currentRecord(voice);
	}

	@Override
	public void hangup(Connection connection) {
		MessageRepository messageRepository = connection.getMessageRepository();
		messageRepository.addMessage(connection.getCurrentRecording(), connection.getCurrentMailboxId());
	}

	private static final String MAILBOX_MENU_TEXT = "Enter 1 to listen to your messages\n"
			+ "Enter 2 to change your passcode\n" + "Enter 3 to change your greeting";
}
