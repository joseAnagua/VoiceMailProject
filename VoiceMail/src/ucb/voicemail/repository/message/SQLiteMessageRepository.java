package ucb.voicemail.repository.message;

import java.sql.Connection;
import java.sql.Statement;

import ucb.voicemail.domain.Message;
import ucb.voicemail.domain.MessageRepository;

public class SQLiteMessageRepository implements MessageRepository {
	private Connection connection;
	
	public SQLiteMessageRepository(Connection connection) {
		try {
			this.connection = connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addMessage(String text, String id_mailbox_ext) {
		try {
            String query = "INSERT INTO new_message(text,mailbox_id) VALUES('" + text + "'," + id_mailbox_ext + ")";
            Statement st = connection.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            // NADA
        }
	}

	@Override
	public Message getCurrentMessage(String id_mailbox_ext) {
		try {
            String query = "SELECT * FROM new_message WHERE mailbox_id=" + id_mailbox_ext + " LIMIT 1";
            Statement st = connection.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(query);
            if (!resultSet.next()) {
                query = "SELECT * FROM kept_message WHERE mailbox_id=" + id_mailbox_ext + " LIMIT 1";
                st = connection.createStatement();
                resultSet = st.executeQuery(query);
                if(resultSet.next()) {
                    return new Message(id_mailbox_ext, resultSet.getString("text"));
                }
                else {
                    return null;
                }
            }
            else {
                return new Message(id_mailbox_ext, resultSet.getString("text"));
            }
        } catch (Exception e) {
            // NADA
        }
        return null;
	}

	@Override
	public Message removeCurrentMessage(String id_mailbox_ext) {
		try {
            String query = "SELECT * FROM new_message WHERE mailbox_id=" + id_mailbox_ext + " LIMIT 1";
            Statement st = connection.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(query);
            if (!resultSet.next()) {
                query = "SELECT * FROM kept_message WHERE mailbox_id=" + id_mailbox_ext + " LIMIT 1";
                Statement st2 = connection.createStatement();
                st2 = connection.createStatement();
                resultSet = st2.executeQuery(query);
                if(resultSet.next()) {
                    query = "DELETE FROM kept_message WHERE id IN " + 
                    		"(SELECT id FROM kept_message WHERE mailbox_id=" + id_mailbox_ext + " LIMIT 1)";
                    Statement stDelete = connection.createStatement();
                    stDelete.executeUpdate(query);
                    return new Message(id_mailbox_ext, resultSet.getString("text"));
                }
                else {
                    return null;
                }
            }
            else {
                query = "DELETE FROM new_message WHERE id = " + 
                		"(SELECT id FROM new_message WHERE mailbox_id=" + id_mailbox_ext + " LIMIT 1)";
                Statement stDelete = connection.createStatement();
                stDelete.executeUpdate(query);
                return new Message(id_mailbox_ext, resultSet.getString("text"));
            }
        } catch (Exception e) {
            // NADA
        }
        return null;
	}

	@Override
	public void saveCurrentMessage(String id_mailbox_ext) {
		Message selectedMessage = removeCurrentMessage(id_mailbox_ext);
        try {
            if(selectedMessage != null) {
                String query = "INSERT INTO kept_message(text,mailbox_id) VALUES('" + selectedMessage.getText() + "'," + id_mailbox_ext + ")";
                Statement st = connection.createStatement();
                st.executeUpdate(query);
            }
        }
        catch(Exception e) {
            // NADA
        }
	}
	
	

}
