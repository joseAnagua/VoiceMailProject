package ucb.voicemail.domain.connection.state;

import ucb.voicemail.domain.Connection;
import ucb.voicemail.domain.ConnectionState;
import ucb.voicemail.domain.MailboxRepository;
import ucb.voicemail.domain.boundary.input.ChangeGreetingMailboxUseCase;
import ucb.voicemail.domain.usecases.ChangeGreetingMailboxInteractor;

public class ChangeGreentingState implements ConnectionState {

	@Override
	public void dial(String key, Connection connection) {
		if (key.equals("#")) {
			String ext = connection.getCurrentMailboxId();
			String newGreeting = connection.getCurrentRecording();
			
			connection.setCurrentRecording("");
			
			ChangeGreetingMailboxUseCase interactor = new ChangeGreetingMailboxInteractor(connection.getPresenter(), connection.getMailboxRepository());
			interactor.changeGreeting(ext, newGreeting);
		}
	}

	@Override
	public void record(String voice, Connection connection) {
		connection.currentRecord(voice);
	}

	@Override
	public void hangup(Connection connection) {

	}
}
