package agent;

import behaviors.CrazyMoveBehavior;
import virologist.Virologist;

public class CrazyDanceAgent extends Agent{

    private CrazyMoveBehavior crazyMove;

    public CrazyDanceAgent(int timeleft) {
        super(timeleft);
        crazyMove=new CrazyMoveBehavior();//VIROLOGUS??
    }

    @Override
    public void RemoveBehFromStack(Virologist v) {
        v.RemoveMoveBeh(crazyMove);
    }

    @Override
    public void AddBehToStack(Virologist v) {
        v.AddMoveBeh(crazyMove);
    }

    @Override
    public void Step() {
        super.Step();
    }
}
