package behaviors;

import Field.Field;

import java.util.ArrayList;

public class CrazyMoveBehavior extends MovementBehavior {
    public CrazyMoveBehavior(){

    }

    /**+
     * A virológust egy tetszőleges szomszédos mezőre lépteti.
     * @param before    a virológus eredeti pozíciója
     * @param after     a mező, amelyre léptetni kell
     */
    @Override
    public void move(Field before, Field after) {
        ArrayList<Field> neighbours = before.getNeighbours();
        int index = (int) Math.round(Math.random()* neighbours.size());
        super.move(before, neighbours.get(index));
    }
}
