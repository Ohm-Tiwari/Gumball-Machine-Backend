package edu.iu.habahram.GumballMachine.model;

public class SoldOutState implements IState {
    IGumballMachine gumballMachine;

    public SoldOutState(IGumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public TransitionResult refill(int count) {
        gumballMachine.changeTheStateTo(GumballMachineState.NO_QUARTER);
        return new TransitionResult(true, "Gumball machine refilled", gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult insertQuarter() {
        return new TransitionResult(false, "The machine is sold out", gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult ejectQuarter() {
        return new TransitionResult(false, "You have not inserted a quarter", gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult turnCrank() {
        return new TransitionResult(false, "There are no gumballs", gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult dispense() {
        return new TransitionResult(false, "No gumballs to dispense", gumballMachine.getTheStateName(), gumballMachine.getCount());
    }



    @Override
    public String getTheName() {
        return GumballMachineState.OUT_OF_GUMBALLS.name();
    }
}
