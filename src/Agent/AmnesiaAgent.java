package Agent;

import Virologist.Virologist;

/**+
 * Amnézia ágenst reprezentáló osztály.
 */
public class AmnesiaAgent extends Agent{
    public AmnesiaAgent(int timeleft) {
        super(timeleft);
    }

    @Override
    public void removeBehavior(Virologist v) {

    }

    /**+
     * Törli a virológus által megismert összes genetikai kódot.
     * @param virologist  virológus, akinek a PropertyHandleréből törölni kell a genetikai kódokat.
     */
    @Override
    public void addBehavior(Virologist virologist) {
        System.out.println("-> AddBehToStack(Virologist virologist)\n! A felejto agens hatni fog.\n\n");
        virologist.getPropertyHandler().deleteGenCodes();

    }

    @Override
    public void step() {
        super.step();
    }
}
