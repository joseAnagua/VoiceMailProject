package ucb.voicemail.presentation.presenter;

import java.util.ArrayList;

import ucb.voicemail.domain.Connection;
import ucb.voicemail.domain.Mailbox;
import ucb.voicemail.domain.Message;
import ucb.voicemail.domain.Telephone;
import ucb.voicemail.domain.boundary.output.Presenter;
import ucb.voicemail.domain.connection.state.*;

public class ConnectionPresenter implements Presenter {
	
	private ArrayList<Telephone> telephones;
	private Connection connection;
	
	public ConnectionPresenter(Connection connection) {
		telephones = new ArrayList<Telephone>();
		this.connection = connection;
	}
	
	public void addTelephone(Telephone telephone) {
		telephones.add(telephone);
	}
	
	public void deleteTelephone(Telephone telephone) {
		telephones.remove(telephone);
	}
	
	@Override
	public void displayInitialPrompt() {
		connection.setState(new ConnectedState());
		for (Telephone telephone : this.telephones) {
			telephone.getPresenter().displayInitialPrompt();
		}
	}
	
	@Override
	public void displayMailboxMessageError() {
		for (Telephone telephone : this.telephones) {
			telephone.getPresenter().displayMailboxMessageError();
		}
	}
	
	@Override
	public void displayMailboxGreeting(Mailbox mailbox) {
		connection.setState(new RecordingState());
		for (Telephone telephone : this.telephones) {
			telephone.getPresenter().displayMailboxGreeting(mailbox);
		}
	}
	
	@Override
	public void displayMailboxMenu() {
		connection.setState(new MailboxMenuState());
		for (Telephone telephone : this.telephones) {
			telephone.getPresenter().displayMailboxMenu();
		}
	}
	
	@Override
	public void displaypPasscodeMessageError() {
		for (Telephone telephone : this.telephones) {
			telephone.getPresenter().displaypPasscodeMessageError();
		}
	}
	
	@Override
	public void displayMessageMenu() {
		connection.setState(new MessageMenuState());
		for (Telephone telephone : this.telephones) {
			telephone.getPresenter().displayMessageMenu();
		}
	}
	
	@Override
	public void displayCurrentMessage(Message message) {
		for (Telephone telephone : this.telephones) {
			telephone.getPresenter().displayCurrentMessage(message);
		}
	}
	
	@Override
	public void displayChangePasscodeMessage() {
		connection.setState(new ChangePasscodeState());
		for (Telephone telephone : this.telephones) {
			telephone.getPresenter().displayChangePasscodeMessage();
		}
	}
	
	@Override
	public void displayChangeGreetingMessage() {
		connection.setState(new ChangeGreentingState());
		for (Telephone telephone : this.telephones) {
			telephone.getPresenter().displayChangeGreetingMessage();
		}
	}
}
