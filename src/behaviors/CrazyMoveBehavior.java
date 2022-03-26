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
        System.out.println("->CrazyMoveBehavior.move(Field before, Field after)");
        System.out.println("! A vitustánc most egy másik mezőt sorsol, ahova a virológus lépni fog.");
        ArrayList<Field> neighbours = before.getNeighbours();
        int index = (int) Math.round(Math.random()* neighbours.size());
        super.move(before, neighbours.get(index));
    }
}
