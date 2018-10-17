package ucb.voicemail.domain;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import ucb.voicemail.presentation.console.ConsoleTelephone;
import ucb.voicemail.presentation.graphical.GraphicalTelephone;
import ucb.voicemail.presentation.graphical.view.MainMenu;
import ucb.voicemail.repository.mailbox.SQLiteMailboxRepository;
import ucb.voicemail.repository.message.SQLiteMessageRepository;

/**
 * This program tests the mail system. A single phone communicates with the
 * program through System.in/System.out.
 */
public class MailSystemTester {

	public static void main(String[] args) {
		
		try {
			getConnectionSQLite();
			
			//MailboxRepository mailboxRepository = new ArrayMailboxRepository(MAILBOX_COUNT);
			//MessageRepository messageRepository = new ArrayMessageRepository(MAILBOX_COUNT);
			
			MailboxRepository mailboxRepository = new SQLiteMailboxRepository(sqliteConnection);
			MessageRepository messageRepository = new SQLiteMessageRepository(sqliteConnection);
			
			GraphicalTelephone w = new GraphicalTelephone(new MainMenu());
			Scanner console = new Scanner(System.in);
			ConsoleTelephone p = new ConsoleTelephone(console);
			Connection c = new Connection(mailboxRepository, messageRepository);
			c.addTelephone(p);
			c.addTelephone(w);
			c.start(); // REINICIAR LA CONEXCION PARA QUE APAREZCA " Enter mailbox number followed by
						// #"
			w.run(c);
			p.run(c);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void getConnectionSQLite() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		sqliteConnection = DriverManager.getConnection("jdbc:sqlite:VoiceMailDB.db");
		initialise();
	}

	private static void initialise() throws SQLException {
		Statement state = sqliteConnection.createStatement();
		Statement state2 = sqliteConnection.createStatement();
		Statement state3 = sqliteConnection.createStatement();
		String query = "SELECT name FROM sqlite_master WHERE type='table' AND name='mailbox'";
		String query2 = "SELECT name FROM sqlite_master WHERE type='table' AND name='kept_message'";
		String query3 = "SELECT name FROM sqlite_master WHERE type='table' AND name='new_message'";
		ResultSet res = state.executeQuery(query);
		ResultSet res2 = state2.executeQuery(query2);
		ResultSet res3 = state3.executeQuery(query3);

		if (!res.next()) {
			Statement state4 = sqliteConnection.createStatement();
			state4.execute("CREATE TABLE mailbox(id integer," + "passcode varchar(200)," + "greeting varchar(200),"
					+ "primary key(id));");

			for (int i = 0; i < 15; i++) {
				PreparedStatement prep = sqliteConnection.prepareStatement("INSERT INTO mailbox values(?,?,?);");
				prep.setString(2, "" + (i + 1));
				prep.setString(3, "You have reached mailbox " + (i + 1) + ". \r\n" + "Please leave a message now.");
				prep.execute();
			}
		}

		if (!res2.next()) {
			Statement state4 = sqliteConnection.createStatement();
			state4.execute("CREATE TABLE kept_message(id integer," + "text varchar(200)," + "mailbox_id integer,"
					+ "primary key(id));");
		}

		if (!res3.next()) {
			Statement state4 = sqliteConnection.createStatement();
			state4.execute("CREATE TABLE new_message(id integer," + "text varchar(200)," + "mailbox_id integer,"
					+ "primary key(id));");
		}

	}

	private static final int MAILBOX_COUNT = 20;
	private static java.sql.Connection sqliteConnection;
}

