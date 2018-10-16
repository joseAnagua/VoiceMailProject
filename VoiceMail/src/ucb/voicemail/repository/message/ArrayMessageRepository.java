package ucb.voicemail.repository.message;

import java.util.ArrayList;
import java.util.HashMap;

import ucb.voicemail.domain.Message;
import ucb.voicemail.domain.MessageRepository;

public class ArrayMessageRepository implements MessageRepository {

	private HashMap<String, MessageQueue> newHashMessages;
	private HashMap<String, MessageQueue> keptHashMessages;
	
	public ArrayMessageRepository(int mailboxCount)
	{
		newHashMessages = new HashMap<String, MessageQueue>();
		keptHashMessages = new HashMap<String, MessageQueue>();
		// Initialize mail boxes.

		for (int i = 0; i < mailboxCount; i++)
		{
			String ext = Integer.toString(i + 1);
			newHashMessages.put(ext, new MessageQueue());
			keptHashMessages.put(ext, new MessageQueue());
		}
    }
	
	@Override
	public void addMessage(String text, String id_mailbox_ext) {
		MessageQueue newMessages = newHashMessages.get(id_mailbox_ext);
		newMessages.add(new Message(id_mailbox_ext, text));
	}

	@Override
	public Message getCurrentMessage(String id_mailbox_ext) {
		MessageQueue newMessages = newHashMessages.get(id_mailbox_ext);
		MessageQueue keptMessages = keptHashMessages.get(id_mailbox_ext);
		if (newMessages.size() > 0)
			return newMessages.peek();
		else if (keptMessages.size() > 0)
	        return keptMessages.peek();
	    else
	        return null;
	}

	@Override
	public Message removeCurrentMessage(String id_mailbox_ext) {
		MessageQueue newMessages = newHashMessages.get(id_mailbox_ext);
		MessageQueue keptMessages = keptHashMessages.get(id_mailbox_ext);
		if (newMessages.size() > 0)
			return newMessages.remove();
	    else if (keptMessages.size() > 0)
	        return keptMessages.remove();
	    else
	        return null;
	}

	@Override
	public void saveCurrentMessage(String id_mailbox_ext) {
		Message message = removeCurrentMessage(id_mailbox_ext);
		MessageQueue keptMessages = keptHashMessages.get(id_mailbox_ext);
	    if (message != null)
	    	keptMessages.add(message);
	}
}
