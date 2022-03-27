package Agent;

import Virologist.Virologist;

/**+
 * Amnézia ágenst reprezentáló osztály.
 */
public class AmnesiaAgent extends Agent{
    public AmnesiaAgent(int timeleft) {
        super(timeleft);
    }

    public AmnesiaAgent() {

    }

    @Override
    public void RemoveBehFromStack(Virologist v) {

    }

    /**+
     * Törli a virológus által megismert összes genetikai kódot.
     * @param v  virológus, akinek a PropertyHandleréből törölni kell a genetikai kódokat.
     */
    @Override
    public void AddBehToStack(Virologist v) {
        v.getPropertyHandler().DeleteGenCodes();
        System.out.println("-> AddBehToStack(Virologist v)\n! Törli a virológus által megismert összes genetikai kódot.\n\n");

    }

    @Override
    public void Step() {
        super.Step();
    }
}
