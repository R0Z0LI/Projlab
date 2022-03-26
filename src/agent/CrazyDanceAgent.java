package agent;

import behaviors.CrazyMoveBehavior;
import virologist.Virologist;

public class CrazyDanceAgent extends Agent {

    private CrazyMoveBehavior crazyMove;

    public CrazyDanceAgent(int timeleft) {
        super(timeleft);
        crazyMove = new CrazyMoveBehavior();//VIROLOGUS??
    }

    public CrazyDanceAgent() {

    }

    @Override
    public void RemoveBehFromStack(Virologist v) {
        v.removeCrazyMoveBeh(crazyMove);
    }

    @Override
    public void AddBehToStack(Virologist v) {
        v.addCrazyMoveBeh(crazyMove);
    }

    @Override
    public void Step() {
        super.Step();
    }
}
