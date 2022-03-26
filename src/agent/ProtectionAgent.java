package agent;

import behaviors.DefAgentDefBehavior;
import virologist.Virologist;

/**+
 * Védő ágenst reprezentáló osztály.
 */
public class ProtectionAgent extends Agent{

    private DefAgentDefBehavior defAgentDef;

    public ProtectionAgent(int timeleft) {
        super(timeleft);
        defAgentDef=new DefAgentDefBehavior();
    }

    public ProtectionAgent() {

    }

    /**+
     * Kitörli a megadott virológus verméből a defAgentDef viselkedést, amit az aktuális ágens okoz.
     * @param v  virológus, akinek a verméből törölni kell a viselkedést.
     */
    @Override
    public void RemoveBehFromStack(Virologist v) {
        v.removeDefenseBeh(defAgentDef);
        System.out.println("-> RemoveBehFromStack(Virologist v)\n! Kitörli a megadott virológus verméből a defAgentDef viselkedést.\n\n");

    }

    /**+
     * Hozzáadja a megadott virológus verméhez a defAgentDef viselkedést, amit az aktuális ágens okoz.
     * @param v  virológus, akinek a verméhez hozzá kell adni a viselkedést.
     */
    @Override
    public void AddBehToStack(Virologist v) {
        v.addDefenseBeh(defAgentDef);
        System.out.println("-> RemoveBehFromStack(Virologist v)\n! Hozzáadja a megadott virológus verméhez a defAgentDef viselkedést.\n\n");
    }

    @Override
    public void Step() {
        super.Step();
    }
}
