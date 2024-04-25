package edu.iu.habahram.GumballMachine.model;

public class SoldState implements IState {
    IGumballMachine gumballMachine;

    public SoldState(IGumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public TransitionResult insertQuarter() {
        return new TransitionResult(false, "Please wait, we're already giving you a gumball", gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult ejectQuarter() {
        return new TransitionResult(false, "Sorry, you already turned the crank", gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult turnCrank() {
        return new TransitionResult(false, "Turning again doesn't get you another gumball!", gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult dispense() {
        String message = "Candy dispensed";
        boolean succeeded = true;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());

    }

    @Override
    public TransitionResult refill(int count) {
        String message = "Refill not allowed";
        boolean succeeded = false;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public String getTheName() {
        return GumballMachineState.GUMBALL_SOLD.name();
    }
}
