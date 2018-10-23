package ucb.voicemail.domain.usecases;

import ucb.voicemail.domain.Mailbox;
import ucb.voicemail.domain.MailboxRepository;
import ucb.voicemail.domain.boundary.input.GetGreetingMailboxUseCase;
import ucb.voicemail.domain.boundary.output.Presenter;

public class GetGreetingMailboxInteractor implements GetGreetingMailboxUseCase {

	private Presenter presenter;
	private MailboxRepository repository;
	
	public GetGreetingMailboxInteractor(Presenter presenter, MailboxRepository repository) {
		this.presenter = presenter;
		this.repository = repository;
	}
	
	@Override
	public void getGreeting(String ext) {
		Mailbox mailbox = repository.findMailbox(ext);
		if(mailbox != null) {
			
			String responseModel = mailbox.getGreeting();
			
			presenter.displayMailboxGreeting(responseModel);
		}
		else {
			presenter.displayMailboxMessageError();
		}
	}

}
