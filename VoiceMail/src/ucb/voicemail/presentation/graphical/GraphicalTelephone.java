package ucb.voicemail.presentation.graphical;

import ucb.voicemail.domain.Connection;
import ucb.voicemail.domain.Telephone;
import ucb.voicemail.domain.boundary.output.Presenter;
import ucb.voicemail.presentation.graphical.view.MainMenu;

public class GraphicalTelephone implements Telephone {

	public GraphicalTelephone(MainMenu mainMenu, Presenter presenter){
		this.mainMenu = mainMenu;
		this.presenter = presenter;
		mainMenu.show();
	}
	
	@Override
	public void updateInterface(String output) {
		this.mainMenu.display(output);
	}
	
	@Override
	public Presenter getPresenter() {
		return presenter;
	}
	
	public void run(Connection c) {
		this.mainMenu.setConnection(c);
		this.mainMenu.show();	
	}
	
	private MainMenu mainMenu;
	private Presenter presenter;
	private Connection connection;
}
