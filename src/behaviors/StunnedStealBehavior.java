package behaviors;
import Collectible.Collectible;
import PropertyHandler.PropertyHandler;
import virologist.Virologist;

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
        return;
    }
}
