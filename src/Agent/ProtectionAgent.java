package Agent;

import Behaviors.DefAgentDefBehavior;
import Virologist.Virologist;
import Game.Game;

/**+
 * Védő ágenst reprezentáló osztály.
 */
public class ProtectionAgent extends Agent{

    private static int id = 0;
    private DefAgentDefBehavior defAgentDef;

    public ProtectionAgent(int timeleft) {
        super(timeleft);
        this.name = "pra" + id++;
        defAgentDef = new DefAgentDefBehavior();
    }

    /**+
     * Kitörli a megadott virológus verméből a defAgentDef viselkedést, amit az aktuális ágens okoz.
     * Game steppable-ből eltávolítja magát
     * @param v  virológus, akinek a verméből törölni kell a viselkedést.
     */
    @Override
    public void removeBehavior(Virologist v) {
        defAgentDef.setVirologist(v);
        v.remove(defAgentDef);
        Game.removeSteppable(this);
    }

    /**
     * Hozzáadja a megadott virológus verméhez a defAgentDef viselkedést, amit az aktuális ágens okoz.
     * Game steppeble-hez is hozzáadja magát
     * @param v  virológus, akinek a verméhez hozzá kell adni a viselkedést.
     */
    @Override
    public void addBehavior(Virologist v) {
        System.out.println(name+" successfully applied on "+v.getName());
        defAgentDef.setVirologist(v);
        v.add(defAgentDef);
        Game.addSteppable(this);
    }

    @Override
    public void step() {
        super.step();

        // we are gonna remove the agent from the virologist
        if (getTimeLeft() == 0) {
            removeBehavior(defAgentDef.getVirologist());
        }
    }

}
