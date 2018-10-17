package ucb.voicemail.presentation.graphical.presenter;

import ucb.voicemail.domain.Mailbox;
import ucb.voicemail.domain.Message;
import ucb.voicemail.domain.boundary.output.Presenter;
import ucb.voicemail.presentation.graphical.view.MainMenu;

public class GraphicalPresenter implements Presenter {
	
	private static final String INITIAL_PROMPT = "Enter mailbox number followed by #";
	private static final String MESSAGE_MAILBOX_ERROR = "Incorrect mailbox number. Try again!";
	private static final String MAILBOX_MENU_TEXT = 
	         "Enter 1 to listen to your messages\n"
	         + "Enter 2 to change your passcode\n"
	         + "Enter 3 to change your greeting";
	private static final String MESSAGE_PASSCODE_ERROR = "Incorrect passcode. Try again!";
	private static final String MESSAGE_MENU_TEXT = 
		       "Enter 1 to listen to the current message\n"
		       + "Enter 2 to save the current message\n"
		       + "Enter 3 to delete the current message\n"
		       + "Enter 4 to return to the main menu";
	private static final String CHANGE_PASSCODE_MESSAGE = "Enter new passcode followed by the # key";
	private static final String CHANGE_GREETING_MESSAGE = "Record your greeting, then press the # key";
	
	private MainMenu view;
	
	public GraphicalPresenter(MainMenu view) {
		this.view = view;
	}
	
	@Override
	public void displayInitialPrompt() {
		view.display(INITIAL_PROMPT);
	}

	@Override
	public void displayMailboxMessageError() {
		view.display(MESSAGE_MAILBOX_ERROR);
	}

	@Override
	public void displayMailboxGreeting(Mailbox mailbox) {
		String viewModel = mailbox.getGreeting();
		view.display(viewModel);
	}

	@Override
	public void displayMailboxMenu() {
		view.display(MAILBOX_MENU_TEXT);
	}

	@Override
	public void displaypPasscodeMessageError() {
		view.display(MESSAGE_PASSCODE_ERROR);
	}

	@Override
	public void displayMessageMenu() {
		view.display(MESSAGE_MENU_TEXT);
	}

	@Override
	public void displayCurrentMessage(Message message) {
		String viewModel;
		if(message != null) {
			viewModel = message.getText() + "\n";
		}
		else {
			viewModel = "No messages." + "\n";
		}
		viewModel += MESSAGE_MENU_TEXT;
		view.display(viewModel);
	}

	@Override
	public void displayChangePasscodeMessage() {
		view.display(CHANGE_PASSCODE_MESSAGE);
	}

	@Override
	public void displayChangeGreetingMessage() {
		view.display(CHANGE_GREETING_MESSAGE);
	}
	
}
