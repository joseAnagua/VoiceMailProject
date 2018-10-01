package ucb.voicemail.domain;
/**
   A mailbox contains messages that can be listed, kept or discarded.
*/
public class Mailbox
{
   /**
      Creates Mailbox object.
      @param aPasscode passcode number
      @param aGreeting greeting string
   */
   public Mailbox(String ext, String passcode, String greeting)
   {
	  this.ext = ext;
      this.passcode = passcode;
      this.greeting = greeting;
      newMessages = new MessageQueue();
      keptMessages = new MessageQueue();
   }

   /**
      Check if the passcode is correct.
      @param aPasscode a passcode to check
      @return true if the supplied passcode matches the mailbox passcode
   */
   public boolean checkPasscode(String aPasscode)
   {
      return aPasscode.equals(passcode);
   }

   /**
      Add a message to the mailbox.
      @param aMessage the message to be added
   */
   public void addMessage(Message aMessage)
   {
      newMessages.add(aMessage);
   }

   /**
      Get the current message.
      @return the current message
   */
   public Message getCurrentMessage()
   {
      if (newMessages.size() > 0)
         return newMessages.peek();
      else if (keptMessages.size() > 0)
         return keptMessages.peek();
      else
         return null;
   }

   /**
      Remove the current message from the mailbox.
      @return the message that has just been removed
   */
   public Message removeCurrentMessage()
   {
      if (newMessages.size() > 0)
         return newMessages.remove();
      else if (keptMessages.size() > 0)
         return keptMessages.remove();
      else
         return null;
   }

   /**
      Save the current message
   */
   public void saveCurrentMessage()
   {
      Message m = removeCurrentMessage();
      if (m != null)
         keptMessages.add(m);
   }

   /**
      Get the mailbox's greeting.
      @return the greeting
   */
   public String getGreeting()
   {
      return greeting;
   }
   
   public String getExt() {
	   return ext;
   }
   
   public String getPasscode() {
	   return passcode;
   }
   
   private MessageQueue newMessages;
   private MessageQueue keptMessages;
   private String ext;
   private String greeting;
   private String passcode;
}
