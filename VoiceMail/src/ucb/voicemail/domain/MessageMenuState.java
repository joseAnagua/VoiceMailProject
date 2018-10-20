package ucb.voicemail.domain;

public class MessageMenuState implements ConnectionState {

	@Override
	public void dial(String key, Connection connection) {
		MessageRepository messageRepository = connection.getMessageRepository();
		if (key.equals("1")) {
			String output = "";
			Message message = messageRepository.getCurrentMessage(connection.getCurrentMailboxId());
			if (message == null)
				output += "No messages." + "\n";
			else
				output += message.getText() + "\n";
			output += MESSAGE_MENU_TEXT;
			connection.notifyToAll(output);
		} else if (key.equals("2")) {
			messageRepository.saveCurrentMessage(connection.getCurrentMailboxId());
			connection.notifyToAll(MESSAGE_MENU_TEXT);
		} else if (key.equals("3")) {
			messageRepository.removeCurrentMessage(connection.getCurrentMailboxId());
			connection.notifyToAll(MESSAGE_MENU_TEXT);
		} else if (key.equals("4")) {
			connection.setState(new MailboxMenuState());
			connection.notifyToAll(MAILBOX_MENU_TEXT);
		}
	}

	@Override
	public void record(String voice, Connection connection) {

	}

	@Override
	public void hangup(Connection connection) {

	}

	private static final String MAILBOX_MENU_TEXT = 
	         "Enter 1 to listen to your messages\n"
	         + "Enter 2 to change your passcode\n"
	         + "Enter 3 to change your greeting";
	
	private static final String MESSAGE_MENU_TEXT = 
	         "Enter 1 to listen to the current message\n"
	         + "Enter 2 to save the current message\n"
	         + "Enter 3 to delete the current message\n"
	         + "Enter 4 to return to the main menu";
}
