package ucb.voicemail.presentation.presenter;

import java.util.ArrayList;

import ucb.voicemail.domain.Connection;
import ucb.voicemail.domain.Mailbox;
import ucb.voicemail.domain.Message;
import ucb.voicemail.domain.Telephone;
import ucb.voicemail.domain.boundary.output.Presenter;

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
		for (Telephone telephone : this.telephones) {
			telephone.getPresenter().displayMailboxGreeting(mailbox);
		}
	}
	
	@Override
	public void displayMailboxMenu() {
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
		for (Telephone telephone : this.telephones) {
			telephone.getPresenter().displayChangePasscodeMessage();
		}
	}
	
	@Override
	public void displayChangeGreetingMessage() {
		for (Telephone telephone : this.telephones) {
			telephone.getPresenter().displayChangeGreetingMessage();
		}
	}
}
