package ucb.voicemail.domain;

public interface Subject {
	
	public void addUserInterface(UserInterface userInterface);
	public void deleteUserInterface(UserInterface userInterface);
	public void notifyObserver(String output);
	
}
