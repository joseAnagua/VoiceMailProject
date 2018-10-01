package ucb.voicemail.domain;
import java.util.ArrayList;

public class Connection implements Subject
{
   public Connection(MailboxRepository s){
      system = s;
      this.telephones = new ArrayList<Telephone>();
      resetConnection();
   }

   public void dial(String key){
      connectionState.dial(key, this);
   }

   public void record(String voice){ 		
       connectionState.record(voice, this);   
   }
   
   public void currentRecord(String voice) {
	   currentRecording += voice;
   }
   
   public void hangup()
   {
      connectionState.hangup(this);
      resetConnection();
   }
   
   public void addMessageCurrent() {
	   currentMailbox.addMessage(new Message("0", "0", currentRecording));
   }
   
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
	   return currentMailbox = system.findMailbox(accumulatedKeys);
   }

   public void setAccumulatedKeys(String text) {
	   accumulatedKeys = text;
   }
   
   public void setCurrentRecording(String text) {
	   currentRecording = text;
   }
   
   public void addAccumulatedKeys(String text) {
	   accumulatedKeys += text;
   }
   
   public Mailbox getCurrentMailbox() {
	   return currentMailbox;
   }

   public String getAccumulatedKeys() {
	   return accumulatedKeys;
   }

   public String getCurrentRecording() {
	   return currentRecording;
   }
   
   public MailboxRepository getMailboxRepository() {
	   return system;
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
   
   private MailboxRepository system;
   private Mailbox currentMailbox;
   private String currentRecording;
   private String accumulatedKeys;
   private ConnectionState connectionState;
   private ArrayList<Telephone> telephones;

   private static final String INITIAL_PROMPT = 
         "Enter mailbox number followed by #";  
}
