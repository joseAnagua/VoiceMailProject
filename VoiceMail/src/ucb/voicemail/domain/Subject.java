package ucb.voicemail.domain;

public interface Subject {
	public void addTelephone(Telephone userInterface);
	public void deleteTelephone(Telephone userInterface);
	public void notifyToAll(String output);
	
}
