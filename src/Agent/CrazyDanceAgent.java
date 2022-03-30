package Agent;

import Behaviors.CrazyMoveBehavior;
import Virologist.Virologist;
/**
 * Vitustáncot reprezentáló osztály.
 */
public class CrazyDanceAgent extends Agent {

    private CrazyMoveBehavior crazyMove;

    public CrazyDanceAgent(int timeleft) {
        super(timeleft);
        crazyMove = new CrazyMoveBehavior();
    }

    /**
     * Kitörli a megadott virológus verméből a crazyMove viselkedést, amit az aktuális ágens okoz.
     * @param v  virológus, akinek a verméből törölni kell a viselkedést.
     */
    @Override
    public void removeBehavior(Virologist v) {
        v.removeCrazyMoveBeh(crazyMove);
        System.out.println("-> RemoveBehFromStack(Virologist v)\n! Kitörli a megadott virológus verméből a crazyMove viselkedést.\n\n");
    }

    /**
     * Hozzáadja a megadott virológus verméhez a crazyMove viselkedést, amit az aktuális ágens okoz.
     * @param v  virológus, akinek a verméhez hozzá kell adni a viselkedést.
     */
    @Override
    public void addBehavior(Virologist v) {
        crazyMove.setVirologist(v);
        v.add(crazyMove);
        System.out.println("-> AddBehToStack(Virologist v)\n! Hozzáadja a megadott virológus verméhez a crazyMove viselkedést.\n\n");
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
