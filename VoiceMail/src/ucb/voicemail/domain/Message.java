package ucb.voicemail.domain;
/**
   A message left by the caller.
*/
public class Message
{
   /**
      Construct a Message object.
      @param messageText the message text
   */
   public Message(String id_message, String id_mailbox_ext, String messageText)
   {
	  this.id_message = id_message;
	  this.id_mailbox_ext = id_mailbox_ext;
      text = messageText;
   }

   /**
      Get the message text.
      @return message text
   */
   public String getText()
   {
      return text;
   }

   private String text;
   private String id_message;
   private String id_mailbox_ext;
}
