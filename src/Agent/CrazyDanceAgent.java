package Agent;

import Behaviors.CrazyMoveBehavior;
import Virologist.Virologist;
import Game.Game;
/**
 * Vitustáncot reprezentáló osztály.
 */
public class CrazyDanceAgent extends Agent {
    private static int id = 0;
    private CrazyMoveBehavior crazyMove;

    public CrazyDanceAgent(int timeleft) {
        super(timeleft);
        this.name = "cda" + id++;
        crazyMove = new CrazyMoveBehavior();
    }

    /**
     * Kitörli a megadott virológus verméből a crazyMove viselkedést, amit az aktuális ágens okoz.
     * @param v  virológus, akinek a verméből törölni kell a viselkedést.
     */
    @Override
    public void removeBehavior(Virologist v) {
        v.remove(crazyMove);
        Game.removeSteppable(this);
    }

    /**
     * Hozzáadja a megadott virológus verméhez a crazyMove viselkedést, amit az aktuális ágens okoz.
     * @param v  virológus, akinek a verméhez hozzá kell adni a viselkedést.
     */
    @Override
    public void addBehavior(Virologist v) {
        crazyMove.setVirologist(v);
        v.add(crazyMove);
        Game.addSteppable(this);
    }

    @Override
    public void step() {
        super.step();
        // we are gonna remove the agent from the virologist
        if (getTimeLeft() == 0) {
            removeBehavior(crazyMove.getVirologist());
        }
    }
}
