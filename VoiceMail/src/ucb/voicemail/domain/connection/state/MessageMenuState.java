package ucb.voicemail.domain.connection.state;

import ucb.voicemail.domain.Connection;
import ucb.voicemail.domain.ConnectionState;
import ucb.voicemail.domain.Message;
import ucb.voicemail.domain.MessageRepository;
import ucb.voicemail.domain.boundary.input.GetCurrentMessageMailboxUseCase;
import ucb.voicemail.domain.boundary.input.RemoveCurrentMessageMailboxUseCase;
import ucb.voicemail.domain.boundary.input.SaveCurrentMessageMailboxUseCase;
import ucb.voicemail.domain.usecases.GetCurrentMessageMailboxInteractor;
import ucb.voicemail.domain.usecases.RemoveCurrentMessageMailboxInteractor;
import ucb.voicemail.domain.usecases.SaveCurrentMessageMailboxInteractor;

public class MessageMenuState implements ConnectionState {

	@Override
	public void dial(String key, Connection connection) {
		String ext = connection.getCurrentMailboxId();
		if (key.equals("1")) {
			GetCurrentMessageMailboxUseCase interactor = new GetCurrentMessageMailboxInteractor(connection.getPresenter(), connection.getMessageRepository());
			interactor.getCurrentMessage(ext);
		} else if (key.equals("2")) {
			SaveCurrentMessageMailboxUseCase interactor = new SaveCurrentMessageMailboxInteractor(connection.getPresenter(), connection.getMessageRepository());
			interactor.saveCurrentMessage(ext);
		} else if (key.equals("3")) {
			RemoveCurrentMessageMailboxUseCase interactor = new RemoveCurrentMessageMailboxInteractor(connection.getPresenter(), connection.getMessageRepository());
			interactor.removeCurrentMessage(ext);
		} else if (key.equals("4")) {
			connection.getPresenter().displayMailboxMenu();
		}
	}

	@Override
	public void record(String voice, Connection connection) {

	}

	@Override
	public void hangup(Connection connection) {

	}
}
