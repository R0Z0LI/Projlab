package Agent;

import TestSets.TestInOutHandler;
import Virologist.Virologist;

/**
 * Amnézia ágenst reprezentáló osztály.
 */
public class AmnesiaAgent extends Agent{
    private static int id = 0;

    /**
     * AmnesiaAgent constructor
     * @param timeLeft remaining time
     */
    public AmnesiaAgent(int timeLeft) {
        super(timeLeft);
        this.name = "ama" + id++;
    }

    @Override
    public void removeBehavior(Virologist v) {
        // does nothing
    }

    /**
     * Törli a virológus által megismert összes genetikai kódot.
     * @param virologist  virológus, akinek a PropertyHandleréből törölni kell a genetikai kódokat.
     */
    @Override
    public void addBehavior(Virologist virologist) {
        System.out.println(name+" successfully applied on "+virologist.getName());
        TestInOutHandler.appendToTestOutput(name+" successfully applied on "+virologist.getName());
        virologist.getPropertyHandler().deleteGenCodes();
    }

}
