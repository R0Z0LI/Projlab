package behaviors;

import virologist.Virologist;

public class StunnedMoveBehavior extends MovementBehavior{
    public StunnedMoveBehavior(Virologist v){
        super(v);
    }

    /**+
     * A virológus helyben marad.
     * @param before    a virológus eredeti pozíciója
     * @param after     a mező, amelyre léptetni kell
     */
    @Override
    public void Move(Field before, Field after) {
        return;
    }
}