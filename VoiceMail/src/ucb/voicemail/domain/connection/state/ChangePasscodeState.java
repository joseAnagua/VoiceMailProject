package ucb.voicemail.domain.connection.state;

import ucb.voicemail.domain.Connection;
import ucb.voicemail.domain.ConnectionState;
import ucb.voicemail.domain.MailboxRepository;
import ucb.voicemail.domain.boundary.input.ChangePasscodeMailboxUseCase;
import ucb.voicemail.domain.usecases.ChangePasscodeMailboxInteractor;

public class ChangePasscodeState implements ConnectionState {

	@Override
	public void dial(String key, Connection connection) {
		if (key.equals("#")) {
			String ext = connection.getCurrentMailboxId();
			String newPasscode = connection.getAccumulatedKeys();
			
			connection.setAccumulatedKeys("");
			
			ChangePasscodeMailboxUseCase interactor = new ChangePasscodeMailboxInteractor(connection.getPresenter(), connection.getMailboxRepository());
			interactor.changePasscode(ext, newPasscode);
		} else
			connection.addAccumulatedKeys(key);
	}

	@Override
	public void record(String voice, Connection connection) {

	}

	@Override
	public void hangup(Connection connection) {

	}
}
