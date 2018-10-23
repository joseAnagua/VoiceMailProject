package ucb.voicemail.domain.usecases;

import ucb.voicemail.domain.MessageRepository;
import ucb.voicemail.domain.boundary.input.SendMessageToMailboxUseCase;
import ucb.voicemail.domain.boundary.output.Presenter;

public class SendMessageToMailboxInteractor implements SendMessageToMailboxUseCase {

	private MessageRepository repository;
	private Presenter presenter;
	
	public SendMessageToMailboxInteractor(Presenter presenter, MessageRepository repository) {
		this.presenter = presenter;
		this.repository = repository;
	}
	
	@Override
	public void sendMessageToMailbox(String ext, String message) {
		repository.addMessage(message, ext);
		//presenter.displayInitialPrompt();
	}

}
