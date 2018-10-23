package ucb.voicemail.domain.usecases;

import ucb.voicemail.domain.Message;
import ucb.voicemail.domain.MessageRepository;
import ucb.voicemail.domain.boundary.input.GetCurrentMessageMailboxUseCase;
import ucb.voicemail.domain.boundary.output.Presenter;

public class GetCurrentMessageMailboxInteractor implements GetCurrentMessageMailboxUseCase {

	private Presenter presenter;
	private MessageRepository repository;
	
	public GetCurrentMessageMailboxInteractor(Presenter presenter, MessageRepository repository) {
		this.presenter = presenter;
		this.repository = repository;
	}
	
	@Override
	public void getCurrentMessage(String ext) {
		Message currentMessage = repository.getCurrentMessage(ext);
		presenter.displayCurrentMessage(currentMessage);
	}

}
