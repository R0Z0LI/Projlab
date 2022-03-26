package agent;

import PropertyHandler.PropertyHandler;
import virologist.Virologist;

public class AmnesiaAgent extends Agent{
    public AmnesiaAgent(int timeleft) {
        super(timeleft);
    }

    public AmnesiaAgent() {

    }

    @Override
    public void RemoveBehFromStack(Virologist v) {

    }

    @Override
    public void AddBehToStack(Virologist v) {
        v.getPropertyHandler().DeleteGenCodes();
    }

    @Override
    public void Step() {
        super.Step();
    }
}
