package ucb.voicemail.domain.boundary.input;

public interface ChangeGreetingMailboxUseCase {
	void changeGreeting(String ext, String newGreeting);
}
