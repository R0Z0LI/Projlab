package Behaviors;

import Field.Field;
import Virologist.Virologist;

public class StunnedMoveBehavior extends MovementBehavior {
    public StunnedMoveBehavior(Virologist v) {
        super(v);
    }

    public StunnedMoveBehavior() {
        super();
    }


    /**
     * +
     * A virológus helyben marad.
     *
     * @param before a virológus eredeti pozíciója
     * @param after  a mező, amelyre léptetni kell
     */
    @Override
    public void move(Field before, Field after) {
        System.out.println("-> StunnedMoveBehavior.move(Field before, Field after)");
        System.out.println("! Lebénulva a mozgás nem sikerül.");
    }
}
