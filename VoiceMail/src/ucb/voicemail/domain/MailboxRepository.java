package ucb.voicemail.domain;

public interface MailboxRepository {
	Mailbox findMailbox(String ext);
	void setPasscode(String passcode, String ext);
	void setGreeting(String greeting, String ext);
}
