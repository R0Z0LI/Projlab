package agent;

import behaviors.*;
import virologist.Virologist;

public class ParalyseAgent extends Agent{
    private StunnedMoveBehavior stunnedMove;
    private StunnedApplyBehavior stunnedApply;
    private StunnedCreateBehavior stunnedCreate;
    private StunnedCollectBehavior stunnedCollect;
    private StunnedStealBehavior stunnedSteal;

    public ParalyseAgent(int timeleft) {
        super(timeleft);
        stunnedMove=new StunnedMoveBehavior();
        stunnedApply=new StunnedApplyBehavior();
        stunnedCreate=new StunnedCreateBehavior();
        stunnedCollect=new StunnedCollectBehavior();
        stunnedSteal=new StunnedStealBehavior();
    }

    @Override
    public void Step() {
        super.Step();
    }

    @Override
    public void AddBehToStack(Virologist v) {
        v.AddMoveBeh(stunnedMove);
        v.AddApplyBeh(stunnedApply);
        v.AddCreateBeh(stunnedCreate);
        v.AddCollectBeh(stunnedCollect);
        v.AddStealBeh(stunnedSteal);
    }

    @Override
    public void RemoveBehFromStack(Virologist v) {
        v.RemoveMoveBeh(stunnedMove);
        v.RemoveApplyBeh(stunnedApply);
        v.RemoveCreateBeh(stunnedCreate);
        v.RemoveCollectBeh(stunnedCollect);
        v.RemoveStealBeh(stunnedSteal);
    }
}
