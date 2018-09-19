package ucb.voicemail.domain;

public class Window implements UserInterface{

	private Main mainMenu;

	public Window(Main mainMenu){
		this.mainMenu = mainMenu;
		mainMenu.show();
	}
	
	@Override
	public void updateInterface(String output) {

		
	}

}
