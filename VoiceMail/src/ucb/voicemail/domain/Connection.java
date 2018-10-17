package ucb.voicemail.domain;

import java.util.ArrayList;

import ucb.voicemail.domain.connection.state.ConnectedState;

public class Connection implements Subject {

	public Connection(MailboxRepository mailboxRepository, MessageRepository messageRepository) {
		this.mailboxRepository = mailboxRepository;
		this.messageRepository = messageRepository;
		this.telephones = new ArrayList<Telephone>();
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
		connectionState = new ConnectedState();
		notifyToAll(INITIAL_PROMPT);
	}

	public void setState(ConnectionState state) {
		connectionState = state;
	}

	public ConnectionState getState() {
		return connectionState;
	}

	public Mailbox findMailboxByAccumulatedKeys() {
		Mailbox currentMailbox = mailboxRepository.findMailbox(accumulatedKeys);
		if(currentMailbox != null) {
			id_current_mailbox = currentMailbox.getExt();
		}
		return currentMailbox;
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

	/*
	 * =================================================================== Metodos
	 * [add - delete - notifyObserver]
	 * ===================================================================
	 */
	@Override
	public void addTelephone(Telephone telephone) {
		this.telephones.add(telephone);
	}

	@Override
	public void deleteTelephone(Telephone telephone) {
		this.telephones.remove(telephone);
	}

	@Override
	public void notifyToAll(String output) {
		for (Telephone telephone : this.telephones) {
			telephone.updateInterface(output);
		}
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
	private ArrayList<Telephone> telephones;

	private static final String INITIAL_PROMPT = "Enter mailbox number followed by #";
	
	public void displayInitialPrompt() {
		for (Telephone telephone : this.telephones) {
			telephone.getPresenter().displayInitialPrompt();
		}
	}
	
	public void displayMailboxMessageError() {
		for (Telephone telephone : this.telephones) {
			telephone.getPresenter().displayMailboxMessageError();
		}
	}
	
	public void displayMailboxGreeting(Mailbox mailbox) {
		for (Telephone telephone : this.telephones) {
			telephone.getPresenter().displayMailboxGreeting(mailbox);
		}
	}
	
	public void displayMailboxMenu() {
		for (Telephone telephone : this.telephones) {
			telephone.getPresenter().displayMailboxMenu();
		}
	}
	
	public void displaypPasscodeMessageError() {
		for (Telephone telephone : this.telephones) {
			telephone.getPresenter().displaypPasscodeMessageError();
		}
	}
	
	public void displayMessageMenu() {
		for (Telephone telephone : this.telephones) {
			telephone.getPresenter().displayMessageMenu();
		}
	}
	
	public void displayCurrentMessage(Message message) {
		for (Telephone telephone : this.telephones) {
			telephone.getPresenter().displayCurrentMessage(message);
		}
	}
	
	public void displayChangePasscodeMessage() {
		for (Telephone telephone : this.telephones) {
			telephone.getPresenter().displayChangePasscodeMessage();
		}
	}
	
	public void displayChangeGreetingMessage() {
		for (Telephone telephone : this.telephones) {
			telephone.getPresenter().displayChangeGreetingMessage();
		}
	}
}
