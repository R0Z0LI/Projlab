package behaviors;

import Field.Field;
import virologist.Virologist;

public class MovementBehavior {
    private Virologist virologist;

    public MovementBehavior(Virologist v) {
        virologist = v;
    }

    public MovementBehavior() {

    }
    public void setVirologist(Virologist v){
        virologist=v;
    }


    /**
     * +
     * A virológust a megadott szomszédos mezőre lépteti.
     *
     * @param before a virológus eredeti pozíciója
     * @param after  a mező, amelyre léptetni kell
     */
    public void move(Field before, Field after) {
        System.out.println("->MovementBehavior.move(Field before, Field after)");
        System.out.println("! A virológus lép egy szomszédos mezőre.");
        before.RemoveVirologist(virologist);
        after.addVirologist(virologist);
        virologist.setCurrentField(after);
    }
}
