package ucb.voicemail.domain;

public interface MessageRepository {
	void addMessage(String text, String id_mailbox_ext);
	Message getCurrentMessage(String id_mailbox_ext);
	Message removeCurrentMessage(String id_mailbox_ext);
	void saveCurrentMessage(String id_mailbox_ext);
}
