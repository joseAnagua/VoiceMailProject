package ucb.voicemail.domain;

public interface ConnectionState {
	void dial(String key, Connection connection);
	void record(String voice, Connection connection);
	void hangup(Connection connection);
}
