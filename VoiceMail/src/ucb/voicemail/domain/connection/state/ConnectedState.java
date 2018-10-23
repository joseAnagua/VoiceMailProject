package ucb.voicemail.domain.connection.state;

import ucb.voicemail.domain.Connection;
import ucb.voicemail.domain.ConnectionState;
import ucb.voicemail.domain.Mailbox;
import ucb.voicemail.domain.boundary.input.GetGreetingMailboxUseCase;
import ucb.voicemail.domain.usecases.GetGreetingMailboxInteractor;

public class ConnectedState implements ConnectionState {

	@Override
	public void dial(String key, Connection connection) {
		if (key.equals("#")) {
			connection.setCurrentMailboxId(connection.getAccumulatedKeys());
			connection.setAccumulatedKeys("");
			
			GetGreetingMailboxUseCase interactor = new GetGreetingMailboxInteractor(connection.getPresenter(), connection.getMailboxRepository());
			String requestModel = connection.getCurrentMailboxId();
			interactor.getGreeting(requestModel);						
		} else {
			connection.addAccumulatedKeys(key);
		}
	}

	@Override
	public void record(String voice, Connection connection) {

	}

	@Override
	public void hangup(Connection connection) {

	}

}
