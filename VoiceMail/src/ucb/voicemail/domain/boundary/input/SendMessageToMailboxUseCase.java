package ucb.voicemail.domain.boundary.input;

public interface SendMessageToMailboxUseCase {
	void sendMessageToMailbox(String ext, String message);
}
