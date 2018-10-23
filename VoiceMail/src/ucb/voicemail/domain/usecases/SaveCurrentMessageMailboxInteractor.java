package ucb.voicemail.domain.usecases;

import ucb.voicemail.domain.MessageRepository;
import ucb.voicemail.domain.boundary.input.SaveCurrentMessageMailboxUseCase;
import ucb.voicemail.domain.boundary.output.Presenter;

public class SaveCurrentMessageMailboxInteractor implements SaveCurrentMessageMailboxUseCase {

	private Presenter presenter;
	private MessageRepository repository;
	
	public SaveCurrentMessageMailboxInteractor(Presenter presenter, MessageRepository repository) {
		this.presenter = presenter;
		this.repository = repository;
	}
	
	@Override
	public void saveCurrentMessage(String ext) {
		repository.saveCurrentMessage(ext);
		presenter.displayMessageMenu();
	}

}
