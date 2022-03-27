package Agent;

import Behaviors.*;
import Virologist.Virologist;

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

    /**+
     * Hozzáadja a megadott virológus verméhez azokat a viselkedéseket, amiket a ParalyseAgent okoz.
     * @param v  virológus, akinek a verméhez hozzá kell adni a viselkedéseket.
     */
    @Override
    public void AddBehToStack(Virologist v) {
        v.addMoveBeh(stunnedMove);
        v.addApplyBeh(stunnedApply);
        v.addCreateBeh(stunnedCreate);
        v.addCollectBeh(stunnedCollect);
        v.addStealBeh(stunnedSteal);
        System.out.println("-> AddBehToStack(Virologist v)\n! Hozzáadja a megadott virológus verméhez azokat a viselkedéseket, amiket a ParalyseAgent okoz.\n\n");

    }

    /**+
     * Kitörli a megadott virológus verméből azokat a viselkedéseket, amiket a ParalyseAgent okoz.
     * @param v  virológus, akinek a verméből törölni kell a viselkedéseket.
     */
    @Override
    public void RemoveBehFromStack(Virologist v) {
        v.removeMoveBeh(stunnedMove);
        v.removeApplyBeh(stunnedApply);
        v.removeCreateBeh(stunnedCreate);
        v.removeCollectBeh(stunnedCollect);
        v.removeStealBeh(stunnedSteal);
        System.out.println("-> RemoveBehFromStack(Virologist v)\n! Kitörli a megadott virológus verméből azokat a viselkedéseket, amiket a ParalyseAgent okoz.\n\n");

    }
}
