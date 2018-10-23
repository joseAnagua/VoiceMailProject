package ucb.voicemail.domain;

import ucb.voicemail.domain.boundary.output.Presenter;
import ucb.voicemail.presentation.presenter.ConnectionPresenter;

public class Connection implements Subject {

	public Connection(MailboxRepository mailboxRepository, MessageRepository messageRepository) {
		this.mailboxRepository = mailboxRepository;
		this.messageRepository = messageRepository;
		this.presenter = new ConnectionPresenter(this);
		resetConnection();
	}

	public void dial(String key) {
		connectionState.dial(key, this);
	}

	public void record(String voice) {
		connectionState.record(voice, this);
	}

	public void hangup() {
		connectionState.hangup(this);
		resetConnection();
	}

	public void currentRecord(String voice) {
		currentRecording += voice;
	}

	private void resetConnection() {
		currentRecording = "";
		accumulatedKeys = "";
		this.getPresenter().displayInitialPrompt();
	}

	public void setState(ConnectionState state) {
		connectionState = state;
	}

	public ConnectionState getState() {
		return connectionState;
	}

	public void setCurrentMailboxId(String ext) {
		id_current_mailbox = ext;
	}
	
	public void setAccumulatedKeys(String text) {
		accumulatedKeys = text;
	}

	public void setCurrentRecording(String text) {
		currentRecording = text;
	}

	public void addAccumulatedKeys(String text) {
		accumulatedKeys += text;
	}

	public String getCurrentMailboxId() {
		return id_current_mailbox;
	}

	public String getAccumulatedKeys() {
		return accumulatedKeys;
	}

	public String getCurrentRecording() {
		return currentRecording;
	}

	public MailboxRepository getMailboxRepository() {
		return mailboxRepository;
	}

	public MessageRepository getMessageRepository() {
		return messageRepository;
	}

	public Presenter getPresenter() {
		return presenter;
	}

	/*
	 * =================================================================== Metodos
	 * [add - delete - notifyObserver]
	 * ===================================================================
	 */
	@Override
	public void addTelephone(Telephone telephone) {
		this.presenter.addTelephone(telephone);
	}

	@Override
	public void deleteTelephone(Telephone telephone) {
		this.presenter.deleteTelephone(telephone);
	}

	public void start() {
		this.resetConnection();
	}

	private MailboxRepository mailboxRepository;
	private MessageRepository messageRepository;
	private String id_current_mailbox;
	private String currentRecording;
	private String accumulatedKeys;
	private ConnectionState connectionState;
	private ConnectionPresenter presenter;
}
