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

        // we are gonna remove the agent from the virologist
        if (getTime_left() == 0) {
            removeBehFromStack(stunnedMove.getVirologist());
        }
    }

    /**+
     * Hozzáadja a megadott virológus verméhez azokat a viselkedéseket, amiket a ParalyseAgent okoz.
     * @param v  virológus, akinek a verméhez hozzá kell adni a viselkedéseket.
     */
    @Override
    public void addBehToStack(Virologist v) {
        stunnedMove.setVirologist(v);
        stunnedApply.setVirologist(v);
        stunnedCreate.setVirologist(v);
        stunnedCollect.setVirologist(v);
        stunnedSteal.setVirologist(v);
        v.addMoveBehavior(stunnedMove);
        v.addApplyBehavior(stunnedApply);
        v.addCreateBehavior(stunnedCreate);
        v.addCollectBehavior(stunnedCollect);
        v.addStealBehavior(stunnedSteal);
        System.out.println("-> AddBehToStack(Virologist v)\n! Hozzáadja a megadott virológus verméhez azokat a viselkedéseket, amiket a ParalyseAgent okoz.\n\n");

    }

    /**+
     * Kitörli a megadott virológus verméből azokat a viselkedéseket, amiket a ParalyseAgent okoz.
     * @param v  virológus, akinek a verméből törölni kell a viselkedéseket.
     */
    @Override
    public void removeBehFromStack(Virologist v) {
        v.removeMoveBeh(stunnedMove);
        v.removeApplyBeh(stunnedApply);
        v.removeCreateBeh(stunnedCreate);
        v.removeCollectBeh(stunnedCollect);
        v.removeStealBeh(stunnedSteal);
        System.out.println("-> RemoveBehFromStack(Virologist v)\n! Kitörli a megadott virológus verméből azokat a viselkedéseket, amiket a ParalyseAgent okoz.\n\n");

    }
}
