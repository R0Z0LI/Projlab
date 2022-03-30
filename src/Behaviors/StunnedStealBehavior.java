package Behaviors;

import Collectible.Collectible;
import PropertyHandler.PropertyHandler;
import Virologist.Virologist;

public class StunnedStealBehavior extends StealBehavior {
    public StunnedStealBehavior(Virologist v) {
        super(v);
    }

    public StunnedStealBehavior() {
        super();
    }

    /**
     * Lebénulva a lopás nem sikerül.
     *
     * @param collectible     ellopandó tárgy
     * @param affected        virológus, akitől lop
     * @param propertyHandler annak virológusnak a tárolója, aki lop
     */
    @Override
    public void steal(Collectible collectible, Virologist affected, PropertyHandler propertyHandler) {
        System.out.println("-> StunnedStealBehavior.steal(Collectible c, Virologist affected, PropertyHandler ph)");
        System.out.println("! Lebénulva a lopás nem sikerül.");
    }
}
