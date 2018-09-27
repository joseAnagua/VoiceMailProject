package ucb.voicemail.domain;
import java.util.ArrayList;

/**
   Connects a phone to the mail system. The purpose of this
   class is to keep track of the state of a connection, since
   the phone itself is just a source of individual key presses.
*/
public class Connection implements Subject
{
   /**
      Construct a Connection object.
      @param s a MailSystem object
      @param p a Telephone object
   */
   public Connection(MailSystem s){
      system = s;
      this.telephones = new ArrayList<Telephone>();
      resetConnection();
   }

   /**
      Respond to the user's pressing a key on the phone touchpad
      @param key the phone key pressed by the user
   */
   public void dial(String key){
      connectionState.dial(key, this);
   }

   /**
      Record voice.
      @param voice voice spoken by the user
   */
   public void record(String voice){ 		
       connectionState.record(voice, this);   
   }
   
   public void currentRecord(String voice) {
	   currentRecording += voice;
   }
   
   /**
      The user hangs up the phone.
   */
   public void hangup()
   {
      connectionState.hangup(this);
      resetConnection();
   }
   
   public void addMessageCurrent() {
	   currentMailbox.addMessage(new Message(currentRecording));
   }
   /**
      Reset the connection to the initial state and prompt
      for mailbox number
   */
   private void resetConnection()
   {
      currentRecording = "";
      accumulatedKeys = "";
      connectionState = new ConnectedState();
      notifyToAll(INITIAL_PROMPT);
   }
   
   public void setState(ConnectionState state) {
	   connectionState = state;
   }
   
   public Mailbox findMailboxByAccumulatedKeys() {
	   currentMailbox = system.findMailbox(accumulatedKeys);
	   return currentMailbox;
   }

   public void setAccumulatedKeys(String text) {
	   accumulatedKeys = text;
   }
   
   public void addAccumulatedKeys(String text) {
	   accumulatedKeys += text;
   }
   
   /**
      Try to log in the user.
      @param key the phone key pressed by the user
   */
   public void login(String key)
   {
      if (key.equals("#"))
      {
         if (currentMailbox.checkPasscode(accumulatedKeys))
         {
            connectionState = new MailboxMenuState();
            this.notifyToAll(MAILBOX_MENU_TEXT);
         }
         else
        	 this.notifyToAll("Incorrect mailbox number. Try again!");
         accumulatedKeys = "";
      }
      else
         accumulatedKeys += key;
   }

   /**
      Change passcode.
      @param key the phone key pressed by the user
   */
   public void changePasscode(String key)
   {
      if (key.equals("#"))
      {
         currentMailbox.setPasscode(accumulatedKeys);
         connectionState = new MailboxMenuState(); 
         this.notifyToAll(MAILBOX_MENU_TEXT);
         accumulatedKeys = "";
      }
      else
         accumulatedKeys += key;
   }

   /**
      Change greeting.
      @param key the phone key pressed by the user
   */
   public void changeGreeting(String key)
   {
      if (key.equals("#"))
      {
         currentMailbox.setGreeting(currentRecording);
         currentRecording = "";
         this.notifyToAll(MAILBOX_MENU_TEXT);
      }
   }

   /**
      Respond to the user's selection from mailbox menu.
      @param key the phone key pressed by the user
   */
   public void mailboxMenu(String key)
   {
      if (key.equals("1"))
      {
         connectionState = new MessageMenuState();
         this.notifyToAll(MESSAGE_MENU_TEXT);
      }
      else if (key.equals("2"))
      {
         connectionState = new ChangePasscodeState();
         this.notifyToAll("Enter new passcode followed by the # key");
      }
      else if (key.equals("3"))
      {
         connectionState = new ChangeGreentingState();
         this.notifyToAll("Record your greeting, then press the # key");
      }
   }

   /**
      Respond to the user's selection from message menu.
      @param key the phone key pressed by the user
   */
   public void messageMenu(String key)
   {
      if (key.equals("1"))
      {
         String output = "";
         Message m = currentMailbox.getCurrentMessage();
         if (m == null) output += "No messages." + "\n";
         else output += m.getText() + "\n";
         output += MESSAGE_MENU_TEXT;
         //phone.speak(output);
         this.notifyToAll(output);
      }
      else if (key.equals("2"))
      {
         currentMailbox.saveCurrentMessage();
         this.notifyToAll(MESSAGE_MENU_TEXT);
      }
      else if (key.equals("3"))
      {
         currentMailbox.removeCurrentMessage();
         this.notifyToAll(MESSAGE_MENU_TEXT);
      }
      else if (key.equals("4"))
      {
         connectionState = new MailboxMenuState();
         this.notifyToAll(MAILBOX_MENU_TEXT);
      }
   }

   /*===================================================================
     Metodos [add - delete - notifyObserver]
     ===================================================================*/
   @Override 
   public void addTelephone(Telephone telephone) {
	   this.telephones.add(telephone);
   }
   
   @Override
   public void deleteTelephone(Telephone telephone) {
	   this.telephones.remove(telephone);
   }
   
   @Override
   public void notifyToAll(String output) {
	   for(Telephone telephone : this.telephones) {
		   telephone.updateInterface(output);
	   }
   }
   
   public void start() {
	   this.resetConnection();
   }  
   //===================================================================  
   
   
   private MailSystem system;
   private Mailbox currentMailbox;
   private String currentRecording;
   private String accumulatedKeys;
   private ConnectionState connectionState;
   private ArrayList<Telephone> telephones;

   private static final String INITIAL_PROMPT = 
         "Enter mailbox number followed by #";  
   
   private static final String MAILBOX_MENU_TEXT = 
         "Enter 1 to listen to your messages\n"
         + "Enter 2 to change your passcode\n"
         + "Enter 3 to change your greeting";
   
   private static final String MESSAGE_MENU_TEXT = 
         "Enter 1 to listen to the current message\n"
         + "Enter 2 to save the current message\n"
         + "Enter 3 to delete the current message\n"
         + "Enter 4 to return to the main menu";
}











