package behaviors;

import Field.Field;
import virologist.Virologist;

public class MovementBehavior {
    private Virologist virologist;

    public MovementBehavior(Virologist v){
        virologist=v;
    }

    /**+
     * A virológust a megadott szomszédos mezőre lépteti.
     * @param before    a virológus eredeti pozíciója
     * @param after     a mező, amelyre léptetni kell
     */
    public void Move(Field before, Field after){
        before.RemoveVirologist(virologist);
        after.AddVirologist(virologist);
        virologist.setCurrField(after);
    }
}
