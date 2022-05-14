package Agent;

import Behaviors.BearBehavior;
import Virologist.Virologist;

public class BearDanceAgent extends Agent {
    private static int id = 0;

    public BearDanceAgent(){
        name="baa"+id++;
    }

    /**
     * Kitörli a megadott virológus verméből a medve viselkedést
     * Nem lehet kitörölni
     * @param v virológus, akinek a verméből törölni kell a viselkedést.
     */
    public  void removeBehavior(Virologist v) { }

    /**
     * Hozzáadja a megadott virológus verméhez a medve  viselkedést
     *
     * @param v virológus, akinek a verméhez hozzá kell adni a viselkedést.
     */
    public  void addBehavior(Virologist v) {
        System.out.println(name+" successfully applied on "+v.getName());
        v.add(new BearBehavior(v));
    }
}
