package ucb.voicemail.presentation.graphical;

import ucb.voicemail.domain.Connection;
import ucb.voicemail.domain.Telephone;

public class Window implements Telephone{

	public Window(MainMenu mainMenu){
		this.mainMenu = mainMenu;
		mainMenu.show();
	}
	
	public void updateInterface(String output) {
		this.mainMenu.changeMainLabel(output);
	}
	
	public void run(Connection c) {
		this.mainMenu.setConnection(c);
		this.mainMenu.show();
		
	} 
	
	private MainMenu mainMenu;
	private Connection connection;
}

