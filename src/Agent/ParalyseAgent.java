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
    public void step() {
        super.step();

        // we are gonna remove the agent from the virologist
        if (getTimeLeft() == 0) {
            removeBehavior(stunnedMove.getVirologist());
        }
    }

    /**+
     * Hozzáadja a megadott virológus verméhez azokat a viselkedéseket, amiket a ParalyseAgent okoz.
     * @param v  virológus, akinek a verméhez hozzá kell adni a viselkedéseket.
     */
    @Override
    public void addBehavior(Virologist v) {
        stunnedMove.setVirologist(v);
        stunnedApply.setVirologist(v);
        stunnedCreate.setVirologist(v);
        stunnedCollect.setVirologist(v);
        stunnedSteal.setVirologist(v);
        v.add(stunnedMove);
        v.add(stunnedApply);
        v.add(stunnedCreate);
        v.add(stunnedCollect);
        v.add(stunnedSteal);
        System.out.println("-> AddBehToStack(Virologist v)\n! Hozzaadja a megadott virologus vermehez azokat a viselkedeseket, amiket a ParalyseAgent okoz.\n\n");
    }

    /**+
     * Kitörli a megadott virológus verméből azokat a viselkedéseket, amiket a ParalyseAgent okoz.
     * @param v  virológus, akinek a verméből törölni kell a viselkedéseket.
     */
    @Override
    public void removeBehavior(Virologist v) {
        v.removeMoveBeh(stunnedMove);
        v.removeApplyBeh(stunnedApply);
        v.removeCreateBeh(stunnedCreate);
        v.removeCollectBeh(stunnedCollect);
        v.removeStealBeh(stunnedSteal);
        System.out.println("-> RemoveBehFromStack(Virologist v)\n! Kitorli a megadott virologus vermebol azokat a viselkedeseket, amiket a ParalyseAgent okoz.\n\n");

    }
}
