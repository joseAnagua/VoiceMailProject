package ucb.voicemail.domain.usecases;

import ucb.voicemail.domain.MailboxRepository;
import ucb.voicemail.domain.boundary.input.ChangePasscodeMailboxUseCase;
import ucb.voicemail.domain.boundary.output.Presenter;

public class ChangePasscodeMailboxInteractor implements ChangePasscodeMailboxUseCase {

	private Presenter presenter;
	private MailboxRepository repository;
	
	public ChangePasscodeMailboxInteractor(Presenter presenter, MailboxRepository repository) {
		this.presenter = presenter;
		this.repository = repository;
	}
	
	@Override
	public void changePasscode(String ext, String newPasscode) {
		repository.setPasscode(newPasscode, ext);
		presenter.displayMailboxMenu();
	}

}
