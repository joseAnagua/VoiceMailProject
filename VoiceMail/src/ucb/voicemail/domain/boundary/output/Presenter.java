package ucb.voicemail.domain.boundary.output;

import ucb.voicemail.domain.Mailbox;
import ucb.voicemail.domain.Message;

public interface Presenter {
	void displayInitialPrompt();
	void displayMailboxMessageError();
	void displayMailboxGreeting(String greeting);
	void displayMailboxMenu();
	void displaypPasscodeMessageError();
	void displayMessageMenu();
	void displayCurrentMessage(String message);
	void displayChangePasscodeMessage();
	void displayChangeGreetingMessage();
}
