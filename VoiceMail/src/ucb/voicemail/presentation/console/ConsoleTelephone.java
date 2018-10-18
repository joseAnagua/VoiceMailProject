package ucb.voicemail.presentation.console;

import java.util.Scanner;

import ucb.voicemail.domain.Connection;
import ucb.voicemail.domain.Telephone;
import ucb.voicemail.domain.boundary.output.Presenter;

public class ConsoleTelephone implements Telephone {

	public ConsoleTelephone(Scanner aScanner, Presenter presenter) {
		scanner = aScanner;
		this.presenter = presenter;
	}

	public void speak(String output) {
		System.out.println(output);
	}

	@Override
	public void updateInterface(String output) {
		System.out.println(output);
	}

	public void run(Connection c) {
		boolean more = true;
		while (more) {
			String input = scanner.nextLine();
			if (input == null)
				return;
			if (input.equalsIgnoreCase(HANGUP))
				c.hangup();
			else if (input.equalsIgnoreCase(QUIT))
				more = false;
			else if (input.length() == 1 && OPTIONS_ALPHA_NUMERIC.indexOf(input) >= 0)
				c.dial(input);
			else
				c.record(input);
		}
	}

	@Override
	public Presenter getPresenter() {
		return presenter;
	}
	
	private Presenter presenter;
	private Scanner scanner;
	private static final String HANGUP = "H";
	private static final String QUIT = "Q";
	private static final String OPTIONS_ALPHA_NUMERIC = "1234567890#";
}
