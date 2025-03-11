package iuh.fit.se.state;

import iuh.fit.se.state.interfaces.State;

public class TVContext implements State {
private State tvState;
public void setState(State state) {
this.tvState=state;
}
public State getState() {
return this.tvState;
}
@Override
public void doAction() {
this.tvState.doAction();
}
}