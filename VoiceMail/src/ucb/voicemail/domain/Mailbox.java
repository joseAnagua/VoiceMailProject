package ucb.voicemail.domain;

/**
 * A mailbox contains messages that can be listed, kept or discarded.
 */
public class Mailbox {
	public Mailbox(String ext, String passcode, String greeting) {
		this.ext = ext;
		this.passcode = passcode;
		this.greeting = greeting;
	}

	public boolean checkPasscode(String aPasscode) {
		return aPasscode.equals(passcode);
	}

	public String getGreeting() {
		return greeting;
	}

	public String getExt() {
		return ext;
	}

	public String getPasscode() {
		return passcode;
	}

	private String ext;
	private String greeting;
	private String passcode;
}

