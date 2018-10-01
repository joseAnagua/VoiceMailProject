package ucb.voicemail.domain;
import java.util.ArrayList;

/**
   A system of voice mail boxes.
*/
public class ArrayMailboxRepository implements MailboxRepository
{
	
	public ArrayMailboxRepository(int mailboxCount)
	{
		mailboxes = new ArrayList<Mailbox>();

		// Initialize mail boxes.

		for (int i = 0; i < mailboxCount; i++)
		{
			String passcode = "" + (i + 1);
			String greeting = "You have reached mailbox " +"["+ (i + 1)+"]"
               + ". \nPlease leave a message now.";
			String ext = Integer.toString(i + 1);
			mailboxes.add(new Mailbox(ext, passcode, greeting));
		}
    }

    @Override
    public Mailbox findMailbox(String ext)
    {
    	int i = Integer.parseInt(ext);
      	if (1 <= i && i <= mailboxes.size())
      		return  mailboxes.get(i - 1);
      	else return null;
   	}
   
    private ArrayList<Mailbox> mailboxes;

	@Override
	public void setPasscode(String passcode, String ext) {
		int i = Integer.parseInt(ext);
      	if (1 <= i && i <= mailboxes.size()) {
      		Mailbox actualMailbox = mailboxes.get(i - 1);
      		mailboxes.set(i - 1, new Mailbox(actualMailbox.getExt(), passcode, actualMailbox.getGreeting()));
      	}
	}
	
	@Override
	public void setGreeting(String greeting, String ext) {
		int i = Integer.parseInt(ext);
      	if (1 <= i && i <= mailboxes.size()) {
      		Mailbox actualMailbox = mailboxes.get(i - 1);
      		mailboxes.set(i - 1, new Mailbox(actualMailbox.getExt(), actualMailbox.getPasscode(), greeting));
      	}
	}
}
