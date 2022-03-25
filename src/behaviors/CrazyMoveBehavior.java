package behaviors;

import virologist.Virologist;

public class CrazyMoveBehavior extends MovementBehavior {
    public CrazyMoveBehavior(Virologist v){
        super(v);
    }

    /**+
     * A virológust egy tetszőleges szomszédos mezőre lépteti.
     * @param before    a virológus eredeti pozíciója
     * @param after     a mező, amelyre léptetni kell
     */
    @Override
    public void Move(Field before, Field after) {
        ArrayList<Field> neighbours = before.GetNeighbours();
        int index = Math.Round(Math.random()* neighbors.size());
        super.Move(before, neighbours.get(index));
    }
}
