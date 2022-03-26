package agent;

import behaviors.DefAgentDefBehavior;
import virologist.Virologist;

public class ProtectionAgent extends Agent{

    private DefAgentDefBehavior defAgentDef;

    public ProtectionAgent(int timeleft) {
        super(timeleft);
        defAgentDef=new DefAgentDefBehavior();
    }

    @Override
    public void RemoveBehFromStack(Virologist v) {
        v.RemoveDefenseBeh(defAgentDef);
    }

    @Override
    public void AddBehToStack(Virologist v) {
        v.AddDefenseBeh(defAgentDef);
    }

    @Override
    public void Step() {
        super.Step();
    }
}
