package ucb.voicemail.domain;

/**
 * A mailbox contains messages that can be listed, kept or discarded.
 */
public class Mailbox {
	/**
	 * Creates Mailbox object.
	 * 
	 * @param aPasscode passcode number
	 * @param aGreeting greeting string
	 */
	public Mailbox(String ext, String aPasscode, String aGreeting) {
		this.ext = ext;
		passcode = aPasscode;
		greeting = aGreeting;
	}

	/**
	 * Check if the passcode is correct.
	 * 
	 * @param aPasscode a passcode to check
	 * @return true if the supplied passcode matches the mailbox passcode
	 */
	public boolean checkPasscode(String aPasscode) {
		return aPasscode.equals(passcode);
	}

	/**
	 * Change mailbox's greeting.
	 * 
	 * @param newGreeting the new greeting string
	 */
	public void setGreeting(String newGreeting) {
		greeting = newGreeting;
	}

	/**
	 * Change mailbox's passcode.
	 * 
	 * @param newPasscode the new passcode
	 */
	public void setPasscode(String newPasscode) {
		passcode = newPasscode;
	}

	/**
	 * Get the mailbox's greeting.
	 * 
	 * @return the greeting
	 */
	public String getGreeting() {
		return greeting;
	}
	
	public String getPasscode() {
		return passcode;
	}
	
	public String getExt() {
		return ext;
	}

	private String ext;
	private String greeting;
	private String passcode;
}
