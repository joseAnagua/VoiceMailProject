package ucb.voicemail.domain.connection.state;

import ucb.voicemail.domain.Connection;
import ucb.voicemail.domain.ConnectionState;
import ucb.voicemail.domain.Mailbox;
import ucb.voicemail.domain.MessageRepository;
import ucb.voicemail.domain.boundary.input.LoginMailboxUseCase;
import ucb.voicemail.domain.boundary.input.SendMessageToMailboxUseCase;
import ucb.voicemail.domain.usecases.LoginMailboxInteractor;
import ucb.voicemail.domain.usecases.SendMessageToMailboxInteractor;

public class RecordingState implements ConnectionState {

	@Override
	public void dial(String key, Connection connection) {
		if (key.equals("#")) {
			String ext = connection.getCurrentMailboxId();
			String passcode = connection.getAccumulatedKeys();
			
			LoginMailboxUseCase interactor = new LoginMailboxInteractor(connection.getPresenter(), connection.getMailboxRepository());
			interactor.loginMailbox(ext, passcode);
			
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
		String message = connection.getCurrentRecording();
		String ext = connection.getCurrentMailboxId();
		
		SendMessageToMailboxUseCase interactor = new SendMessageToMailboxInteractor(connection.getPresenter(), connection.getMessageRepository());
		interactor.sendMessageToMailbox(ext, message);
	}
}
