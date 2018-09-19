package ucb.voicemail.domain;

public class Window implements UserInterface{

	private MainMenu mainMenu;

	public Window(MainMenu mainMenu){
		this.mainMenu = mainMenu;
		mainMenu.show();
	}
	
	@Override
	public void updateInterface(String output) {
		this.mainMenu.changeMainLabel(output);
	}
	
	public void run(Connection c) {
		this.mainMenu.setConnection(c);
		this.mainMenu.show();
		
	} 

}
