package ucb.voicemail.domain.usecases;

import ucb.voicemail.domain.Mailbox;
import ucb.voicemail.domain.MailboxRepository;
import ucb.voicemail.domain.boundary.input.LoginMailboxUseCase;
import ucb.voicemail.domain.boundary.output.Presenter;

public class LoginMailboxInteractor implements LoginMailboxUseCase {

	private Presenter presenter;
	private MailboxRepository repository;
	
	public LoginMailboxInteractor(Presenter presenter, MailboxRepository repository) {
		this.presenter = presenter;
		this.repository = repository;
	}
	
	@Override
	public void loginMailbox(String ext, String passcode) {
		Mailbox currentMailbox = repository.findMailbox(ext);
		if (currentMailbox.checkPasscode(passcode)) {
			presenter.displayMailboxMenu();
		} else {
			presenter.displaypPasscodeMessageError();
		}
	}

}
