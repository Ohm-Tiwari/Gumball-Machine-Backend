package edu.iu.habahram.GumballMachine.model;

public class NoQuarterState implements IState{
    IGumballMachine gumballMachine;
    public NoQuarterState(IGumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    @Override
    public TransitionResult insertQuarter() {
        gumballMachine.changeTheStateTo(GumballMachineState.HAS_QUARTER);
        String message = "Inserted a quarter";
        boolean succeeded = true;
        int count = gumballMachine.getCount();
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), count);
    }
    @Override
    public TransitionResult ejectQuarter() {
        String message = "You have not inserted a quarter";
        boolean succeeded = false;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }
    @Override
    public TransitionResult turnCrank() {
        String message = "There's no quarter";
        boolean succeeded = false;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }
    @Override
    public TransitionResult dispense() {
        String message = "Pay first";
        boolean succeeded = false;
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
        return GumballMachineState.NO_QUARTER.name();
    }
}
