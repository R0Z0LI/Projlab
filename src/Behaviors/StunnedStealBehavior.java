package Behaviors;
import Collectible.Collectible;
import PropertyHandler.PropertyHandler;
import Virologist.Virologist;

public class StunnedStealBehavior extends StealBehavior{
    public StunnedStealBehavior(Virologist v){
        super(v);
    }

    public StunnedStealBehavior() {
        super();
    }

    /**
     * Lebénulva a lopás nem sikerül.
     * @param c         ellopandó tárgy
     * @param affected  virológus, akitől lop
     * @param ph        annak virológusnak a tárolója, aki lop
     */
    @Override
    public void steal(Collectible c, Virologist affected, PropertyHandler ph) {
        System.out.println("-> StunnedStealBehavior.steal(Collectible c, Virologist affected, PropertyHandler ph)");
        System.out.println("! Lebénulva a lopás nem sikerül.");
        return;
    }
}
