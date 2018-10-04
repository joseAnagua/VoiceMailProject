package ucb.voicemail.domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import ucb.voicemail.domain.MailboxRepository;

public class SQLiteMailboxRepository implements MailboxRepository {
	private Connection connection;

	public SQLiteMailboxRepository(Connection connection) {
		try {
			this.connection = connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Mailbox findMailbox(String id) {
		try {
			String query = "SELECT * FROM mailbox WHERE id=" + id;
			Statement state = connection.createStatement();
			ResultSet resultSet = state.executeQuery(query);
			if (resultSet.next()) {
				return new Mailbox(resultSet.getString("id"), resultSet.getString("passcode"),
						resultSet.getString("greeting"));
			}
		} catch (Exception e) {
			// NADA
		}

		return null;
	}

	@Override
	public void setPasscode(String passcode, String id) {
		try {
            String query = "UPDATE mailbox set passcode ='" + passcode + "' WHERE id = " + id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            // NADA
        }
	}

	@Override
	public void setGreeting(String greeting, String id) {
		try {
            String query = "UPDATE mailbox set greeting ='" + greeting + "' WHERE id = " + id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            // NADA
        }
	}

}
