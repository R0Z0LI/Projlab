package Agent;

import Behaviors.*;
import Virologist.Virologist;
import Game.Game;

public class ParalyseAgent extends Agent {
    private static int id = 0;
    private StunnedBehavior stunnedBeh;

    public ParalyseAgent() {
        super(2);
        this.name = "paa" + id++;
        stunnedBeh = new StunnedBehavior();
    }

    @Override
    public void step() {
        super.step();
        // eltávolítja az ágens hatását
        if (getTimeLeft() == 0) {
            removeBehavior(stunnedBeh.getVirologist());
        }
    }

    /**+
     * Hozzáadja a megadott virológus verméhez azokat a viselkedéseket, amiket a ParalyseAgent okoz.
     * @param v  virológus, akinek a verméhez hozzá kell adni a viselkedéseket.
     */
    @Override
    public void addBehavior(Virologist v) {
        stunnedBeh.setVirologist(v);
        v.add(stunnedBeh);
        Game.addSteppable(this);
    }

    /**+
     * Kitörli a megadott virológus verméből azokat a viselkedéseket, amiket a ParalyseAgent okoz.
     * @param v  virológus, akinek a verméből törölni kell a viselkedéseket.
     */
    @Override
    public void removeBehavior(Virologist v) {
        v.remove(stunnedBeh);
        Game.removeSteppable(this);
    }
}
