package iuh.fit.se.state;

import iuh.fit.se.state.interfaces.State;
import iuh.fit.se.state.states.TVStartState;
import iuh.fit.se.state.states.TVStopState;

public class TVRemote {
	public static void main(String[] args) {
		TVContext context = new TVContext();
		State tvStartState = new TVStartState();
		State tvStopState = new TVStopState();
		context.setState(tvStartState);
		context.doAction();
		context.setState(tvStopState);
		context.doAction();
	}
}