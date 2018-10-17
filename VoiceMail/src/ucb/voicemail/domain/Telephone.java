package ucb.voicemail.domain;

import ucb.voicemail.domain.boundary.output.Presenter;

public interface Telephone {
	void updateInterface(String output);
	Presenter getPresenter();
}
