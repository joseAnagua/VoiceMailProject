package ucb.voicemail.domain.usecases;

import ucb.voicemail.domain.MailboxRepository;
import ucb.voicemail.domain.boundary.input.ChangeGreetingMailboxUseCase;
import ucb.voicemail.domain.boundary.output.Presenter;

public class ChangeGreetingMailboxInteractor implements ChangeGreetingMailboxUseCase {

	private Presenter presenter;
	private MailboxRepository repository;
	
	public ChangeGreetingMailboxInteractor(Presenter presenter, MailboxRepository repository) {
		this.presenter = presenter;
		this.repository = repository;
	}
	
	@Override
	public void changeGreeting(String ext, String newGreeting) {
		repository.setGreeting(newGreeting, ext);
		presenter.displayMailboxMenu();
	}

}
