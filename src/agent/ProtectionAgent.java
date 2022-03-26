package agent;

import behaviors.DefAgentDefBehavior;
import virologist.Virologist;

public class ProtectionAgent extends Agent{

    private DefAgentDefBehavior defAgentDef;

    public ProtectionAgent(int timeleft) {
        super(timeleft);
        defAgentDef=new DefAgentDefBehavior();
    }

    public ProtectionAgent() {

    }

    @Override
    public void RemoveBehFromStack(Virologist v) {
        v.removeDefenseBeh(defAgentDef);
    }

    @Override
    public void AddBehToStack(Virologist v) {
        v.addDefenseBeh(defAgentDef);
    }

    @Override
    public void Step() {
        super.Step();
    }
}
