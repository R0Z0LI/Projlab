package agent;

import behaviors.*;
import virologist.Virologist;

public class ParalyseAgent extends Agent {
    private StunnedMoveBehavior stunnedMove;
    private StunnedApplyBehavior stunnedApply;
    private StunnedCreateBehavior stunnedCreate;
    private StunnedCollectBehavior stunnedCollect;
    private StunnedStealBehavior stunnedSteal;

    public ParalyseAgent(int timeleft) {
        super(timeleft);
        stunnedMove = new StunnedMoveBehavior();
        stunnedApply = new StunnedApplyBehavior();
        stunnedCreate = new StunnedCreateBehavior();
        stunnedCollect = new StunnedCollectBehavior();
        stunnedSteal = new StunnedStealBehavior();
    }

    public ParalyseAgent() {

    }

    @Override
    public void Step() {
        super.Step();
    }

    @Override
    public void AddBehToStack(Virologist v) {
        v.addMoveBeh(stunnedMove);
        v.addApplyBeh(stunnedApply);
        v.addCreateBeh(stunnedCreate);
        v.addCollectBeh(stunnedCollect);
        v.addStealBeh(stunnedSteal);
    }

    @Override
    public void RemoveBehFromStack(Virologist v) {
        v.removeMoveBeh(stunnedMove);
        v.removeApplyBeh(stunnedApply);
        v.removeCreateBeh(stunnedCreate);
        v.removeCollectBeh(stunnedCollect);
        v.removeStealBeh(stunnedSteal);
    }
}
