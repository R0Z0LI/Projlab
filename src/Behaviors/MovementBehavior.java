package Behaviors;

import Field.Field;
import TestSets.TestInOutHandler;
import Virologist.Virologist;

public class MovementBehavior {
    private Virologist virologist;

    public MovementBehavior(Virologist v) {
        virologist = v;
    }

    public MovementBehavior() {
    }

    public void setVirologist(Virologist v) {
        virologist = v;
    }

    public Virologist getVirologist() {
        return virologist;
    }

    /**
     * +
     * A virológust a megadott szomszédos mezőre lépteti.
     *
     * @param before a virológus eredeti pozíciója
     * @param after  a mező, amelyre léptetni kell
     */
    public void move(Field before, Field after) {
        System.out.println(virologist.getName()+" stepped on "+after.getName());
        TestInOutHandler.appendToTestOutput(virologist.getName()+" stepped on "+after.getName()+"\n");
        before.removeVirologist(virologist);
        after.addVirologist(virologist);
        virologist.setCurrentField(after);
    }
}
