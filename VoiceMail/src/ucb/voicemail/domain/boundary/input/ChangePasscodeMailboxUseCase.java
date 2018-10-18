package ucb.voicemail.domain.boundary.input;

public interface ChangePasscodeMailboxUseCase {
	void changePasscode(String ext, String newPasscode);
}
