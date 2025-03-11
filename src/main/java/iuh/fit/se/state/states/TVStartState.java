package iuh.fit.se.state.states;

import iuh.fit.se.state.interfaces.State;

public class TVStartState implements State {
@Override
public void doAction() {
System.out.println("TV is turned ON"); 
}
}