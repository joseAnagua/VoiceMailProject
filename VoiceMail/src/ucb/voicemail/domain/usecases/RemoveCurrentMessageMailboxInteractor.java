package ucb.voicemail.domain.usecases;

import ucb.voicemail.domain.MessageRepository;
import ucb.voicemail.domain.boundary.input.RemoveCurrentMessageMailboxUseCase;
import ucb.voicemail.domain.boundary.output.Presenter;

public class RemoveCurrentMessageMailboxInteractor implements RemoveCurrentMessageMailboxUseCase {

	private Presenter presenter;
	private MessageRepository repository;
	
	public RemoveCurrentMessageMailboxInteractor(Presenter presenter, MessageRepository repository) {
		this.presenter = presenter;
		this.repository = repository;
	}
	
	@Override
	public void removeCurrentMessage(String ext) {
		repository.removeCurrentMessage(ext);
		presenter.displayMessageMenu();
	}

}
